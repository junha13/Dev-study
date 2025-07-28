
public class Test2 {

	public static void main(String[] args) {
		System.out.println("안녕하세요");
		System.out.println("저는입니다");
		
		//변수 상자 만들기
		String name1;
		name1 = "홍길동1";
		//이퀄 표시는 오른쪽 값이 왼쪽 상자에 들어가는거임
		
		int age1;
		age1 = 21;
		//각 변수상자는 상자별로 크기가 다름 메모리는 비싸기 때문에
		
		
		//콘솔 창에 뿌려보기
		System.out.println(name1);
		
		//변수상자 만들면서 값 넣기
		String name2 = "홍길동2";
		int age2 = 22;
		System.out.println(name2);
		System.out.println(age2+"세");
		
		//변수상자 안에 들어있는 값 더해보기
		int age3 = 10;
		int age4 = 20;
		
		//변수 상자 속 값이 튀어나와서 더해지는거임
		int age5;
		age5 = age3+age4;
		System.out.println(age5);
		
		String output1 = name2 + age2; //오른쪽 숫자를 글자로 자동으로 바꿔줌 ㄷㄷ
		System.out.println(output1);
		
	}

}
