import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class EnvironmentTest {

	public static void main(String[] args) {

		//운영체제의 환경 변수 얻기( key/value => Map, Properties )
		//환경 설정 정보
		//1.일반 자바 클래스
		Properties props = System.getProperties();
		Set<String> keys = props.stringPropertyNames(); //key얻기
		for(String key:keys) {
			System.out.println(key+"\t"+props.getProperty(key)); //value얻기
		}
		System.out.println("##################################################");
		
		//2.스프링
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env  = ctx.getEnvironment();
		
		 Map<String, Object> m = env.getSystemProperties();
		 Set<String> keys2 = m.keySet(); //key얻기
		 for (String key : keys2) {
			 System.out.println(key + "\t" + m.get(key)); //value얻기
		}
		
	}

}
