
public class PersonTest {
	public static void main(String[] args) {
		
		Person person = new Person();
		person.selfIntroduce();


		Person person1 = new Person(3, "철수");
		person1.selfIntroduce();
		Person person2 = new Person(4, "영희");
		person2.selfIntroduce();
		Person person3 = new Person(5, "짱구");
		person3.selfIntroduce();
		
		System.out.println("전체인구 : " + Person.getPopulation());
	}
}

class Person {
	static int numberOfPersons;
	String name;
	int age;
	
	Person() {
		this.age = 12;
		this.name = "Anonymous";
		numberOfPersons +=1;
	}
	
	Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPersons +=1;
	}
	
	void selfIntroduce() {
		System.out.println("내 이름은 " + this.name + "이며, 나이는 " + this.age + "살입니다.");
	}
	
	static int getPopulation() {
		return numberOfPersons;
	}
}