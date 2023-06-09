package jido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class is used to create a JDBC
 * connection with MySql DB.
 * @author w3spoint
 */
public class hanbai{
	//JDBC and database properties.
	private static final String DB_DRIVER =
		           "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL =
		        "jdbc:mysql://localhost:3306/jido";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";
	private static String SQL = "update product_tb set product_quantity = ? where product_id = ?";
	static Scanner sc = new Scanner(System.in);
	static int sum = 0, otsuri = 0;
    //static Keisan KS = new Keisan();
    static int sentaku;

	public static void nyukin() throws SQLException, InterruptedException {
    	// 入金処理
		System.out.println("商品一覧");
		System.out.println("1.  お水     110円");
		System.out.println("2.  コーラ   120円");
		System.out.println("3.  コーヒー 130円");
		System.out.println("4.  オレンジ 140円");
		System.out.println("5.  お茶     150円");
		System.out.println("6.  緑茶     160円");
    	int inputmoney;

    	System.out.print("入力する金額：");
    	inputmoney = sc.nextInt();

    	sum = inputmoney;
    	sum += otsuri;

    	// 100以下1990より大きい場合再度入力する
    	if (sum <= 100 || sum > 1990) {
    	    System.out.println("->100円以上と1990円未満で入力してください ");
    	    System.out.println(sum + "円を返却されました！");
    	    hanbai.nyukin();
    	} else {// 入力された金額を合計に表示される

    	    System.out.println("入れた金額： " + sum + "円");
    	    System.out.println("---------------------------------------------------");
    	}

    	// 0なら終わっておつりを出る、1なら商品を購入する
    	System.out.println("おつり→0 購入 →1 ");

    	int a = sc.nextInt();
    	if (a == 0) {
    	    System.out.println("お釣り：" + sum);
    	    main(null);
    	}
    }

	public static void main(String args[]) throws SQLException {
		// 商品を表示する
		System.out.println("---------------------------------------------------");
		try {
			nyukin();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("購入可能商品");
		try {
		    Connection conn = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		    Statement stmt = conn.createStatement();
		    // drinkのテーブルを飛び出す
		    ResultSet rs = stmt.executeQuery("select* from product_tb");
		    Scanner num = new Scanner(System.in);
		    while (rs.next()) {
			// 売り切れの処理
			if (rs.getInt("product_quantity") <= 0) {
			    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + "売り切れ");
			}else if (rs.getInt("product_price") > sum) {
			    continue;
			}
			else {
			    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "円");
			}
		    }
		 // 商品を購入される処理と商品のデータを更新する
		    System.out.println("---------------------------------------------------");
		    System.out.println("購入したい商品");
		    sentaku = num.nextInt();
		    switch (sentaku) {
		    case 1:
			rs = stmt.executeQuery("select* from product_tb where product_id = 1");


			while (rs.next()) {
				System.out.println("購入したもの");
				System.out.println("");
			    System.out.println("商品名： " + rs.getString(2));

			    int shohin = rs.getInt(3);
			    otsuri = sum - shohin;
			    System.out.println("お釣り： " + otsuri);
			    update.zaikoupdate(rs.getInt(4), rs.getInt(1));


			}
			break;

		    case 2:
				rs = stmt.executeQuery("select* from product_tb where product_id = 2");
				while (rs.next()) {
					System.out.println("購入したもの");
					System.out.println("");
				    System.out.println("商品名： " + rs.getString(2));

				    int shohin = rs.getInt(3);
				    otsuri = sum - shohin;
				    System.out.println("お釣り： " + otsuri);
				    update.zaikoupdate(rs.getInt(4), rs.getInt(1));

				}
				break;

		    case 3:
				rs = stmt.executeQuery("select* from product_tb where product_id = 3");
				while (rs.next()) {
					System.out.println("購入したもの");
					System.out.println("");
				    System.out.println("商品名： " + rs.getString(2));

				    int shohin = rs.getInt(3);
				    otsuri = sum - shohin;
				    System.out.println("お釣り： " + otsuri);
				    update.zaikoupdate(rs.getInt(4), rs.getInt(1));

				}
				break;

		    case 4:
				rs = stmt.executeQuery("select* from product_tb where product_id = 4");
				while (rs.next()) {
					System.out.println("購入したもの");
					System.out.println("");
				    System.out.println("商品名： " + rs.getString(2));

				    int shohin = rs.getInt(3);
				    otsuri = sum - shohin;
				    System.out.println("お釣り： " + otsuri);
				    update.zaikoupdate(rs.getInt(4), rs.getInt(1));

				}
				break;

		    case 5:
				rs = stmt.executeQuery("select* from product_tb where product_id = 5");
				while (rs.next()) {
					System.out.println("購入したもの");
					System.out.println("");
				    System.out.println("商品名： " + rs.getString(2));

				    int shohin = rs.getInt(3);
				    otsuri = sum - shohin;
				    System.out.println("お釣り： " + otsuri);
				    update.zaikoupdate(rs.getInt(4), rs.getInt(1));

				}
				break;

		    case 6:
				rs = stmt.executeQuery("select* from product_tb where product_id = 6");
				while (rs.next()) {
					System.out.println("購入したもの");
					System.out.println("");
				    System.out.println("商品名： " + rs.getString(2));

				    int shohin = rs.getInt(3);
				    otsuri = sum - shohin;
				    System.out.println("お釣り： " + otsuri);
				    update.zaikoupdate(rs.getInt(4), rs.getInt(1));

				}
				break;


		    default:
			break;
		    }



		    conn.close();
		} catch (Exception ex) {

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
	    }}