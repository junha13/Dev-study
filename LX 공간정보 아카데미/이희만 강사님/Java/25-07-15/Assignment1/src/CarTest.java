
public class CarTest {
	public static void main(String[] args) {
		
	Car car1 = new Car();
	
	car1.setName("hudson");
	car1.setSpeed(300);
	System.out.println("이름 : " + car1.getName() + "\t속도 : " + car1.getSpeed());
	
	Car car2 = new Car();
	car2.setName("carrear");
	car2.setSpeed(200);
	System.out.println("이름 : " + car2.getName() + "\t속도 : " + car2.getSpeed());
	
	Car car3 = new Car();
	car3.setName("mater");
	car3.setSpeed(80);
	System.out.println("이름 : " + car3.getName() + "\t속도 : " + car3.getSpeed());
		
	}
}
	
class Car {
	String name;
	int speed;
		
	void setName(String name) {
		this.name = name;
	}
		
	void setSpeed(int speed) {
		this.speed = speed;
	}
		
	int getSpeed() {
		return this.speed;
	}
	
	String getName() {
		return this.name;
	}
	
}


