package com.lx.house;

import java.util.ArrayList;
import com.lx.dog.Dog;

public class House {
	String name;
	ArrayList<Dog> dogs = new ArrayList<Dog>();
	
	public House(String name) {
		this.name = name;
	}
	
	public void setDog(Dog dog) {
		this.dogs.add(dog);
		System.out.println(dog.getName() + "가 " + this.name + "에 들어갔습니다.");
	}
	
}
