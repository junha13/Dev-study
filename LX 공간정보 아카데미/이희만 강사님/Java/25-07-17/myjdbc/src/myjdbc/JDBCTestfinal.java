package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTestfinal {
	public static void main(String[] args) throws Exception {
		// 드라이버 클래스를 메모리로 로딩한다.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 커넥션을 생성한다.
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		// 스테이트먼트를 생성하다
		Statement stmt = con.createStatement();

		// 쿼리를 실행하여 ResultSet을 참조한다.
		String sql = "select * from employees";
		ResultSet rs = stmt.executeQuery(sql);
		
		
		// DB를 읽어온다.
		while(rs.next()) {
			String lastName = rs.getString("last_name");
			System.out.println(lastName);
		}
		// ResultSet을 닫는다. Statement도 닫는다. Connection도 닫는다.
		con.close();
	}

}
