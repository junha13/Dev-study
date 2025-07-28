package basic;

public class ConstructorTest {
	public static void main(String[] args) {
		User user1 = new User("heeman");
		//생성자는 없어도 되지만 있으면 존재하는 생성자만 호출가능하다.
	}
}

class User {
	User(String name){
		
	}

}