//  4. Display all cities that employees belong to but don’t allow repetition. 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question4 {

    static String url = "jdbc:mysql://localhost:3306/northwind";
    static String user = "root";
    static String password = "";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found: " + e);
            return;
        }

        String query = "SELECT DISTINCT City FROM customers";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("database is connected successfully");
            while (rs.next()) {
                // use column label or index
                String city = rs.getString("City");
                System.out.println("City: " + city);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
