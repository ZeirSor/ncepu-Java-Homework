package databaseVisit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseOperations {

	private Scanner sc = new Scanner(System.in);

	private String DB_URL = "jdbc:mysql://localhost:3306/ncepu-java?serverTimezone";

	private String USERNAME = "root";

	private String PASSWORD = "1234";

	public static void main(String[] args) {
		new DatabaseOperations();
	}

	public DatabaseOperations() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			if (connection != null) {
				System.out.println("Database connection succeeded!");
			}
			System.out.println("---------------------------------");

			// 先清空表格
			truncateTable(connection);
			queryAllInfo(connection);
			// 通过插入录入三条信息
			insertInfo(connection, "算法图解", 27.5, "赵峰");
			insertInfo(connection, "Java基础教程", 25.7, "张三");
			insertInfo(connection, "深入理解Java虚拟机", 52.7, "李四");
			// 展示表格信息
			queryAllInfo(connection);

			vagueQueryInfo(connection, "Java");

			// 通过键盘输入新增一本书。
			System.out.println("Please enter the title, price, author in order");
			String bookname = sc.nextLine();
			double price = sc.nextDouble();
			sc.nextLine();
			String author = sc.nextLine();
			insertInfo(connection, bookname, price, author);
			queryAllInfo(connection);

			// 删除价格大于30元的所有图书.
			delete_accordingToPrice(connection, 30);
			queryAllInfo(connection);

			// 将作者的名字由“峰”改为“锋”（前提是至少包含一位带峰字的作者）
			authorInfo_vagueReplace(connection, "峰", "锋");
			queryAllInfo(connection);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void queryAllInfo(Connection connection) {
		System.out.println("---------database query---------");
		String sql = "select" + " " + "*" + " " + "from book";
		System.out.println(sql);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String bookname = resultSet.getString("bookname");
				String price = resultSet.getString("price");
				String author = resultSet.getString("author");
				System.out.println(bookname + " " + price + " " + author);
			}

			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("---------------------------------");
		}

	}

	public void insertInfo(Connection connection, String bookname, double price, String author) {
		System.out.println("---------database insert---------");
		String sql = "insert into book values(" + "'" + bookname + "', " + price + ", '" + author + "')";
		System.out.println(sql);

		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();
			System.out.println("insert succeeded!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void truncateTable(Connection connection) {
		String sql = "truncate table book";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void vagueQueryInfo(Connection connection, String info) {
		System.out.println("---------database vague query---------");
		String sql = "select * from book where bookname like " + "'%" + info + "%'";
		System.out.println(sql);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String bookname = resultSet.getString("bookname");
				String price = resultSet.getString("price");
				String author = resultSet.getString("author");
				System.out.println(bookname + " " + price + " " + author);
			}

			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete_accordingToPrice(Connection connection, double price) {
		System.out.println("---------database delete according to price---------");
		String sql = "DELETE from book where " + "price>" + price;
		System.out.println(sql);

		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void authorInfo_vagueReplace(Connection connection, String oldInfo, String newInfo) {
		System.out.println("---------database author Info vague Replace---------");
		String sql = "update book set author=replace(author, '" + oldInfo + "', '" + newInfo + "')";
		System.out.println(sql);

		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
