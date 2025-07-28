package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class EmpMain {
	public static void main(String[] args) throws Exception {
		
		// 부서번호를 입력받아서 그 부서에 근무하는 사원들의 목록을 출력함
		System.out.print("부서번호 : ");
		Scanner scan = new Scanner(System.in);
		int deptNo = scan.nextInt();
		while(deptNo!=0) {
			System.out.println(deptNo);
			List<Emp> empList = getEmpListByDeptNo(deptNo); 
			for(Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println("부서번호 0은 종료 : ");
			deptNo = scan.nextInt();
		// 부서정보를 전달받아서 그 부서의 부서원정보를 리턴함 메서드명은 getEmpListByDeptNo
		
		}
	}

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

}
