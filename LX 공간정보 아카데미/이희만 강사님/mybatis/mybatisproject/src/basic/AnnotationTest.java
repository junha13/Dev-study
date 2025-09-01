package basic;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationTest {
	public static void main(String[] args) {
		// Annotation이 뭘까? => Annotation
		// 변수는 아님. 함수도, 클래스, 패키지도 아니다.
		// 주로 어노테이션은 마킹용도로 사용한다.
		
		MyClass myClass = new MyClass();
		Annotation[] annotationList = myClass.getClass().getAnnotations();
		
		
		// stream 은 for루프를 조금 더 좋게 돌릴 수 잇음
		for (Annotation annotation : annotationList) {
			System.out.println(annotation);
		}
	}

}

@Retention(RetentionPolicy.RUNTIME)
@interface
MyAnnotatiln {  // 한번 설정해두면 마킹이 가능함
	
}
// MyClass 라는 클래스는 @MyAnnotation으로 마킹한 것, 도장 찍은 것
@MyAnnotatiln
class MyClass {
	
}
