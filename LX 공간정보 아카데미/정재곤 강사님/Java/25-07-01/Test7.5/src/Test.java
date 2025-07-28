
public class Test {

	public static void main(String[] args) {
		
		//물고기 만들기
		Fish fish1 = new Fish("물고기1");
		
		Fish fish2 = new Fish("광어");
		
		//바다 만들기
		Sea sea1 = new Sea("태평양", fish2);
		sea1.name = "태평양";
		sea1.fish = fish2; //바다 클래스 안에 fish를 만들었으니까
		
		System.out.println("바다 안에 들어있는 물고기의 이름은? : " + sea1.fish.name);

	}

}
