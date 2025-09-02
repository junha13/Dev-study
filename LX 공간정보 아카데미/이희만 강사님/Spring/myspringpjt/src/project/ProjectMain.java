package project;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProjectMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		EmpService service = (EmpService) context.getBean(EmpService.class);
		Scanner scan = new Scanner(System.in); 
		
		  int way=10;
	      while(way!=0) {
	         System.out.println("<원하는 검색방법 번호를 입력하세요>(0 입력시 종료됩니다)");
	         System.out.println("1.이름 2.입사년도 3. 부서번호 4. 도시이름 5.통계자료 6. 부서장이름을 통한 부서원검색");
	         try {
	         way = scan.nextInt();
	         } catch (InputMismatchException e) {
	             System.out.println("숫자로 다시 입력해주세요.");
	             scan.nextLine();
	             continue;
	         }
	         switch(way) {
	         case 1:
	            System.out.println("미구현");;
	            break;
	         case 2:
	     		System.out.println("입사연도 입력(YYYY) : ");
	    		int year = scan.nextInt();
	    		while(year!=0) {
	    			List<Emp> list = service.findEmpByYear(year);
	    			for(Emp emp : list) {
	    				System.out.println(emp.toString());		
	    			}
	    			System.out.println("연도 입력(0은 종료) : ");
	    			year = scan.nextInt();
	    		}
	            break;
	         case 3:
	     		System.out.println("부서번호 입력 : ");
	    		int dept = scan.nextInt();
	    		while(dept!=0) {
	    			List<Emp> list = service.findEmpByYear(dept);
	    			for(Emp emp : list) {
	    				System.out.println(emp.toString());		
	    			}
	    			System.out.println("부서번호 입력(0은 종료) : ");
	    			dept = scan.nextInt();
	    		}
	            break;
	         case 4:
		            System.out.println("미구현");;
	            break;
	         case 5:
		            System.out.println("미구현");;
	            break;
	         case 6:
		            System.out.println("미구현");;
	            break;
	         default:
	            System.out.println("선택지에 없는 번호입니다.");
	            break;
	         }
	      }
	      scan.close();
	      System.out.println("-프로그램 종료-");
	   }
}