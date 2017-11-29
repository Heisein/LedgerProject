package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class FindIDResult_9 {

	JFrame jf = new JFrame("¿ëµ·Á¶");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[2];
	
	public FindIDResult_9(){
		
		JoinResult_panel();
		SET_Label_Area();
		SET_IMG_Area();
		
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void JoinResult_panel() {
		sub.setSize(360, 450);
		sub.setLocation(0, 60);
		sub.setVisible(true);
		sub.setBackground(Color.white);
		sub.setLayout(null);
		JLabel welcome = new JLabel("Username");
		welcome.setSize(300,300);
		welcome.setLocation(200,200);
		sub.add(welcome);
		jp.add(sub);
	}
	
	public void SET_Label_Area() {

		jl[0] = new JLabel("¾ÆÀÌµð Ã£±â °á°ú");
		jl[1] = new JLabel("·Î±×ÀÎ ÇÏ·¯ °¡±â");

		jl[0].setSize(130, 20);
		jl[0].setLocation(120, 20);
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));

		jl[1].setSize(150, 20);
		jl[1].setLocation(120, 525);
		jl[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new Login_2().point(jf.getLocation());
				jf.setVisible(false);
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
				new FindID_7().point(jf.getLocation());
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
