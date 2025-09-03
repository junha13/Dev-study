package myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		// ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		// 이걸 읽으라고 시키는거임 - xml파일을 읽게 되면 java 패키지, 파일에서 
		// 이제 어노테이션 태그가 붙은 애들을 찾아가서 spring bean 객체로 생성하는거임
		
		EmpService service = (EmpService) context.getBean(EmpService.class);
		// overloading -> 같은 클래스 안에서 이름만 같고 **매개변수**만 다르게 여러 버전의 메서드를 만드는 것.
		// 다형성의 법칙임 
		
//		
//		// 어노테이션 방식이라서 service가 아닌 empServiceImpl 클래스명이 와야됨
//		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
//
//		for(Emp emp : empList) {
//			System.out.println(emp);
//		}
		
		String firstName = "Steven";
		String lastName = null;
		List<Emp> empList = service.getEmpFirstNLastName(firstName, lastName);
		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}	
}

//


