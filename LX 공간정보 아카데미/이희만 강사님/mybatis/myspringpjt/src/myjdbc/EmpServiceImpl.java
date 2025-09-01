package myjdbc;

import java.util.List;

// EmpServiceImpl이 EmpDAO를 의존하고 있구나.
public class EmpServiceImpl implements EmpService {
	
	EmpDAO dao;

	@Override
	public void setDAO(EmpDAO dao) {
		this.dao = dao;
		
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		// 이 과정을 의존한다고 표현
		return this.dao.getEmpListByDeptNo(deptNo);
	}

}
