package basic;


public class SingletonTest {
	public static void main(String[] args) {
		// MySingleton singleton1 = new MySingleton();  // 생성자가 private로 막혀있어서 내부에서만 호출 가능
		
		// 객체가 여러개 생성되지 않음
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = MySingleton.getInstance();
		MySingleton singleton3 = MySingleton.getInstance();
		MySingleton singleton4 = MySingleton.getInstance();
		
	
	}
}

class MySingleton {
	private static MySingleton me = new MySingleton();
	private MySingleton() {
		System.out.println("MySingleton");
	}
	public static MySingleton getInstance() {
		return me;
	}
}