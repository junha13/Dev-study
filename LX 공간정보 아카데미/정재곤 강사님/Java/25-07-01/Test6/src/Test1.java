
public class Test1 {

	public static void main(String[] args) {
		//붕어빵 틀을 만들고 뒤에 ()를 붙힘, 새로운 객체도 메모리에 둬야 하기때문에 변수 상자에 넣어야됨
		 Fish fish1 = new Fish(); //변수 상자의 크기는 모르니까 Fish로 함
		 
		 //붕어빵 안에 들어있는 변수 상자에 값을 넣기
		 fish1.name = "붕어빵1";
		 fish1.age = 1;
		 
		 System.out.println("붕어빵의 이름 : " + fish1.name);
		

	}

}
