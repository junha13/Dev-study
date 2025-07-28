package test4;

public class test2 {

	public static void main(String[] args) {
		
		//더하기 함수 실행
		int a = 10;
		int b = 10;
		
		//변수의 유효범위, 상자 안에 있는 ab랑 위에 ab는 다른 애임
		int c = add(a, b);
		System.out.println("더하기 결과 : " + c);
		
		
		int d = subtract(a, b);
		System.out.println("빼기 결과 : "+d);
		
		//print1, walk 함수 실행, 받을 상자도 없음
		print1();
		walk(10);
		walk(12);
		
	}
	static void walk(int speed) {
		System.out.println(speed + "KM 속도로 걸어갑니다.");
	}
	static int add(int a, int b) {
		return a+b;
	}
	static int subtract(int a, int b) {
		return a-b;
	}
	static void print1() { //콘솔에 출력하는 함수 상자
		System.out.println("print1 함수가 실행되었어요.");
	}
}
