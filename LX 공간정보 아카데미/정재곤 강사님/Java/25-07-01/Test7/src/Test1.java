
public class Test1 {

	public static void main(String[] args) {
		
		//Person 붕어빵 틀에서 진짜 붕어빵 만들기
		//항상 new 뒤에서 나와야됨 붕어빵에서 나올때만 써야됨 ★생성자함수라고 부름
		Person person1 = new Person("홍길동1", 21, "010-2105-5551");
		//person1.name = "홍길동1";
		//person1.age = 21;
		//person1.mobile = "010-1000-1000";
		
		Person person2 = new Person("홍길동2", 21, "010-4657-4581");
		//person2.name = "홍길동2";
		//person2.age = 22;
		//person2.mobile = "010-2000-2000";
		
		//이건 특수한 함수인데 입력변수가 3개인 함수를 하나도 없이 호출하려했으니까
		//근데 3개짜리 안만들었으면 그 입력변수가 하나도 없는 함수상자가 자동으로 만들어짐
		//근데 3개짜리 만들면 기존의 입력변수가 하나도 없는 함수상자가 없어짐
		
		System.out.println("person1 변수 상자에 들어가 있는 붕어빵 안에 들어있는 변수상자의 값");
		System.out.println("person1.name : " + person1.name + ", person1.age : " + person1.age + ", person1.mobile : " + person1.mobile);
		System.out.println("person1.name : " + person2.name + ", person1.age : " + person2.age + ", person1.mobile : " + person2.mobile);
		//person1 객체를 하나 불러왔더니 그 안에 함수 상자가 하나 있어서 그걸 실행한거임 실행 자체는 person에서 실행된거임
		
		person1.walk();
		
	
	}
	//여기까지 계속 만들어보기
	//이후 클래스 기능 추가
	

}
