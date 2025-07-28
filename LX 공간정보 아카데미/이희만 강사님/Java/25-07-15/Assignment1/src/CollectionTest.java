import java.util.*;

public class CollectionTest {
	public static void main(String[] args) {
		
		// collectionTest api는 배열과 관련이 있음, 배열의 갯수가 지정되어 있어서 제한적임
		// collectionTest는 타입과 갯수에 상관이 없음 // List, Map, Set, Iterator
		
		List list = new ArrayList(); // List는 interface임, 뒤에 있는건 class임
		// List는 동적 배열, index로 참조한다. 0번째, 1번째
		list.add(33);
		list.add("dd");
		list.add(new Employee());
		
		list.size(); 
		String str = (String) list.get(1);  // 그래서 3의배수할때 LIST로 넣었어도 됐을듯
		
		List<String> list2 = new ArrayList<String>();
		list2.add("11");
		String str2 = list2.get(0);
		
		
		// ArrayList list = new ArrayList(); // 9번줄 처럼 코딩하기보다 10번줄 처럼 해야됨
		//List list = makeList();
		
		// map (name, value)로 관리 컨테이너, 뭔가 담아두는 것
		Map<String, Object> map = new HashMap<String, Object>();  // hashmap누르고 f4누르면 상위 클래스 형태를 알려줌
		// map은 STACK영역에 64bit 메모리의 공간의 이름으로, 힙 영역에 new HashMap으로 생성된 객체의 주솟값을 가지고 있다.
		map.put("name", "Heeman");
		map.put("pw", "12345");
		String name = (String) map.get("name");
		map.put("list", list2); // object가 개신기하네
		
		
		// set : 수학의 set : 중복되지 않은 요소들 가지고 있는 콜렉션
		Set<String> keySet = map.keySet();  // keyset은 Map이라는 인터페이스에 붙어있는 메서드로, Hashmap에 오버라이드 되어 실행중임
	}

//	private static List makeList() {
//		// TODO Auto-generated method stub
//		return new Vector();
//	}

}
