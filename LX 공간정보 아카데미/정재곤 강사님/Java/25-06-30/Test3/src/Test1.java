
public class Test1 {
	public static void main(String[] args) {
		
		//if문 사용
		int age1 = 7;
		if (age1 > 10) {
			System.out.println("나이가 10보다 많아요.");
		} else {
			System.out.println("나이가 10보다 적거나 같아요.");
		}
		
		//for문 사용하기
		int count = 0;
		
		count = count + 1;
		count = count + 2;
		count = count + 3;
		count = count + 4;
		count = count + 5;
		count = count + 6;
		count = count + 7;
		count = count + 8;
		count = count + 9;
		count = count + 10;
		System.out.println("1부터 10까지 더한 값 : " + count );
		
		int count2 =0;
		for (int  i = 0; i < 1000; i++) { //몇번 반복될지 (단순히 10, 100넣는것보단 i값을 제한하는거임, i++은 그 전 문장int  i = 0; i < 10이 실행되고 나서 1씩 더하는거임)
			count2 = count2 + (i+1);	
		}
		System.out.println("1부터 10까지 더한 값 : " +count2);
		
		//함수상자 실행하기
		int output1 = add(10, 50);
		System.out.println("더하기 결과 : " + output1);
		//함수 상자 만들기
		
	}	//소괄호 안에가 함수상자 안에서 일하는거, 중괄호가 	
	static int add(int a, int b) { //★★★메모리에 그냥 숫자 두개를 담을 수 없으니까 변수상자를 설정하는거임, 그래서 숫자를 받는 순간에 상자로 받는거임
		int c = a + b; //함수상자에서 밑에 구멍으로는 상자에 담아서 내릴 필요가 없음 함수를 실행하는 쪽에서 변수상자에 담아가야됨 
		return c;
	}

}
