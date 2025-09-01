package strore;

import java.util.ArrayList;
import java.util.List;

import customer.Customer;
import product.Product;

public class Store {
	
	public String name;
	
	public List<Customer> customers = new ArrayList<Customer>();
	public List<Product> products = new ArrayList<Product>();
	
	
	public Store(String name) {
		this.name = name;
	}
	
	public void pay(Customer customer, Product product) {
		this.customers.add(customer);
		this.products.add(product);
		
		customer.getMyProducts().add(product);
		Product.totalCharge += product.charge;
		
	}
	
}
