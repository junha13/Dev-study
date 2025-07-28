import java.util.ArrayList;

public class Person {
	String name;
	int age;
	
	ArrayList<Skill> skill = new ArrayList<Skill>();
	
	
	Person(String name, int age, ArrayList<Skill> skill) {
		this.name = name;
		this.age = age;
		this.skill = skill;
	}
}
