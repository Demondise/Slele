package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDataManager {
	static Connection conn;
	static ResultSet res;

	public static void setupDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("sql.bsite.net\\MSSQL2016", "shivam9899_", "Shivam@123");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public static void runSqlquerry(String querry) {
		try {
			PreparedStatement s = conn.prepareStatement(querry);
			res = s.executeQuery();
			s.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getResult() {
		try {
			while (res.next()) {
				System.out.println("id " + res.getInt("id") + " | " + "name " + res.getString("name"));
			}
			res.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
