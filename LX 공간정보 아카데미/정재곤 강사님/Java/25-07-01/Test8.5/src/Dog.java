
public class Dog {
	String name;
	
	//기본 생성자 함수
	Dog () {
		System.out.println("강아지가 만들어졌어요.");
		
	}
	
	//이름을 전달받는 생성자 함수
	Dog (String name) {
		this.name = name;
		
		System.out.println("강아지가 만들어졌어요 -> " + name);
		
	}
	
}
