import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {

		//"getMessege"메서드를 갖고있는 MessageSource를 사용해야 함
		//MessageSource를 상속받고있는 ApplicationContext를 사용해도 됨
//		ApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:com/config/user.xml");

		MessageSource ctx = 
				new GenericXmlApplicationContext("classpath:com/config/user.xml");
		
		//리소스 번들(resource bundle)에서 메세지 얻기
//		ctx.getMessage("properties의 키값", "properties에 전달할 값", "일치하는 키값이 없을때 기본값", 지역명시)
		String mesg = ctx.getMessage("greeting", null, null, Locale.KOREA);
		System.out.println(mesg);
		String mesg2 = ctx.getMessage("greeting", null, null, Locale.ENGLISH);
		System.out.println(mesg2);
		
		//{n}에 값 치환, 값은 String 배열로 입력
		String mesg3 = ctx.getMessage("greeting2", new String[] {"홍길동","감사합니다."} , null, Locale.KOREA);
		System.out.println(mesg3);
		mesg3 = ctx.getMessage("greeting2", new String[] {"이순신","감사합니다."} , null, Locale.KOREA);
		System.out.println(mesg3);
		
	}

}
