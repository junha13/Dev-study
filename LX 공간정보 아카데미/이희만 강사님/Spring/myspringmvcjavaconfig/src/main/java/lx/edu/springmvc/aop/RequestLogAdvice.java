package lx.edu.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lx.edu.springmvc.dao.RequestLogDAO;
import lx.edu.springmvc.vo.RequestLogVO;

@Aspect
@Component
@EnableAspectJAutoProxy
public class RequestLogAdvice {
	
	@Autowired
	RequestLogDAO dao;
	
	@Before("execution(* lx.edu.springmvc.controller.Addr*.*(..))")
	public void beforeLog(JoinPoint joinPoint) throws Exception {
		System.out.println("LogAdvice.beforeLog()"); 

		String targetClass = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		
		RequestLogVO vo = new RequestLogVO();
		vo.setReqClass(targetClass);
		vo.setReqMethod(methodName);
		
		dao.insertDB(vo);
		
		System.out.printf("class=%s, method=%s\n", targetClass, methodName);
	}
}
