//  1.Get Order id, Product id, Unit price from Order Details.

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Question1 {

  static String url = "jdbc:mysql://localhost:3306/northwind";
  static String user = "root";
  static String password = "";

  public static void main(String[] args) throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, user, password);
      System.out.println("database is connected succesfully");
      System.out.println("===Order Details===");
      Statement stmt = conn.createStatement();
      String query = "SELECT od.OrderID, od.ProductID, p.ProductName, p.Unit, p.Price " +
          "FROM orderdetails od " +
          "JOIN products p ON od.ProductID = p.ProductID";

      ResultSet res = stmt.executeQuery(query);

      System.out.println("\nOrderID | ProductID | ProductName | Unit | Price");

      // Loop through the result set
      while (res.next()) {
        int orderId = res.getInt("OrderID");
        int productId = res.getInt("ProductID");
        String unit = res.getString("Unit");
        String price = res.getString("Price");

        System.out.println(orderId + " " + productId + " " + unit + " " + price);

      }

      // Close resources
      res.close();
      stmt.close();
      conn.close();

    } catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }
}
