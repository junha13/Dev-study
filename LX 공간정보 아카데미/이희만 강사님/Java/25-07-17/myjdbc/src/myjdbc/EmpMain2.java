package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class EmpMain2 {
	public static void main(String[] args) throws Exception {
		
		// 부서번호를 입력받아서 그 부서에 근무하는 사원들의 목록을 출력함
		System.out.print("job_id : ");
		Scanner scan = new Scanner(System.in);
		String jobId = scan.nextLine();
		while(jobId != null && jobId.length()!=0) {
			System.out.println(jobId);
			List<Emp> empList = getEmpListByJobId(jobId); 
			for(Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println("부서번호 0은 종료 : ");
			jobId = scan.nextLine();
		// 부서정보를 전달받아서 그 부서의 부서원정보를 리턴함 메서드명은 getEmpListByDeptNo
		
		}
	}

	private static List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		// db접속 데이터를 가져와서 result에 담는다.
		// 커넥션을 생성한다.
		Connection conn1 = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		// Statment를 생성한다.
		Statement stmt1 = conn1.createStatement();
		// 쿼리를 실행하여 REsultSet을 참조한다
		String sql1 = "select * from employees where department_id = '" + jobId + "'"; // Strimg이면 
		ResultSet rs1 = stmt1.executeQuery(sql1);
		while(rs1.next()) {
			Emp emp = new Emp();
			emp.id = rs1.getInt("employee_id");
			emp.lastName = rs1.getString("last_name");
			emp.salary = rs1.getString("salary");
			result.add(emp);
		}
		//
		return result;
	}

	private static List<Emp> getEmpListByDeptNo(String deptNo) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		// db접속 데이터를 가져와서 result에 담는다.
		// 커넥션을 생성한다.
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		// Statment를 생성한다.
		String sql = "select * from employees where department_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리를 실행하여 REsultSet을 참조한다
		stmt.setSting(1,deptNo);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getString("salary");
			result.add(emp);
		}
		//
		return result;
	}
	/*
	private static List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		// db접속 데이터를 가져와서 result에 담는다.
		// 커넥션을 생성한다.
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		// Statment를 생성한다.
		Statement stmt = conn.createStatement();
		// 쿼리를 실행하여 REsultSet을 참조한다
		String sql = "select * from employees where department_id = " + deptNo;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getString("salary");
			result.add(emp);
		}
		//
		return result;
	}
*/
}
