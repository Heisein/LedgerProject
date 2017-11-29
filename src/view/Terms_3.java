package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Terms_3 {
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	boolean check1 = false;
	boolean check2 = false;
	JCheckBox jc[] = new JCheckBox[4]; // 약관 체크박스
	JLabel jl[] = new JLabel[2]; // 약관동의, 다음버튼
	JPanel sub[] = new JPanel[2]; // 체크박스 패널

	public Terms_3() {

		SET_Label_Area();
		SET_Check_Area();
		SET_IMG_Area();

		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void SET_Label_Area() {

		jl[0] = new JLabel("약관동의");
		jl[1] = new JLabel("다음");

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
		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new join_4();
				jf.setVisible(false);
			}
		});
	}

	public void SET_Check_Area() {

		for (int i = 0; i < sub.length; i++) {
			sub[i] = new JPanel();
			sub[i].setVisible(true);
		}

		sub[0].setSize(360, 450);
		sub[0].setLocation(0, 60);
		sub[0].setLayout(null);
		sub[0].setBackground(Color.white);
		sub[0].setBorder(new LineBorder(Color.BLACK, 1));
		sub[1].setSize(360, 250);
		sub[1].setLocation(0, -50);
		sub[1].setLayout(null);
		sub[1].setBackground(Color.white);
		sub[1].setBorder(new LineBorder(Color.BLACK, 1));

		for (int i = 0; i < jc.length; i++) {
			jc[i] = new JCheckBox();
		}

		jc[0].setSize(250, 50);
		jc[0].setLocation(10, 0);
		jc[0].setText("용돈조 이용약관 전체 동의");
		jc[0].setBorder(new LineBorder(Color.BLACK, 2));
		jc[0].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		jc[0].setBackground(Color.WHITE);

		jc[0].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				for (int i = 1; i < jc.length; i++) {
					if (jc[i].isSelected() == true) {
						jc[i].setSelected(false);
					} else {
						jc[i].setSelected(true);
					}
				}
			}
		});

		jc[1].setLocation(10, 100);
		jc[1].setSize(250, 45);
		jc[1].setText("이용약관 동의(필수)");
		jc[1].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jc[1].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jc[1].isSelected()) {
					check1 = true;
				} else {
					check1 = false;
				}
			}
		});
		jc[2].setLocation(10, 150);
		jc[2].setSize(250, 45);
		jc[2].setText("개인정보 처리방침 동의(필수)");
		jc[2].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jc[2].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jc[2].isSelected()) {
					check1 = true;
				} else {
					check1 = false;
				}
			}
		});

		jc[3].setLocation(10, 200);
		jc[3].setSize(250, 45);
		jc[3].setText("제3자 정보제공 동의(선택)");
		jc[3].setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		for (int i = 1; i < jc.length; i++) {
			jc[i].setBackground(Color.WHITE);
			jc[i].setVisible(true);
			sub[1].add(jc[i]);
		}
		sub[0].add(jc[0]);
		sub[0].add(sub[1]);

		jp.add(sub[0]);

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
				new FirstLogin_1();
				jf.dispose();
			}
		});

		jp.add(jl);
	}

}