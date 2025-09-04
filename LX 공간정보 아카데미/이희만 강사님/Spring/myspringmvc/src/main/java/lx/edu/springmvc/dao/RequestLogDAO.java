package lx.edu.springmvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.edu.springmvc.vo.RequestLogVO;

@Component
public class RequestLogDAO {

	@Autowired
	SqlSession session;
	
	public int insertDB(RequestLogVO vo) throws Exception { 
		return session.insert("mapper-requestlog.insertDB", vo);
	}

	
}
