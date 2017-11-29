package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Set;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.User;
import model.UserDAO;

public class FindPWD_10 {
	
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[5];
	UserDAO users = new UserDAO();
	User user;
	JTextArea jta[] = new JTextArea[4];
	
	public FindPWD_10() {

		SET_Text_And_Label_Area();
		SET_IMG_Area();
		SET_Label_Area();
		
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void SET_Text_And_Label_Area() {//회원 가입 영역
		
		sub.setSize(360, 450);
		sub.setLocation(0, 60);
		sub.setLayout(null);
		sub.setBackground(Color.white);

		JLabel jl_intro = new JLabel("           아이디를 찾기 위해서는 본인인증이 필요합니다.");
		jl_intro.setLocation(-1, 0);
		jl_intro.setSize(360, 40);
		jl_intro.setVisible(true);
		jl_intro.setBorder(new LineBorder(Color.GRAY));
		sub.add(jl_intro);
		
		
		jta[0] = new JTextArea("이메일");
		jta[1] = new JTextArea("이름 입력");
		jta[2] = new JTextArea("생년월일(6자리입력)");
		jta[3] = new JTextArea("휴대전화 ");
		
//		
		JLabel jl[] = new JLabel[4];
		jl[0] = new JLabel("이메일 입력");
		jl[1] = new JLabel("이름 입력");
		jl[2] = new JLabel("생년월일 입력");
		jl[3] = new JLabel("전화번호 입력");

		for (int i = 0; i < 4; i++) {
			jl[i].setLocation(20, 40 + (80 * i));
			jta[i].setLocation(20, 70 + (80 * i));
		}
//체크박스 영역
		JCheckBox jcb = new JCheckBox("본인 확인을 위한 약관에 동의합니다.");
		jcb.setSize(340, 30);
		jcb.setLocation(20, 370);
		jcb.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		jcb.setBackground(Color.WHITE);
		sub.add(jcb);
//배열영역
		for (int i = 0; i < jta.length; i++) {
			jl[i].setSize(300, 40);
			jl[i].setVisible(true);
			sub.add(jta[i]);
			sub.add(jl[i]);
		}

		for (int i = 0; i < 4; i++) {
			jta[i].setSize(300, 30);
			jta[i].setBackground(Color.white);
			jta[i].setBorder(new LineBorder(Color.black));
	
		}
		jta[3].setSize(160, 30);
		jta[3].setLocation(160, 310);
		jp.add(sub);
		
// 콤보박스 영역		
		JComboBox jc = new JComboBox();
		String tele[]= {"SKT","KT","LG","HELLO"};
		jc.setSize(120,30);
		jc.setVisible(true);
		jc.setLocation(20, 310);
		jc.setBackground(Color.WHITE);
		
		for(int i = 0 ; i <tele.length;i++)
		{
			jc.addItem(tele[i]);
		}
		sub.add(jc);
		
		
		//내용삭제 영역 [이벤트임]
		jta[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				jta[0].setText("");
			}
		});
		jta[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				jta[1].setText("");
			}
		});
		jta[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				jta[2].setText("");
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
				new Login_2().point(jf.getLocation());
				jf.setVisible(false);
			}
		});

		jp.add(jl);
	}
	
	public void SET_Label_Area() {//기타 라벨 영역
		JLabel jl[] = new JLabel[2];
		
		jl[0] = new JLabel("비밀번호 찾기");
		jl[1] = new JLabel("다음");

		jl[0].setSize(110, 20);
		jl[0].setLocation(120, 20);
		jl[0].setFont(new Font("맑은 고딕", Font.PLAIN, 16));

		jl[1].setSize(100, 20);
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
				// TODO Auto-generated method stub
				User User = users.findId(jta[0].getText(),jta[3].getText());
				String str=User.getUserPwd();
				
				JOptionPane.showMessageDialog(jf, "회원님의 비밀번호는 "+str+" 입니다.");
				
				new Login_2().point(jf.getLocation());
				jf.setVisible(false);
			}
		});
	}
	
	public void point(Point p) {
	      if (p != null) {
	         jf.setLocation(p);
	   }
	 }

}
