
public class Calculator {
	public static void main(String[] args) {
		int an = 1;  //성인 수
		int kn = 1;  //어린이 수
		int out = cal(an, kn); //함수 받아주기
		System.out.println("성인 수 : "+an+"명");
		System.out.println("어린이 수 : "+kn+"명");
		if (an+kn >=5) {  //단체할인 if문
			System.out.println("입장료는 " +Math.round(out * 0.8)+"원.");
		} else {  
			System.out.println("\n 입장료는 " +out+"원.");
		}
	} 
	//계산기 함수
	static int cal (int an, int kn) {
		int output = an * 20000 + kn * 9900;
		return output;
	}
}
