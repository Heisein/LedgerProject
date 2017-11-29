package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;

import model.User;

public class MainScreen_14 {

	JFrame jf = new JFrame("¿ëµ·Á¶");
	JPanel jp = new JPanel();
	User user;
	
	public MainScreen_14(User user) {
		this.user = user;
		
		SET_IMG_Area();
		SET_Pannels_Area();
		SET_Label_Area();
		
		jf.setSize(370, 600);
		
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		
		ScrollPane sp = new ScrollPane();
		sp.add(jp);
		jp.setPreferredSize(new Dimension(320,800));
		
		jf.add(sp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

	public void SET_IMG_Area() {

		ImageIcon img = new ImageIcon("images/tree.png");
		JLabel jl = new JLabel(img);
		jl.setSize(200, 204);
		jl.setLocation(75, 80);
		jl.setVisible(true);
		jp.add(jl);

	}
	
	public void SET_Pannels_Area() {

		//¼­ºêÆÐ³Î
		JPanel sub[]=new JPanel[3];
		for(int i = 0 ; i < sub.length;i++)
		{
			sub[i]=new JPanel();
			jp.add(sub[i]);
			sub[i].setBackground(Color.WHITE);
			sub[i].setLayout(null);
		}
		
		sub[0].setSize(300,150);
		sub[0].setLocation(15,300);
		sub[1].setSize(300,150);
		sub[1].setLocation(15,470);
		sub[2].setSize(300,120);
		sub[2].setLocation(15,640);
		
		JLabel jl[] = new JLabel[20];
		for(int i = 0 ; i < 20;i++)
		{
			jl[i]=new JLabel();
			jl[i].setSize(150,20);
			jl[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		}
		
		ImageIcon img = new ImageIcon("images/button.png");
		for(int i = 17 ; i < 20;i++)
		{
			jl[i]=new JLabel(img);
			jl[i].setSize(30,30);
		}
		
		jl[0].setText("¿¹»ê");
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		jl[0].setLocation(10, 10);
		jl[1].setText("ÃÑ ¿¹»ê");
		jl[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[1].setLocation(10, 50);
		jl[2].setText("ÃÑ ¼Òºñ¾×");
		jl[2].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[2].setLocation(10, 70);
		jl[3].setText("400,000");
		jl[3].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		jl[3].setLocation(200, 50);
		jl[4].setText("0");
		jl[4].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		jl[4].setLocation(200, 70);
		jl[5].setText("¼Òºñ ³»¿ª");
		jl[5].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		jl[5].setLocation(10, 10);
		jl[6].setText("³ªÀÇ ¼ÒºñºÐ·ù Top3");
		jl[6].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[6].setLocation(10, 45);
		jl[7].setText("¸¶Æ®");
		jl[7].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[7].setLocation(30, 70);
		jl[8].setText("Ä«Æä/º£ÀÌÄ¿¸®");
		jl[8].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[8].setLocation(30, 90);
		jl[9].setText("ÁÖÀ¯/ÀÚµ¿Â÷");
		jl[9].setLocation(30, 110);
		jl[9].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[10].setText("184,000");
		jl[10].setLocation(200, 70);
		jl[10].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[11].setText("74,000");
		jl[11].setLocation(200, 90);
		jl[11].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[12].setText("53,000");
		jl[12].setLocation(200, 110);
		jl[12].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[13].setText("Ä«µåÁ¤º¸");
		jl[13].setLocation(10, 10);
		jl[13].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		jl[14].setText("°èÁÂ");
		jl[14].setLocation(10, 50);
		jl[14].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[15].setText("123°èÁÂ¹øÈ£");
		jl[15].setLocation(10, 70);
		jl[15].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		jl[16].setText("4,235ÀÜ¾×");
		jl[16].setLocation(200, 60);
		jl[16].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		
		jl[17].setLocation(260, 10);
		jl[18].setLocation(260, 10);
		jl[19].setLocation(260, 10);
		
		jl[17].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new StatView_29(user);
				jf.setVisible(false);
			}
		});
		jl[18].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new LedgerBoard(user);
				jf.setVisible(false);
			}
		});
		jl[19].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new CardRegist_27(user);
				jf.setVisible(false);
			}
		});

		sub[0].add(jl[0]);
		sub[0].add(jl[1]);
		sub[0].add(jl[2]);
		sub[0].add(jl[3]);
		sub[0].add(jl[4]);
		sub[0].add(jl[17]);
		sub[1].add(jl[5]);
		sub[1].add(jl[6]);
		sub[1].add(jl[7]);
		sub[1].add(jl[8]);
		sub[1].add(jl[9]);
		sub[1].add(jl[10]);
		sub[1].add(jl[11]);
		sub[1].add(jl[12]);
		sub[1].add(jl[18]);
		sub[2].add(jl[13]);
		sub[2].add(jl[14]);
		sub[2].add(jl[15]);
		sub[2].add(jl[16]);
		sub[2].add(jl[19]);
	}
	
	public void SET_Label_Area() {
		JLabel jl[] = new JLabel[2];
		ImageIcon img = new ImageIcon("images/menu.png");
		jl[0] = new JLabel("");
		jl[1] = new JLabel(img);
		
		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuView_28(user);
				jf.setVisible(false);
			}
		});

		jl[0].setLocation(20, -20);
		jl[1].setLocation(260, -20);

		for (int i = 0; i < jl.length; i++) {
			jl[i].setSize(100, 100);
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}

	}
	
	
	public void point(Point p) {
		if (p != null) {
			jf.setLocation(p);
		}
	}

}
