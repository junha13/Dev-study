package lx.edu.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAdvice {
	
	@Before("execution(* lx.edu.springmvc.controller.Addr*.*(..))") // bean이 되길래 execution도 되겠구나 햇는데 
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println("LogAdvice.beforeLog()"); // 실행하라고 한 적이 없는데 런타임 시에 실행이 됨
		// addrbook이 객체로 생성된 다음 문자를 띄워야하니까 
		// 메서드가 실행될때마다 로그가 찍히는거임
		// 이걸 외부에서 aop로 엮은거임
		
		Class targetClass = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		
		System.out.printf("class=%s, method=%s\n", targetClass.getName(), methodName);
		// 결코 메서드에 일일히 로그를 찍는게 아니라 이렇게 모아서 찍어야됨 (controller에 집어넣는게 아님)
	}
}
