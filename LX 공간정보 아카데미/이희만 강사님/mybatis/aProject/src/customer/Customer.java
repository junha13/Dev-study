package customer;

import java.util.ArrayList;
import java.util.List;

import product.Product;

public class Customer {
	String name;
	int age;
	String mobile;
	
	public Customer(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	
	List<Product> myProducts = new ArrayList<Product>();
	
	public List<Product> getMyProducts() {
		return myProducts;
	}

	public void setMyProducts(List<Product> myProducts) {
		this.myProducts = myProducts;
	}
	
	
	
	
}
