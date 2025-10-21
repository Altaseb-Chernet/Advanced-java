import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Question3 {

    static String url = "jdbc:mysql://localhost:3306/northwind";
    static String user = "root";
    static String password = "";

  public static void main(String[] args) throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, user, password);
      System.out.println("database is connected succesfully");
      Statement stmt = conn.createStatement();
      String query = """
            SELECT 
                od.OrderID,
                SUM(od.Quantity * p.Price) AS TotalOrderPrice
            FROM 
                orderdetails od
            JOIN 
                products p ON od.ProductID = p.ProductID
            GROUP BY 
                od.OrderID;
            """;

        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
                int orderId = res.getInt("OrderID");
                double total = res.getDouble("TotalOrderPrice");
                System.out.println("Order ID: " + orderId + " | Total Price: $" + total);
            }
}
    catch (Exception e) {
      System.out.println("Error: " + e);
    }
}
}
