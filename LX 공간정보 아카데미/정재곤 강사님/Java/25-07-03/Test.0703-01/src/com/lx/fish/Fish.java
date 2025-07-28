package com.lx.fish;
import com.lx.sea.Sea;

public class Fish extends Sea {
	
	public String name;

	public Fish(String name) {
		this.name = name;
		Sea.count = Sea.count + 1;
	}
}

