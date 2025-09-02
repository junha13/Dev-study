package project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDAO dao;

	@Override
	public void setDAO(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Emp> findEmpByYear(int year) throws Exception {
		return this.dao.findEmpByYear(year);
	}

	@Override
	public List<Emp> findEmpByDeptId(int deptId) throws Exception {
		return this.dao.findEmpByDeptId(deptId);
	}

}
