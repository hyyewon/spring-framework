import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class TestMain {

	public static void main(String[] args) {

		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:com/config/user.xml");
		
		//scope="singleton" 은 하나의 인스턴스로 여러 사용자가 사용하기 때문에 인스턴스가 공유된다.
		UserService s1 = ctx.getBean("service",UserService.class);
		UserService s2 = ctx.getBean("service",UserService.class);
		System.out.println("singleton:" + (s1==s2)); 
		
		s1.username="홍길동";
		s2.username="이순신";
		System.out.println(s1.username); //이순신
		System.out.println(s2.username); //이순신
		
		//scope="prototype" 은 매번 생성됨, 생성할 때마다 주소값이 달라짐 -> 자신만의 데이터 유지 가능
		UserService s3 = ctx.getBean("service2",UserService.class);
		UserService s4 = ctx.getBean("service2",UserService.class);
		System.out.println("prototype:" + (s3==s4));
		
		s3.username="유관순";
		s4.username="강감찬";
		System.out.println(s3.username+"\t"+s4.username);
		
		
	}

}
