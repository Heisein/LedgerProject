package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import javax.swing.border.LineBorder;

import model.User;

public class StatView_29 {

	JFrame jf = new JFrame("¿ëµ·Á¶");
	JPanel jp = new JPanel();
	User user;
	public StatView_29(User user) {
		this.user = user;
		SET_Graph_Area();
		SET_Pannels_Area();
		SET_Label_Area();

		jf.setSize(360, 600);

		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void SET_Graph_Area() {

		ImageIcon img = new ImageIcon("images/29_bar.png");

		JLabel jl[] = new JLabel[6];
		for (int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel(img);
			jl[i].setSize(35, 200);
			jl[i].setLocation(40 + (i * 45), 50);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}

	}

	public void SET_Pannels_Area() {
		JPanel sub[] = new JPanel[2];

		for (int i = 0; i < sub.length; i++) {
			sub[i] = new JPanel();
			jp.add(sub[i]);
			sub[i].setBackground(Color.WHITE);
			sub[i].setVisible(true);
			sub[i].setLayout(null);
		}

		sub[0].setSize(310, 110);
		sub[0].setLocation(15, 280);

		sub[1].setSize(310, 110);
		sub[1].setLocation(15, 420);

		JLabel jl[] = new JLabel[10];
		for (int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel();
			jl[i].setSize(150, 30);
		}

		jl[0].setText("ÀÌ¹ø´Þ ³»¿ª");
		jl[1].setText("¼öÀÔ");
		jl[2].setText("ÁöÃâ");
		jl[3].setText("1,384,580");
		jl[4].setText("841,210");
		jl[5].setText("6°³¿ù Æò±Õ ³»¿ª");
		jl[6].setText("¼öÀÔ");
		jl[7].setText("ÁöÃâ");
		jl[8].setText("1,000,000");
		jl[9].setText("222,210");

		jl[0].setLocation(10, 10);
		jl[1].setLocation(10, 50);
		jl[2].setLocation(10, 70);
		jl[3].setLocation(200, 50);
		jl[4].setLocation(200, 70);
		jl[5].setLocation(10, 10);
		jl[6].setLocation(10, 50);
		jl[7].setLocation(10, 70);
		jl[8].setLocation(200, 50);
		jl[9].setLocation(200, 70);

		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		jl[2].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		jl[3].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		jl[4].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		jl[5].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[6].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		jl[7].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		jl[8].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		jl[9].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));

		for (int i = 0; i < 5; i++) {
			sub[0].add(jl[i]);
		}
		for (int j = 5; j < jl.length; j++) {
			sub[1].add(jl[j]);
		}

		JLabel[] Line = new JLabel[2];

		for (int i = 0; i < Line.length; i++) {
			Line[i] = new JLabel();
			Line[i].setBorder(new LineBorder(new Color(200,200,200), 5));
			Line[i].setSize(285, 2);
		}
		Line[0].setLocation(10, 45);
		Line[1].setLocation(10, 45);

		sub[0].add(Line[0]);
		sub[1].add(Line[1]);
	}

	public void SET_Label_Area() {
		JLabel jl[] = new JLabel[3];
		ImageIcon img = new ImageIcon("images/menu.png");
		ImageIcon img1 = new ImageIcon("images/back.png");
		jl[0] = new JLabel(img1);
		jl[1] = new JLabel(img);
		jl[2] = new JLabel("Åë°è");

		jl[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainScreen_14(user);
				jf.setVisible(false);
			}
		});
		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuView_28(user);
				jf.setVisible(false);
			}
		});

		jl[0].setSize(30, 30);
		jl[0].setLocation(10, 10);
		jl[1].setSize(30, 30);
		jl[1].setLocation(300, 10);
		jl[2].setSize(50, 50);
		jl[2].setLocation(155, 0);
		jl[2].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		jl[2].setForeground(Color.WHITE);

		for (int i = 0; i < jl.length; i++) {
			jp.add(jl[i]);
		}

	}

	public void point(Point p) {
		if (p != null) {
			jf.setLocation(p);
		}
	}

}
