package db_connect;

import javax.swing.JOptionPane;

public class MemberUITest6 {

	public static void main(String[] args) {
		//입력하는 화면을 ui파일에 만들자..
		
		String id = JOptionPane.showInputDialog("아이디 입력"); 
		String pw = JOptionPane.showInputDialog("패스워드 입력"); 
		
		
		//입력한 데이터를 가지고 db에 넣읍시다.!!
		//db의 member테이블에 넣고 싶어요!!!
		//==> MemberDAO사용하면 됨.
		MemberDAO dao = new MemberDAO();
		
		//보내는 쪽
		//1) 가방을 만든다.
		MemberVO bag = new MemberVO();
		
		//2) 가방에 입력한 값들을 넣자.(set()이용)
		bag.setId(id);
		bag.setPw(pw);
	
		//3) 가방을 DAO에게 전달
		//dao.insert(bag);
		int result = dao.login(bag);
		if (result == 1) {
			JOptionPane.showMessageDialog(null, "로그인 성공");
			gasifan2 gasi = new gasifan2();
			gasi.open();
		} else {
			JOptionPane.showMessageDialog(null, "로그인 실패");
			MemberUI2 log = new MemberUI2();
			log.open();
		}
		
	}

}
