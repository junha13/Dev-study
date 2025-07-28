package myjdbc;

public class ConstructorTest {
	 public static void main(String[] args) {
		//String str = new String(55); // 생성자를 실행한거임
		// int 타입의 매개변수를 받는 생성자가 정의되어 있지 않다.
		User user = new User();
		User user1 = new User();
		User user2 = user1;
		User user3 = new User("heeman");
		// 2개의 객체가 생겼고 1개의 객체에 대해 2개의 변수가 레퍼런스 하는거임 ㄷㄷ 
		// 생성자는 없어도 되지만 있으면 있으면 존재하는 생성자만 호출 가능하다. 
	 
	 }

}

class User {
	User(String name) {  // 생성자함수
		
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
