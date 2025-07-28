package myjdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		FileReader fr = new FileReader("db-info-properties");
		props.load(fr);
		System.out.println(props.getProperty("url"));
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Class class가 있고 그 안에 forname 메서드가 존재하고 실행한거, 
		
		Connection conn = 
				DriverManager.getConnection(props.getProperty("url"), props.getProperty("userName"), props.getProperty("password"));
		// DriverManager클래스 getConnection 메서드를 이용해 커넥션 타입의 객체에 저장
		// System.out.println(conn.getClass().getName()); => ConnectionImpl 클래스에 잇음
		
		String sql = "select * from employees";
		System.out.println(conn.getClass().getName());
		
		Statement stmt = conn.createStatement();

		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String lastName  = rs.getString("last_name");
			int salary = rs.getInt("salary");
			System.out.println("last_name = " + lastName + ",\t salary=" + salary);
		}
		// next는 ResultSet이란 인터페이스에 선언되어 있는 메서드를 하위 클래스에서 상속받아 정의하고 그 메소드를 실행하여 !!타입 변수에 담고 있음
		
		//System.out.println(rs.getString("last_name"));
		
		conn.close();
		System.out.println("김준하 바보");
		
	}
}
