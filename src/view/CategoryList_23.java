package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Ledger;
import model.LedgerDAO;
import model.User;

public class CategoryList_23 {
	JFrame jf =new JFrame("�뵷��");
	JPanel jp =new JPanel();
	JPanel ledgerPanel =new JPanel();
	DecimalFormat shapFormat = new DecimalFormat("#,###"); // ��ǥ�� ����
	User user; // �α������� ����
	LedgerDAO ledgerdao; // dao���ٿ�
	ArrayList<Ledger> ledgers;
	
	public CategoryList_23(User user, String category) {
		this.user = user;
		ledgerdao = new LedgerDAO(user);
		ledgers = ledgerdao.getLedgers(category); // ī�װ����� ���� �������� ������
		jf.setSize(360,600);
		jf.setTitle("�뵷��");
		
		// �����г� ����
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		
		// �����гο� �̸��̶� �� �Һ�� ����
		JLabel categoryTitleLabel =new JLabel(category + " �Һ��");
		categoryTitleLabel.setFont(new Font("�������",Font.PLAIN,12));
		categoryTitleLabel.setForeground(Color.WHITE);
		categoryTitleLabel.setSize(300,20);
		categoryTitleLabel.setLocation(20,70);
		jp.add(categoryTitleLabel);
		
		// �ѼҺ��		
		JLabel categoryTotalLabel =new JLabel(shapFormat.format(ledgerdao.calcTotal(category)) + "��");
		categoryTotalLabel.setFont(new Font("�������",Font.PLAIN,22));
		categoryTotalLabel.setForeground(Color.WHITE);
		categoryTotalLabel.setSize(100,20);
		categoryTotalLabel.setLocation(20,95);
		jp.add(categoryTotalLabel);
		
		SET_IMG_Area();
		SET_Label_Area();
		
		// �����гο� ��ũ�� ����
		setLedgerList();
		
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setLedgerList() {
		ledgerPanel.setSize(360, 600);
		ledgerPanel.setLocation(0, 130);
		ledgerPanel.setLayout(null);
		ledgerPanel.setBackground(Color.white);

		ScrollPane sp = new ScrollPane();
		sp.setLocation(0, 130);
		sp.setSize(340, 600);
		sp.add(ledgerPanel);
		
		JLabel[] locateLabel = new JLabel[ledgers.size()];
		JLabel[] dateLabel = new JLabel[ledgers.size()];
		JLabel[] payLabel = new JLabel[ledgers.size()];
		JLabel[] moneyLabel = new JLabel[ledgers.size()];

		// ledger �ҷ��ö����� ������ �ٽñ׷���!
		ledgerPanel.setSize(360, 200 + (ledgers.size() * 55));
		ledgerPanel.setPreferredSize(new Dimension(340, 200 + (ledgers.size() * 55)));

		System.out.println("�缳���� ledgerPanel : " + ledgerPanel.getSize());

		for (int i = 0; i < ledgers.size(); i++) {
			Ledger l = ledgers.get(i); // temp������ ����� Ledger l
			
			// ��� ���� �ѷ���
			locateLabel[i] = new JLabel(l.getLocate());
			locateLabel[i].setFont(new Font("���� ���", Font.PLAIN, 16));
			locateLabel[i].setBounds(15, 5 + (i * 55), 200, 25);

			// ���� �ѷ���
			String date = l.getDate();
			String str = new String(
					"20" + date.substring(0, 2) + "." + date.substring(2, 4) + "." + date.substring(4, 6) + " "
							+ date.substring(6, 8) + ":" + date.substring(8, 10) + " " + l.getCategory());

			dateLabel[i] = new JLabel(str);
			dateLabel[i].setFont(new Font("���� ���", Font.PLAIN, 12));
			dateLabel[i].setForeground(Color.GRAY);
			dateLabel[i].setBounds(15, 25 + (i * 55), 200, 25);

			// ���α׾���
			JLabel line = new JLabel();
			line.setBorder(new LineBorder(Color.GRAY, 5));
			line.setSize(275, 2);
			line.setLocation(15, 55 + (i * 55));
			line.setVisible(true);

			// �Һ�ݾ� �ѷ���
			payLabel[i] = new JLabel();
			int payInt = Integer.parseInt(l.getPay()); // ��ǥ������� �о�� �Һ�ݾ� int������
														// �Ľ�
			String payStr;
			if (l.isExpense()) {
				payLabel[i].setForeground(Color.RED); // �����̸� ����
				payStr = "- " + shapFormat.format(payInt);
			} else {
				payLabel[i].setForeground(Color.BLUE); // �����̸� �Ķ�
				payStr = "+ " + shapFormat.format(payInt);
			}
			payLabel[i].setText(payStr);
			payLabel[i].setFont(new Font("���� ���", Font.PLAIN, 16));
			int payX = 281 - (payStr.length() * 7);
			if (l.isExpense())
				payX += 4;
			payLabel[i].setBounds(payX, 5 + (i * 55), payStr.length() * 10, 25);

			ledgerPanel.add(line);
			ledgerPanel.add(locateLabel[i]);
			ledgerPanel.add(dateLabel[i]);
			ledgerPanel.add(payLabel[i]);
			
		} // eof
		
		jp.add(sp);
	}
	
	
	
	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CategoryMain_21(user);
				jf.dispose();
			}
		});
		
		jp.add(jl);
	}
	public void SET_Label_Area() {//��Ÿ �� ����
		JLabel jl[] = new JLabel[2];
		ImageIcon menu = new ImageIcon("images/menu.png");
		
		jl[0] = new JLabel("�Һ�з���");
		jl[1] = new JLabel(menu);
		
		
		jl[0].setSize(100, 20);
		jl[0].setLocation(130, 20);
		jl[0].setFont(new Font("���� ���", Font.BOLD, 16));

		jl[1].setSize(40, 40);
		jl[1].setLocation(295, 10);
		jl[1].setFont(new Font("���� ���", Font.PLAIN, 14));
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		
	}
	
}
