package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.User;

public class Set_Money_18 {
	JFrame jf =new JFrame("¿ëµ·Á¶");
	JPanel jp =new JPanel();
	JPanel sub =new JPanel();
	JPanel sub1 =new JPanel();
	User u;
	public Set_Money_18() {
		SET_IMG_Area();
		SET_Label_Area();
		Show_Money();
		Set_Money_Area();
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Show_Money() {
		sub1.setSize(360,120);
		sub1.setLayout(null);
		sub1.setLocation(0,67);
		sub1.setBackground(new Color(117, 102, 205));
		ImageIcon graphic=new ImageIcon("images/graphexample.png");
		JLabel[] jl =new JLabel[5];
		jl[0]= new JLabel("ÃÑ ¿¹»ê");
		jl[1]= new JLabel("400,000");
		jl[2] = new JLabel("±×·¡ÇÁ ÀÚ¸®");
		jl[3]= new JLabel("150,000 ³²À½");
		
		jl[0].setForeground(Color.WHITE);
		jl[1].setForeground(Color.WHITE);
		jl[3].setForeground(Color.WHITE);
		 
		jl[0].setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		jl[1].setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		jl[3].setFont(new Font("¸¼Àº°íµñ",Font.BOLD,13));
		
		jl[0].setSize(100,20);
		jl[1].setSize(100,20);
		jl[2].setSize(320,50);
		jl[3].setSize(100,30);
		
		jl[0].setLocation(10,10);
		jl[1].setLocation(250,10);
		jl[2].setLocation(10,20);
		jl[3].setLocation(250,60);
		
		jl[4] =new JLabel("   Áö³­´Þ ¼Òºñ¸¦ Âü°íÇÏ¿© »õ·Î¿î ¿¹»êÀ» ¼³Á¤ÇÏ¼¼¿ä.");
		jl[4].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,13));
		jl[4].setSize(360,30);
		jl[4].setLocation(0,90);
		jl[4].setOpaque(true);
		jl[4].setBackground(new Color(220,220,220));
		for(int i=0; i<jl.length; i++) {
			sub1.add(jl[i]);
		}
		jp.add(sub1);
	}
	
	public void Set_Money_Area() {
		sub.setSize(360,330);
		sub.setLayout(null);
		sub.setLocation(0,180);
		sub.setBackground(Color.WHITE);
		
		JLabel[] jl=new JLabel[4];
		jl[0]=new JLabel("½Äºñ");
		jl[1]=new JLabel("¹®È­/Ãë¹Ì");
		jl[2]=new JLabel("±³À°/À°¾Æ");
		jl[3]=new JLabel("°íÁ¤ºñ");
		for(int i=0; i<jl.length; i++) {
			jl[i].setSize(100,30);
			jl[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,14));
			sub.add(jl[i]);
		}
		jl[0].setLocation(20,20);
		jl[1].setLocation(20,80);
		jl[2].setLocation(20,140);
		jl[3].setLocation(20,200);
		
		JLabel Line[] =new JLabel[4];
		for(int i=0; i<Line.length; i++) {
			Line[i] =new JLabel();
	    	Line[i].setBorder(new LineBorder(Color.GRAY,5));
		    Line[i].setSize(310,2);
		    sub.add(Line[i]);
	    }
		Line[0].setLocation(15,65);
		Line[1].setLocation(15,130);
		Line[2].setLocation(15,185);
		Line[3].setLocation(15,245);
		
		JTextField[] money =new JTextField[4];
		for(int i=0; i<money.length; i++) {
			money[i] = new JTextField();
			money[i].setSize(100,30);
			sub.add(money[i]);
		}
		money[0].setLocation(180,20);
		money[1].setLocation(180,80);
		money[2].setLocation(180,140);
		money[3].setLocation(180,200);
		JLabel won[] =new JLabel[4];
		for(int i=0; i<won.length; i++) {
			won[i] = new JLabel("¸¸¿ø");
			won[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
			won[i].setSize(70,30);
			sub.add(won[i]);
		}
		won[0].setLocation(290,20);
		won[1].setLocation(290,80);
		won[2].setLocation(290,140);
		won[3].setLocation(290,200);
		jp.add(sub);
	}
	
	public void  SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Budget_Set1_17();
				jf.setVisible(false);
			}
		});
		jp.add(jl);
	}
	public void SET_Label_Area() {//±âÅ¸ ¶óº§ ¿µ¿ª
		JLabel jl[] = new JLabel[3];
		
		jl[0] = new JLabel("¿¹»ê ¼³Á¤");
		jl[1] = new JLabel("¿Ï·á");

		jl[0].setSize(100, 20);
		jl[0].setLocation(145, 20);
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(150, 525);
		jl[1].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));

		for (int i = 0; i < 2; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		
		ImageIcon menu = new ImageIcon("images/menu.png");
		jl[2]=new JLabel(menu);
		jl[2].setSize(40, 40);
		jl[2].setLocation(295, 10);
		jp.add(jl[2]);
		
		
	}
}
