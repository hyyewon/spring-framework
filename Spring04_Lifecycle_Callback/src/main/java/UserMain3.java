import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain3 {

	public static void main(String[] args) {

		//다형성 적용 x
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:com/config/user3.xml");
	
		ctx.close(); //@PreDestroy.yyy
		
	}

}
