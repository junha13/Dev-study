
public class Tesettestsetsetsetsetsets {

	public static void main(String[] args) {
		
		//변수 상자 만들기
		String name1;
		name1 = "홍길동1";
		
		String name2 = "홍길동2"; //변수에 값 넣어주는걸 초기화라고 함
		
		int age1 = 21;
		int age2 = 22;
		
		int output = age1 + age2;
		
		System.out.println("더하기 결과 : " + output);
		
		//함수 상자 실행하기, 함수를 호출한거임
		print1();
		print2(25);
		int output1 = add(4, 5);
		System.out.println("더하기 결과는 : " + output1);
		
		// 붕어빵 만들기 변수상자 정리
		
		FishFish fish1 = new FishFish();
		fish1.name = "광어";
		fish1.age = 21;
		System.out.println(fish1.name + fish1.age);
		System.out.println("물고기의 이름" + fish1.name);
		
		Person person1 = new Person();
		boolean isPerson = person1.walk(8);
		System.out.println("walk 함수 실행결과" + isPerson);
		
		
		fish1.babies.add(new Baby());
		System.out.println("아기 물고기는 몇마리? : " + fish1.babies.size());
		
	}
	
	
	
	static int add(int a, int b) {
		return a + b;
	}
	
	static void print2(int speed) {
		System.out.println("스피드는 " + speed + "Km 입니다");
	}
	
	//함수 상자 생성하기
	static void print1() {
		System.out.println("print1 함수가 실행되었습니다.");
	}
	
	

}
