
public class Test1 {

	public static void main(String[] args) {
		
		// 고객 객체 생성
		Customer customer1 = new Customer("철수", 21, "010-1111-1111");
		Customer customer2 = new Customer("짱구", 22, "010-2222-2222");
		Customer customer3 = new Customer("훈이", 23, "010-3333-3333");
		Customer customer4 = new Customer("맹구", 24, "010-4444-4444");
		Customer customer5 = new Customer("유리", 25, "010-5555-5555");
		
		// 스토어 객체 생성
		Store store1 = new Store("현대백화점");
		Store store2 = new Store("롯데백화점");
		Store store3 = new Store("신세계백화점");
	
		// 제품 객체 생성
		Product product1 = new Product("상의", 40000);
		Product product2 = new Product("하의", 50000);
		Product product3 = new Product("신발", 80000);
		
		// 스토어에 제품 배정
		store1.setProduct(product1);
		store1.setProduct(product2);
		store1.setProduct(product3);
		
		// 구매 동작 시행
		store1.pay(customer1, product1);
		store1.pay(customer1, product1);
		store1.pay(customer1, product2);
		store1.pay(customer1, product3);
		store1.pay(customer2, product3);

		// 스토어 안 고객, 상품 수 출력
		System.out.println("\n현재 " + store1.name + "에는 고객 : " + store1.scustomers.size() + "명, 제품 : " + store1.sproducts.size() + "종류가 있습니다.");
		System.out.println("현재 " + store2.name + "에는 고객 : " + store2.scustomers.size() + "명, 제품 : " + store2.sproducts.size() + "종류가 있습니다.");
		System.out.println("현재 " + store3.name + "에는 고객 : " + store3.scustomers.size() + "명, 제품 : " + store3.sproducts.size() + "종류가 있습니다.");

		// 고객별 총 구매 금액 출력
		System.out.println("\n현재 " + customer1.getName() + "님께서 구매하신 금액은  "+ customer1.getMySumFee() + "원 입니다.");
		System.out.println("현재 " + customer2.getName() + "님께서 구매하신 금액은  "+ customer2.getMySumFee() + "원 입니다.");
		System.out.println("현재 " + customer3.getName() + "님께서 구매하신 금액은  "+ customer3.getMySumFee() + "원 입니다.");
		
		// System.out.println("현재 " + store1.name + "의 총 매출은 " + store1.);
		
		// 제품별 매출 금액 출력 
		System.out.println("\n현재 " + product1.name + "의 총 매출은 " + product1.getProductFee() + "원 입니다.");
		System.out.println("현재 " + product2.name + "의 총 매출은 " + product2.getProductFee() + "원 입니다.");
		System.out.println("현재 " + product3.name + "의 총 매출은 " + product3.getProductFee() + "원 입니다.");
		
		// 총 매출 금액 출력
		System.out.println("\n총 매출은 " + Product.feeSum + "원 입니다.");
		
		// 총 라
		
		System.out.println(store1.todayProducts.size());
		System.out.println(store1.dayToSoldProduckList.size());
		for (int i = 0; i < store1.todayProducts.size(); i++) {
		System.out.println(store1.dayToSoldProduckList.get("2025-07-04").get(i).name);
		System.out.println(store1.dayToSoldProduckList.get("2025-07-04").get(i).fee);
		}
		
	}
	
	

}
