package com.lx.animal;

public class Dog extends Animal {
	
	static int dcount = 0;

	public Dog(String name, int age, String mobile) {
		super(name, age, mobile);
		dcount = dcount + 1;
		System.out.println("현재 동물이 총 " + Animal.count + "마리 만들어졌습니다. (강아지 : " + dcount + "마리)");
	}
	
	public void standup() {
		System.out.println("\n강아지가 서있습니다." + "(" + this.name + ")");
	}
	
	public void sitdown() {
		System.out.println("\n강아지가 앉아있습니다." + "(" + this.name + ")");
	}
	
	public void run() {
		System.out.println("\n강아지가 뛰어갑니다." + "(" + this.name + ")");
	}
	
}
