package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.User;

public class Set_Cate_More_20 {
	JFrame jf = new JFrame("¿ëµ·Á¶");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JPanel sub1 = new JPanel();
	User user;

	public Set_Cate_More_20(User user) {
		this.user = user;
		
		SET_IMG_Area();
		SET_Label_Area();
		Show_Money();
		Set_Cate();
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Show_Money() {
		sub1.setSize(360, 110);
		sub1.setLayout(null);
		sub1.setLocation(0, 67);
		sub1.setBackground(new Color(117, 102, 205));

		ImageIcon graphic = new ImageIcon("images/fullgraphicexample.png");
		JLabel[] jl = new JLabel[6];
		jl[0] = new JLabel("11¿ù ÃÑ ¿¹»ê");
		jl[1] = new JLabel("400,000");
		jl[2] = new JLabel("11¿ù ÃÑ ¼Òºñ");
		jl[3] = new JLabel("400,000");
		jl[4] = new JLabel(graphic);
		jl[5] = new JLabel("0 ³²À½");

		jl[0].setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 15));
		jl[1].setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 15));
		jl[2].setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jl[3].setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jl[5].setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 10));

		for (int i = 0; i < 4; i++) {
			jl[i].setSize(100, 30);
			jl[i].setForeground(Color.WHITE);
		}
		jl[0].setLocation(30, 10);
		jl[1].setLocation(250, 10);
		jl[2].setLocation(30, 30);
		jl[3].setLocation(250, 30);

		jl[4].setSize(320, 30);
		jl[4].setLocation(10, 55);

		jl[5].setForeground(Color.WHITE);
		jl[5].setSize(100, 30);
		jl[5].setLocation(270, 80);

		for (int i = 0; i < jl.length; i++) {
			sub1.add(jl[i]);
		}
		jp.add(sub1);
	}

	public void Set_Cate() {
		sub.setSize(360, 455);
		sub.setLayout(null);
		sub.setLocation(0, 170);
		sub.setBackground(Color.white);

		JLabel grayLine = new JLabel("¹Ì¼³Á¤ ¿¹»ê");
		grayLine.setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 15));
		grayLine.setSize(360, 35);
		grayLine.setLocation(0, 0);
		grayLine.setOpaque(true);
		grayLine.setBackground(new Color(220, 220, 220));
		sub.add(grayLine);

		JLabel[] jl1 = new JLabel[4];
		jl1[0] = new JLabel("¿Ü½Ä");
		jl1[1] = new JLabel("Ä«Æä/º£ÀÌÄ¿¸®");
		jl1[2] = new JLabel("¼ú/À¯Èï");
		jl1[3] = new JLabel("±âÅ¸");
		for (int i = 0; i < jl1.length; i++) {
			jl1[i].setSize(100, 30);
			jl1[i].setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 15));
			sub.add(jl1[i]);
		}
		jl1[0].setLocation(20, 40);
		jl1[1].setLocation(20, 80);
		jl1[2].setLocation(20, 120);
		jl1[3].setLocation(20, 160);

		JLabel Line[] = new JLabel[4];
		for (int i = 0; i < Line.length; i++) {
			Line[i] = new JLabel();
			Line[i].setBorder(new LineBorder(Color.GRAY, 5));
			Line[i].setSize(310, 2);
			sub.add(Line[i]);
		}
		Line[0].setLocation(15, 70);
		Line[1].setLocation(15, 110);
		Line[2].setLocation(15, 150);
		Line[3].setLocation(15, 190);

		JLabel[] leftMoney = new JLabel[8];
		for (int i = 0; i < 4; i++) {
			leftMoney[i] = new JLabel("0");
			leftMoney[i].setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 10));
			leftMoney[i].setSize(100, 20);
			sub.add(leftMoney[i]);
		}
		leftMoney[0].setLocation(300, 35);
		leftMoney[1].setLocation(300, 75);
		leftMoney[2].setLocation(300, 115);
		leftMoney[3].setLocation(300, 155);

		for (int i = 4; i < 8; i++) {
			leftMoney[i] = new JLabel("¿¹»ê 0");
			leftMoney[i].setSize(100, 20);
			leftMoney[i].setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 10));
			sub.add(leftMoney[i]);

		}
		leftMoney[4].setLocation(280, 50);
		leftMoney[5].setLocation(280, 90);
		leftMoney[6].setLocation(280, 130);
		leftMoney[7].setLocation(280, 170);
		jp.add(sub);
	}

	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jp.add(jl);
	}

	public void SET_Label_Area() {// ±âÅ¸ ¶óº§ ¿µ¿ª
		JLabel jl[] = new JLabel[3];

		jl[0] = new JLabel("¿¹»ê ¼³Á¤");

		jl[0].setSize(100, 20);
		jl[0].setLocation(45, 20);
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		jl[0].setForeground(Color.WHITE);
		jl[0].setVisible(true);
		jp.add(jl[0]);

		ImageIcon menu = new ImageIcon("images/menu.png");
		jl[2] = new JLabel(menu);
		jl[2].setSize(40, 40);
		jl[2].setLocation(295, 10);
		jp.add(jl[2]);

	}
}
