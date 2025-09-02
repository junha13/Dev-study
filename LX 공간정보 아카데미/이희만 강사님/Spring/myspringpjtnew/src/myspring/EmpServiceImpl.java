package myspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



// empServiceImpl 이런거 생성 안하고 해도 됨 하지만 객체 와이어링 그런거는 다 해놔야 됨



@Component("empService") //=> spring bean으로 생성되지 못한다.
public class EmpServiceImpl implements EmpService {
	
	// @Autowired // Autowired가 있으니까 EmpDAO  // EmpDAO 클래스에다가 @Repository를 하지 않으면 bean 객체를 못가져와서 autowired에 오류남
	EmpDAO dao = null; // 인스턴스 변수 중에서도 (객체 변수임 ★★★★★★) 

//	
//	public void setDAO(EmpDAO dao) {
//		this.dao = dao;
//	}

	// source - constructor using fields
	// 스프링에서 알아서 생성자를 호출한 다음에 자바빈 객체로 만들어줌
	public EmpServiceImpl(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptId) throws Exception {
		return this.dao.getEmpListByDeptNo(deptId);
	}

	@Override
	public List<Emp> getEmpFirstNLastName(String firstName, String lastName) throws Exception {
		return this.dao.getEmpByFirstNLastName(firstName, lastName);
	}

}

// dao 이름을 가진 객체 변수가 하나 있고 메서드가 두개 있네요