package myspring;

import java.util.List;

public interface EmpService {

	// void setDAO(EmpDAO dao);

	// 메서드를 선언한 것  \\ 선언과 정의는 다름 선언은 이렇게 하고 정의는 하위 클래스에서 정의해야 함.
	List<Emp> getEmpListByDeptNo(int deptNo) throws Exception;

}
