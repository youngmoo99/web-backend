package error;

public class 예외처리Main2 {

	public static void main(String[] args) {
		//에러가 있는 클래스의 객체를 생성하고, 메서드를 호출해 보자 
		에러발생3 error = new 에러발생3();
		try {
			error.call(); // 실행 에러가있는 메서드 
		} catch (Exception e) {
			System.out.println("총관리자 이므로 에러발생 메일");
			
		}System.out.println("예외처리 했음, 프로그램 중단 x ");
		

	}

}
