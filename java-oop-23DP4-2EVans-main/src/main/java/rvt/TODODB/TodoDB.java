package rvt.TODODB; // Norāda pakotni (mapi), kurā šī klase atrodas

// Importē klases darbam ar datubāzi
import java.sql.Connection;      // Savienojums ar DB
import java.sql.DriverManager;   // Izveido savienojumu ar DB
import java.sql.SQLException;    // Apstrādā SQL kļūdas
import java.sql.Statement;       // Izpilda vienkāršus SQL vaicājumus

// Klase, kas apstrādā Todo datubāzi
public class TodoDB {

    // Datubāzes adrese (SQLite fails tiks izveidots projekta mapē)
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    // Konstruktors – tiek izsaukts, kad izveido jaunu TodoDB objektu
    public TodoDB() {

        // Uzreiz inicializē (izveido) tabulu, ja tā neeksistē
        initSchema();
    }
    
    // Metode, kas izveido savienojumu ar datubāzi
    private Connection connect() throws SQLException {

        // Izveido un atgriež savienojumu ar SQLite DB
        return DriverManager.getConnection(DB_URL);
    }

    // Metode, kas izveido tabulu (ja tā vēl neeksistē)
    private void initSchema() {

        // SQL komanda tabulas izveidei
        String sql = "CREATE TABLE IF NOT EXISTS todo ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT," // id kolonna ar automātisku pieaugumu
        + "task TEXT NOT NULL) STRICT"; // task lauks nedrīkst būt tukšs

        // try-with-resources automātiski aizver savienojumu un statement
        try (
            Connection conn = connect();              // atver savienojumu
            Statement stmt = conn.createStatement();  // izveido SQL izpildītāju
        ) {
            // Izpilda SQL komandu
            stmt.execute(sql);

        } catch (SQLException e) {

            // Ja ir kļūda, izmet RuntimeException ar ziņojumu
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }

    // Metode, kas pievieno jaunu uzdevumu datubāzei
    private void add(String task) {

        // SQL ar vietturi (?), lai izvairītos no SQL injection
        String sql = "INSERT INTO todo (task) VALUES (?)";

        try (
            Connection conn = connect();                 // savienojums ar DB
            var pstmt = conn.prepareStatement(sql);      // sagatavots SQL vaicājums
        ) {
            // Ieliek vērtību vietā (?)
            pstmt.setString(1, task);

            // Izpilda INSERT komandu
            pstmt.executeUpdate();

        } catch (SQLException e) {

            // Ja kļūda – met exception
            throw new RuntimeException("Add failed: " + e.getMessage());
        }
    }

    // Metode, kas izvada visus ierakstus no datubāzes
    private void findAll() {

        // SQL komanda visu datu iegūšanai
        String sql = "Select * from todo";

        try (
            Connection conn = connect();               // savienojums
            var stmt = conn.createStatement();         // SQL izpildītājs
            var rs = stmt.executeQuery(sql);           // rezultātu kopums
        ) {
            // Cikls caur visiem rezultātiem
            while (rs.next()) {

                // Nolasa kolonnas pēc nosaukuma
                int id = rs.getInt("id");
                String task = rs.getString("task");

                // Izdrukā konsolē
                System.out.println(id + ": " + task);
            }

        } catch (SQLException e) {

            // Kļūdas apstrāde
            throw new RuntimeException("Find all failed: " + e.getMessage());
        }
    }

    // Metode, kas dzēš ierakstu pēc ID
    private void removeID(int id) {

        // SQL komanda dzēšanai
        String sql = "DELETE FROM todo WHERE id = ?";

        try (
            Connection conn = connect();              // savienojums
            var pstmt = conn.prepareStatement(sql);   // sagatavots vaicājums
        ) {
            // Ievieto ID viettura vietā (?)
            pstmt.setInt(1, id);

            // Izpilda DELETE
            pstmt.executeUpdate();

        } catch (SQLException e) {

            // Kļūdas apstrāde
            throw new RuntimeException("Remove failed: " + e.getMessage());
        }
    }

    // Testa metode (programmas starts)
    public static void main(String[] args) {

        // Izveido DB objektu (automātiski izveido tabulu)
        TodoDB db = new TodoDB();

        db.add("Charmless Man"); // Pievieno uzdevumu

        // Dzēš ierakstu ar ID = 4 (ja eksistē)
        db.removeID(4);

        // Izvada visus ierakstus uz konsoli
        db.findAll();
    }
}