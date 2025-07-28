import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<Student> student = new ArrayList<Student>();
		
		student.add(new Student("최일구1", 12, 12));
		student.add(new Student("최일구2", 13, 15));
		student.add(new Student("최일구3", 14, 14));
		student.add(new Student("최일구4", 15, 17));
		student.add(new Student("최일구5", 16, 16));
		System.out.println(student.get(0).getClass().getName());
		
		int sum = 0;
		for (int i = 0; i<student.size(); i++) {
			System.out.println(student.get(i).name+" "+student.get(i).age+" "+student.get(i).score);
			sum = sum + student.get(i).score;
		}
		double mean = (double) sum / student.size();
		System.out.println("평균 점수 : " + mean);
		
	}


}
