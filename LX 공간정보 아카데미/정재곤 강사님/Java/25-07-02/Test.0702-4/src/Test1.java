import java.util.ArrayList;

import com.lx.animal.Animal;
import com.lx.animal.Dog;
import com.lx.animal.Cat;

public class Test1 {

	public static void main(String[] args) {
		Animal animal1 = new Animal();
		animal1.name = "dd";
		
		Dog dog1 = new Dog();
		dog1.name = "rkddkwl";
		dog1.age = 21;
		dog1.run();
		
		Animal dog2 = new Dog(); //변수 상자의 크기를 animal로 할 수 잇음 이러면 이름밖에 못넣나?
		//Cat dog3 = new Dog(); //dog에는 age가 있으니까 안되는듯? 상속 관계이기 때문에
		//부모의 크기를 가진 애는 변수 상자의 크기로 정할 수 있음
		dog2.walk();
		//dog2.run(); //run은 왜안돼 animal에서 만들어둔 것만 사용할 수 있음
	
		Animal cat2 = new Cat();
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(dog1);
		animals.add(dog2);
		animals.add(cat2);
		//Dog dog3 = animals.get(0); //리스트에 넣었다가 다시 꺼내면 dog로 다시 돌릴 수 없음 그러면 Animal이라는 자료형에 넣어야됨
		Animal dog3 = animals.get(0);
		Dog dog4 = (Dog) dog3; //()로 자료형을 바꿀 수 있는거임;;
		
		//부모클래스에 상속되면 고양이와, 강아지 둘 다 리스트에 넣을 수 있음, 위에처럼 따로 객체설정하지 않아도 그냥 넣을 수 있음
		//기능도 animal에서 개발된 것만 사용할 수 있음
		//그러면 기능은 animal에 몰빵하고 속성만 상속받으면 되려나?
		//이러면 코드의 양이 줄어들긴함
		
	}

}
