
public class InheritanceTest {
	public static void main(String[] args) {
		// Rectangle 클래스의 print()메서드를 실행하고 싶다.
		Shape shape = new Rectangle();
		shape.print();  // interface에서 가지고 잇는 메서드를 실행할 수 잇음 근데 젤 위에는 object임
		
		// *** print는 interface인 Shape에 선언되어 있고, class인 Rectangle에서 정의되어 있어서 print는 pectangle에서 실행됨

		// Shape shape = new Shape();
		Shape shape1;
	
	}
}
// 일종의 추상 class, .class로 존재함. 객체생성되지 않음. 그러나 타입으로는 생성가능하다
// 내부에 메서드를 선언하는 곳에 사용한다.
interface Shape {
	// 메서드를 define하는 것 안되고 선언(declare)하는 것만 가능하다. 추상 메서드는 **바디**를 갖지 않는다.
	public abstract void print(); // public abstract는 없어도 자동으로 적용된다.
}
// implements Shape이라는 부분으로 인터페이스에 선언된 메서드를 정의해야 한다.

class Rectangle implements Shape{

	@Override
	public void print() {
		
	}
	// 정의란 {} 구간을 만드는 것이고 호출되었을 때 무엇이 실행될지를 기술해둔다.
}



interface Triangle {
	
}