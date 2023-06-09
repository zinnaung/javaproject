package jido;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class zaiko{

    private static String DB_URL = "jdbc:mysql://localhost:3306/jido";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    static int id, price, quantity, a, delete, locate;
    static String name = "";
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);

    public void zaiko() {
	System.out.println("ID   商品名     個数");
	try {
	    Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	    Statement stmt = conn.createStatement();

	    ResultSet rs = stmt.executeQuery("select* from product_tb ");

	    while (rs.next()) {
		System.out.println(rs.getInt(1) + "    " + rs.getString(2) + "    " + (rs.getInt(4)) + "個");
		locate = rs.getInt(1);
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

