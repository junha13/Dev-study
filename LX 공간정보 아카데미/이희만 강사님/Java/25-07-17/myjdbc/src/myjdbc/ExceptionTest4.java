package myjdbc;

public class ExceptionTest4 {
	public static void main(String[] args) {
		try {
			print(); // 예외처리를 하지 않은 채 호출하고 있어서 
		} catch (RuntimeException e) {
			
		}
		/*
		 * compile time exception, runtime exception : RuntimeException의 하위
		 * checked exception, unchecked exception
		 */
	}

	private static void print() throws RuntimeException {
		if(true) throw new RuntimeException("dd");
		
	}

}
