package addrbook;

import java.util.List;
import java.util.Scanner;

public class AddrBookdeleteMain {
	public static void main(String[] args) throws Exception {
		System.out.println("addrbook id list");
		Scanner sc = new Scanner(System.in);
		System.out.println("id를 입력하세요(삭제)");
		int abId = sc.nextInt();
		
		
		boolean result = new AddrBookDAO().deleteDB(abId);
		sc.close();
		System.out.println(result);
	}
}


