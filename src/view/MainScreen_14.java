package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DescCategory;
import model.Ledger;
import model.LedgerDAO;
import model.User;

public class MainScreen_14 {

	JFrame jf = new JFrame("�뵷��");
	JPanel jp = new JPanel();
	User user;
	int totalExpense = 0; // �� ����
	int totalImpotation = 0; // �� ����

	DecimalFormat shapFormat = new DecimalFormat("#,###"); // ��ǥ�� ����

	LedgerDAO ledgerDAO; // ���� dao
	ArrayList<Ledger> ledgers; // �Ǽ�

	int beautyTotal = 0; // ��Ƽ �Ѿ�
	int eatTotal = 0; // �ĺ� �Ѿ�
	int martTotal = 0; // ��Ʈ �Ѿ�
	int booksTotal = 0; // ����/���� �Ѿ�
	int cafeTotal = 0; // ī��/����Ŀ�� �Ѿ�
	int transportTotal = 0; // ����� �Ѿ�
	int nocateTotal = 0; // �̺з� �Ѿ�
	String[] categoryStr = new String[7]; // �Ʒ��� ����� ī�װ� ��Ʈ��

	public MainScreen_14(User user) {
		this.user = user;
		ledgerDAO = new LedgerDAO(user); // ������ �г� �ʱ�ȭ ���� ledgerDAO�� �ҷ��µ�
		ledgers = ledgerDAO.getLedgers(); // ó���� �׷��� �뵵�� ledger ������

		SET_IMG_Area();
		SET_Pannels_Area();
		SET_Label_Area();

		jf.setSize(370, 600);

		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);

		ScrollPane sp = new ScrollPane();
		sp.add(jp);
		jp.setPreferredSize(new Dimension(320, 800));

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

		// �Ź� ������ ���̸� �ȵǹǷ� setLedgerList �ҷ��ö����� �ʱ�ȭ
		totalExpense = 0;

		// �����г�
		JPanel sub[] = new JPanel[3];
		for (int i = 0; i < sub.length; i++) {
			sub[i] = new JPanel();
			jp.add(sub[i]);
			sub[i].setBackground(Color.WHITE);
			sub[i].setLayout(null);
		}

		sub[0].setSize(300, 150);
		sub[0].setLocation(15, 300);
		sub[1].setSize(300, 150);
		sub[1].setLocation(15, 470);
		sub[2].setSize(300, 120);
		sub[2].setLocation(15, 640);

		JLabel jl[] = new JLabel[20];
		for (int i = 0; i < 20; i++) {
			jl[i] = new JLabel();
			jl[i].setSize(150, 20);
			jl[i].setFont(new Font("���� ���", Font.PLAIN, 14));
		}

		ImageIcon img = new ImageIcon("images/button.png");
		for (int i = 17; i < 20; i++) {
			jl[i] = new JLabel(img);
			jl[i].setSize(30, 30);
		}

		jl[0].setText("����");
		jl[0].setFont(new Font("���� ���", Font.BOLD, 14));
		jl[0].setLocation(10, 10);
		jl[1].setText("�� ����");
		jl[1].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[1].setLocation(10, 50);
		jl[2].setText("�� �Һ��");
		jl[2].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[2].setLocation(10, 70);
		jl[3].setText("400,000"); // �� ���� �� ��ġ(gui ���� �� ���� ��)
		jl[3].setFont(new Font("���� ���", Font.BOLD, 16));
		jl[3].setLocation(200, 50);
		jl[4].setText(""); // �� �Һ�� (gui ���� �� ���� ��)
		jl[4].setFont(new Font("���� ���", Font.BOLD, 16));
		jl[4].setLocation(200, 70);
		jl[5].setText("�Һ� ����");
		jl[5].setFont(new Font("���� ���", Font.BOLD, 14));
		jl[5].setLocation(10, 10);
		jl[6].setText("���� �Һ�з� Top3");
		jl[6].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[6].setLocation(10, 45);
		jl[7].setText(""); // �Һ�з�1 (gui ���� �� ���� ��)
		jl[7].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[7].setLocation(30, 70);
		jl[8].setText(""); // �Һ�з� 2 (gui ���� �� ���� ��)
		jl[8].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[8].setLocation(30, 90);
		jl[9].setText(""); // �Һ�з� 3 (gui ���� �� ���� ��)
		jl[9].setLocation(30, 110);
		jl[9].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[10].setText(""); // �Һ�з� �ݾ�(gui ���� �� ���� ��)
		jl[10].setLocation(200, 70);
		jl[10].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[11].setText("");// �Һ�з� �ݾ�(gui ���� �� ���� ��)
		jl[11].setLocation(200, 90);
		jl[11].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[12].setText("");// �Һ�з� �ݾ�(gui ���� �� ���� ��)
		jl[12].setLocation(200, 110);
		jl[12].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[13].setText("ī������");
		jl[13].setLocation(10, 10);
		jl[13].setFont(new Font("���� ���", Font.BOLD, 14));
		jl[14].setText("����");
		jl[14].setLocation(10, 50);
		jl[14].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[15].setText("123���¹�ȣ");
		jl[15].setLocation(10, 70);
		jl[15].setFont(new Font("���� ���", Font.PLAIN, 14));
		jl[16].setText("4,235�ܾ�");
		jl[16].setLocation(200, 60);
		jl[16].setFont(new Font("���� ���", Font.PLAIN, 18));

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

