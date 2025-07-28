
public class ClassTest2 {
	public static void main(String[] args) {
		Util util1 = new Util();
		util1.name = "hahaha";
		System.out.println(util1.name);
		Util util2 = new Util();		
		System.out.println(util2.name);  // util2의 이름도 hahaha로 참조됨 static이라서 
		
		Util.getName();
		//Sam2.amount
	}

}

class Util {
	static String name;
	public static String getName() {
		return name;
	}
}

class Sam2 {  // 힙 영역에 메모리 공간을 차지한 것이 객체임
	int count; // 인스턴스 변수  instance 변수, 객체변수  => 객체를 생성하고나서 참조가능하기에
	static int amount; // 클래스 변수 => 이 클래스로 생성된 모든 객체가 공유하기에
	void print() {
		int localCount; // 로컬변수, 지역변수 // 해당 지역에서만 참조 가능하기에 지역은 { } 블럭이다.
		try {
			int myCount = 500;  // 이 로컬변수(이건 임시변수일수도)가 이 지역 안에서만 정의되어 있기 때문에 밑에서 호출이 안됨 
		} catch(Exception e) {
			
		}
		//System.out.println(myCount);
	}
	// 메서드가 문자열을 출력할 수 있게끔 return으로 착각하면 안됨
}
