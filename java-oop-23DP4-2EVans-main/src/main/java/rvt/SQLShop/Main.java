package rvt.SQLShop;

// Importē klases darbam ar datubāzi
import java.sql.Connection;      // Savienojums ar DB
import java.sql.DriverManager;   // Izveido savienojumu ar DB
import java.sql.SQLException;    // Apstrādā SQL kļūdas
import java.sql.Statement;       // Izpilda vienkāršus SQL vaicājumus

public class Main {
    private static final String DB_URL = "jdbc:sqlite:rex_shop.db";

    public Main() {

        initSchema();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
}

    
private void initSchema() {

    String sql1 = "CREATE TABLE IF NOT EXISTS kategorijas ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "name TEXT NOT NULL)";

    String sql2 = "CREATE TABLE IF NOT EXISTS preces ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "name TEXT NOT NULL,"
        + "price REAL,"
        + "category_id INTEGER,"
        + "FOREIGN KEY (category_id) REFERENCES kategorijas(id))";

    try (Connection conn = connect();
         Statement stmt = conn.createStatement()) {

        stmt.execute(sql1);
        stmt.execute(sql2);

    } catch (SQLException e) {
        throw new RuntimeException("Schema init failed: " + e.getMessage());
    } 
    }// <-- Add this closing brace to end the method or block

    public void add(String name) {

        // SQL ar vietturi (?), lai izvairītos no SQL injection
        String sql1 = "INSERT INTO kategorijas (name) VALUES (?)";
        String sql2 = "INSERT INTO preces (name, price, category_id) VALUES (?, ?, ?)";

        try (
            Connection conn = connect();                 // savienojums ar DB
            var pstmt1 = conn.prepareStatement(sql1);  
            var pstmt2 = conn.prepareStatement(sql2);     // sagatavots SQL vaicājums
        ) {
            // Ieliek vērtību vietā (?)
            pstmt1.setString(1, name);
            pstmt2.setString(1, name);
            pstmt2.setDouble(2, 10.0);
            pstmt2.setInt(3, 1);

            // Izpilda INSERT komandu
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

        } catch (SQLException e) {

            // Ja kļūda – met exception
            throw new RuntimeException("Add failed: " + e.getMessage());
        }
    }

    public void addCategory(String name) {
        String sql = "INSERT INTO kategorijas (name) VALUES (?)";
    
        try (Connection conn = connect();
             var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, name);
            pstmt.executeUpdate();
    
        } catch (SQLException e) {
            throw new RuntimeException("Add failed: " + e.getMessage());
        }
    }
    

    public void findAll() {
        String sql = "SELECT * FROM preces";
    
        try (Connection conn = connect();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {
    
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + ": " +
                    rs.getString("name") + " | " +
                    rs.getDouble("price") + " | category=" +
                    rs.getInt("category_id")
                );
            }
    
        } catch (SQLException e) {
            throw new RuntimeException("Find all failed: " + e.getMessage());
        }
    }

    public void findById(int id) {
        String sql = "SELECT * FROM preces WHERE id = ?";
    
        try (Connection conn = connect();
             var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, id);
            var rs = pstmt.executeQuery();
    
            if (rs.next()) {
                System.out.println(
                    rs.getInt("id") + ": " +
                    rs.getString("name") + " | " +
                    rs.getDouble("price") + " | category=" +
                    rs.getInt("category_id")
                );
            } else {
                System.out.println("Nav atrasts ieraksts ar ID = " + id);
            }
    
        } catch (SQLException e) {
            throw new RuntimeException("Find by ID failed: " + e.getMessage());
        }
    }

    // Metode, kas dzēš ierakstu pēc ID
    
    public void deleteById(int id) {
        String sql = "DELETE FROM preces WHERE id = ?";

        try (Connection conn = connect();
            var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Delete failed: " + e.getMessage());
        }
    }

    public void deleteAll() {
        String sql = "DELETE FROM preces";
    
        try (Connection conn = connect();
             var stmt = conn.createStatement()) {
    
            stmt.executeUpdate(sql);
    
        } catch (SQLException e) {
            throw new RuntimeException("Delete all failed: " + e.getMessage());
        }
    }
    
    public String findAllText() {
        StringBuilder result = new StringBuilder();

        String sql = "SELECT * FROM preces";

        try (Connection conn = connect();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.append(rs.getInt("id"))
                    .append(": ")
                    .append(rs.getString("name"))
                    .append("\n");
            }

        } catch (SQLException e) {
            return "Kļūda: " + e.getMessage();
        }

        return result.toString();
    }


    // Testa metode (programmas starts)
    public static void main(String[] args) {
        Main db = new Main();
        
        db.findAll();        // visi
        
        db.deleteById(2);    // dzēš vienu
            // db.deleteAll();   // dzēš visus
    }
}
    
