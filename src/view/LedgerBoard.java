package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Ledger;
import model.LedgerDAO;
import model.User;

public class LedgerBoard {
	User user;
	JFrame jf = new JFrame("용돈조"); // 메인 프레임
	JPanel jp = new JPanel(); // 메인 패널
	JPanel ledgerPanel; // 레더 패널, 사용 내역 보여줄 패널
	JLabel titleLabel = new JLabel();
	showPopup pop; // 팝업창
	LedgerBoard ledgerlo;
	int totalExpense = 0; // 총 지출
	int totalImpotation = 0; // 총 수입
	DecimalFormat shapFormat = new DecimalFormat("#,###"); // 원표기 포맷

	Ledger l;
	LedgerDAO ledgerDAO; // 껀수 dao
	ArrayList<Ledger> ledgers; // 건수

	public LedgerBoard(User user) {
		this.user = user;
		ledgerDAO = new LedgerDAO(user); // 유저로 패널 초기화 전에 ledgerDAO를 불러온디
		ledgers = ledgerDAO.getLedgers(); // 처음에 그려줄 용도로 ledger 가져옴
		ledgerlo = this; // JDialog에서 얘를 참조 못해서 이 주소를 보낼려고 얘 레퍼런스 저장함

		System.out.println("현재 로그인한 유저 : " + user.getUserID());

		// 라벨 추가
		titleLabel = new JLabel("소비 내역");

		titleLabel.setSize(100, 20);
		titleLabel.setLocation(140, 20);
		titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		titleLabel.setForeground(Color.WHITE);

		jp.add(titleLabel);

		// 이미지 추가
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainScreen_14(user);
				jf.dispose();
			}
		});

		ImageIcon img2 = new ImageIcon("images/plus.png");
		JLabel plusLabel = new JLabel(img2);
		plusLabel.setSize(50, 50);
		plusLabel.setLocation(295, 6);
		plusLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pop = new showPopup(jf, "사용 이력 추가", ledgerlo);
				pop.setVisible(true);
			}
		});
		
		ImageIcon img3 = new ImageIcon("images/category.png");
		JLabel categoryLabel = new JLabel(img3);
		categoryLabel.setSize(31, 31);
		categoryLabel.setLocation(264, 17);
		categoryLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CategoryMain_21(user);
				jf.dispose();
			}
		});

		jp.add(categoryLabel);
		jp.add(plusLabel);
		jp.add(jl);

		// 레더 패널 추가
		ledgerPanel = new JPanel();
		ledgerPanel.setLocation(0, 60);
		ledgerPanel.setLayout(null);
		ledgerPanel.setBackground(Color.white);

		// 레더패널에 스크롤 붙임
		ScrollPane sp = new ScrollPane();
		sp.setLocation(0, 60);
		sp.setSize(340, 600);
		sp.add(ledgerPanel);

		// 초기 읽어온 ledger 뿌려줌
		this.setLedgerList();

		// 메인 패널 초기화
		jp.setLayout(null);
		jp.setBackground(new Color(117, 102, 205));
		jp.add(sp);

		// 메인 프레임 초기화
		jf.add(jp);
		jf.setSize(360, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	public void rePaint() { // 얘 불릴때마다 화면 다시그린다
		Collections.sort(ledgers); // 이유는 모르겠는데 리버스 제대로안되서 소트(오름차순)먼저함
		Collections.reverse(ledgers); // 내림차순으로 정렬시킴
		ledgerDAO.saveLedger(); // 파일저장

		ledgerPanel.removeAll();
		this.setLedgerList();
		System.out.println("리페인트 실행!");
	}

	public void toCategoryDetailModify_25Class() {
		jf.setVisible(false);
		
		new CategoryDetailModify_25(user,l);
	}
	
	// ledger 컬렉션에 있는걸 화면에 뿌려준다
	public void setLedgerList() {

		JLabel[] locateLabel = new JLabel[ledgers.size()];
		JLabel[] dateLabel = new JLabel[ledgers.size()];
		JLabel[] payLabel = new JLabel[ledgers.size()];
		JLabel[] moneyLabel = new JLabel[ledgers.size()];
		JLabel[] moreLabel =new JLabel[ledgers.size()];
		
		//25번 화면으로 넘어갈려는 이미지파일;
		ImageIcon moreimg=new ImageIcon("images/more.png");

		// ledger 불러올때마다 사이즈 다시그려줌!
		ledgerPanel.setSize(360, 200 + (ledgers.size() * 55));
		ledgerPanel.setPreferredSize(new Dimension(340, 200 + (ledgers.size() * 55)));

		System.out.println("재설정된 ledgerPanel : " + ledgerPanel.getSize());

		// 매번 총지출,수입이 쌓이면 안되므로 setLedgerList 불러올때마다 초기화
		totalExpense = 0;
		totalImpotation = 0;

		int jTemp = ledgers.size() - 1;
		for (int i = 0; i < ledgers.size(); i++) {
			Ledger l = ledgers.get(i); // temp용으로 사용할 Ledger l

			// 사용 내역 뿌려줌
			locateLabel[i] = new JLabel(l.getLocate());
			locateLabel[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			locateLabel[i].setBounds(15, 5 + (i * 55), 200, 25);

			// 일자 뿌려줌
			String date = l.getDate();
			String str = new String(
					"20" + date.substring(0, 2) + "." + date.substring(2, 4) + "." + date.substring(4, 6) + " "
							+ date.substring(6, 8) + ":" + date.substring(8, 10) + " " + l.getCategory());

			dateLabel[i] = new JLabel(str);
			dateLabel[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			dateLabel[i].setForeground(Color.GRAY);
			dateLabel[i].setBounds(15, 25 + (i * 55), 200, 25);

			// 라인그어줌
			JLabel line = new JLabel();
			line.setBorder(new LineBorder(Color.GRAY, 5));
			line.setSize(275, 2);
			line.setLocation(15, 55 + (i * 55));
			line.setVisible(true);

			// 소비금액 뿌려줌
			payLabel[i] = new JLabel();
			int payInt = Integer.parseInt(l.getPay()); // 원표기용으로 읽어온 소비금액 int형으로
														// 파싱

			String payStr;
			if (l.isExpense()) {
				payLabel[i].setForeground(Color.RED); // 지출이면 빨강
				payStr = "- " + shapFormat.format(payInt);
				totalExpense += payInt; // 총지출에 더해줌
			} else {
				payLabel[i].setForeground(Color.BLUE); // 수입이면 파랑
				payStr = "+ " + shapFormat.format(payInt);
				totalImpotation += payInt; // 총수입에 더해줌
			}
			payLabel[i].setText(payStr);
			payLabel[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			int payX = 281 - (payStr.length() * 7);
			if (l.isExpense())
				payX += 4;
			payLabel[i].setBounds(payX, 5 + (i * 55), payStr.length() * 10, 25);

			moreLabel[i] =new JLabel(moreimg);
			moreLabel[i].setSize(50,50);
			moreLabel[i].setBounds(230, 5 + (i * 55),150, 40);
			int iTemp = i;
			moreLabel[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					new CategoryDetailModify_25(user, ledgers.get(iTemp));
				}
			});
			
			ledgerPanel.add(moreLabel[i]);
			ledgerPanel.add(line);
			ledgerPanel.add(locateLabel[i]);
			ledgerPanel.add(dateLabel[i]);
			ledgerPanel.add(payLabel[i]);
			
		} // eof

		
		int myMoney = 0;
		
		// 총사용금액은 포문이 반대로 돌아야해서 마지막에 따로!
		for (int i = ledgers.size() - 1; i >= 0; i--) {
			// 총 사용금액 뿌려줌
			Ledger ltemp = ledgers.get(jTemp--);
			if (ltemp.isExpense())
				myMoney -= Integer.parseInt(ltemp.getPay());
			else
				myMoney += Integer.parseInt(ltemp.getPay());

			moneyLabel[i] = new JLabel(shapFormat.format(myMoney) + "");
			moneyLabel[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			int moneyX = 281 - (moneyLabel[i].getText().length() * 7);
			moneyLabel[i].setBounds(moneyX, 25 + (i * 55), moneyLabel[i].getText().length() * 10, 25);
			
			ledgerPanel.add(moneyLabel[i]);
		}

		
		System.out.println("총지출 : " + totalExpense);
		System.out.println("총수입 : " + totalImpotation);
	}
}

// ================== 이하 추가하는 팝업창 클래스 ==========================
class showPopup extends JDialog implements ActionListener {
	JPanel mp, innerPanel;
	JLabel titleLabel;
	JButton confirmButton;
	LedgerBoard board;
	LedgerBoard le;

	public showPopup(Frame parent, String str, LedgerBoard le) {
		super(parent, str, true); // JDialog 생성자인듯
		this.le = le; //

		this.setSize(360, 600);
		addWindowListener(new MyWinListener());

		// 메인 패널 초기화
		mp = new JPanel();
		mp.setBackground(new Color(117, 102, 205));
		mp.setLayout(null);

		// 메인 패널에 타이틀 라벨 붙이기
		titleLabel = new JLabel("소비 내역 추가");

		titleLabel.setSize(150, 20);
		titleLabel.setLocation(120, 20);
		titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		titleLabel.setForeground(Color.WHITE);

		mp.add(titleLabel);

		// 내용 입력 패널 초기화
		innerPanel = new JPanel();
		innerPanel.setBackground(Color.WHITE);
		innerPanel.setLayout(null);
		innerPanel.setBounds(0, 60, 360, 450);

		// 내용 입력 패널에 내부 붙이기
		JLabel[] titles = new JLabel[6];
		titles[0] = new JLabel("금액");
		titles[1] = new JLabel("내역");
		titles[2] = new JLabel("일시");
		titles[3] = new JLabel("지출여부");
		titles[4] = new JLabel("카테고리");
		titles[5] = new JLabel("메모");

		JTextField[] texts = new JTextField[4];

		for (int i = 0; i < 6; i++) {
			// 라벨들 크기와 폰트 설정, 패널에 추가
			titles[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			titles[i].setBounds(15, 5 + (i * 50), 100, 50);
			innerPanel.add(titles[i]);

			// 라인 끄어줌
			if (i < 5) {
				JLabel line = new JLabel();
				line.setBorder(new LineBorder(Color.GRAY, 5));
				line.setSize(275, 2);
				line.setLocation(15, 55 + (i * 50));
				line.setVisible(true);
				innerPanel.add(line);
			}

			// 텍스트필드 초기화, 생성, 패널에 추가
			if (i < 3) {
				texts[i] = new JTextField();
				texts[i].setBounds(90, 18 + (i * 50), 200, 30);

				innerPanel.add(texts[i]);
			}

		} // eof

		JTextArea memoArea = new JTextArea();
		memoArea.setBounds(15, 300, 300, 120);
		memoArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		innerPanel.add(memoArea);

		// 일시 텍스트필드 옆에 자동 일시 버튼
		JButton autoDateBtn = new JButton("현재");
		autoDateBtn.setBounds(295, 118, 45, 30);

		// 자동 일시 버튼 누르면 현재시간 입력됨
		autoDateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
				texts[2].setText(sdf.format(date));
			}
		});

		innerPanel.add(autoDateBtn);

		// 텍스트필드 텍스트 초기화
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
		texts[0].setText("금액을 입력해주세요.");
		texts[1].setText("이용 내역을 입력해주세요.");
		texts[2].setText(sdf.format(date));

		// 텍스트필드 누르면 글자없어지게 마우스리스너 추가
		texts[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texts[0].setText("");
			}
		});

		texts[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texts[1].setText("");
			}
		});

		texts[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texts[2].setText("");
			}
		});

		// 수입, 지출 라디오박스
		JRadioButton jrb1 = new JRadioButton("지출");
		JRadioButton jrb2 = new JRadioButton("수입");

		jrb1.setSelected(true); // 라디오박스 둘중 하나는 선택되어 있어야 하므로 기본값으로 지출 true로

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		jrb1.setBackground(Color.white);
		jrb2.setBackground(Color.white);
		jrb1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jrb2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		jrb1.setBounds(85, 165, 70, 30);
		jrb2.setBounds(160, 165, 70, 30);

		innerPanel.add(jrb1);
		innerPanel.add(jrb2);

		// 카테고리
		String[] categoryStr = { "카테고리를 선택해주세요", "뷰티", "외식", "마트", "서점/문구", "카페/베이커리", "교통", "미분류" };
		JComboBox categoryCb = new JComboBox(categoryStr);
		categoryCb.setBounds(90, 218, 200, 30);

		innerPanel.add(categoryCb);

		// =============== 이하 메인패널 ==============

		// 메인패널 뒤로가기 버튼
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		// 메인패널 완료버튼
		JLabel commitLabel = new JLabel("완료");
		commitLabel.setSize(100, 20);
		commitLabel.setLocation(150, 525);
		commitLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		commitLabel.setForeground(Color.white);

		// 완료버튼 누르면
		commitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// texts 0금액 1일시 2지출여부 3카테고리 4메모
				boolean isExpense = true;

				// 라디오박스 기본값이 지출이므로.
				if (jrb1.isSelected())
					isExpense = true;
				else
					isExpense = false;

				// 콘솔에 추가된 Ledger 찍어보기
				String str = (texts[0].getText() + "," + texts[1].getText() + "," + texts[2].getText() + "," + isExpense
						+ "," + categoryCb.getSelectedItem());
				System.out.println(str);

				// ledgerDAO에 insert
				le.ledgerDAO.insertLedger(texts[0].getText(), texts[1].getText(), texts[2].getText(), isExpense,
						categoryCb.getSelectedItem().toString(), " " + memoArea.getText());

				le.rePaint(); // 다시 그려주기~
				dispose(); // 이거 삭제
			}
		});

		mp.add(jl);
		mp.add(commitLabel);

		add(innerPanel);
		add(mp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); // 대화상자 제거
	}

	class MyWinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}

}
