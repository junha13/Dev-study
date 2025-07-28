package test4;

public class test1 {
	
	//함수 상자 void = 아래쪽 구멍의 크기가 정해질 수 없다. , 입력 구멍이 하나이다.
	//자바는 함수 상자 안에 함수 상자를 만들 수 없음, 자바스크립트는 가능임
	public static void main(String[] args) {
		int output1 = q(10, 10);
		System.out.println("더하기 결과 : " + output1);
		
		int output2 = w(10, 10);
		System.out.println("빼기 결과 : " + output2);
		
		int output3 = e(10, 10);
		System.out.println("곱하기 결과 : "+ output3);
		
		int output4 = r(10, 10);
		System.out.println("나누기 결과 : "+output4);
	
		int output5 = t(10, 10, 50, 50, 40, 100);
		System.out.println("평균 결과 : "+output5);
	}
	static int q (int a, int b) {
		int c = a + b;
		return c;
	}
	static int w (int a, int b) {
		int c = a - b;
		return c;
	}
	static int e (int a, int b) {
		int c = a * b;
		return c;
	}
	static int r (int a, int b) {
		int c = a / b;
		return c;
	}
	static int t(int...nums) {
		int sum = 0;
		for (int n: nums) {
			sum +=n;
		}
		return sum / nums.length;
	}
}
