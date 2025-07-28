
public class Test1 {

	public static void main(String[] args) {
		
		// 동물농장 만들기
		Farm farm1 = new Farm();
		Dog dog1 = new Dog("d");
		System.out.println("강아지가 태어난 시간 : " + dog1.birth);
		
		farm1.animals.put("dd", dog1); // 하나는 add 두개는 put, 첫번째는 
		//0,1,2 대신에 dd로 칸 제목을 지정해준거임 ㄷㄷ
		
		
		
		Cat cat1 = new Cat("라라");
		farm1.animals.put("rara", cat1);
		
		System.out.println("미미를 찾아줘 : " + farm1.animals.get("dd").name);
		
	
	
	
	
	}

}
