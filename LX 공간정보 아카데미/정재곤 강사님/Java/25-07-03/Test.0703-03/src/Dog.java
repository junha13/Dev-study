import java.text.SimpleDateFormat;
import java.util.Date;   // date import는 두 번째꺼 설정해야됨

public class Dog extends Animal {
	
	Dog(String name) {
		super(); // 생성자 함수를 실행하라
		
		super.name = name;
		System.out.println("강아지가 만들어졌어요. 이름 : " + name);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		String now = format.format(date);
		super.birth = now;
				
	}

}
