package com.lx.animal;

public class Cat extends Animal {

	static int ccount = 0;
	
	public Cat(String name, int age, String mobile) {
		super(name, age, mobile);
		ccount = ccount + 1;
		System.out.println("현재 동물이 총 " + Animal.count + "마리 만들어졌습니다. (고양이 : " + ccount + "마리)");
	}
	
	public void standup() {
		System.out.println("\n고양이가 서있습니다." + "(" + this.name + ")");
	}
	
	public void sitdown() {
		System.out.println("\n고양이가 앉아있습니다." + "(" + this.name + ")");
	}
	
	public void run() {
		System.out.println("\n고양이가 뛰어갑니다." + "(" + this.name + ")");
	}
}
