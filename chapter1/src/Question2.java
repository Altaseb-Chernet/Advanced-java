import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Question2 {

    static String url = "jdbc:mysql://localhost:3306/northwind";
    static String user = "root";
    static String password = "";

  public static void main(String[] args) throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, user, password);
      System.out.println("database is connected succesfully");
      Statement stmt = conn.createStatement();
      String query = "select firstName from employees where firstName='Nancy'";
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            String firstName = res.getString("firstName");
            System.out.println("First Name: " + firstName);

    }
}
    catch (Exception e) {
      System.out.println("Error: " + e);
    }
}
}
