package com.lx;

public class Fish {

	String name;
	int age;
	
	public String getname() {  //name이라는 변수 상자를 그냥 밑으로 내리는거임
		return this.name;	   //그래서 fish1.name이 아니라 fish1.getname()을 하는거임
	}
	//던져준 값을 fish의 이름으로 변환하는 거임 변수 상자를 바로 건드리면 보안에 문제가 있을 수 잇으니까
	//근데 요즘에 생기는 것들은 getname, setname 없는경우도 있는데 자바는 get, set 함수를 많이 쓸때가 있음
	//형태 정도랑 왜 쓰는지 정도를 이해하면 좋을듯
	
	void setname(String name) {
		this.name = name;
	}
	
	public int getage() {
		return this.age;
	}
	
	public void setage(int age) {
		
		if (age <20) {
			System.out.println("미성년자");
			return;    //뒤에 없이 쓰면 break같은 느낌임
		}
		
		this.age = age;
	}
	
	
	
	public Fish() {
		
	}
	
	public Fish(String name) {
		this.name = name;
	}
	
}
