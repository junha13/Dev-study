package myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component  // 어노테이션 부여 ( 스프링 bean이 엮여짐 )
public class EmpDAO {
	
	@Autowired
	DataSource dataSource;
	// 그냥 와이어링 걸어서 쓰면 됨 코드가 확 줄어 ㄸ 
	// 
	
	@Autowired
	SqlSession session;
	
	//성, 명을 전달받아서 그 이름에 해당하는 사원정보를 리턴함. 
	public Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		Emp emp = new Emp();
		Connection conn = dataSource.getConnection();
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
	
	public List<Emp> getEmpListByDeptNo(int deptId) throws Exception {
		return session.selectList("getEmpListByDeptNo", deptId);
		
//		List<Emp> result = new ArrayList<Emp>();
//
//		Connection conn = dataSource.getConnection();
//		String sql = "select * from employees where department_id = ?";
//		PreparedStatement stmt = conn.prepareStatement(sql);
//		stmt.setInt(1, deptNo);
//		ResultSet rs = stmt.executeQuery();
//		while(rs.next()) {
//			Emp emp = new Emp();
//			emp.id = rs.getInt("employee_id");
//			emp.lastName = rs.getString("last_name");
//			emp.salary = rs.getInt("salary");
//			result.add(emp);
//		}
//		return result;
	}
	
	
	/*
	public static List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		//db접속 데이터를 가져와서 result에 담는다. 
		//커넥션을 생성한다. 
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		//Statement를 생성한다. 
		Statement stmt = conn.createStatement();
		//쿼리를 실행하여 ResultSet을 참조한다. 
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
	
	//public static List<Emp> getEmpListByHireDate(int hireDate) throws Exception {
		
//	}

	
	/*
	public static List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		//db접속 데이터를 가져와서 result에 담는다. 
		//커넥션을 생성한다. 
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		//Statement를 생성한다. 
		Statement stmt = conn.createStatement();
		//쿼리를 실행하여 ResultSet을 참조한다. 
		String sql = "select * from employees where job_id = '" + jobId + ''";
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
