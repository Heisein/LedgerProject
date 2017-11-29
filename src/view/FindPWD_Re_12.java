package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class FindPWD_Re_12 {

	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[2];
	
	public FindPWD_Re_12(){
		
		Set_PWD_panel();
		SET_Label_Area();
		SET_IMG_Area();
		
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Set_PWD_panel() {
		sub.setSize(360, 450);
		sub.setLocation(0, 60);
		sub.setVisible(true);
		sub.setBackground(Color.white);
		sub.setLayout(null);
		
		JLabel jl_intro = new JLabel("    용돈조 계정으로 사용할 비밀번호를 다시 설정해 주세요.");
		jl_intro.setLocation(-1, 0);
		jl_intro.setSize(360, 40);
		jl_intro.setVisible(true);
		jl_intro.setBorder(new LineBorder(Color.GRAY));
		sub.add(jl_intro);
		
		JTextArea jta[] = new JTextArea[2];
		JLabel jl[] = new JLabel[2];
		
		jl[0] = new JLabel("비밀번호 입력");
		jta[0] = new JTextArea("비밀번호 입력");
		
		jl[1] = new JLabel("비밀번호 재입력");
		jta[1] = new JTextArea("비밀번호 재입력");
		
		for (int i = 0; i < 2; i++) {
			jl[i].setSize(300, 40);
			jta[i].setSize(300, 40);
			jta[i].setBorder(new LineBorder(Color.black));
			jl[i].setLocation(20, 40 + (80 * i));
			jta[i].setLocation(20, 70 + (80 * i));
			sub.add(jl[i]);
			sub.add(jta[i]);
		}
		
		
		jp.add(sub);
	}
	
	public void SET_Label_Area() {

		jl[0] = new JLabel("비밀번호 변경");
		jl[1] = new JLabel("다음");

		jl[0].setSize(140, 20);
		jl[0].setLocation(120, 20);
		jl[0].setFont(new Font("맑은 고딕", Font.PLAIN, 16));

		jl[1].setSize(150, 20);
		jl[1].setLocation(150, 525);
		jl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new Login_2().point(jf.getLocation());
				jf.setVisible(false);
			}
		});
	}
	
	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new FindPWD_10().point(jf.getLocation());
				jf.setVisible(false);
			}
		});

		jp.add(jl);
	}
	
	public void point(Point p) {
	      if (p != null) {
	         jf.setLocation(p);
	   }
	 }
	
}
