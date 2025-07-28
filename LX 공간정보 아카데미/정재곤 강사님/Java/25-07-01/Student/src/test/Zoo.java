package test;
import java.util.ArrayList;

public class Zoo {

	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("치타", 10, 120.1));
		animals.add(new Animal("표범", 12, 151.5));
		animals.add(new Animal("사자", 14, 111.7));
		animals.add(new Animal("호랑이", 8, 124.14));
		Zoomanager zooo = new Zoomanager(animals);
		
		
		

	}

}
