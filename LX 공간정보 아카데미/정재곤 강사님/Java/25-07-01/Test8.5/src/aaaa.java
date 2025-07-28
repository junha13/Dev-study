
public class aaaa {

	public static void main(String[] args) {
		System.out.println("안녕!");
		String name1;
		name1 = "안녕";
		System.out.println(name1);
		
		int age = 21;
		int age1 = 22;
		
		int output = age + age1;
		System.out.println(output);
		
		if (output > 40) {
			System.out.println("숫자가 크다");
		} else {
			System.out.println("숫자가 작다");
		}
		
		int count=0;
		for (int i = 0; i < 10; i++) {
			count = count + (i+1);
		}
		System.out.println(count);
		

	}
	static void print1() {
		System.out.println("함수 호출됨");
	}
	
	static int add(int a, int b) {
		int output = a + b;
		return output;
	}

}
