package myjdbc;

public class VariableObject {
	public static void main(String[] args) {
		Product product = new Product();
		Product product2 = new Product();
		product2.price = 5000;
		System.out.println(product.price);
		product = product2;
		System.out.println(product.price);		
	}
}

class Product {
	int price;  // 객체변수 (인스턴스 변수)
	String name;
	String maker;
	
}