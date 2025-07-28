import java.util.Calendar;

public class ControlTest {
	static int FRIDAY = 6;

	public static void main(String[] args) {
		
		// 1부터 얼마까지 누적해야 백만을 초과할까? 1+2+3+n
		// 변수? 로직? 제어문?
		// count, sum
		// 반복문을 사용할 때, for, while문을 쓸때는 몇번 반복해야 할지 모를 때
		int count = 0;
		int sum = 0;
		while (sum<1000000) {
			count++;
			sum = sum+ count;
		}
		System.out.printf("1부터 %d까지 누적하면 %d가 되고 백만을 넘습니다", count, sum); // 첫 번째 %d에 count, %d 
	}
}
