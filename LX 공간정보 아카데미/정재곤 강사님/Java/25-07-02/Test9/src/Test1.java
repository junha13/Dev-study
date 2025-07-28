import com.lx.Fish; //다른 패키지에 들어있는 걸 쓰려면 import해야함

public class Test1 {

	public static void main(String[] args) {
		
		Fish fish1 = new Fish("물고기1"); //생성자함수 = constructor  근데 제한되어있어서 못쓰는거임 public을 써야딤
		System.out.println("fish1의 정보 -- > 이름 : " + fish1.getname());
		//필드는 속성인데 클래스 틀에서 변수 상자가 제한되어있는거임 , 근데 변수 상자에 public 붙히는거 권장하지 않음 왜지
		
		fish1.setage(60);
		System.out.println("fish1의 정보 -- > 이름 : " + fish1.getage());		
		
		Fish fish2 = new Fish("");
	}

}
