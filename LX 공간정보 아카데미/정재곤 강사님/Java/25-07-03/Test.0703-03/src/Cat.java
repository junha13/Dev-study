
public class Cat extends Animal {
	
	Cat(String name) { // 바꿔도 왜 오류가 안날까 왜 
		super();
		
		super.name = name;
		System.out.println("고양이가 만들어졌어요. 이름  " + name);
	}
	
}
