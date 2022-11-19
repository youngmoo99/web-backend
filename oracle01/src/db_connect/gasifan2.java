package db_connect;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gasifan2 {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;

	public static void open() {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.GREEN);
        f.setSize(500, 700);
        f.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("나의 게시판");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 65));
        lblNewLabel.setBounds(61, 10, 365, 62);
        f.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("--------------");
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 52));
        lblNewLabel_1.setBounds(12, 82, 484, 35);
        f.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("게시판 id");
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_2.setBounds(155, 109, 167, 35);
        f.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("게시판 제목");
        lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_2_1.setBounds(155, 187, 167, 35);
        f.getContentPane().add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("게시판 내용");
        lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_2_2.setBounds(155, 267, 167, 35);
        f.getContentPane().add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("게시판 작성자");
        lblNewLabel_2_3.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_2_3.setBounds(155, 353, 204, 35);
        f.getContentPane().add(lblNewLabel_2_3);
        
        t1 = new JTextField();
        t1.setBounds(56, 142, 355, 35);
        f.getContentPane().add(t1);
        t1.setColumns(10);
        
        t2 = new JTextField();
        t2.setColumns(10);
        t2.setBounds(56, 222, 355, 35);
        f.getContentPane().add(t2);
        
        t3 = new JTextField();
        t3.setColumns(10);
        t3.setBounds(56, 312, 355, 35);
        f.getContentPane().add(t3);
        
        t4 = new JTextField();
        t4.setColumns(10);
        t4.setBounds(56, 388, 355, 35);
        f.getContentPane().add(t4);
        
        JButton btnNewButton = new JButton("게시물 작성 완료");
        btnNewButton.setBackground(Color.YELLOW);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id = t1.getText();
        		String title = t2.getText();
        		String content = t3.getText();
        		String writer = t4.getText();
        		
        		gasifanDAO dao = new gasifanDAO();
        		dao.insert(id, title, content, writer);
        		
        	}
        });
        btnNewButton.setBounds(61, 433, 350, 40);
        f.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("게시물 삭제 완료");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id = t1.getText();
        	
        		
        		gasifanDAO dao = new gasifanDAO();
        		dao.delete(id);
        	}
        });
        btnNewButton_1.setBackground(Color.RED);
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton_1.setBounds(61, 491, 350, 40);
        f.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("게시물 검색 완료");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id = t1.getText();
        		
        		gasifanDAO dao = new gasifanDAO();
        		GasifanVO bag = dao.select(id);
        		
        		t1.setText(bag.getId());
        		t2.setText(bag.getTitle());
        		t3.setText(bag.getContent());
        		t4.setText(bag.getWriter());
        		
        		
        	}
        });
        btnNewButton_2.setBackground(Color.BLUE);
        btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton_2.setBounds(61, 553, 350, 40);
        f.getContentPane().add(btnNewButton_2);
        f.setVisible(true);
		

	}
}
