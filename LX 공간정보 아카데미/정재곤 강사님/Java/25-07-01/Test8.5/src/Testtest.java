import java.util.ArrayList;
import java.util.Scanner;

public class Testtest {

	public static void main(String[] args) {
		ArrayList<String> person = new ArrayList<String>();
		person.add("홍길동");
		person.add("홍길동2");
		person.add("홍길동3");
		Scanner sc	 = new Scanner(System.in);
		System.out.println("숫자를ㅇ팁력ㄹ하세요");
		int num = sc.nextInt();
		
		
		System.out.println("사이즈 : " + person.size());
		System.out.println("3번째 사람 : " + person.get(2));
		
		for (int i = 0; i < person.size(); i++) {
			System.out.println(i+1 +"번째 사람은"+person.get(i));
		}

	}

}
