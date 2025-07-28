import java.util.ArrayList;

public class House {
	ArrayList dogs;
	ArrayList cats;
	
	
	House() {
		
	}
	
	House(ArrayList dogs, ArrayList cats) {
		this.dogs = dogs;
		this.cats = cats;
		
		System.out.println("집이 만들어졌어요");
	}
}
