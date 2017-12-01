package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.PasswordAuthentication;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.LedgerDAO;
import model.User;

public class StatView_29 {

	JFrame jf = new JFrame("�뵷��");
	JPanel jp = new JPanel();
	User user;
	LedgerDAO ledgerdao = null;
	DecimalFormat shapFormat = new DecimalFormat("#,###"); // ��ǥ�� ����
	String[] months = new String[6];
	int fiveMonthExpense = 0;
	int fiveMonthSuip = 0 ;
	
	public StatView_29(User user) {
		this.user = user;

		// ������ �������� dao ����
		ledgerdao = new LedgerDAO(user);
		
		Calendar now = Calendar.getInstance();
		
		// �̹����� �������� 0������ �ʱ�ȭ
		months[0] = (now.get(Calendar.MONTH) +1) + "";
		
		// [1]���� ���� ���� -i��(1,2,3,4,5) �ؼ� 6���� �־����
		for(int i=1; i<6;i++){
			months[i] = (Integer.parseInt(months[0]) - i) + "";
		}
		
		// ��� �̹��� �׸��ºκ�
		ImageIcon img = new ImageIcon("images/29_bar.png");

		// ��� �׷��� �׸���
		JLabel jl[] = new JLabel[5];
		for (int i = 0; i < jl.length; i++) {
			int recSize = ledgerdao.calcTotal(months[i], true, true)/10; // �׷��� X ũ��
			if(recSize >= 250) recSize = 250;
			jl[i] = new JLabel(img);
			jl[i].setSize(recSize, 25);
			jl[i].setLocation(70 , 55 + (i * 45));
			jl[i].setVisible(true);
			jp.add(jl[i]);
			
			fiveMonthExpense += ledgerdao.calcTotal(months[i], true, true);
			fiveMonthSuip += ledgerdao.calcTotal(months[i], false, true);
		}
		
		JLabel monthLabel[] = new JLabel[6];
		for (int i = 0; i < monthLabel.length; i++) {
			monthLabel[i] = new JLabel(months[i] + "��");
			monthLabel[i].setSize(50, 25);
			if(i == 0)  monthLabel[i].setForeground(Color.blue);
			else monthLabel[i].setForeground(Color.white);
			monthLabel[i].setLocation(20 , 55 + (i * 45));
			
			jp.add(monthLabel[i]);
		}

		// ��� �г� �߰��ϴ� �κ�
		JPanel statisPanel[] = new JPanel[2];

		// ��� �гε� �ʱ�ȭ (0 �̹��� 1 6��)
		for (int i = 0; i < statisPanel.length; i++) {
			statisPanel[i] = new JPanel();
			jp.add(statisPanel[i]);
			statisPanel[i].setBackground(Color.WHITE);
			statisPanel[i].setVisible(true);
			statisPanel[i].setLayout(null);
		}
		statisPanel[0].setSize(310, 110);
		statisPanel[0].setLocation(15, 280);
		statisPanel[1].setSize(310, 110);
		statisPanel[1].setLocation(15, 420);

		// �гο� �� �󺧵�
		JLabel statisLabel[] = new JLabel[10];

		for (int i = 0; i < statisLabel.length; i++) {
			statisLabel[i] = new JLabel();
			statisLabel[i].setSize(150, 30);
		}

		// ���� ��~
		statisLabel[0].setText("�̹��� ����");
		statisLabel[1].setText("����");
		statisLabel[2].setText("����");
		statisLabel[3].setText(shapFormat.format(ledgerdao.calcTotal(months[0], false, true)));
		statisLabel[4].setText(shapFormat.format(ledgerdao.calcTotal(months[0], true, true)));
		statisLabel[5].setText("5���� ��� ����");
		statisLabel[6].setText("����");
		statisLabel[7].setText("����");
		statisLabel[8].setText(shapFormat.format(fiveMonthSuip));
		statisLabel[9].setText(shapFormat.format(fiveMonthExpense));

		statisLabel[0].setLocation(10, 10);
		statisLabel[1].setLocation(10, 50);
		statisLabel[2].setLocation(10, 70);
		statisLabel[3].setLocation(200, 50);
		statisLabel[4].setLocation(200, 70);
		statisLabel[5].setLocation(10, 10);
		statisLabel[6].setLocation(10, 50);
		statisLabel[7].setLocation(10, 70);
		statisLabel[8].setLocation(200, 50);
		statisLabel[9].setLocation(200, 70);

		statisLabel[0].setFont(new Font("���� ���", Font.PLAIN, 14));
		statisLabel[1].setFont(new Font("���� ���", Font.PLAIN, 12));
		statisLabel[2].setFont(new Font("���� ���", Font.PLAIN, 12));
		statisLabel[3].setFont(new Font("���� ���", Font.PLAIN, 17));
		statisLabel[4].setFont(new Font("���� ���", Font.PLAIN, 17));
		statisLabel[5].setFont(new Font("���� ���", Font.PLAIN, 14));
		statisLabel[6].setFont(new Font("���� ���", Font.PLAIN, 12));
		statisLabel[7].setFont(new Font("���� ���", Font.PLAIN, 12));
		statisLabel[8].setFont(new Font("���� ���", Font.PLAIN, 17));
		statisLabel[9].setFont(new Font("���� ���", Font.PLAIN, 17));

		// ����г� �ϴ��г�
		for (int i = 0; i < 5; i++) {
			statisPanel[0].add(statisLabel[i]);
		}
		for (int j = 5; j < statisLabel.length; j++) {
			statisPanel[1].add(statisLabel[j]);
		}

		// �� �����ֱ�
		JLabel[] Line = new JLabel[2];

		for (int i = 0; i < Line.length; i++) {
			Line[i] = new JLabel();
			Line[i].setBorder(new LineBorder(new Color(200, 200, 200), 5));
			Line[i].setSize(285, 2);
		}
		Line[0].setLocation(10, 45);
		Line[1].setLocation(10, 45);

		statisPanel[0].add(Line[0]);
		statisPanel[1].add(Line[1]);
		
		// �� �̹����� �ҷ�����
		SET_Label_Area();

		// ���� ������ �ʱ�ȭ
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void SET_Label_Area() {
		JLabel jl[] = new JLabel[3];
		ImageIcon img = new ImageIcon("images/menu.png");
		ImageIcon img1 = new ImageIcon("images/back.png");
		jl[0] = new JLabel(img1);
		jl[1] = new JLabel(img);
		jl[2] = new JLabel("���");

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
		jl[2].setFont(new Font("���� ���", Font.BOLD, 16));
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
