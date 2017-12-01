package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Budget_Set1_17 {
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[5];

	public Budget_Set1_17() {
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

		sub.setSize(360, 380);
		sub.setLocation(0, 130);
		sub.setLayout(null);
		sub.setBackground(Color.white);

		JLabel jl[] = new JLabel[7];
		jl[0] = new JLabel("식비");
		jl[1] = new JLabel("뷰티/건강");
		jl[2] = new JLabel("쇼핑");
		jl[3] = new JLabel("문화/취미");
		jl[4] = new JLabel("교육/육아");
		jl[5] = new JLabel("기타");
		jl[6] = new JLabel("고정비");
		
		for (int i = 0; i < jl.length; i++) {
			jl[i].setSize(100,20);
			jl[i].setLocation(40,10+(i*52));
			jl[i].setFont(new Font("맑은 고딕", Font.BOLD, 14));
			sub.add(jl[i]);
		}
		
		JLabel jl2[] = new JLabel[7];
		jl2[0] = new JLabel("외식,카페/베이커리,술/유흥,마트");
		jl2[1] = new JLabel("뷰티,건강");
		jl2[2] = new JLabel("쇼핑,온라인쇼핑,해외결제");
		jl2[3] = new JLabel("영화/문화,레저/스포츠,서점/문구");
		jl2[4] = new JLabel("교육,육아");
		jl2[5] = new JLabel("기타,애완동물,경조사/종교,여행/숙박");
		jl2[6] = new JLabel("교통,통신,세금,금융,자동차,생활");
		
		for (int i = 0; i < jl2.length; i++) {
			jl2[i].setSize(300,20);
			jl2[i].setLocation(40,30+(i*52));
			jl2[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			sub.add(jl2[i]);
		}
		
		JLabel jl3[] = new JLabel[7];
		for (int i = 0; i < jl3.length; i++) {
			jl3[i] = new JLabel("0");
			jl3[i].setSize(100,20);
			jl3[i].setLocation(315,10+(i*52));
			jl3[i].setFont(new Font("맑은 고딕", Font.PLAIN, 17));
			sub.add(jl3[i]);
		}
		
		JLabel jl4[] = new JLabel[7];
		for (int i = 0; i < jl4.length; i++) {
			jl4[i] = new JLabel("지난달 소비액");
			jl4[i].setSize(100,20);
			jl4[i].setLocation(260,30+(i*52));
			jl4[i].setFont(new Font("맑은 고딕", Font.PLAIN, 11));
			jl4[i].setForeground(new Color(100, 100, 100));
			sub.add(jl4[i]);
		}
		JLabel imgLabel[] = new JLabel[7];
		ImageIcon[] img = new ImageIcon[7];
		
		for (int i = 0; i < imgLabel.length; i++) {
			img[i] = new ImageIcon("images/categori_unchecked.png");
			imgLabel[i]= new JLabel(img[i]);
			imgLabel[i].setSize(30,30);
			imgLabel[i].setLocation(8,11+(i*52));
			sub.add(imgLabel[i]);
		}
		
		JLabel[] Line =new JLabel[7];
		for (int i = 0; i < Line.length; i++) {
			Line[i] = new JLabel();
			Line[i].setBorder(new LineBorder(Color.GRAY,5));
			Line[i].setSize(320,2);
			Line[i].setLocation(10,57+(i*52));
			sub.add(Line[i]);
		}
		
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
		JLabel jl[] = new JLabel[5];
		Image icon = new ImageIcon("images/menu.png").getImage();
		jl[0] = new JLabel("예산 설정");
		jl[1] = new JLabel("다음");
		jl[2] = new JLabel(new ImageIcon(icon));
		jl[3] = new JLabel("총 예산");
		jl[4] = new JLabel("400,000");

		jl[0].setSize(100, 20);
		jl[0].setLocation(140, 20);
		jl[0].setFont(new Font("맑은 고딕", Font.BOLD, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(150, 525);
		jl[1].setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		jl[2].setSize(20,20);
		jl[2].setLocation(310, 20);
		
		jl[3].setSize(100,40);
		jl[3].setLocation(20,60);
		jl[3].setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		jl[4].setSize(100,40);
		jl[4].setLocation(230,55);
		jl[4].setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jp.add(jl[i]);
		}
		
		JPanel p1 = new JPanel();
		JLabel lb1 = new JLabel("예산관리가 필요한 소비항목을 선택해주세요");
		
		p1.setLayout(null);
		p1.setSize(360,30);
		p1.setLocation(0,100);
		p1.setBackground(new Color(220, 220, 220));
		
		lb1.setSize(300,30);
		lb1.setLocation(33,1);
		lb1.setFont(new Font("맑은 고딕", Font.PLAIN,13));
		
		p1.add(lb1);
		
		jp.add(p1);
		jp.add(jl[2]);
	}
}