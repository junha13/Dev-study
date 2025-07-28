package basic;

public class StringTest {
	public static void main(String[] args) {
		String str = "Hello";
		String str2 = "Hello"; //Hello 문자열이 이미 존재하여 그 문자열을 사용함
		System.out.println(str == str2);
		System.out.println(str.equals(str2));
		str = str.replace('H', 'h'); //새로 생성된 문자열이다. String 객체는 immutable 하다. 
		System.out.println(str);
		str = str + "ha"; //기존의 str 내부의 문자열이 변경되는 것이 아니라 새로 문자열이 생성되어 할당된다.
		//String, StringBuffer, StringBuilder
		//문자열을 상당히 여러번 가공해야 한다면 StringBuilder를 사용해야 한다.
		String product = "S25:Samsung:1500000";
		String[] productInfo = product.split(":");
		
	}
}
