import java.util.ArrayList;

import com.lx.animal.*;
import com.lx.person.Person;

public class Test1 {
	
	// System.out.println("안녕!"); // 실행코드는 무조건 함수 안에 들어가야 함.
	// String name2 = "홍길동2"; // 실행코드가 아니고 선언코드임, 근데 이건 계속 살아있음
	// name2 = "홍길동3"; // 얘는 또 실행코드임 ㄷㄷ 함수상자 안에 들어가야 함.
	static int count = 0; // 왜인지는 모르겠는데 static 붙혀야됨
	
	public static void main(String[] args) { //이 static도 Test1이라는 클래스에 진짜로 붙어있는 거임
		
		// 변수 상자 만들기
		String name1 = "홍길동1"; // 이거는 main 함수가 끝나면 없어짐
		int age1 = 21; // 변수 상자 크기 = 자료형
		boolean isPerson = true;
		float weight = 80.5f;  // double이 너무 크니까 조금 작은걸 만든거임 
		double weight2 = 80.5;  // 메모리가 엄청 많이 들어감 너무 큼 
		
		int output1 = age1 + 20;
		System.out.println("더하기 결과 : " + output1);  // 1번
		
		// 함수 상자
		int output2 = add(age1, 10);
		System.out.println("더하기 결과 : " + output2);
		
		// 붕어빵 틀에서 붕어빵 만들기
		Person person1 = new Person();
		person1.name = "d";
		System.out.println("Person1 변수상자에 들어가있는 붕어빵의 이름 : " + person1.name);
		
		Person person2 = new Person("홍길동");
		System.out.println("Person2 변수상자에 들어가있는 붕어빵의 이름 : " + person2.name);  // 4번
		
		// 만들어진 붕어빵(동물)의 개수 저장하기
		// int count = 0;
		
		
		
		Animal animal1 = new Animal();
		// count = count +1;
		// addCount();
		// Animal.count = Animal.count + 1;
		animal1.name = "동물1";
		animal1.walk();
		
		Dog dog1 = new Dog();
		// count = count +1;
		// addCount();
		// Animal.count = Animal.count + 1;
		dog1.name = "강아지1";
		dog1.age = 1;
		dog1.walk();
		Animal dog2 = new Dog();
		
		Cat cat1 = new Cat();
		// count =+1;
		// addCount();
		// Animal.count = Animal.count + 1;
		cat1.name = "고양이1";
		cat1.run();          //5번
		
		System.out.println("만들어진 동물 마릿수 : " + Animal.count);
		
		// 하나의 변수 상자 
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(dog1);
		animals.add(cat1);
		System.out.println("동물 마릿수 : " + animals.size());
		
		Animal out1 = animals.get(0);
		out1.walk();
		System.out.println("첫 번째 동물의 이름 : " + out1.name);
		
		Animal out2 = animals.get(1);
		Cat out3 = (Cat) out2;
		out3.run();
		
		
		// *클래스에 입력된 실제 것들
		// 클래스 변수
		// 클래스 메서드
		
		// *실제 붕어빵에 입력되는 것들
		// 인스턴스 변수 (멤버 변수)
		// 인스턴스 메서드 (함수, 멤버 함수)
		
	}
	
	static void addCount() {
		count = count + 1;
	}
	
	// 함수 상자 만들기
	static int add(int a, int b) {
		System.out.println("안녕하세요");

		return a + b;   // 2번
	}

}
