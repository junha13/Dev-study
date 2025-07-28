
public class review {

	public static void main(String[] args) {
		int an = 1;
		int kn = 1;
		System.out.println("어른 " + an + "명");
		System.out.println("어린이 " + kn + "명");
		int output1 = calculator(an, kn);
		if (an + kn >= 5) {
			System.out.println("입장료는 " + Math.round(output1 * 0.8) + "원.");
		} else {
			System.out.println("입장료는 " + output1 + "원.");
		}

	}
	static int calculator(int an, int kn) {
		int output = an * 20000 + kn * 9900;
		return output;
	}
}
