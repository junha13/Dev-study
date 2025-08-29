package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMainMybatis {
	public static void main(String[] args) throws Exception {
		String resource = "configuration.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		// emp 사용
		// Emp vo = session.selectOne("getEmpListByDeptId",100); 
		// (mapper-id / 입력값) 이기 때문에 sql문에 100이라는 값이 입력된거임
		List<Emp> list = session.selectList("getEmpListByDeptId", 80); 
		for(Emp vo : list) {
			System.out.println(vo.lastName);
		}
	}
}
 