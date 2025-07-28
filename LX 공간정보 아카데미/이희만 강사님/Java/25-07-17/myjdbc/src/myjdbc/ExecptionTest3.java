package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExecptionTest3 {
	public static void main(String[] args) {
		// file reading
		FileReader fr;
		try {
			fr = new FileReader("list.txt");
			int read;
			read = fr.read();
		} catch (FileNotFoundException e) {

		 //컨트롤 스페이스 throws절로 정의되어있음 
		// 오류 풀려면 trycatch절이나 throws절 사용
		// 이 지역 선에서 끝내려면 trycatch절, excption으로 넘기려면 throws절 사용
		} catch (IOException e) {

		} finally {
			// 예외가 발생되든 안되든 실행되는 구간이다.
			// 트라이 안에가 실행되든 안되든 실행됨
		}

		
		//System.out.println((char)read); // list.txt의 한글자를 찍어서 보여주는거
	}
}
