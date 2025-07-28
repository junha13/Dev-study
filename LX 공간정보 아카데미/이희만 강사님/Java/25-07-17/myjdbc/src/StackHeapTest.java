
public class StackHeapTest {
	public static void main(String[] args) {
		int count = 500;  // 기본형 4bytes 를 할당받음
		Product product;  // 참조형 64bit  // 생성된 객체의 주솟값을 저장 후 반환
		product = new Product();
		
		product.maker = "Samsung";
		change(product);
		System.out.println(product.maker);
		// callbyreferance
		
	}

	private static void change(Product pro) {
		pro.maker = "Apple";
		
	}
}

class Product {
	String maker;
	
}
