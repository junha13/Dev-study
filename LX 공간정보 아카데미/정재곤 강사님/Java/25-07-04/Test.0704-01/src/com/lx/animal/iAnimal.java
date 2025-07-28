package com.lx.animal;

//약속 정하기 (동물이라면 무조건 run이라는 함수상자가 있어야 해요.)
public interface iAnimal { //class를 interface로 바꿈 , 
	
	public void run(); // 인터페이스에서는 중괄호 제외하고 함수에 ;붙힘 , 붕어빵 틀을 약속을 지키면서 만들라는 의미
	
	public void setName(String name);
}
