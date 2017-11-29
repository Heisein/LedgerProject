package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.UserDAO;
//JoinResult_6의 회원가입 성공 창을 팝업 창으로 바꾸어줌

public class join_4 {
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[5];
	JTextField[] jta = new JTextField[5];
	UserDAO user = new UserDAO();
	showPopup1 show;
	join_4 jointemp;

	public join_4() {
		this.jointemp = this;
		SET_Text_And_Label_Area();
		SET_IMG_Area();
		SET_Label_Area();
		toLogin_2Class();

		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void SET_Text_And_Label_Area() {// 회원 가입 영역

		sub.setSize(360, 450);
		sub.setLocation(0, 60);
		sub.setLayout(null);
		sub.setBackground(Color.white);

		JLabel jl_intro = new JLabel("      고객님의 금융생활을 돕기 위해 회원가입이 필요해요");
		jl_intro.setLocation(-1, 0);
		jl_intro.setSize(360, 40);
		jl_intro.setVisible(true);
		jl_intro.setBorder(new LineBorder(Color.GRAY));
		sub.add(jl_intro);

		jta[0] = new JTextField("이름 입력");
		jta[1] = new JTextField("이메일 입력");
		jta[2] = new JPasswordField();
		jta[3] = new JPasswordField();
		jta[4] = new JTextField("핸드폰번호 입력");

		JLabel jl[] = new JLabel[5];
		jl[0] = new JLabel("이름 입력");
		jl[1] = new JLabel("이메일 입력");
		jl[2] = new JLabel("비밀번호 입력");
		jl[3] = new JLabel("비밀번호 재입력");
		jl[4] = new JLabel("핸드폰번호 입력");

		for (int i = 0; i < 5; i++) {
			jl[i].setLocation(20, 40 + (80 * i));
			jta[i].setLocation(20, 70 + (80 * i));
		}

		for (int i = 0; i < jta.length; i++) {
			jta[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

				}
			});
		}
		for (int i = 0; i < jta.length; i++) {
			jl[i].setSize(300, 40);
			jl[i].setVisible(true);
			sub.add(jta[i]);
			sub.add(jl[i]);
		}

		for (int i = 0; i < jta.length; i++) {
			jta[i].setSize(300, 30);
			jta[i].setBackground(Color.white);
			jta[i].setVisible(true);
			jta[i].setBorder(new LineBorder(Color.black));

		}
		jp.add(sub);

		// 내용삭제 영역 [이벤트임]
		jta[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jta[0].setText("");
			}
		});
		jta[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jta[1].setText("");
			}
		});
		jta[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jta[2].setText("");
			}
		});
		jta[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jta[3].setText("");
			}
		});
		jta[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jta[4].setText("");
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
				new Terms_3();
				jf.setVisible(false);
			}
		});

		jp.add(jl);
	}

	public void SET_Label_Area() {// 기타 라벨 영역
		JLabel jl[] = new JLabel[2];

		jl[0] = new JLabel("회원가입");
		jl[1] = new JLabel("가입");

		jl[0].setSize(100, 20);
		jl[0].setLocation(140, 20);
		jl[0].setFont(new Font("맑은 고딕", Font.PLAIN, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(150, 525);
		jl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}

		// 가입 버튼
		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// jl[0] = new JLabel("이름 입력");
				// jl[1] = new JLabel("이메일 입력");
				// jl[2] = new JLabel("비밀번호 입력");
				// jl[3] = new JLabel("비밀번호 재입력");
				// jl[4] = new JLabel("핸드폰번호 입력");
				String userId = jta[1].getText();
				String userPwd = "";
				char[] pass = ((JPasswordField) jta[2]).getPassword();

				for (int i = 0; i < pass.length; i++) {
					userPwd += pass[i];
				}
				String userName = jta[0].getText();
				String userPhone = jta[4].getText();

				System.out.println(user.insertUser(userId, userPwd, userName, userPhone));

				if (e.getSource() == jl[1]) {
					if (show == null) {
						show = new showPopup1(jf, "회원가입 완료", jointemp);
					}
					show.setVisible(true);
					jl[1].requestFocus();
				}

				// new Login_2();
				// jf.dispose();
			}
		});

	}

	public void toLogin_2Class() {
		jf.setVisible(false);
		new Login_2();
	}

	public static void main(String[] args) {
		new join_4();
	}
}

class showPopup1 extends JDialog implements ActionListener {
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel welcome = new JLabel();
	JLabel showWelcome[] = new JLabel[2];
	JButton GoingLogin;
	join_4 jointemp;

	public showPopup1(Frame parent, String str, join_4 jointemp) {
		super(parent, str, true);
		this.jointemp = jointemp;

		// 화면 상단에 환영합니다 문구 라벨
		welcome = new JLabel("환영합니다");
		welcome.setSize(100, 20);
		welcome.setLocation(140, 10);
		welcome.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		welcome.setForeground(Color.white);

		// 로그인 창으로 넘어가는 버튼
		GoingLogin = new JButton("로그인 하러가기");
		GoingLogin.setSize(355, 45);
		GoingLogin.setLocation(0, 410);
		GoingLogin.addActionListener(this);
		GoingLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		GoingLogin.setBackground(new Color(117, 102, 205));
		GoingLogin.setForeground(Color.white);

		// 환영합니다. 가입되셨습니다 보여주는 하얀 panel
		sub.setSize(360, 350);
		sub.setLocation(0, 60);
		sub.setVisible(true);
		sub.setBackground(Color.white);
		sub.setLayout(null);

		// 가입 성공 문구 보여주는 라벨들
		showWelcome[0] = new JLabel("환영합니다.");
		showWelcome[1] = new JLabel("성공적으로 가입되셨습니다.");
		for (int i = 0; i < showWelcome.length; i++) {
			showWelcome[i].setFont(new Font("맑은 고딕", Font.PLAIN, 17));
			showWelcome[i].setSize(300, 30);
			sub.add(showWelcome[i]);
		}
		showWelcome[0].setLocation(130, 140);
		showWelcome[1].setLocation(80, 170);
		jp.add(sub);
		jp.add(GoingLogin);
		jp.add(welcome);

		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);

		setSize(360, 500);
		add(jp);
		addWindowListener(new MyWinListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == GoingLogin) {
			jointemp.toLogin_2Class();
		}
		dispose(); // 대화상자 제거
	}

	class MyWinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}

}