import java.util.ArrayList;

public class Product {
	
	String name;
	int fee;
	String birth;
	static int feeSum;
	public static ArrayList<Product> products = new ArrayList<Product>();
	
	// 제품 생성자 함수
	Product(String name, int fee) {
		this.name = name;
		this.fee = fee;
	}
	
	// 제품별 요금 계산 함수
 	int getProductFee() {
 		int sum = 0;
 		if (!(Product.products.size()==1)) {
 		for (int i = 0; i < Product.products.size(); i++) {
 			if (this.name == Product.products.get(i).name) {
 				sum += this.fee;
 			}
 		} return sum;
 		} else { return this.fee; 
		} 
 	}

}
