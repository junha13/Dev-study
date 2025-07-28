package com.lx.fish;

public class Shark extends Fish {  // 여기서 빨간 줄 뜨는 거 생성자함수는 물려받아서 쓸 수 없는거임 만들면 사라짐
	
	public Shark(String name) { // fish name 변수 상자를 물려받아서 사용하는데 생성자함수는 직접 만들어야됨
		super(name);   // super는 부모를 가리킴 때문에 fish 부모의 생성자 함수가 실행되는거임
	}
 
}
