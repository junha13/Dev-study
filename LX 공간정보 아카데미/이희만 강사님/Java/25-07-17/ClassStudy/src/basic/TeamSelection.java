package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TeamSelection {
	public static void main(String[] args) throws Exception {
		String[] array = {"고영준", "고예원", "권수현", "김민재", "김병욱", "김준하", "노은호", "박민호", "박윤정", 
						  "박윤호", "박정훈", "박지겸", "서지현", "안병주", "어성준", "이동민", "이유나", "이재빈",
						  "이정민", "이주형", "이태민", "정성범", "정준안", "정태수", "정형민", "조계연", "주영민", 
						  "차민정", "하성민", "하지서"};
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
			if(count%6==0) {
				System.out.println();
				Thread.sleep(2000);
			}
		}
		
	}
}
