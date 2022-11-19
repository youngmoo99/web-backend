package db_connect;

import java.util.ArrayList;

public class MemberListUI {

	public static void main(String[] args) {
		MemberDAO dao= new MemberDAO();
		
		ArrayList<MemberVO> list = dao.list();
		
		System.out.println("검색한 회원수 >> "+list.size());
		for (MemberVO bag: list) {
			System.out.println(bag.getId());
			System.out.println(bag.getPw());
			System.out.println(bag.getName());
			System.out.println(bag.getTel());
			System.out.println("---------------------");
		}
//		for (int i=0; i<list.size(); i++) { 위와 같음 
//		System.out.println(bag.getId());
//			System.out.println(bag.getPw());
//			System.out.println(bag.getName());
//			System.out.println(bag.getTel());
//			System.out.println("---------------------");
//		}
	}

}