		// �� �Һ�� ���ϱ�
		for (int i = 0; i < ledgers.size(); i++) {
			Ledger l = ledgers.get(i); // temp������ ����� Ledger l

			int payInt = Integer.parseInt(l.getPay()); // ��ǥ������� �о�� �Һ�ݾ� int������
														// �Ľ�

			if (l.isExpense()) {
				totalExpense += payInt; // �����⿡ ������
			} else {
				totalImpotation += payInt; // �Ѽ��Կ� ������
			}
		}
		jl[4].setText(shapFormat.format(totalExpense) + "");
		int moneyX = 251 - (jl[4].getText().length() * 7);
		jl[4].setBounds(moneyX, 70, jl[4].getText().length() * 10, 25);

		// ī�װ� �迭 �ʱ�ȭ
		categoryStr[0] = "��Ƽ";
		categoryStr[1] = "�ܽ�";
		categoryStr[2] = "��Ʈ";
		categoryStr[3] = "����/����";
		categoryStr[4] = "ī��/����Ŀ��";
		categoryStr[5] = "����";
		categoryStr[6] = "�̺з�";

		for (int i = 0; i < categoryStr.length; i++) {

		}

		// �Һ�з� Top3 ���ϱ�
		// �з��� �Һ��Ѿ� ���ϱ�
		for (Ledger l : ledgers) {
			switch (l.getCategory()) {
			case "��Ƽ":
				if (l.isExpense())
					beautyTotal += Integer.parseInt(l.getPay());
				break;
			case "��Ʈ":
				if (l.isExpense())
					martTotal += Integer.parseInt(l.getPay());
				break;
			case "�ܽ�":
				if (l.isExpense())
					eatTotal += Integer.parseInt(l.getPay());
				break;
			case "����/����":
				if (l.isExpense())
					booksTotal += Integer.parseInt(l.getPay());
				break;
			case "ī��/����Ŀ��":
				if (l.isExpense())
					cafeTotal += Integer.parseInt(l.getPay());
				break;
			case "����":
				if (l.isExpense())
					transportTotal += Integer.parseInt(l.getPay());
				break;
			case "�̺з�":
				if (l.isExpense())
					nocateTotal += Integer.parseInt(l.getPay());
				break;
			}
		}

		Map cMap = new HashMap();

		Integer[] categoryArr = { beautyTotal, eatTotal, martTotal, booksTotal, cafeTotal, transportTotal,
				nocateTotal, };

		for (int i = 0; i < categoryStr.length; i++) {
			cMap.put(categoryStr[i], categoryArr[i]);
		}

		Set<Map.Entry> set = cMap.entrySet();
		Iterator<Map.Entry> entryIter = set.iterator();
		Iterator<Map.Entry> entryIter1 = set.iterator();
		Iterator<Map.Entry> entryIter2 = set.iterator();
		Iterator<Map.Entry> entryIter3 = set.iterator();

		Integer[] valueArr = new Integer[7];
		int a = 0;
		while (entryIter.hasNext()) {
			Map.Entry entry = entryIter.next();
			valueArr[a] = (Integer) entry.getValue();
			a++;
		}
		a = 0;

		Arrays.sort(valueArr, new DescCategory());

		String[] str = { "", "", "" };
		if (valueArr[0] != 0) {
			jl[10].setText(shapFormat.format(valueArr[0]) + "");
			jl[10].setBounds(251 - (jl[10].getText().length() * 7), 70, jl[10].getText().length() * 10, 25);

			while (entryIter1.hasNext()) {
				Map.Entry entry1 = entryIter1.next();
				if (entry1.getValue() == (valueArr[0])) {
					str[0] = (String) entry1.getKey();
				}
			}
			jl[7].setText(str[0]);
		}
		if (valueArr[1] != 0) {
			jl[11].setText(shapFormat.format(valueArr[1]) + "");
			jl[11].setBounds(251 - (jl[11].getText().length() * 7), 90, jl[11].getText().length() * 10, 25);
			while (entryIter2.hasNext()) {
				Map.Entry entry2 = entryIter2.next();
				if (entry2.getValue() == (valueArr[1])) {
					str[1] = (String) entry2.getKey();
				}
			}
			jl[8].setText(str[1]);
			if (valueArr[2] != 0) {
				jl[12].setText(shapFormat.format(valueArr[2]) + "");
				jl[12].setBounds(251 - (jl[12].getText().length() * 7), 110, jl[12].getText().length() * 10, 25);
				while (entryIter3.hasNext()) {
					Map.Entry entry3 = entryIter3.next();
					if (entry3.getValue() == (valueArr[2])) {
						str[2] = (String) entry3.getKey();
					}
				}
				jl[9].setText(str[2]);
			}
		}

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
