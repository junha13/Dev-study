package myspring;

import java.sql.Connection;
import java.sql.DriverManager;

public class Emp {

	public int id;
	public String lastName;
	public int salary;
	@Override
	public String toString() {
		return "Emp [id=" + id + ", lastName=" + lastName + ", salary=" + salary + "]";
	}
	
	

}
