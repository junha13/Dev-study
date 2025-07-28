package myjdbc;

public class ExceptionTest1 {
	public static void main(String[] args) {
		System.out.println("start");
		try {
			System.out.println("inside");
			printHello(-5);
			System.out.println("inside end");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		System.out.println("end");
	}

	private static void printHello(int count) throws Exception {
		if(count<=0) throw new Exception("마이너스는 안되거든요!");
		for(int i=0;i<count;i++) {
			System.out.println("Hello");
		}
	}
}
