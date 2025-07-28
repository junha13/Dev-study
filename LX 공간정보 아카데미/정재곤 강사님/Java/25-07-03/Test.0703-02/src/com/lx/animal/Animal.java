package com.lx.animal;

public class Animal {
	
	static int count = 0;
	
	String name;
	int age;
	String mobile;
	
	public Animal(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		count = count + 1;
	}
	
	public void standup() {
	}
	
	public void sitdown() {
	}
	
	public void run() {
	}
	
}
