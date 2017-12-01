package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Set_Cate_Money_19 {
	JFrame jf =new JFrame("¿ëµ·Á¶");
	JPanel jp =new JPanel();
	JPanel sub =new JPanel();
	JPanel sub1 =new JPanel();
	public Set_Cate_Money_19() {
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
		sub1.setSize(360,110);
		sub1.setLayout(null);
		sub1.setLocation(0,67);
		sub1.setBackground(new Color(117, 102, 205));
		
		ImageIcon graphic=new ImageIcon("images/fullgraphicexample.png");
		JLabel[] jl = new JLabel[6];
		jl[0]= new JLabel("11¿ù ÃÑ ¿¹»ê");
		jl[1]= new JLabel("400,000");
		jl[2]= new JLabel("11¿ù ÃÑ ¼Òºñ");
		jl[3]= new JLabel("400,000");
		jl[4]=new JLabel(graphic);
		jl[5]= new JLabel("0 ³²À½");
		
		jl[0].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		jl[1].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		jl[2].setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		jl[3].setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		jl[5].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,10));
		
		for(int i=0; i<4; i++) {
			jl[i].setSize(100,30);
			jl[i].setForeground(Color.WHITE);
		}
		jl[0].setLocation(30,10);
		jl[1].setLocation(250,10);
		jl[2].setLocation(30,30);
		jl[3].setLocation(250,30);
		
		jl[4].setSize(320,30);
		jl[4].setLocation(10,55);
		
		jl[5].setForeground(Color.WHITE);
		jl[5].setSize(100,30);
		jl[5].setLocation(270,80);

		for(int i=0; i<jl.length; i++) {
			sub1.add(jl[i]);
		}
		jp.add(sub1);
	}
	
	public void Set_Cate() {
		sub.setSize(360,455);
		sub.setLayout(null);
		sub.setLocation(0,170);
		sub.setBackground(Color.white);
		
		JLabel grayLine =new JLabel("¼³Á¤ ¿¹»ê");
		grayLine.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		grayLine.setSize(360,35);
		grayLine.setLocation(0,0);
		grayLine.setOpaque(true);
		grayLine.setBackground(new Color(220,220,220));
		sub.add(grayLine);
		
		JLabel[] jl1=new JLabel[4];
		jl1[0]=new JLabel("½Äºñ");
		jl1[1]=new JLabel("¹®È­/Ãë¹Ì");
		jl1[2]=new JLabel("±³À°/À°¾Æ");
		jl1[3]=new JLabel("°íÁ¤ºñ");
		for(int i=0; i<jl1.length; i++) {
			jl1[i].setSize(100,30);
			jl1[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
			sub.add(jl1[i]);
		}
		jl1[0].setLocation(20,40);
		jl1[1].setLocation(20,80);
		jl1[2].setLocation(20,120);
		jl1[3].setLocation(20,160);
		
		JLabel Line[] =new JLabel[4];
		for(int i=0; i<Line.length; i++) {
			Line[i] =new JLabel();
	    	Line[i].setBorder(new LineBorder(Color.GRAY,5));
		    Line[i].setSize(310,2);
		    sub.add(Line[i]);
	    }
		Line[0].setLocation(15,70);
		Line[1].setLocation(15,110);
		Line[2].setLocation(15,150);
		Line[3].setLocation(15,190);
		
		JLabel grayLine2 =new JLabel(" ¹Ì¼³Á¤ ¿¹»ê");
		grayLine2.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		grayLine2.setSize(360,35);
		grayLine2.setLocation(0,192);
		grayLine2.setOpaque(true);
		grayLine2.setBackground(new Color(220,220,220));
		sub.add(grayLine2);
		
		JLabel[] jl2=new JLabel[3];
		jl2[0]=new JLabel("ºäÆ¼/°Ç°­");
		jl2[1]=new JLabel("¼îÇÎ");
		jl2[2]=new JLabel("±âÅ¸");
		for(int i=0; i<jl2.length; i++) {
			
			jl2[i].setSize(100,30);
			jl2[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
			sub.add(jl2[i]);
		}
		jl2[0].setLocation(20,225);
		jl2[1].setLocation(20,265);
		jl2[2].setLocation(20,305);
		
		JLabel Line2[] =new JLabel[2];
		for(int i=0; i<Line2.length; i++) {
			Line2[i] =new JLabel();
	    	Line2[i].setBorder(new LineBorder(Color.GRAY,5));
		    Line2[i].setSize(310,2);
		    sub.add(Line2[i]);
	    }
		Line2[0].setLocation(15,260);
		Line2[1].setLocation(15,300);
		
		JLabel[] leftMoney =new JLabel[14];
		for(int i=0; i<7; i++) {
			leftMoney[i]= new JLabel("0");
			leftMoney[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,10));
			leftMoney[i].setSize(100,20);
			sub.add(leftMoney[i]);
		}
		leftMoney[0].setLocation(300,35);
		leftMoney[1].setLocation(300,75);
		leftMoney[2].setLocation(300,115);
		leftMoney[3].setLocation(300,155);
		leftMoney[4].setLocation(300,225);
		leftMoney[5].setLocation(300,265);
		leftMoney[6].setLocation(300,305);
		          
		
		for(int i=7; i<11; i++) {
			leftMoney[i]= new JLabel("¿¹»ê 100,000");
			leftMoney[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,10));
			leftMoney[i].setSize(100,20);
			sub.add(leftMoney[i]);
		}
		leftMoney[7].setLocation(250,50);
		leftMoney[8].setLocation(250,90);
		leftMoney[9].setLocation(250,130);
		leftMoney[10].setLocation(250,170);
		for(int i=11; i<14; i++) {
			leftMoney[i]= new JLabel("¿¹»ê 0");
			leftMoney[i].setSize(100,20);
			leftMoney[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,10));
			sub.add(leftMoney[i]);
		}
		leftMoney[11].setLocation(280,240);
		leftMoney[12].setLocation(280,280);
		leftMoney[13].setLocation(280,315);
		
		ImageIcon frontimg =new ImageIcon("images/front.png");
		JLabel[] front =new JLabel[7];
		for(int i=0; i<front.length; i++) {
			front[i] = new JLabel(frontimg);
			front[i].setSize(50,50);
			sub.add(front[i]);
		}
		front[0].setLocation(300,30);
		front[1].setLocation(300,65);
		front[2].setLocation(300,105);
		front[3].setLocation(300,145);
		front[4].setLocation(300,220);
		front[5].setLocation(300,255);
		front[6].setLocation(300,295);
		jp.add(sub);
	}
	public void  SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jp.add(jl);
	}
	public void SET_Label_Area() {//±âÅ¸ ¶óº§ ¿µ¿ª
		JLabel jl[] = new JLabel[3];
		
		jl[0] = new JLabel("¿¹»ê ¼³Á¤");
		
		jl[0].setSize(100, 20);
		jl[0].setLocation(45, 20);
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		jl[0].setForeground(Color.WHITE);
		jl[0].setVisible(true);
		jp.add(jl[0]);
		
		ImageIcon menu = new ImageIcon("images/menu.png");
		jl[2]=new JLabel(menu);
		jl[2].setSize(40, 40);
		jl[2].setLocation(295, 10);
		jp.add(jl[2]);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Set_Cate_Money_19();
	}

}
