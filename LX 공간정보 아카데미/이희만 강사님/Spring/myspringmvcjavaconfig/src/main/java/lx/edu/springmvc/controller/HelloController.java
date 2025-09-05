package lx.edu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // MVC 중 controller로 만든거임
public class HelloController {
	
	
	@RequestMapping("/hello.do")
	public String hello() {
		return "hello";  // hello.jsp를 리턴하는거임 ( 자동으로 /WEB-INF/views/return.jsp 로 바뀜
						 // servlet-context에서 surfix, prefix 참고하면 됨
	}

}
