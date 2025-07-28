
public class Test2 {

	public static void main(String[] args) {

		//함수상자를 실행하기 - 호출하기 
		int output1 = add(10, 10);
		System.out.println("더하기 결과 : " + output1);
		
		print1();
		
		print2("홍길동");
		
	}
	
	static void print1() {
		System.out.println("print1 함수 호출됨");
	}
	
	static void print2(String name) {
		System.out.println("print2 함수 호출됨 -> " + name);
	}
	
	//함수 상자 만들기 (선언, 정의하기)
	static int add(int a, int b) {
		int output = a + b;
		return output;
	}
}
