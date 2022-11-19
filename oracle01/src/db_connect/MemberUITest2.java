package db_connect;

import javax.swing.JOptionPane;

public class MemberUITest2 {

	public static void main(String[] args) {
		
		String id = JOptionPane.showInputDialog("아이디 입력");
		String pw = JOptionPane.showInputDialog("패스워드 입력");
		String name= JOptionPane.showInputDialog("이름 입력");
	    String tel = JOptionPane.showInputDialog("전화번호 입력");
		
		//입력한 데이터를 가지고 db에 넣기 
		//MEMBER 테이블에 넣고싶어요 ==> MemberDAO 
		MemberDAO dao = new MemberDAO();
		
		//보내는 쪽 
		//1) 가방을 만든다
		MemberVO bag = new MemberVO();
		//2) 가방에 입력한 값들을 넣자 
		bag.setId(id);
		bag.setPw(pw);
		bag.setName(name);
		bag.setTel(tel);
		
		//3) 가방을 DAO에게 전달 
		
		dao.insert(bag);
		
		

		

	}

}
