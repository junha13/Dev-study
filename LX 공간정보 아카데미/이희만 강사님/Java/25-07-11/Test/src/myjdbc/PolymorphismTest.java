package myjdbc;

public class PolymorphismTest {
	public static void main(String[] args) {
		System.out.println(1); // System 클래스의 out 변수
		System.out.println("1"); // 메서드를 호출, 실행 한거임    정의, 실행, 선언
		System.out.println();
		// 서로 다른 메서드인거임
		Sample sam = new Sample();  // 
		sam.change(333);
		// change라는 메서드를 실행한거임 sample클래스 내부에 붙어있음
		// 객체생성으로 인해 호출이 된거임
		
	}
}
	
class Sample {
	// overload
	void change(String string) {
		
	}
	// overload
	void change(int i) {
		
	}
	
}
	// 이런걸 다형성이라고 하고, 재정의라고 함 overload
	

