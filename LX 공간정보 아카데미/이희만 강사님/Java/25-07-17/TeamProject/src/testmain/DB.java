package testmain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DB {

	// *****보완 필요*****
	// 사람 이름으로 사람 정보 얻는 메서드로, **전체 이름(King Steven)**을 넣으면 그 사람 정보을 뽑아줌
	// id, name, salary 출력
	// 특이점은 대소문자 구분 없이 넣으면 되고, 중복 이름은 없지만 중복처리를 제거해주면 좋을듯 함
	// 그거 말고는 띄어쓰기를 안해도 검색이 가능하거나 그러면 좋을 듯 함
	public static List<Emp> getEmpInfoByEmpName(String empName) throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn =
				DriverManager.getConnection(DBConfig.set("url"), "root", "rootroot");
		String sql = "select * from employees where lower(concat(last_name, ' ', first_name)) = lower(?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,empName);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getString("salary");
			list.add(emp);
		}
		return list;
	}
}