
public class Test {

	public static void main(String[] args) {
		
		// 콘솔에 입력하기
		System.out.println("안녕!");
		
		// 변수 상자 만들기
		String name1; //변수 상자는 소문자 
		name1 = "안녕"; //오른쪽 값을 변수 상자에 할당한다, 변수 상자가 이미 만들어졌기 때문에 String 안씀
		System.out.println("name1의 값 : " + name1);

		//변수상자 만들면서 초기화하기 (초기화라는건 값을 넣는거임)
		String name2 = "안녕";
		
		//숫자 두개를 더하기
		int age1 = 21;
		int age2 = 22;
		
		int output1 = age1 + age2;
		System.out.println("더하기 결과 : " + output1);
		
		//if문 사용하기
		if (age1 > 20) {
			System.out.println("age1의 값이 20보다 큽니다. : " + age1);
		} else {
			System.out.println("age1의 값이 20보다 크지 않습니다. : " + age1);
			
		}
		
		//for문 사용하기
		int count = 0;
		for (int i = 0; i < 10; i++) { //초기값; 반복횟수; 반복문
			count = count + (i+1);
			System.out.println("count " + i + " : " +count);
		}
		System.out.println("count의 값 : " + count);
		
	}

}
