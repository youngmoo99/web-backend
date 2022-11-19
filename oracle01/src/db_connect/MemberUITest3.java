package db_connect;

import javax.swing.JOptionPane;

public class MemberUITest3 {

	public static void main(String[] args) {
		
		String id = JOptionPane.showInputDialog("검색할 아이디 입력");
		
		
		//입력한 데이터를 가지고 db에 넣기 
		//MEMBER 테이블에 넣고싶어요 ==> MemberDAO 
		MemberDAO dao = new MemberDAO();
		
	
	
		
		MemberVO bag = dao.one(id); //메서드에서 컨트롤 클릭하면 이동 ,void일 경우엔 사용불가능
		JOptionPane.showMessageDialog(null, bag);
		
		

		

	}

}
