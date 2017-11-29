package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.User;
import model.UserDAO;

public class CardRegist_27 {
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	User user;
	public CardRegist_27(User user) {
		this.user = user;
		
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

	public void SET_Text_And_Label_Area() {// 카드 등록

		sub.setSize(360, 450);
		sub.setLocation(0, 60);
		sub.setLayout(null);
		sub.setBackground(Color.white);

		JLabel jl_intro = new JLabel("    고객님의 금융생활을 돕기 위해 관리할 계좌가 필요해요 ");
		jl_intro.setLocation(-1, 0);
		jl_intro.setSize(360, 40);
		jl_intro.setBorder(new LineBorder(Color.GRAY));
		jl_intro.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		sub.add(jl_intro);

		JLabel jl[] = new JLabel[3];
		jl[0] = new JLabel("은행");
		jl[1] = new JLabel("계좌번호");
		jl[2] = new JLabel("입력하신 계정으로 금융관리가 시작됩니다");

		jl[0].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jl[2].setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		jl[0].setLocation(20, 70);
		jl[1].setLocation(20, 130);
		jl[2].setLocation(40, 390);

		jl[0].setSize(100, 50);
		jl[1].setSize(100, 50);
		jl[2].setSize(360, 50);

		for (int i = 0; i < jl.length; i++) {
			sub.add(jl[i]);
		}

		String[] banks = {"은행 선택", "신한은행", "농협", "국민은행","하나은행","새마을금고","기업은행" };

		JComboBox bankBox = new JComboBox(banks);
		bankBox.setSelectedIndex(0);
		bankBox.setSize(200,35);
		bankBox.setLocation(110,80);
		
		JTextField tf1 = new JTextField();
		
		tf1.setSize(200,35);
		tf1.setLocation(110,140);
		tf1.setText("계좌번호 '-' 없이 입력");
		
		tf1.addMouseListener((new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				tf1.setText("");
			}
		}));
			
			
		
		sub.add(tf1);
		sub.add(bankBox);
		jp.add(sub);

	}

	public void SET_IMG_Area() {
		JLabel jl = new JLabel("취소");
		jl.setSize(50, 50);
		jl.setLocation(10, 8);
		jl.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		jl.setForeground(Color.WHITE);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainScreen_14(user);
				jf.setVisible(false);
			}
		});

		jp.add(jl);
	}

	public void SET_Label_Area() {// 기타 라벨 영역
		JLabel jl[] = new JLabel[2];

		jl[0] = new JLabel("카드 등록");
		jl[1] = new JLabel("확인");

		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new MainScreen_14(user);
				jf.setVisible(false);
			}
		});
		
		jl[0].setSize(100, 20);
		jl[0].setLocation(140, 20);
		jl[0].setFont(new Font("맑은 고딕", Font.BOLD, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(150, 525);
		jl[1].setFont(new Font("맑은 고딕", Font.BOLD, 14));
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jp.add(jl[i]);
		}
	}

}