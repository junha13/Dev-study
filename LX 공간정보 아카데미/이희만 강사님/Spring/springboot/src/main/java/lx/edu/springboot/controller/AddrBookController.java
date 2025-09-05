package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lx.edu.springboot.dao.AddrBookDAO;
import lx.edu.springboot.vo.AddrBookVO;


@Controller
public class AddrBookController {
	
	@Autowired
	ApplicationContext context;  // 인터페이스인데도 막 돌아다님

	// 컨트롤러가 있고 메서드만 넣어서 대응되게 하면 될듯
	
	@Autowired
	AddrBookDAO dao;
	
	@RequestMapping("/addrbook_form.do")  // 이 요청경로로 들어오면 메서드 실행
	public String form() {
		return "addrbook_form";  // jsp file name
	}
	
//	@RequestMapping("addrbook_list.do")
//	public String list(HttpServletRequest req) throws Exception {
//		List<AddrBookVO> list = dao.getDBList();
//		// list를 request에 넣는다.
//		req.setAttribute("data", list);
//		return "addrbook_list"; // 권한을 넘긴다?
//	}
	
	@RequestMapping("addrbook_list.do")
	public String list(HttpSession session, HttpServletRequest req) throws Exception {
//		if(session.getAttribute("userId")==null) {  // 이 과정을 인터셉터로 만드는게 더 좋음
//			return "login";
//		}

		ModelAndView result = new ModelAndView();
		List<AddrBookVO> list = dao.getDBList();
		// list를 request에 넣는다.
		req.setAttribute("data", list);
		result.addObject("data", list);
		result.setViewName("addrbook_list");  
		// 로그인 유무를 캐치해서 뭔가를 할거면 이런 controller에 덕지덕지 쓰는게 아니라 인터셉터를 하는거임
		
		return "addrbook_list"; // 권한을 넘긴다?
	}
	
	@RequestMapping("insert.do")
	public String insert(AddrBookVO vo) throws Exception {  // req로 받아서 하나하나 객체에 안넣어줘도 되는거고 그냥 vo를 생성해서 가져오면 되는거임 spring이잖아
		
		System.out.println(vo);
		dao.insertDB(vo);
		
		return "redirect:addrbook_list.do";
	}
	
	@RequestMapping("edit_form.do")
	public ModelAndView edit(@RequestParam("abId") int abId) throws Exception {
		ModelAndView result = new ModelAndView();
		AddrBookVO ab = dao.getDB(abId);
		result.addObject("ab", ab);
		result.setViewName("addrbook_edit_form");
		return result;
	}
	
	@RequestMapping("update.do")
	public String update(AddrBookVO vo) throws Exception {

		int num = dao.updateDB(vo);
		// true, false 처리 할거면
		return "redirect:addrbook_list.do";
	}
	
//	public AddrBookVO makeAddrBookData(HttpServletRequest req) {
//		AddrBookVO addr = new AddrBookVO();
//		addr.abName = req.getParameter("abName");
//		return addr;
//	}
}

