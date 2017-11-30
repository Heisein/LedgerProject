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
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	User user;
	LedgerDAO ledgerDao;
	int beautyTotal = 0; // 뷰티 총액
	int eatTotal = 0; // 식비 총액
	int martTotal = 0; // 마트 총액
	int booksTotal = 0; // 서점/문구 총액
	int cafeTotal = 0; // 카페/베이커리 총액
	int transportTotal = 0; // 교통비 총액
	int nocateTotal = 0; // 미분류 총액
	double intTotal = 0;
	DecimalFormat shapFormat = new DecimalFormat("#,###"); // 원표기 포맷
	String[] categoryStr = new String[7]; // 아래에 사용할 카테고리 스트링

	public CategoryMain_21(User user) {
		this.user = user;
		ledgerDao = new LedgerDAO(user);

		// 카테고리 배열 초기화
		categoryStr[0] = "뷰티";
		categoryStr[1] = "외식";
		categoryStr[2] = "마트";
		categoryStr[3] = "서점/문구";
		categoryStr[4] = "카페/베이커리";
		categoryStr[5] = "교통";
		categoryStr[6] = "미분류";

		// 값 초기화
		intTotal = ledgerDao.calcTotal(true);
		beautyTotal = ledgerDao.calcTotal("뷰티", true);
		martTotal = ledgerDao.calcTotal("마트", true);
		eatTotal = ledgerDao.calcTotal("외식", true);
		booksTotal = ledgerDao.calcTotal("서점/문구", true);
		cafeTotal = ledgerDao.calcTotal("카페/베이커리", true);
		transportTotal = ledgerDao.calcTotal("교통", true);
		nocateTotal = ledgerDao.calcTotal("미분류", true);

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

		JLabel title = new JLabel("소비분류");
		title.setSize(100, 20);
		title.setLocation(140, 16);
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
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

		// 카테고리명
		JLabel[] cateName = new JLabel[7];
		cateName[0] = new JLabel("뷰티");
		cateName[1] = new JLabel("외식");
		cateName[2] = new JLabel("마트");
		cateName[3] = new JLabel("서점/문구");
		cateName[4] = new JLabel("카페/베이커리");
		cateName[5] = new JLabel("교통");
		cateName[6] = new JLabel("미분류");

		// 지출 비율(%)
		JLabel[] catePercent = new JLabel[7];

		// 0으로 나눌수도 있어서 예외처리 안하면 컴파일러가 실행도 못하게함.
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

		// 금액
		JLabel[] catePay = new JLabel[7];
		catePay[0] = new JLabel(shapFormat.format(beautyTotal) + "");
		catePay[1] = new JLabel(shapFormat.format(eatTotal) + "");
		catePay[2] = new JLabel(shapFormat.format(martTotal) + "");
		catePay[3] = new JLabel(shapFormat.format(booksTotal) + "");
		catePay[4] = new JLabel(shapFormat.format(cafeTotal) + "");
		catePay[5] = new JLabel(shapFormat.format(transportTotal) + "");
		catePay[6] = new JLabel(shapFormat.format(nocateTotal) + "");

		// 상세보기(더보기)
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

			// 카테고리명
			cateName[i].setSize(110, 40);
			cateName[i].setLocation(55, i * 55);
			cateName[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			cateName[i].setVisible(true);

			// 지출비율
			catePercent[i].setSize(110, 75);
			catePercent[i].setLocation(55, i * 55);
			catePercent[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			catePercent[i].setVisible(true);

			// 금액
			catePay[i].setSize(110, 52);
			int payX = 290 - catePay[i].getText().length() * 7;
			catePay[i].setLocation(payX, i * 55);
			catePay[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
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

			// 상세보기
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
