import java.util.ArrayList;

public class Play {

	public static void main(String[] args) {
		//부서 정의
		Department dep1 = new Department("개발");
		Department dep2 = new Department("기획");
		Department dep3 = new Department("연구");
		
		//사람 정의
		
		ArrayList<Skill> skill1 = new ArrayList<Skill>();
		
		Person per1 = new Person("김철수", 21);
		per1.skill.add(new Skill("포토샵", "캐드", "자바"));
		

	}

}
