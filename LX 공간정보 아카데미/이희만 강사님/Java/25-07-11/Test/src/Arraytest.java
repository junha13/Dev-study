
public class Arraytest {

	public static void main(String[] args) {
		// array : 배열, 선언, 생성, 할당, 참조
		//int[] list;  // 이건 잘못됨. 배열이란 선언할 때 갯수를 지정하지 않는다. 선언
		int[] list;
		int list2[];
		list = new int[10]; // 생성할 땐 갯수를 지정해야 한다. 레전드네  // 생성은 선언을 한 후에 지정되어야 함 // 이건 10칸을 만드는거임
		list[0] = 55;
		list[10] = 100; // 컴파일은 되어도 실행이 안될 수 있음 // 근데 11번째에다가 넣으려니까 컴파일에는 문제가 없지만 실행에 문제가 생김
		// 컴파일이 되면 클래스 파일이 만들어짐 ★★★ 문법에 어긋나면 클래스파일이 안만들어짐
		// 컴파일
		
		// 자바의 array는 동입타입만 됨, 크기변경이 불가 
		// 그래서 ArrayList를 사용해야 함  => CollectionAPI를 알고 있어야 함
		int[] list3 = {23,45,7,12,46};
		for(int ele:list3) {
			System.out.println(ele);
		}
		
		for (int i =0;i<list3.length; i++) {
			System.out.println(list3[i]);
		}
	}

}
