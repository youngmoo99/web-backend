package error;

public class 문제발생클래스2 {

	public static void main(String[] args) {
		try {
			//System.out.println(3/0);
			
			int[] num = {1,2}; 
			num[2] = 22;
			
		} catch (ArithmeticException e) {
			System.out.println("수학에러");
		
		}catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("배열 에러");
		}catch (Exception e) {
			System.out.println("위에서 안잡은 다른 에러 처리");
		}finally {
			System.out.println("에러처리 다 끝남");
		}

	}

}
