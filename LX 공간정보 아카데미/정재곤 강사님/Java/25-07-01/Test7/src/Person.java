//사람을 위한 붕어빵 틀 만들기
public class Person {
	String name;
	int age;
	
	//붕어빵 틀에서 실행되는 게 아니라 붕어빵 안에서 만들어지는거임
	//
	boolean walk(int speed) {
		System.out.println(speed + "Km 속도로 걸어갑니다.");
		
		return true;
	}
	
	Person() {
		System.out.println("사람이 만들어졌습니다.");
	}
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
		
		System.out.println("사람이 만들어졌습니다");
	}
	
}
