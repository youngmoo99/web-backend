package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class DB연결2 {

	public static void main(String[] args) throws Exception {
		//1~3: apache iBatis-> google myBatis
			//				      ���̹�Ƽ��		
		//1. ����̹�(Ŀ����) ���� 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1. ����̹� ���� ok....");
		
		//2. db����(shop, root, 1234)
		String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "scott";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB���� ok....");
		
		//3. sql�� ����
		String id = JOptionPane.showInputDialog("id");
		String pw = JOptionPane.showInputDialog("pw");
		String name = JOptionPane.showInputDialog("name");
		String tel = JOptionPane.showInputDialog("tel");
		
		String sql = "insert into member values (?,?,?,?)";
		//String sql = "delete from member where id = '700' ";
		//SQL������ ����ϴ� ��ü�� ������־�� �ڹٴ� �ν�
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, tel);
		System.out.println("3. SQL�� ���� ok....");

		//4. sql�� ����
		ps.executeUpdate();
		System.out.println("4. SQL�� ���� ok....");
	}

}
