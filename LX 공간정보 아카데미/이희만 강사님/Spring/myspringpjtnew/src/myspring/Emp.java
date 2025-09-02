package myspring;

public class Emp {

	public int employeeId;  // 언더스코어를 카멜케이스로 변환하여 사용하게 되면 각 class의 객체변수도 이름도 바꿔야한다ㅓ.
	public String lastName;
	public String firstName;
	public int salary;
	
	@Override
	public String toString() {
		return "Emp [employeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName + ", salary="
				+ salary + "]";
	}
	
	

}
