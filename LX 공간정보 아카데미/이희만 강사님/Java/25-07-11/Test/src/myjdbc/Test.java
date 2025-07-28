package myjdbc;

public class Test {

	public static void main(String[] args) {
		// 메모리, 할당, 이름
		// 변수는 할당받은 메모리 공간에 대한 이름
		int count = 100; // 변수가 무엇인가?
		
		int count2; // 메모리를 할당받고 그 공간을 count 이름으로 참조하게 한다.
		count2 = 100; // 할당받은 메모리 공간에 100이라는 숫자를 기입한다.
		count2 = Integer.MAX_VALUE; // Integer는 클래스임 MAX_VALUE는 INTEGER 타입의 변수임  -2^31 ~ 2^31-1 32bit니까 1bit는 부호임
		System.out.println(count2);
		System.out.println(Integer.toBinaryString(count2));
		count2 = count2 + 1;
		System.out.println(count2);
		System.out.println(Integer.toBinaryString(count2));
		count2 = count2 + 1;
		System.out.println(count2);
		System.out.println(Integer.toBinaryString(count2));
		String name = new String("HAHA"); // 생성된 객체의 주소를 name변수로 할당받은 공간에 기입한다.
		
	}

}
