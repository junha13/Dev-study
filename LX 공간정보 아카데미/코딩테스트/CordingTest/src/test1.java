/*입력한 배열의 합을 구하는 프로그램을 작성하시오.
 - 입력 : 4 9 3 50 => 문자열로 입력됨
 - 출력 : 64*/

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력하라고 (숫자마다 띄어쓰기 넣어서)");
		String num = sc.nextLine();
		String[] numList = num.split(" ");
		
		int result = 0;
		
		for (int i=0; i < numList.length; i++) {
			result += Integer.parseInt(numList[i]);
			
		}
		
		System.out.println(result);

		sc.close();
	}

}
