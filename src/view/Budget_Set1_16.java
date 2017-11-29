package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Budget_Set1_16 {
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[5];

	public Budget_Set1_16() {
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

	public void SET_Text_And_Label_Area() {// 예산 목표 

		sub.setSize(360, 450);
		sub.setLocation(0, 60);
		sub.setLayout(null);
		sub.setBackground(Color.white);

		JLabel jl[] = new JLabel[9];
		jl[0] = new JLabel("예산 목표액");
		jl[1] = new JLabel("만원");
		jl[2] = new JLabel("나의 소비이력");
		jl[3] = new JLabel("예산 설정은 '만원'단위로 설정 가능");
		jl[4] = new JLabel("지난달 대비 400,000원 초과");
		jl[5] = new JLabel("예산안 만들기를 시작합니다.");
		jl[6] = new JLabel("40");
		jl[7] = new JLabel("0만원");
		jl[8] = new JLabel("0만원");

		jl[0].setSize(100,50);
		jl[0].setLocation(130,40);
		jl[0].setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		jl[1].setSize(100,50);
		jl[1].setLocation(240,95);
		jl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		jl[2].setSize(100,50);
		jl[2].setLocation(20,170);
		jl[2].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		jl[3].setSize(200,50);
		jl[3].setLocation(150,172);
		jl[3].setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		jl[3].setForeground(Color.GRAY);
		
		jl[4].setSize(250,50);
		jl[4].setLocation(80,340);
		jl[4].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jl[4].setForeground(new Color(134, 30, 186));
		
		jl[5].setSize(250,50);
		jl[5].setLocation(85,365);
		jl[5].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		jl[6].setSize(100,50);
		jl[6].setLocation(155,85);
		jl[6].setFont(new Font("맑은 고딕", Font.BOLD, 30));
		jl[6].setForeground(new Color(134, 12, 186));
		
		JPanel[] panel = new JPanel[3];
		
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
			panel[i].setSize(305,40);
			panel[i].setLocation(20,210+(i*45));
			panel[i].setBackground(new Color(210, 210, 210));
			sub.add(panel[i]);
		}
		
		
		JRadioButton[] rb = new JRadioButton[3];
		
		rb[0] = new JRadioButton("지난달 총 소비액");
		rb[1] = new JRadioButton("3개월 평균 소비액");
		rb[2] = new JRadioButton("직접입력");
		
		ButtonGroup rbGroup = new ButtonGroup();

		for (int i = 0; i < rb.length; i++) {
			panel[i].setLayout(null);
			rb[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			rb[i].setLocation(5,5);
			rb[i].setSize(150,30);
			rb[i].setBackground(new Color(210, 210, 210));
			rbGroup.add(rb[i]);
			panel[i].add(rb[i]);
		}
		
		for (int i = 7; i < jl.length; i++) {
			jl[i].setSize(40,20);
			jl[i].setLocation(260,8);
			jl[i].setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		}
		
		panel[0].add(jl[7]);
		panel[1].add(jl[8]);
		
		JLabel Line =new JLabel();
		Line.setBorder(new LineBorder(Color.GRAY,5));
		Line.setSize(130,2);
		Line.setLocation(105,135);
		
		for (int i = 0; i < 7; i++) {
			sub.add(jl[i]);
		}
		sub.add(Line);
		
		jp.add(sub);
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
		JLabel jl[] = new JLabel[3];
		Image icon = new ImageIcon("images/menu.png").getImage();
		jl[0] = new JLabel("예산 설정");
		jl[1] = new JLabel("다음");
		jl[2] = new JLabel(new ImageIcon(icon));

		jl[0].setSize(100, 20);
		jl[0].setLocation(140, 20);
		jl[0].setFont(new Font("맑은 고딕", Font.BOLD, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(150, 525);
		jl[1].setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		jl[2].setSize(20,20);
		jl[2].setLocation(310, 20);
		
		for (int i = 0; i < 2; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		jp.add(jl[2]);
	}
}