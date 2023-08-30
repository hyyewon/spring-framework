import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;
import com.dto.Person;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
		
		System.out.println("1.전체 Cat 목록");
		Person p1 = ctx.getBean("p1",Person.class); //has a 관계로 Person을 가져오면 Cat도 가져올 수 있음
		List<Cat> list = p1.getCatList();
		for(Cat cat:list) {
			System.out.println(cat);
		}
		
		
		System.out.println("2.idx 이용한 특정 위치 Cat 출력");
		Person p2 = ctx.getBean("p2",Person.class); 
		List<Cat> list2 = p2.getCatList();
		for(Cat cat:list2) {
			System.out.println(cat);
		}
		
		
		System.out.println("3.age < 10 Cat 출력"); //value="#{xxx.?[조건식]}"  ? : selection(행 선택) ! : projection(열 선택)
		Person p3 = ctx.getBean("p3",Person.class); 
		List<Cat> list3 = p3.getCatList();
		for(Cat cat:list3) {
			System.out.println(cat);
		}
		
		System.out.println("4.age < 10 and married==false Cat 출력"); //value="#{xxx.?[조건식]}"  ? : selection(행 선택) ! : projection(열 선택)
		Person p4 = ctx.getBean("p4",Person.class); 
		List<Cat> list4 = p4.getCatList();
		for(Cat cat:list4) {
			System.out.println(cat);
		}
		
		
	}

}
