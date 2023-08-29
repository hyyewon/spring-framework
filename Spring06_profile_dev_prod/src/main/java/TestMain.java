import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class TestMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		//profile 결정
		//어떤 환경에서 작업할 것인지 선택
		ctx.getEnvironment().setActiveProfiles("dev"); //메서드 체인방법으로 "dev"을 연결 (두가지 xml중 활성화)
		
		//xml 등록
		ctx.load("classpath:com/config/user_dev.xml","classpath:com/config/user_prod.xml"); //두가지 xml로드
		ctx.refresh();
		
		//빈 얻기(다형성)
		UserService service = ctx.getBean("service", UserService.class);
		System.out.println(service.mesg());
	}

}
