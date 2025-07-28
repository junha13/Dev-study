import com.lx.dog.Dog;
import com.lx.house.House;

public class Test {

	public static void main(String[] args) {
		Dog dog1 = new Dog("뽀삐1", 1, "010-1111-1111");
		House house1 = new House("래미안");
		House house2 = new House("삼성");
		
		house1.setDog(dog1);
		
		
		
		

	}
}