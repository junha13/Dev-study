package myjdbc;

import java.sql.*;
import java.util.*;
// 입사년도를 입력받아서 그 해에 입사한 사원목록을 리턴함.

public class EmpDAO {
	// 성, 명을 전달받엇 그 이름에 해당하는 사원정보를 리턴함
	public Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		Emp result = new Emp();
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		// Statment를 생성한다.
		String sql = "select * from employees where department_id = ? and last_name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리를 실행하여 REsultSet을 참조한다
		stmt.setString(1,firstName);
		stmt.setString(2,lastName);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getString("salary");
		}
		//
		return result;
	}

	
	public List<Emp> getEmpListbyHireYear(int hireYear) throws Exception {
		// java.API에 존재하는 interface들이고 이 interface를 이용해서 db접속을 함
		// 드라이버
		List<Emp> output = new ArrayList<Emp>();
		Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = con.createStatement(); // connection interface에 선언되어 있는걸 connectionimple 에 정의되어 있는 메서드를 실행한거고, 리턴타입은 Statement임
		String sql = "select * from employees where hire_date =" + hireYear;
		ResultSet rs = stmt.executeQuery(sql);
		
		
		System.out.println(rs.getClass().getName());
		System.out.println(stmt.getClass().getName());
		
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getString("salary");
			output.add(emp);
		}
		
		return output;
	}
}

// 일단 
