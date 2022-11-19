package bdcp;

public class DBCP {

	//싱글톤 
		//내(dbcp)가 하나만 만들어서 내가 필요한 클래스에 주자 
	static DBCP instance = null;
	
	//생성자 메서드를 private 선언하여 외부에서 
			// 객체를 여러개 만들지 못하게 막기 
	//객체 생성할 때 클래스이름과 동일한 생성자를 호출
	// new DBCP()를 못하게 외부에서 접근불가로 만들어버림 
	private DBCP() {
		
	}
	
	// 내가 만들어놓은 객체를 외부에 주는 메서드 하나 
	// public으로 만들어주자 
	public static DBCP getInstance() {
		if(instance ==null) {
			instance = new DBCP();
		}
		return instance;
	}
	

}
