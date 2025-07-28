import java.util.ArrayList;

public class Testtest {

	public static void main(String[] args) {
		
		//사람 객체 정하기
		Person person1 = new Person("홍길동", 21, "010-2103-3406");
		Person person2 = new Person("dd", 211, "d");
		Person person3 = new Person("d", 211, "d");

		Dog dog1 = new Dog("d");
		Dog dog2 = new Dog("df");
		Dog dog3 = new Dog("ddf");
		
		Cat cat1 = new Cat("d");
		Cat cat2 = new Cat("ddd");
		Cat cat3 = new Cat("ddddd");
		
		House house1 = new House("반포자이", person1, dog1, cat1);
		House house2 = new House("삼성래미안", person2, dog2, cat2);
		House house3 = new House("e편한세상", person3, dog3, cat3);
		
		System.out.println(house1.name+" "+house1.person.name+" "+ house1.person.mobile);
		ArrayList<House> house = new ArrayList<House>();
		
	}

}
