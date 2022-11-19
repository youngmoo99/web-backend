package db_connect;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class MemberUI3 {
	private static JTable table;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.GREEN);
		f.setSize(500,800);
		
		JLabel lblNewLabel = new JLabel("회원정보목록");
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		f.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.CENTER);
		
		//table항목명은 1차원배열
		String[] header = {"아이디", "패스워드", "이름", "전화번호"};
		
		//main()이 사작하자마자 dao.list()
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.list();
		Object[][] all = new Object[list.size()][4]; //행, 열의개수
		//table내용은 2차원배열 
		for (int i = 0; i < all.length; i++) { //list.size()와 같음 
			MemberVO bag = list.get(i); // 가방을 1개 꺼내세요
			all[i][0] = bag.getId();
			all[i][1] = bag.getPw();
			all[i][2] = bag.getName();
			all[i][3] = bag.getTel();
					
		}
		
		
		table = new JTable(all,header);
		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowNo = table.getSelectedRow();
				
				int colNo = table.getSelectedColumn();
				
				//클릭 한 값 가지고오기 
				Object id = table.getModel().getValueAt(rowNo, 0); // 0,0
				Object pw = table.getModel().getValueAt(rowNo, 1); // 0,1
				Object name = table.getModel().getValueAt(rowNo, 2); // 0,2
				Object tel = table.getModel().getValueAt(rowNo, 3); // 0,3
				JOptionPane.showMessageDialog(table,id+" "+pw+" "+name+" "+tel);
	
				}
			
		});
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\YoungMoo\\Desktop\\1111.png"));
		panel.add(lblNewLabel_1);
	
		f.setVisible(true);
	}

}
