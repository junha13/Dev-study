package myjdbc;

import java.util.List;

// EmpServiceImpl이 EmpDAO를 의존하고 있구나.
public class EmpServiceImpl implements EmpService {
	
	
	// EmpDAO dao; - 이것보다 null로 하는게 좋음
	EmpDAO dao = null; // 인스턴스 변수 중에서도 (객체 변수임 ★★★★★★) 

	
	// xml 에서 service 객체 만들때 propertie에 dao를 set함수를 만들어주지 않는다면 밑에 getempLsist함수가 실행이 안됨
	// nullpointer Exception 발생
	
	@Override
	public void setDAO(EmpDAO dao) {
		this.dao = dao;
		
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		// 이 과정을 의존한다고 표현   // 여기에 dao = new DAO() 이런식으로 안해도됨
		// 메서드를 실행할때마다 객체를 생성하지 않아도 됨.
		
		return this.dao.getEmpListByDeptNo(deptNo);
	}

}

// dao 이름을 가진 객체 변수가 하나 있고 메서드가 두개 있네요