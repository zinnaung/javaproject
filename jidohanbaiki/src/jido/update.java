package jido;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class update extends zaiko {
    private static String DB_URL = "jdbc:mysql://localhost:3306/jido";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    private static String SQL1 = "update product_tb set product_quantity= ? where product_id = ?";

    public static void zaikoupdate(int quantity, int id) {

	try {
	    Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);

	    try (PreparedStatement rs2 = conn.prepareStatement(SQL1)) {
		rs2.setInt(1, quantity - 1);
		rs2.setInt(2, id);

		rs2.executeUpdate();
	    }
	    conn.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }


    private static Connection getConnection(String dbURL, String userName, String password) {
	Connection conn = null;
	try {
	    conn = DriverManager.getConnection(dbURL, userName, password);
	} catch (Exception ex) {
	    System.out.println("connect failure!");
	    ex.printStackTrace();
	}
	return conn;
    }
}
