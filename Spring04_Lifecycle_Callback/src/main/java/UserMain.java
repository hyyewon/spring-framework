import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain {

	public static void main(String[] args) {

		//destroy 호출을 받기 위해 다형성 적용 x
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
	
		ctx.close(); //destroy-method="yyy"
		
	}

}
