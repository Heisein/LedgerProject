package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.CardDAO;
import model.DescCategory;
import model.Ledger;
import model.LedgerDAO;
import model.User;
import model.UserDAO;

public class MainScreen_14 {
	UserDAO UD = new UserDAO();
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	User user;
	int totalExpense = 0; // 총 지출
	int totalImpotation = 0; // 총 수입
	JOptionPane jop = new JOptionPane();
	JLabel jl[] = new JLabel[20];
	User utemp;

	DecimalFormat shapFormat = new DecimalFormat("#,###"); // 원표기 포맷

	LedgerDAO ledgerDAO; // 껀수 dao
	ArrayList<Ledger> ledgers; // 건수
	CardDAO cardDAO; // 카드 DAO

	int beautyTotal = 0; // 뷰티 총액
	int eatTotal = 0; // 식비 총액
	int martTotal = 0; // 마트 총액
	int booksTotal = 0; // 서점/문구 총액
	int cafeTotal = 0; // 카페/베이커리 총액
	int transportTotal = 0; // 교통비 총액
	int nocateTotal = 0; // 미분류 총액
	String[] categoryStr = new String[7]; // 아래에 사용할 카테고리 스트링

	public MainScreen_14(User user) {

		this.user = user;
		ledgerDAO = new LedgerDAO(user); // 유저로 패널 초기화 전에 ledgerDAO를 불러온디
		ledgers = ledgerDAO.getLedgers(); // 처음에 그려줄 용도로 ledger 가져옴
		cardDAO = new CardDAO(user);
		jf.add(jop);
		jop.setLocation(15, 300);
		
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

		// 매번 총지출 쌓이면 안되므로 setLedgerList 불러올때마다 초기화
		totalExpense = 0;

		// 서브패널
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

		for (int i = 0; i < 20; i++) {
			jl[i] = new JLabel();
			jl[i].setSize(150, 20);
			jl[i].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		}

		ImageIcon img = new ImageIcon("images/button.png");
		for (int i = 17; i < 20; i++) {
			jl[i] = new JLabel(img);
			jl[i].setSize(30, 30);
		}

		// 카드 체크용
		boolean isCard = false;

		jl[0].setText("예산");
		jl[0].setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jl[0].setLocation(10, 10);
		jl[1].setText("총 예산");
		jl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[1].setLocation(10, 50);
		jl[2].setText("총 소비액");
		jl[2].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[2].setLocation(10, 70);
		jl[3].setText(user.getBudget()); // 총 예산 라벨 위치(gui 구현 때 만든 것)
		jl[3].setFont(new Font("맑은 고딕", Font.BOLD, 16));
		jl[3].setLocation(200, 50);
		jl[4].setText(""); // 총 소비액 (gui 구현 때 만든 것)
		jl[4].setFont(new Font("맑은 고딕", Font.BOLD, 16));
		jl[4].setLocation(200, 70);
		jl[5].setText("소비 내역");
		jl[5].setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jl[5].setLocation(10, 10);
		jl[6].setText("나의 소비분류 Top3");
		jl[6].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[6].setLocation(10, 45);
		jl[7].setText(""); // 소비분류1 (gui 구현 때 만든 것)
		jl[7].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[7].setLocation(30, 70);
		jl[8].setText(""); // 소비분류 2 (gui 구현 때 만든 것)
		jl[8].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[8].setLocation(30, 90);
		jl[9].setText(""); // 소비분류 3 (gui 구현 때 만든 것)
		jl[9].setLocation(30, 110);
		jl[9].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[10].setText(""); // 소비분류 금액(gui 구현 때 만든 것)
		jl[10].setLocation(200, 70);
		jl[10].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[11].setText("");// 소비분류 금액(gui 구현 때 만든 것)
		jl[11].setLocation(200, 90);
		jl[11].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[12].setText("");// 소비분류 금액(gui 구현 때 만든 것)
		jl[12].setLocation(200, 110);
		jl[12].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jl[13].setText("카드정보");
		jl[13].setLocation(10, 10);
		jl[13].setFont(new Font("맑은 고딕", Font.BOLD, 14));
		if (cardDAO.getCards() != null) {
			jl[14].setText(cardDAO.getCards().get(0).getBankName());
			jl[14].setSize(100, 20);
			isCard = true;
		} else {
			jl[14].setText("등록된 계좌 없음!");
		}
		jl[14].setLocation(10, 50);
		jl[14].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		if (cardDAO.getCards() != null) {
			jl[15].setText(cardDAO.getCards().get(0).getAccount());
			jl[15].setSize(100, 20);
		} else {
			jl[15].setText("");
		}
		jl[15].setLocation(10, 70);
		jl[15].setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		jl[17].setLocation(260, 10);
		jl[18].setLocation(260, 10);
		jl[19].setLocation(260, 10);

		jl[17].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				utemp = popup(user);
				jop.setVisible(true);
			}
		});
		if(utemp != null) this.user = utemp;
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

		if (isCard) {
			ImageIcon cardimg = new ImageIcon("images/card.png");
			JLabel jl = new JLabel(cardimg);
			jl.setSize(75, 57);
			jl.setLocation(215, 40);
			jl.setVisible(true);
			sub[2].add(jl);
		}

		// 총 소비액 구하기
		for (int i = 0; i < ledgers.size(); i++) {
			Ledger l = ledgers.get(i); // temp용으로 사용할 Ledger l

			int payInt = Integer.parseInt(l.getPay()); // 원표기용으로 읽어온 소비금액 int형으로
			// 파싱

			if (l.isExpense()) {
				totalExpense += payInt; // 총지출에 더해줌
			} else {
				totalImpotation += payInt; // 총수입에 더해줌
			}
		}
		jl[4].setText(shapFormat.format(totalExpense) + "");
		int moneyX = 251 - (jl[4].getText().length() * 7);
		jl[4].setBounds(moneyX, 70, jl[4].getText().length() * 10, 25);

		// 카테고리 배열 초기화
		categoryStr[0] = "뷰티";
		categoryStr[1] = "외식";
		categoryStr[2] = "마트";
		categoryStr[3] = "서점/문구";
		categoryStr[4] = "카페/베이커리";
		categoryStr[5] = "교통";
		categoryStr[6] = "미분류";

		for (int i = 0; i < categoryStr.length; i++) {

		}

		// 소비분류 Top3 구하기
		// 분류별 소비총액 구하기
		for (Ledger l : ledgers) {
			switch (l.getCategory()) {
			case "뷰티":
				if (l.isExpense())
					beautyTotal += Integer.parseInt(l.getPay());
				break;
			case "마트":
				if (l.isExpense())
					martTotal += Integer.parseInt(l.getPay());
				break;
			case "외식":
				if (l.isExpense())
					eatTotal += Integer.parseInt(l.getPay());
				break;
			case "서점/문구":
				if (l.isExpense())
					booksTotal += Integer.parseInt(l.getPay());
				break;
			case "카페/베이커리":
				if (l.isExpense())
					cafeTotal += Integer.parseInt(l.getPay());
				break;
			case "교통":
				if (l.isExpense())
					transportTotal += Integer.parseInt(l.getPay());
				break;
			case "미분류":
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

		JPanel gra[] = new JPanel[2];

		gra[0] = new JPanel();
		gra[1] = new JPanel();

		long max = Long.parseLong(jl[3].getText());
		double now = totalExpense;

		System.out.println(max + " " + totalExpense);

		gra[0].setLocation(10, 100);
		gra[0].setLayout(null);
		gra[0].setSize(250, 20);
		gra[0].setBackground(Color.black);

		gra[1].setSize((int) ((now / max) * 250), 10);
		gra[1].setLocation(0, 5);
		gra[1].setBackground(new Color(117, 102, 205));

		sub[0].add(gra[0]);
		gra[0].add(gra[1]);
	}

	public User popup(User user) {

		jop.setSize(300, 100);
		jop.setBackground(Color.white);
		jop.setLayout(null);

		JLabel label = new JLabel("새로 책정할 예산을 적어주세요");
		label.setSize(200, 20);
		label.setLocation(10, 10);
		jop.add(label);

		JTextArea jt = new JTextArea(jl[3].getText());
		jt.setSize(200, 20);
		jt.setLocation(10, 30);
		jop.add(jt);

		JButton jb = new JButton("확인");
		jb.setSize(200, 20);
		jb.setLocation(10, 50);

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jl[3].setText(jt.getText());

				UD.budgetchange(user.getUserID(), jt.getText());
				jop.removeAll();
				jop.setVisible(false);
				jl[3].setText(jt.getText());
				
				user.setBudget(jt.getText());
				
				new MainScreen_14(user);
				jf.dispose();
			}

		});

		jop.add(jb);
		return user;

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