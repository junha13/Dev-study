package basic;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {
		// 입력한 문자에 대한 아스키값을 출력함
		// q, Q를 입력하면 종료
		Scanner sc = new Scanner(System.in);
		System.out.println("문자입력 : ");
		String input = sc.nextLine();
		char first = input.charAt(0);
		
		while (first!='q') {
			System.out.println((int)first);
			System.out.println("문자입력 : ");
			input = sc.nextLine();
			first = input.charAt(0);
		}
	}
}
