package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TeamSelection2 {
	public static void main(String[] args) throws Exception {
		String[] array = {"고영준", "고예원", "권수현", "김민채", "노은호", 
						  "박민호", "박윤정", "박윤호", "어성준", "서지현", 
						  "이동민", "이재빈", "이주형", "정성범", "정준안", 
						  "조계연", "주영민", "차민정", "하지서", "안병주"};
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		for(String str : array) {
			list.add(str);
		}
		Random random = new Random();
		while(list.size()!=0) {
			int temp = random.nextInt(list.size());
			//System.out.println(temp);
			result.add(list.remove(temp));
		}
		//System.out.println(result);
		int count = 0;
		for(String name: result) {
			System.out.print(name + "\t");
			count++;
			if(count%2==0) {
				System.out.println();
				Thread.sleep(2000);
			}
		}
		
	}
}
