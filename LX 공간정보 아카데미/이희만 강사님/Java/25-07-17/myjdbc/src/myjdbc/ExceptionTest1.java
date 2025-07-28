package myjdbc;

public class ExceptionTest1 {
	public static void main(String[] args) throws Exception {
		print();
		//System.out.println("start");
		//System.out.println("start");
		//try {
		//	System.out.println("inside");
		//	printHello(-55);
		//	System.out.println("inside end");
		//} catch (Exception e) {  // 밑에서 new Exception에서 생성된 객체가 여기 e로 들어가는거임
		//	System.out.println("catch");
		//	System.out.println(e.getMessage());
			// e.printStackTrace();
			
		//}
		//System.out.println("end");
		// 이거 오류 왜생겨요?
		// 메서드를 실행한건데, 그 메서드가 예외처리가 정의되어 있으면 호출할때도 예외처리를 해야 한다.
		// 그래서 컴파일이 안되는거임
	}

	private static void print() throws Exception {
		printHello(-5); // printHello가 throws절을 가지고 있는 상태로 정의되어 있어서 
		
	}

	private static void printHello(int count) throws Exception {
		if(count<=0) throw new Exception("마이너스는 안되거든요!"); // 생성자라서 예외 객체가 만들어지는거임 그 객체가 위에 e에 들어가는거임
		// 예외처리를 해버린거임 ㄷㄷ
		for (int i = 0; i < count; i++) {
		System.out.println("Hello");
		}
		
	}

}
