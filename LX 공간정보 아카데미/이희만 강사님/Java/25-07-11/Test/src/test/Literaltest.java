package test;

public class Literaltest {
	public static void main(String[] args) {
		System.out.println("Hello");  // println은 printstream 클래스 안에 붙어 있음
		
		//1, 1.0, 1.0f, '1', "1"
		float myf = 1.0f;  // 문법에 어긋나니까 float 타입의 변수에 double 타입의 값을 넣으려니까 오류가 나는거임
		int num = '1';
		System.out.println(num); // 문자 1을 저장하는 아스키코드 49 출력
		int num1 = 50;
		System.out.println((char)num1); // 아스키코드 50의 값을 가지는 숫자 2 출력
		
		
	}
}
