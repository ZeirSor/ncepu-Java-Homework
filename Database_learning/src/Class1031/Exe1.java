package Class1031;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exe1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String DB_URL = "jdbc:mysql://localhost:3306/db_test?serverTimezone=UTC";

			Connection connection = DriverManager.getConnection(DB_URL, "root", "1234");

			if (connection != null) {
				System.out.println("success!");
			}

//			String id_toQuery = "1103";

			Statement statement = connection.createStatement();
//			String sql = "SELECT * FROM user where id=" + id_toQuery;
			String sql = "SELECT * FROM user";
			System.out.println(sql);

			ResultSet resultSet = statement.executeQuery(sql);

//			System.out.println(resultSet.getString("id"));

			System.out.println(resultSet);
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("username");
				String age = resultSet.getString("age");

				System.out.println(id + ' ' + name + ' ' + age);
				System.out.println(resultSet);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
