package com.lx.dog;

public class Dog {

	String name;
	int age;
	String mobile;
	
	public Dog(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
}
