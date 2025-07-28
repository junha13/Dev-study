package basic;

public class Ex02 {
	public static void main(String[] args) {
		/*
		* 1부터 1000까지의 100개의 임의의 수로 이루어진 배열을 생성하는 함수를
		* 호출하여 배열을 생성한다.
		- 2.인덱스가 홀수인 수들을 출력하는 함수
		- 3.배열의 수들의 합을 반환하는 함수
		- 4.가장 작은 수의 위치(인덱스)를 반환하는 함수
		- 5.3의 배수만을 새로운 배열에 복사하여 리턴하는 함수
		*/
		int[] list = makeArray();
	}

	private static int[] makeArray() {
		int [] result = new int[100];
		for(int i=0;i<100;i++) {
			result[i] = (int)(Math.random()*1000) + 1;
		}
		return result;
	}
}
