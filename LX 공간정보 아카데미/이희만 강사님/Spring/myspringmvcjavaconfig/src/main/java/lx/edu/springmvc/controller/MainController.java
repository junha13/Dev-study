package lx.edu.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.Session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.edu.springmvc.dao.UserDAO;

@Controller
public class MainController {

	@Autowired
	UserDAO dao;

	
	@GetMapping("login_form.do")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("loginAction.do")
	public String loginAction(HttpServletRequest req, @RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {
		// 클라이언트가 보낸 id, pw가 맞는지 확인작업해함
		System.out.println("id = " + id + ", pw = ");
		if(id.equals(pw)) {
			session.setAttribute("userId", id);  // session이 필요하면 매개변수에다가 session을 넣으면 되잖아 이자석아 진짜 
			return "redirect:addrbook_list.do";
		}
		
		// req.getSession(); 으로 세션 받아서 써도 됨 그렇게 문제는 안되는데 스프링이니까 그냥 매개로 받자
		// 세션은 브라우저에서 들어가면 만들어지는 객체라고 생각하면 됨 (브라우저 닫으면 세션도 없어짐)
		return "redirect:login_form.do";
	}
}
