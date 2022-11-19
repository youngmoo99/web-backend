package db_connect;

import javax.swing.JOptionPane;

public class MemberUITest {

	public static void main(String[] args) {
		
		String id = JOptionPane.showInputDialog("아이디 입력");
//		String pw = JOptionPane.showInputDialog("패스워드 입력");
//		String name= JOptionPane.showInputDialog("이름 입력");
//		String tel = JOptionPane.showInputDialog("전화번호 입력");
		
		//입력한 데이터를 가지고 db에 넣기 
		//MEMBER 테이블에 넣고싶어요 ==> MemberDAO 
		MemberDAO dao = new MemberDAO();
		dao.delete(id);
		
		//dao.insert(id,pw,name,tel);
		

	}

}
