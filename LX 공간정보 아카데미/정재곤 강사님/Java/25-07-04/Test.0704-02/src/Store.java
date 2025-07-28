import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Store {

	String name;
	int todaySumFee;
	
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat ("YYYY-MM-dd");
	String today = format.format(date);
	
	ArrayList<Customer> scustomers = new ArrayList<Customer>(); // store 고객, 상품 배열은 s추가
	ArrayList<Product> sproducts = new ArrayList<Product>();
	ArrayList<Product> todayProducts = new ArrayList<Product>();
	
	HashMap<String, ArrayList<Product>> dayToSoldProduckList = new HashMap<String, ArrayList<Product>>();
	HashMap<String, Integer> dayTotal = new HashMap<String, Integer>();
	

 	Store(String name) {
 		this.name = name;
 	}
 	
 	void setProduct(Product product) {
 		this.sproducts.add(product);
 	}
 	
 	ArrayList<Customer> getCustomer() {
 		return this.scustomers;
 	}
 	
 	ArrayList<Product> getProduct() {
 		return this.sproducts;
 	} 	
 	
 	void pay(Customer customer, Product product) {
 		
 		// 고객 중복 제거
 		if (scustomers.size() >= 1) {
 		for (int i = 0; i < scustomers.size(); i++) {
 			if (scustomers.get(i).getName() == customer.getName()) {
 			} else {
 				this.scustomers.add(customer);
 			}
 		}} else {this.scustomers.add(customer);}
 		
 		// 배열 추가
 		Product.products.add(product);
 		customer.myProducts.add(product);
 		customer.mySumFee += product.fee;
 		Product.feeSum += product.fee;
 		
 		// 날짜별 arraylist 초기화
 		if (this.dayToSoldProduckList.containsKey(today)) {
 			} else {
 				todayProducts.clear();
 			}
 		
 		// 오늘 팔린 물건 추가
 		todayProducts.add(product);
 		dayToSoldProduckList.put(today, todayProducts);
 	}
 	
 			
 	
 	
 	// 날짜 생성 함수
 	String birth() {
 		Date date = new Date();
 		SimpleDateFormat format = new SimpleDateFormat ("YYYY-MM-dd");
 		return format.format(date);	
 	}
 
}
