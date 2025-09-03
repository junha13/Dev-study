package lx.edu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AddrBookController {

	// 컨트롤러가 있고 메서드만 넣어서 대응되게 하면 될듯
	
	@Autowired
	AddrBookDAO dao;
	
	@RequestMapping("/addrbook_form.do")  // 이 요청경로로 들어오면 메서드 실행
	public String form() {
		return "addrbook_form";  // jsp file name
	}
	
	@RequestMapping("addrbook_list.do")
	public String list(HttpServletRequest req) throws Exception {
		List<AddrBookVO> list = dao.getDBList();
		// list를 request에 넣는다.
		req.setAttribute("data", list);
		return "addrbook_list"; // 권한을 넘긴다?
	}
	
	@RequestMapping("insert.do")
	public String insert(AddrBookVO vo) throws Exception {  // req로 받아서 하나하나 객체에 안넣어줘도 되는거고 그냥 vo를 생성해서 가져오면 되는거임 spring이잖아
		
		System.out.println(vo);
		dao.insertDB(vo);
		
		return "redirect:addrbook_list.do";
	}
	
//	public AddrBookVO makeAddrBookData(HttpServletRequest req) {
//		AddrBookVO addr = new AddrBookVO();
//		addr.abName = req.getParameter("abName");
//		return addr;
//	}
}

