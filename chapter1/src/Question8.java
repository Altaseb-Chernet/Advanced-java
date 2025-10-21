// 8. List the name of all employees whose first name starts with the letter ‘A’.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question8 {

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

        String query = "SELECT Firstname, LastName FROM employees where FirstName like 'A%'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("database is connected successfully");
            while (rs.next()) {
                // use column label or index
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                System.out.println("FirstName: " + FirstName + " | LastName: " + LastName);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
