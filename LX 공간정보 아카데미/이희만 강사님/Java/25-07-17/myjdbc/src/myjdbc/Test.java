package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		// 입사년도를 입력받아서 그 해에 입사한 사원목록을 리턴함.
		System.out.print("입사년도 : ");
		Scanner sc = new Scanner(System.in);
		int hireYear = sc.nextInt();
		while(hireYear!=0) {
			System.out.println(hireYear);
			List<Emp> empList = getEmpListbyHireYear(hireYear); 
			for(Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println("부서번호 0은 종료 : ");
			hireYear = sc.nextInt();
		}
	}
	
	
	public static List<Emp> getEmpListbyHireYear(int hireYear) throws Exception {
		List<Emp> output = new ArrayList<Emp>();
		Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = con.createStatement(); 
		String sql = "select * from employees where year(hire_date) =" + hireYear;
		ResultSet rs = stmt.executeQuery(sql);
		
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
