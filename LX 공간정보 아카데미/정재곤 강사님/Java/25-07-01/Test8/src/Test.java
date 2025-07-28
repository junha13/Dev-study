
public class Test {

	public static void main(String[] args) {
		//person 객체 만들기
		Person person1 = new Person("홍길동1", 20, "010-1111-1111");
		Person person2 = new Person("홍길동2", 21, "010-2222-2222");
		Person person3 = new Person("홍길동3", 22, "010-3333-3333");
		
		//Dog 객체 만들기
		Dog dog1 = new Dog("뽀삐1");
		Dog dog2 = new Dog("뽀삐2");
		Dog dog3 = new Dog("뽀삐3");
		
		//Cat 객체 만들기
		Cat cat1 = new Cat("루비1");
		Cat cat2 = new Cat("루비2");
		Cat cat3 = new Cat("루비3");
		
		//House 객체 만들기
		House house1 = new House("반포자이", person1, dog1, cat1);
		House house2 = new House("래미안", person2, dog2, cat2);
		House house3 = new House("e편한세상", person3, dog3, cat3);
		
		//House 출력
		System.out.println("1번 집 이름 : " + house1.name 
				+ "\n\n 사람 이름 : " + house1.person.name + "  나이 : " + house1.person.age + "  전화번호 : " + house1.person.mobile 
				+ "\n 강아지 이름 : " + house1.dog.name 
				+ "\n 고양이 이름 : " + house1.cat.name);
		System.out.println("\n\n\n2번 집 이름 : " + house2.name 
				+ "\n\n 사람 이름 : " + house2.person.name + "  나이 : " + house2.person.age + "  전화번호 : " + house3.person.mobile
				+ "\n 강아지 이름 : " + house2.dog.name 
				+ "\n 고양이 이름 : " + house2.cat.name);
		System.out.println("\n\n\n3번 집 이름 : " + house3.name 
				+ "\n\n 사람 이름 : " + house3.person.name + "  나이 : " + house2.person.age + "  전화번호 : " + house3.person.mobile
				+ "\n 강아지 이름 : " + house3.dog.name 
				+ "\n 고양이 이름 : " + house3.cat.name);
		
	}

}
