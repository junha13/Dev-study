import java.util.ArrayList;
import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {
		
		int randomNumber = (int) (Math.random() * 100) +1; // 0 ~ 1 double
		int inputNumber = 0;
		int count = 0;
		ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
		
		while (inputNumber != randomNumber) {
		
			Scanner scan = new Scanner(System.in);
			System.out.println("1~100 사이의 숫자 입력 : ");
			inputNumber = scan.nextInt();
		
			if (inputNumber < 0 && inputNumber > 100) {
				System.out.println("다시 입력해 주세요");
			}
			
			if (inputNumber < randomNumber) {
				System.out.println("up");
				count +=1;
				inputNumbers.add(inputNumber);
			} else {
				System.out.println("down");
				count +=1;
				inputNumbers.add(inputNumber);
			}	
		}
			System.out.println("정답을 맞추셨습니다");
			System.out.println("지금까지 입력하신 숫자는 : ");
			for(int i = 0; i < inputNumbers.size(); i++)
				System.out.println(inputNumbers.get(i));
	}
}
