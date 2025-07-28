package myjdbc;

public class ExceptionTest2 {
	public static void main(String[] args) {
		print();
	}

	private static void print()  {
		try {
			printHello(-5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void printHello(int count) throws Exception {
		if(count<=0) throw new Exception("마이너스는 안되거든요!");
		for(int i=0;i<count;i++) {
			System.out.println("Hello");
		}
	}
}
