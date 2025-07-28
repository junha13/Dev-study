package basic;

public class InheritanceTest {
	public static void main(String[] args) {
		Shape shape = new Rectangle();
		shape.print();
	}
}
interface Shape {
	public abstract void print();
}
abstract class Rectangle implements Shape {
	void write() {
		
	}
}