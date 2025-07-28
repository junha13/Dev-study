
public class FunctionTest {
	public static void main(String[] args) {
			
		print(5); // 프린트라는 메서드를 호출(call), 실행(execute)했는데 존재하지 않는다.
		// 메서드 정의, 선언, 호출, 실행의 차이점을 알고 있어야 한다.
		// 메서드이름, 전달받는 데이터, 리턴
		System.out.println(print(5) + print(7));
			
		// class의 구성 요소 : 메서드, 변수, 생성자 ★★★★
		// 객체지향 언어는 
		// c언어는 구조적인 언어 함수 위주
		
		int count;
		count = 500;
		Emp emp; // emp : Emp타입의 변수 선언, ★★힙영역에 생성된 객체의 주소값★★을 저장할 수 있는 메모리 공간
				 //	★★★★stack 영역에 64비트 메모리 공간을 할당받아서 emp라는 이름으로 참조하게 되고, 그 공간엔 객체의 주소값을 저장할 수 있다. 막 숫자넣고 그런건 안되고 객체의 주솟값
		emp = new Emp(); // 힙 영역에 새로운 객체를 생성하고 그 주솟값을 emp에 어싸인하는거임
			// 생성자 호출임
		emp.count = 500;
		System.out.println(emp.count);
		change(emp);
		System.out.println(emp.count); // 할당을 받을 때 emp, emp2가 있고 힙 영역에 EMP가 생성되고 그 주솟값을 emp에서 받고 500이라는 값을 써넣는데, emp2에서 count값을 1000을 써넣음으로써 emp에서 봤을 때도 1000이 된다.
		// call by reference
		
	}
	private static void change(Emp emp2) {
		emp2.count = 1000;
	}

	
	// 메서드를 정의했다. define 했다. definition 했다.
	// 함수를 왜 사용해야하나?
	// 1. 중복코드 제거
	// 2. 코드를 이해하기 편하게 하려고
	// 3. 
	private static int print(int count) {
		int result = 0;
		for (int i = 0; i < count; i++) {
			System.out.println("hello");
			result +=1;
		}
		String str;  // 메서드는 무조건 동사로 시작함
		return result;
	}

	

}

class Emp{
	int count;
}