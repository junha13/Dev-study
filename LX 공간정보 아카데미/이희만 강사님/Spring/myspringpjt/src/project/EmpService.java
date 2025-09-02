package project;

import java.util.List;

public interface EmpService {
	
	void setDAO(EmpDAO dao);
	
	List<Emp> findEmpByYear(int year) throws Exception;
	
	List<Emp> findEmpByDeptId(int deptId) throws Exception;

}
