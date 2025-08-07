package userIfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDAO {
	public static List<String> getJobList() throws Exception { // static을 사용하는 것에 거부감을 안느껴도 될듯 그냥 객체생성없이 한다 느낌으로
		// String[] result = null;
		
		Connection connection = getConnection();
		String sql = "select distinct job_id from employees";
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		List<String> list = new ArrayList<String>();
		while(rs.next()) {  // rs.getString(1)이 뭔지? 다시 보기
			System.out.println(rs.getString(1));
			list.add(rs.getString(1));  // list에 하나씩 추가
		}
		
		String[] result = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		

		
		connection.close();
		// result = (String[]) list.toArray();  // 이부분을 사용할 수 없음 (object라서?)
		// list.toArray(result);

		return list;	
	}
	public static List<Emp> getEmpIfoListByJobId(String jobId) throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select * from employees where job_Id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, jobId);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt(1);
			emp.first_name = rs.getString(2);
			emp.salary = rs.getDouble(8);
			emp.department_id = rs.getInt(11);
			empList.add(emp);
		}
		connection.close();
		return empList;
		
	}
	public static List<Emp> getEmpListByEmpCondition(String searchSelect, Object searchInput) throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select * from employees where ? = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, searchSelect);
		psmt.setObject(2, searchInput);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt(1);
			emp.first_name = rs.getString(2);
			emp.salary = rs.getDouble(8);
			emp.department_id = rs.getInt(11);
			empList.add(emp);
		}
		connection.close();
		return empList;
		
	}
	public static List<Emp> getEmpList() throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select * from employees";
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt(1);
			emp.first_name = rs.getString(2);
			emp.salary = rs.getDouble(8);
			emp.department_id = rs.getInt(11);
			empList.add(emp);
		}
		connection.close();
		return empList;
		
	}
	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
