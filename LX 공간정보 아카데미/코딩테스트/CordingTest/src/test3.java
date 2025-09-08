import java.text.ParseException;
import java.util.Scanner;

public class test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력해라 숫자 배열. 띄어쓰기 넣어서");
		String[] numList = sc.nextLine().split(" ");
		
		int maxNum = 0;
		for (int x=0; x<numList.length; x++) {
			int num1 = Integer.parseInt(numList[x]);
			if (num1 > maxNum ) maxNum=num1;
		}
		System.out.println("입력받은 배열 중 제일 큰 수 = "+ maxNum);
		sc.close();
	}
}
