//자바의 싱글톤 패턴 구현 (singleton design pattern)
//UserService를 한 번만 생성하게끔 구현
class UserService{
	
	//3.static, private 변수로 지정
	private static UserService service;
	
	//1.생성자를 private으로 지정 -> new 불가
	private UserService() {
	}
	
	//2.자기자신의 메서드에서 생성(한번은 생성해야 함)
	public static UserService getInstance() { //외부에서 메서드호출하려면 객체생성 해야함, but 객체생성하지 않고 접근해야 함 ->static사용
		if(service==null) {
			service = new UserService();
		}
		return service;
	}
	
}

public class TestMain {

	public static void main(String[] args) {
		
		//대표적인 싱글톤 객체: Calendar.getInstanc()

//		UserService s1 = new UserService(); //생성하려면 new + 생성자 사용
//		UserService s2 = new UserService(); //외부에서 생성할 수 있고, 여러번 생성할 수 있는 것은 생성자가 public 이기 때문
		UserService s3 = UserService.getInstance(); //외부에서는 클래스 이름으로 접근
		UserService s4 = UserService.getInstance(); //100번지
		UserService s5 = UserService.getInstance(); //100번지
		
		System.out.println(s3==s4);
		System.out.println(s3==s5);
		System.out.println(s5==s4);
		
	}

}
