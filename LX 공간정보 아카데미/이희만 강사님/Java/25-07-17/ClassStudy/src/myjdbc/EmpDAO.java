package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	//성, 명을 전달받아서 그 이름에 해당하는 사원정보를 리턴함 
	public Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		Emp emp = new Emp();
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where first_name = ? and last_name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
		}
		return emp;
	}
	
	public static List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		System.out.println(conn.getClass().getName());
		Statement stmt = conn.createStatement();
		String sql = "select * from employees where department_id = " + deptNo;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}

	public static List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where job_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, jobId);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}
	/*
	public static List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select * from employees where job_id = '" + jobId + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}
	*/

}
