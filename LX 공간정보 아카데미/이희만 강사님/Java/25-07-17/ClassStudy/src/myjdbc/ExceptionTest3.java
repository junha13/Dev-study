package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest3 {
	public static void main(String[] args)  {
		//file reading
		FileReader fr;
		try {
			fr = new FileReader("list.txt");
			int read;
			read = fr.read();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			//예외가 발생되든 안되든지 실행되는 구간이다.
		}
	}
}
