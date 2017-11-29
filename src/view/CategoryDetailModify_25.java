package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Ledger;
import model.LedgerDAO;
import model.User;

//소비이력상세 편집
public class CategoryDetailModify_25 {
	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	User user;
	Ledger l;
	LedgerDAO dao;
	JTextField[] text = new JTextField[3];
	
	String pay,locate,date;
	public CategoryDetailModify_25(User user, Ledger l) {
		this.user = user;
		this.l = l;
		dao=new LedgerDAO(user);
		jf.setSize(360, 600);
		jf.setTitle("용돈조");
		System.out.println(l.toString());
		SET_IMG_Area();
		SET_Text_And_Label_Area();
		SET_Label_Area();

		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void SET_Text_And_Label_Area() {

		sub.setSize(360, 600);
		sub.setLocation(0, 60);
		sub.setLayout(null);
		sub.setBackground(Color.white);

		JLabel[] jl1 = new JLabel[6];
		jl1[0] = new JLabel("금액");
		jl1[1] = new JLabel("내역");
		jl1[2] = new JLabel("일시");
		jl1[3] = new JLabel("지출수단");
		jl1[4] = new JLabel("카테고리");
		jl1[5] = new JLabel("메모");
		for (int i = 0; i < jl1.length; i++) {
			jl1[i].setFont(new Font("맑은고딕", Font.PLAIN, 15));
			jl1[i].setLocation(20, 20 + (i * 50));
		}
		JLabel Line[] = new JLabel[5];
		for (int i = 0; i < Line.length; i++) {
			Line[i] = new JLabel();
			Line[i].setBorder(new LineBorder(Color.GRAY, 5));
			Line[i].setSize(300, 2);
			Line[i].setLocation(20, 50 + (i * 50));
			sub.add(Line[i]);
		}
		String[] category = { "외식", "카페/베이커리", "술/유흥", "마트", "생활/주거", "교통", "주유/자동차", "통신", "쇼핑", "온라인쇼핑", "뷰티",
				"영화/문화" };
		JComboBox cate_List = new JComboBox(category);
		cate_List.setSelectedIndex(0);
		cate_List.setSize(100, 25);
		cate_List.setLocation(220, 210);

		sub.add(cate_List);

		String[] money = { "현금", "체크카드" };
		JComboBox selectMoney = new JComboBox(money);
		selectMoney.setSelectedIndex(0);
		selectMoney.setSize(100, 25);
		selectMoney.setLocation(220, 160);
		sub.add(selectMoney);


		
		for (int i = 0; i < text.length; i++) {
			text[i] = new JTextField();
			text[i].setLocation(200, 10 + (i * 50));
		}
		// 텍스트필드 텍스트 초기화
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
		text[0].setText(l.getPay());
		text[1].setText(l.getLocate());
		text[2].setText(sdf.format(date1));

		// 텍스트필드 누르면 글자없어지게 마우스리스너 추가
		text[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text[0].setText("");
			}
		});

		text[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text[1].setText("");
			}
		});

		text[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text[2].setText("");
			}
		});

		for (int i = 0; i < text.length; i++) {
			text[i].setSize(120, 30);
			text[i].setVisible(true);
			sub.add(text[i]);
		}

		for (int i = 0; i < jl1.length; i++) {
			jl1[i].setSize(80, 15);
			jl1[i].setVisible(true);
			sub.add(jl1[i]);
		}

		JTextField memo = new JTextField();
		memo.setSize(330, 100);
		memo.setLocation(10, 300);
		sub.add(memo);

		JButton delete = new JButton("삭제하기");
		delete.setSize(350, 40);
		delete.setLocation(0, 460);
		delete.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		delete.setForeground(Color.white);
		delete.setBackground(Color.GRAY);
		delete.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) {
				dao.removeLedger(l);
				dao.saveLedger();
				
				jf.setVisible(false);
				new LedgerBoard(user);
			}
		});
		sub.add(delete);
		jp.add(sub);

	}

	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				new LedgerBoard(user);
			}
		});

		jp.add(jl);
	}

	public void SET_Label_Area() {// 기타 라벨 영역
		JLabel jl[] = new JLabel[2];

		jl[0] = new JLabel("소비이력편집");
		jl[1] = new JLabel("완료");

		
		jl[0].setSize(100, 20);
		jl[0].setLocation(110, 20);
		jl[0].setFont(new Font("맑은 고딕", Font.PLAIN, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(300, 20);
		jl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		
		jl[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pay = text[0].getText();
				locate = text[1].getText();
				date = text[2].getText();
				
				dao.setLedgerData(l,pay, locate, date);
				dao.saveLedger();
				jf.setVisible(false);
				new LedgerBoard(user);
			}
		});

	}

}
