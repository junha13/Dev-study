package myjdbc;

import java.util.Scanner;

public class ExecptionTest {
	public static void main(String[] args){
		System.out.println("숫자로 변환할 문자열을 입력바랍니다.");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		try {
			System.out.println("변환된 숫자는 " + convert(input) +" 입니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static int convert(String str) throws Exception {
		if (str.length() == 0) throw new Exception("예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.");
		return Integer.parseInt(str);
	}
}
