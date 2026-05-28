package rvt.TODODB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TodoDB {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB() {
        initSchema();
    }
    
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {
        String sql = "CREATE TABLE IF NOT EXISTS todo ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "task TEXT NOT NULL) STRICT";

        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement();
        ) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }
    private void add(String task) {
        String sql = "INSERT INTO todo (task) VALUES (?)";
        try (
            Connection conn = connect();
            var pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Add failed: " + e.getMessage());
        }

    }
    private void findAll() {
        String sql = "Select * from todo";
        try (
            Connection conn = connect();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String task = rs.getString("task");
                System.out.println(id + ": " + task);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Find all failed: " + e.getMessage());
        }
    }
    private void removeID(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        try (
            Connection conn = connect();
            var pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Remove failed: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        TodoDB db = new TodoDB();

        db.add("Country House");
        db.add("Blur");

        db.findAll();
    }
}