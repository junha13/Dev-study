package com.lx.animal;

public class Dog extends Animal {

	public int age = 0; //초기화까지는 할 수 있음

	// walk 함수를 다시 만들었음 (재정의, override)
	public void walk() {
		System.out.println(this.name + " 강아지가 걸어갑니다.");
	}
}
