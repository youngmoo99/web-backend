package bdcp;

public class DBCPUser {

	public static void main(String[] args) {
		//DBCP nmae = new DBCP(); 외부에서 객체생성 막아버림 객체생성 x
		
		//싱글톤 방법 -> 객체를 하나만 만들어서 하나만 계속 사용 
		// <---> 프로토타입 방법 : 틀을 이용해서 필요할떄마다 꼐속 여러개 만들어서 사용 
		
		DBCP dbcp = DBCP.getInstance(); // 최초로 객체를 요구할 때 DBCP도 객체를 만든다 
		System.out.println(dbcp);
		
		
		DBCP dbcp2 = DBCP.getInstance(); // 두번째 객체를 요구할 때 아까 만들어둔 객체를 리턴한다 
		System.out.println(dbcp2);

	}

}
