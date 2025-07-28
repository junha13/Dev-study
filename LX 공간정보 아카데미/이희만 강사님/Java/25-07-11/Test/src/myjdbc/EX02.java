package myjdbc;

import java.util.ArrayList;

public class EX02 {
	public static void main(String[] args) {
		/*
		* 1부터 1000까지의 100개의 임의의 수로 이루어진 배열을 생성하는 함수를
		* 호출하여 배열을 생성한다.
		- 2.인덱스가 홀수인 수들을 출력하는 함수
		- 3.배열의 수들의 합을 반환하는 함수
		- 4.가장 작은 수의 위치(인덱스)를 반환하는 함수
		- 5.3의 배수만을 새로운 배열에 복사하여 리턴하는 함수
		

		option!
		- 배열의 수들을 한 줄에 10개씩 출력하는 함수, 이때 각 수들은 줄이 맞춰져야 함


		5번은 List Collection API를 사용하는 것이 더 적절한다.
		*/
		int[] list = makeArray();
		
		 System.out.println(list[10]); 
		 getOddNumber(list); 
		 getAddNumber(list);
		 getSmallNumber(list); 
		 setThreeArray(list); 
		 makeLine(list);
		
	}

	public static int[] makeArray() {
		int [] result = new int[100];
		for (int i=0; i<100; i++) {
			result[i] = (int) (Math.random()*1000)+1;
		}
		return result;
	}
	
	public static void getOddNumber(int[] list) {
		String output = "";
		for (int i = 0; i < list.length; i++) {
			if (i%2==1 && i !=0) {
				output = output + "인덱스 " + i + "번 " + list[i] + " \n";
			}
		}
		System.out.println(output);
	}
	
	public static void getAddNumber(int[] list) {
		int output2 = 0;
		for (int i = 0; i < list.length; i++) {
			output2 = output2 + list[i];
		}
		System.out.println(output2 + "\n");
	}
	
	public static void getSmallNumber(int[] list) {
		int min = 0;
		for (int i = 0; i < list.length; i++) {
			if(list[min] > list[i]) {
				min = i;
			}
		}
		System.out.println(min + " " + list[min] + "\n");
	}
	
	public static void setThreeArray(int[] list) {
		ArrayList<Integer> arrays = new ArrayList<Integer>();
		for (int i = 0; i < list.length; i++) {
			if (list[i] % 3 == 0) {
				arrays.add(list[i]);
				System.out.println("원래 리스트 인덱스" + i + "번, 현재 arraylist 인덱스 " + (arrays.size()-1) + "번" + list[i]);
			}
		}

	}
	
	public static void makeLine(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + "\t");
			if ((i+1) % 10 == 0) {
				System.out.println("");
			}
		}
	}
}
