package myjdbc;

public class ExceptionTest4 {
	public static void main(String[] args) {
		try {
			print();
		} catch(RuntimeException e) {
			
		}
		/*
		 * compile time exception, runtime exception :RuntimException
		 * checked exception, unchecked exception
		 */
	}

	private static void print() throws RuntimeException {
		if(true) throw new RuntimeException("haha");
		
	}
}
