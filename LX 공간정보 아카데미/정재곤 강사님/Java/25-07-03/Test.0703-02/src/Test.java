import com.lx.animal.*;

public class Test {

	public static void main(String[] args) {
		Animal animal1 = new Dog("뽀삐1", 1, "010-1111-1111");
		Animal animal2 = new Dog("뽀삐2", 2, "010-2222-2222");
		Animal animal3 = new Dog("뽀삐3", 3, "010-3333-3333");
		Animal animal4 = new Cat("루비1", 3, "010-3333-3333");
		Animal animal5 = new Cat("루비2", 3, "010-3333-3333");
		
		animal1.sitdown();
		animal2.standup();
		animal3.run();
		animal4.sitdown();
		animal5.standup();
		
	}

}
