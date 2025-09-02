package project;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmpDAO {
	
	@Autowired
	SqlSession session;
	
	public List<Emp> findEmpByYear(int year) throws Exception {
		return session.selectList("findEmpByYear", year);
	}
	public List<Emp> findEmpByDeptId(int deptId) throws Exception {
		return session.selectList("findEmpByDeptId", deptId);
	}

}
