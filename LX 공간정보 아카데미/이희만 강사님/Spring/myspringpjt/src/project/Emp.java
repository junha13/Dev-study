package project;

public class Emp {
	int empId, deptId, salary;
	String firstName, lastName, hireDate, email;
	
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", deptId=" + deptId + ", salary=" + salary + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", hireDate=" + hireDate + ", email=" + email + "]";
	}
}