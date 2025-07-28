package com.lx.animal;

public class Cat implements iAnimal {

	String name;
	
	public void run() {
		System.out.println("고양이가 뛰어갑니다.");
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
