package userIfo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserIO {
	// 사용자의 정보를 전달받아서 파일에 저장한다.
	public void addUser(User user, String fileName) throws Exception {
		FileWriter fr = new FileWriter(fileName, true);
		PrintWriter out = new PrintWriter(fr); // append ???
		String str = user.getLastName() + "|" +user.getFirstName() + "|" +user.getEmail();
		
		out.print(str);
		out.close();
		}
}
