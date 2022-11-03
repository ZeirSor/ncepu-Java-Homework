package db_frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {

	private static String DB_URL = "jdbc:mysql://localhost:3306/ncepu-java?serverTimezone";
	private static String USERNAME = "root";
	private static String PASSWORD = "1234";
	private static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	@SuppressWarnings("finally")
	public static Connection connectDatabase() {
		try {
			Class.forName(LOAD_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			if (connection != null)
				System.out.println("successfully connected to the database!");
			else
				System.out.println("Failed to connect to the database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return connection;
		}
	}

	public static void add(Connection coon, String id, String name, int age) throws SQLException {
		String sql = "insert into student VALUES(?, ?, ?)";
		ps = coon.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		System.out.println(sql);
		ps.execute();
		ps.close();
	}

	public static ResultSet showAll(Connection coon) throws SQLException {
		String sql = "select * from student";
		System.out.println(sql);

		statement = coon.createStatement();
		rs = statement.executeQuery(sql);
//		statement.close();
		return rs;

	}

	public static void del(Connection coon, String id) throws SQLException {
		String sql = "delete from student where id='" + id + "'";
		System.out.println(sql);
		statement = coon.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}

	public static void mod(Connection coon, String oldId, String newId, String name, int age) throws SQLException {
		String sql = "update student set id='" + newId + "',name='" + name + "',age=" + age + " where id='" + oldId
				+ "'";
		System.out.println(sql);
		statement = coon.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}
}
