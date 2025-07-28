package myjdbc;

public class StringTest {
	public static void main(String[] args) {
		
		String str = new String("Hello"); // 생성된객체를 str로 참조하고 있음
		String str2 = new String("Hello");
		System.out.println(str==str2); // 이건 서로 다른 객체를 참조하는 것인가를 보는 거임
		
		String str3 = "Hello";   // 이건 왜 같다고 나오는가 문자열은 ==로 비교하면 안됨
		String str4 = "Hello";   // Hello 문자열이 이미 존재하여 그 문자열을 사용함
		System.out.println(str3==str4);
		
		String str5= new String("Hello"); // 생성된객체를 str로 참조하고 있음
		String str6 = new String("Hello");
		System.out.println(str5.equals(str6));
		
		str = str.replace('H', 'h'); // 새로 생성된 문자열이다. immutable하다? 
		// String 객체는 immutable하다.  (내부 문자열은 변경이 불가능하다)
		System.out.println(str);
		
		str = str + "ha";
		// 기존의 str 내부의 문자열이 변경되는 것이 아니라 새로 문자열이 생성되어 **할당**된다
		System.out.println(str);
		
		// String, StringBuffer, StringBuilder
		// 문자열을 상당히 여러번 가공해야 한다면 StringBuilder를 사용해야 한다.
		String product = "S25:Samsung:1500000";
		String[] procutInfo = product.split(":");

		// 프로젝트를 하기 전에 배운 것을 다 통합하여 해야 함
	}
}
