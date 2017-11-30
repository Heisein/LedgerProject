package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.User;
import model.UserDAO;
import view.showPopup1.MyWinListener;

public class FindPWD_Re_12 {

	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[2];
	UserDAO user = new UserDAO();
	showPopup3 show;
	FindPWD_Re_12 retemp;
	User u;
	JPasswordField[] jta = new JPasswordField[2];

	public FindPWD_Re_12(User user) {
		this.retemp = this;
		this.u = user;

		System.out.println(u);

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

		JLabel jl[] = new JLabel[2];

		jl[0] = new JLabel("비밀번호 입력");
		jta[0] = new JPasswordField("비밀번호 입력");

		jl[1] = new JLabel("비밀번호 재입력");
		jta[1] = new JPasswordField("비밀번호 재입력");

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
				///////////////////

				String userPwd = "";
				char[] pass = ((JPasswordField) jta[1]).getPassword();

				for (int i = 0; i < pass.length; i++) {
					userPwd += pass[i];
				}

				// System.out.println(users.checkUsers(String userId, String
				// newPwd));

				if (e.getSource() == jl[1]) {
					if (show == null) {
						user.changePWD(u.getUserID(), userPwd);
						show = new showPopup3(jf, "비밀번호 변경 완료", retemp);
					}
					show.setVisible(true);
					jl[1].requestFocus();
				}
				///////////////
				new Login_2().point(jf.getLocation());
				jf.setVisible(false);
			}
		});
	}

	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new MenuView_28(u);
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

class showPopup3 extends JDialog implements ActionListener {
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel change = new JLabel();
	JLabel confirmChange = new JLabel();
	JButton ok;
	FindPWD_Re_12 retemp;

	public showPopup3(Frame parent, String str, FindPWD_Re_12 retemp) {
		super(parent, str, true);
		this.retemp = retemp;

		// 화면 상단에 환영합니다 문구 라벨
		change = new JLabel("비밀번호 변경");
		change.setSize(100, 30);
		change.setLocation(140, 10);
		change.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		change.setForeground(Color.white);

		// 확인버튼
		ok = new JButton("확인");
		ok.setSize(355, 45);
		ok.setLocation(0, 410);
		ok.addActionListener(this);
		ok.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		ok.setBackground(new Color(117, 102, 205));
		ok.setForeground(Color.white);

		// 환영합니다. 가입되셨습니다 보여주는 하얀 panel
		sub.setSize(360, 350);
		sub.setLocation(0, 60);
		sub.setVisible(true);
		sub.setBackground(Color.white);
		sub.setLayout(null);

		// 가입 성공 문구 보여주는 라벨들
		confirmChange = new JLabel("비밀번호가 변경되었습니다.");
		confirmChange.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		confirmChange.setSize(300, 30);
		sub.add(confirmChange);

		confirmChange.setLocation(80, 170);
		jp.add(sub);
		jp.add(ok);
		jp.add(change);

		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);

		setSize(360, 500);
		add(jp);
		addWindowListener(new MyWinListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			new Login_2();
		}
		dispose(); // 대화상자 제거
	}

	class MyWinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}

}