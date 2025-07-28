import java.util.ArrayList;

public class Customer {
	String name;
	int age;
	String mobile;
	public ArrayList<Product> myProducts = new ArrayList<Product>();
	public int mySumFee = 0;
	
	Customer(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	
	String getName() {
		return this.name;
	}
	
	int getMySumFee() {
		return mySumFee;
	}
	
	
	
	
}
