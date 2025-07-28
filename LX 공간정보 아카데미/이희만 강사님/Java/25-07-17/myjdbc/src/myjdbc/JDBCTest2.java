package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class JDBCTest2 {
	public static void main(String[] args) throws Exception {
		Class myClass = Class.forName("com.mysql.cj.jdbc.Driver"); // jdbctest2 class를 메모리에 **로딩**한거임
		System.out.println(myClass.getClass().getName());
		
		
		
		// JDBCTest2 test = (JDBCTest2) myClass.newInstance(); // 그 메모리가 뭘 리턴하면 여러 연산이 가능함
		
		// JDBCTest test2 = new JDBCTest();
		
		//Connection conn =
		//		DriverManager.getConnection("")
	}
	
}
