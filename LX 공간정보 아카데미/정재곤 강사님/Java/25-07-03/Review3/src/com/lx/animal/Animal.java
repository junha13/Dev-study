package com.lx.animal;

public class Animal {
	
	public static int count = 0; //static이란, 다른거는 실제 붕어빵에 찍혀서 나오는데 이건 철판에 붙어서 안나옴
	//클래스에만 붙어있는 값, ***실제 붕어빵에 붙어있지 않음***
	
	public String name; // 이건 클래스에 안붙어있는거임 그 실제 붕어빵을 만들 때만 찍혀서 진짜 붕어빵에만 붙어있는 변수임
	//때문에 실제 붕어빵을 만들 때 static을 안붙히고 count를 하면 이게 뭔 값인지 모르니까 static 써야댐 
	//그리고 실제 붕어빵에 count를 변수로 안넣게 하려고 하는거ㅇ
	//static은 전역변수임 (이건 잘모름) 
	
	public Animal() {
		count = count + 1;
	}

	
	
	public void walk() {
		System.out.println(this.name + " 걸어갑니다.");
		
	}
}
