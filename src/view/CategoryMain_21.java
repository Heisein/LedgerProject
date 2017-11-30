package view;

import java.awt.Color;
import java.awt.Font;
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

public class CategoryMain_21 {
	JFrame jf = new JFrame("�뵷��");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	User user;
	LedgerDAO ledgerDao;
	int beautyTotal = 0; // ��Ƽ �Ѿ�
	int eatTotal = 0; // �ĺ� �Ѿ�
	int martTotal = 0; // ��Ʈ �Ѿ�
	int booksTotal = 0; // ����/���� �Ѿ�
	int cafeTotal = 0; // ī��/����Ŀ�� �Ѿ�
	int transportTotal = 0; // ����� �Ѿ�
	int nocateTotal = 0; // �̺з� �Ѿ�
	double intTotal = 0;
	DecimalFormat shapFormat = new DecimalFormat("#,###"); // ��ǥ�� ����
	String[] categoryStr = new String[7]; // �Ʒ��� ����� ī�װ� ��Ʈ��

	public CategoryMain_21(User user) {
		this.user = user;
		ledgerDao = new LedgerDAO(user);

		// ī�װ� �迭 �ʱ�ȭ
		categoryStr[0] = "��Ƽ";
		categoryStr[1] = "�ܽ�";
		categoryStr[2] = "��Ʈ";
		categoryStr[3] = "����/����";
		categoryStr[4] = "ī��/����Ŀ��";
		categoryStr[5] = "����";
		categoryStr[6] = "�̺з�";

		// �� �ʱ�ȭ
		intTotal = ledgerDao.calcTotal(true);
		beautyTotal = ledgerDao.calcTotal("��Ƽ", true);
		martTotal = ledgerDao.calcTotal("��Ʈ", true);
		eatTotal = ledgerDao.calcTotal("�ܽ�", true);
		booksTotal = ledgerDao.calcTotal("����/����", true);
		cafeTotal = ledgerDao.calcTotal("ī��/����Ŀ��", true);
		transportTotal = ledgerDao.calcTotal("����", true);
		nocateTotal = ledgerDao.calcTotal("�̺з�", true);

		SET_Title_Area();
		SET_Content_Area();

		jf.setSize(360, 600);
		jp.setLayout(null);
		jf.add(jp);
		jp.setBackground(new Color(117, 102, 205));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void SET_Title_Area() {
		ImageIcon back = new ImageIcon("images/back.png");
		JLabel jl_back = new JLabel(back);
		jl_back.setSize(50, 50);
		jl_back.setLocation(5, 3);
		jl_back.setVisible(true);
		jl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LedgerBoard(user);
				jf.dispose();
			}
		});

		JLabel title = new JLabel("�Һ�з�");
		title.setSize(100, 20);
		title.setLocation(140, 16);
		title.setFont(new Font("���� ���", Font.PLAIN, 16));
		title.setForeground(Color.WHITE);
		title.setVisible(true);

		ImageIcon menu = new ImageIcon("images/menu.png");
		JLabel jl_menu = new JLabel(menu);
		jl_menu.setSize(50, 50);
		jl_menu.setLocation(290, 5);
		jl_menu.setVisible(true);
		jl_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// new CategoryList();
				jf.setVisible(false);
			}
		});

		jp.add(jl_back);
		jp.add(title);
		jp.add(jl_menu);

	}

	private void SET_Content_Area() {
		sub.setSize(360, 510);
		sub.setLocation(0, 55);
		sub.setLayout(null);
		sub.setBackground(Color.WHITE);

		// ī�װ���
		JLabel[] cateName = new JLabel[7];
		cateName[0] = new JLabel("��Ƽ");
		cateName[1] = new JLabel("�ܽ�");
		cateName[2] = new JLabel("��Ʈ");
		cateName[3] = new JLabel("����/����");
		cateName[4] = new JLabel("ī��/����Ŀ��");
		cateName[5] = new JLabel("����");
		cateName[6] = new JLabel("�̺з�");

		// ���� ����(%)
		JLabel[] catePercent = new JLabel[7];

		// 0���� �������� �־ ����ó�� ���ϸ� �����Ϸ��� ���൵ ���ϰ���.
		if (beautyTotal != 0)
			catePercent[0] = new JLabel(
					(Double.parseDouble(String.format("%.2f", (beautyTotal / intTotal * 100)))) + "%");
		else
			catePercent[0] = new JLabel("0%");
		if (eatTotal != 0)
			catePercent[1] = new JLabel((Double.parseDouble(String.format("%.2f", (eatTotal / intTotal * 100)))) + "%");
		else
			catePercent[1] = new JLabel("0%");
		if (martTotal != 0)
			catePercent[2] = new JLabel(
					(Double.parseDouble(String.format("%.2f", (martTotal / intTotal * 100)))) + "%");
		else
			catePercent[2] = new JLabel("0%");
		if (booksTotal != 0)
			catePercent[3] = new JLabel(
					(Double.parseDouble(String.format("%.2f", (booksTotal / intTotal * 100)))) + "%");
		else
			catePercent[3] = new JLabel("0%");
		if (cafeTotal != 0)
			catePercent[4] = new JLabel(
					(Double.parseDouble(String.format("%.2f", (cafeTotal / intTotal * 100)))) + "%");
		else
			catePercent[4] = new JLabel("0%");
		if (transportTotal != 0)
			catePercent[5] = new JLabel(
					(Double.parseDouble(String.format("%.2f", (transportTotal / intTotal * 100)))) + "%");
		else
			catePercent[5] = new JLabel("0%");
		if (nocateTotal != 0)
			catePercent[6] = new JLabel(
					(Double.parseDouble(String.format("%.2f", (nocateTotal / intTotal * 100)))) + "%");
		else
			catePercent[6] = new JLabel("0%");

		// �ݾ�
		JLabel[] catePay = new JLabel[7];
		catePay[0] = new JLabel(shapFormat.format(beautyTotal) + "");
		catePay[1] = new JLabel(shapFormat.format(eatTotal) + "");
		catePay[2] = new JLabel(shapFormat.format(martTotal) + "");
		catePay[3] = new JLabel(shapFormat.format(booksTotal) + "");
		catePay[4] = new JLabel(shapFormat.format(cafeTotal) + "");
		catePay[5] = new JLabel(shapFormat.format(transportTotal) + "");
		catePay[6] = new JLabel(shapFormat.format(nocateTotal) + "");

		// �󼼺���(������)
		JLabel[] more = new JLabel[7];

		// icon
		ImageIcon[] icon = new ImageIcon[7];
		icon[0] = new ImageIcon("images/1.png");
		icon[1] = new ImageIcon("images/2.png");
		icon[2] = new ImageIcon("images/3.png");
		icon[3] = new ImageIcon("images/4.png");
		icon[4] = new ImageIcon("images/5.png");
		icon[5] = new ImageIcon("images/6.png");
		icon[6] = new ImageIcon("images/7.png");

		JLabel[] label = new JLabel[7];
		for (int i = 0; i < 7; i++) {

			// ī�װ���
			cateName[i].setSize(110, 40);
			cateName[i].setLocation(55, i * 55);
			cateName[i].setFont(new Font("���� ���", Font.PLAIN, 16));
			cateName[i].setVisible(true);

			// �������
			catePercent[i].setSize(110, 75);
			catePercent[i].setLocation(55, i * 55);
			catePercent[i].setFont(new Font("���� ���", Font.PLAIN, 13));
			catePercent[i].setVisible(true);

			// �ݾ�
			catePay[i].setSize(110, 52);
			int payX = 290 - catePay[i].getText().length() * 7;
			catePay[i].setLocation(payX, i * 55);
			catePay[i].setFont(new Font("���� ���", Font.PLAIN, 16));
			catePay[i].setVisible(true);

			// Line
			JLabel line = new JLabel();
			line.setBorder(new LineBorder(Color.GRAY, 5));
			line.setSize(262, 2);
			line.setLocation(56, 51 + (i * 55));
			line.setVisible(true);

			// icon
			label[i] = new JLabel(icon[i]);
			label[i].setSize(35, 35);
			label[i].setLocation(11, 12 + (i * 54));

			// �󼼺���
			ImageIcon moreImg = new ImageIcon("images/more.png");
			more[i] = new JLabel(moreImg);
			more[i].setSize(50, 55);
			more[i].setLocation(285, i * 55);
			more[i].setVisible(true);

			int iTemp = i;

			more[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(categoryStr);
					new CategoryList_23(user, categoryStr[iTemp]);
					jf.dispose();
				}
			});

			sub.add(cateName[i]);
			sub.add(catePercent[i]);
			sub.add(catePay[i]);
			sub.add(line);
			sub.add(label[i]);
			sub.add(more[i]);
		}

		jp.add(sub);
	}
}
