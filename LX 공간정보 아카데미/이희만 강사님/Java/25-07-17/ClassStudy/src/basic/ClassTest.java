package basic;

public class ClassTest {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.count = 500;
		System.out.println(emp.count);
	}
}

class Employee {
	int count;
	Employee(){
		System.out.println("Employee()");
	}
}
