import customer.Customer;
import product.Product;
import strore.Store;

public class Main {
	public static void main(String[] args) {
		
		Store store1 = new Store("a");
		Customer cus1 = new Customer("철수", 7, "010");
		Product pro1 = new Product("바지", 7000);
		store1.pay(cus1, pro1);
		
		System.out.println(store1.customers.size());
		System.out.println(Product.totalCharge);
	}

}
