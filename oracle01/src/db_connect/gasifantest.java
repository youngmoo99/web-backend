package db_connect;

import java.util.ArrayList;

public class gasifantest {

	public static void main(String[] args) {
		gasifanDAO dao= new gasifanDAO();
		
		ArrayList<GasifanVO> list = dao.list();
		
		System.out.println("검색한 회원수 >> "+list.size());
		for (GasifanVO bag: list) {
			System.out.println(bag.getId());
			System.out.println(bag.getTitle());
			System.out.println(bag.getContent());
			System.out.println(bag.getWriter());
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
