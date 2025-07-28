package myjdbc;

public class ExceptionTest5 {
	public static void main(String[] args) {
		try {
			printHello(-5);
		} catch (MyException e) {
			System.out.println(e.getMessage());
			
		}
	}

	private static void printHello(int count) throws MyException {
		if(count<=0) throw new MyException("마이너스는 안되거든요!");
		for(int i=0;i<count;i++) {
			System.out.println("Hello");
		}
	}
}

class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}