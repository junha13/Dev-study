// 전달받은 문자열이 회문(앞으로나 뒤로나 동일한 문자열) 문자열인지를 체크하는 메서드를 완성하시오.

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세용");
		String[] input = sc.nextLine().split("");
		
		if(input.length > 2) {
			for (int i=0; i<input.length; i++) {
				int num = input.length-i-1;
					if(input[i]!=input[num]) {
						System.out.println(i+"번째 문자열이 " + num + "번째 문자열과 안맞습니다");
						break;
					}
				System.out.println(i+"번째 문자열이 " + num + "번째 문자열과 맞습니다");
			}
			//System.out.println("문자열이 일치합니다");
		}
		
		sc.close();
	}
}
