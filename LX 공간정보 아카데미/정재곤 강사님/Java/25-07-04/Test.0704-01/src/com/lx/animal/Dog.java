package com.lx.animal;

public class Dog implements iAnimal{  // ianimal에서 만든 약속을 지키겠다는 의미 implemants
	
	String name;
	
	public void run() { //중괄호 빼곤 똑같이 써야댐
		System.out.println(this.name + "강아지가 뛰어갑니다.");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
