package myjdbc;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력:");
		String str = scan.nextLine();
		try {
			int convertedNum = convert(str);
			System.out.println(convertedNum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	private static int convert(String str) throws Exception {
		if(str.length()==0) throw new Exception("그냥 엔터를 치셨군요!");
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			throw new Exception("숫자로 변환할 수 없습니다!");
		}
		return result;
	}
}
