package addrbook;

import java.util.List;

public class AddrBookMain {
	public static void main(String[] args) throws Exception {
		System.out.println("addrbook id list");
		
		// 사용자의 아이디를 출력할 수 있음
		// 이렇게만 하면 오류가 나는데, jndi
		List<AddrBookVO> list = new AddrBookDAO().getDBList();
		for(AddrBookVO vo : list) {
			System.out.println(vo);
		}
	}

}
