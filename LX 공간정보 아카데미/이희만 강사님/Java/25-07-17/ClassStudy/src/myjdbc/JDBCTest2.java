package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class JDBCTest2 {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		FileReader fr = new FileReader("db-info.properties");
		props.load(fr);
		System.out.println(props.getProperty("url"));
		
		Class.forName(props.getProperty("driverClassName"));
		
		Connection conn = 
				DriverManager.getConnection(props.getProperty("url"), props.getProperty("userName"),
						props.getProperty("password"));
		System.out.println(conn.getClass().getName());
		String sql = "select * from employees";
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String lastName = rs.getString("last_name");
			int salary = rs.getInt("salary");
			System.out.println("last_name=" + lastName + ", salary=" + salary);
		}
		conn.close();
	}

}
