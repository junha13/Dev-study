package basic;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		/*
		 * 업앤다운 게임입니다.
			1부터 100사이의 임의 숫자를 생성해둡니다.
			사용자로부터 숫자를 입력받습니다.
			입력숫자가 임의숫자보다 크면 아래란 문자열 출력
			작으면 위 라는 문자열 출력
			그래서 몇번만에 맞췄는지를 출력해줍니다.
			0아래이거나 100보다 크면 다시 입력하게 합니다.
			
			옵션
			- 그동안 입력한 숫자를 저장하여 출력합니다^^
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("1~100사이 숫자 입력:");
		int input = scan.nextInt();
		System.out.println("입력하신 숫자는 : "+ input);
		System.out.printf("입력하신 숫자는 : %d\n", input);
		int random = (int)(Math.random() * 100) + 1; //0 ~ 1 double
		
	}
}
