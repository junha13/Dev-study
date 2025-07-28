import java.util.ArrayList;
public class Test {

	public static void main(String[] args) {
		//집만들기
		
		Dog dog1 = new Dog("강아지1");
		Cat cat1 = new Cat("고양이1");
		ArrayList<Dog> dogs = new ArrayList<Dog>(); //배열에 아무거나 넣을 수 있는데 꺽쇠하고 Dog를 넣음으로써 자료형을 정한거임
		dogs.add(dog1);
		
		ArrayList cats = new ArrayList();
		cats.add(cat1);
		
		dogs.add(new Dog("강아지18"));
		dogs.add(new Dog("강아지18"));
		System.out.println(dogs.get(1).getClass());
		
		House house1 = new House(dogs, cats);
		System.out.println("집 안에 있는 강아지와 고양이의 이름 " + house1.dogs.size() + "," + house1.cats.size());
		
		ArrayList names = new ArrayList();
		names.add("홍길동1");
		names.add("홍길동2");
		names.add("홍길동3");
		//size, get (자바는 배열이 0부터 시작임) 
		System.out.println("names 안에 만들어진 칸의 개수 : " +names.size());
		System.out.println("names 안에 두번재 이름은? " +names.get(1));
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println("name의 " +i+"인덱스에 해단하는 칸의 값 : " +names.get(i));
			//인터레이션 :각 항의 값들을 하나씩 빼서 확인하는것
		}
		
	}

}
