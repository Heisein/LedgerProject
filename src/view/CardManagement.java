package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Card;
import model.CardDAO;
import model.User;

public class CardManagement {
   User user;
   JFrame jf = new JFrame("용돈조"); // 메인 프레임
   JPanel jp = new JPanel(); // 메인 패널
   JPanel sub = new JPanel(); // 메인 패널
   JPanel sub1 = new JPanel(); // 메인 패널

   ArrayList<Card> cards; // 건수
   Card c;
   CardDAO carddao;

   public CardManagement(User user) {
      this.user = user;
      carddao = new CardDAO(user);
      cards =carddao.getCards();

      LabelAccount();
      showAccount();

      System.out.println("현재 로그인한 유저 : " + user.getUserID());

      // 메인 패널 초기화
      jp.setLayout(null);
      jp.setBackground(new Color(117, 102, 205));
      // 메인 프레임 초기화
      jf.add(jp);
      jf.setSize(360, 600);
      jf.setVisible(true);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // 계좌 보여주는 패널
   public void showAccount() {
      sub.setSize(360, 560);
      sub.setLayout(null);
      sub.setLocation(0, 0);
      sub.setBackground(Color.white);

      JLabel[] bankLabel = new JLabel[cards.size()];
      JLabel[] accountLabel = new JLabel[cards.size()];
      JLabel[] cardLabel = new JLabel[cards.size()];
      JCheckBox[] checkbox = new JCheckBox[cards.size()];

      
      ImageIcon card = new ImageIcon("images/card.png");

      int jTemp = cards.size() -1;
      for (int i = 0; i < cards.size(); i++) {
         Card c = cards.get(i); // temp용으로 사용할 Card c
System.out.println(i);
         //checkbox를 이용해 삭제
         checkbox[i]=new JCheckBox("",false);
         checkbox[i].setSize(10,10);
         checkbox[i].setBounds(5, 70 + (i * 40), 30, 15);
         checkbox[i].setBackground(Color.WHITE);
         System.out.println(c);
         // 은행 뿌려줌
         bankLabel[i] = new JLabel(c.getBankName());
         bankLabel[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
         bankLabel[i].setBounds(35, 70 + (i * 40), 200, 15);

         // 라인그어줌
         JLabel line = new JLabel();
         line.setBorder(new LineBorder(Color.GRAY, 5));
         line.setSize(325, 2);
         line.setLocation(10, 98 + (i * 40));
         line.setVisible(true);

         // 사용 내역 뿌려줌
         accountLabel[i] = new JLabel(c.getAccount());
         accountLabel[i].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
         accountLabel[i].setBounds(120,70 + (i * 40), 200, 15);
         sub.add(checkbox[i]);
         sub.add(bankLabel[i]);
         sub.add(line);
         sub.add(accountLabel[i]);
      }

      
      JButton delete=new JButton("삭제하기");
      delete.setSize(345,30);
      delete.setBackground(Color.white);
      delete.setLocation(0,530);
      
      delete.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(cards.size()<=1) {
               JOptionPane.showMessageDialog(jf, "최소 하나의 계좌는 있어야 합니다.");
               return;
            }
            for(int i=0; i<cards.size(); i++) {
               if(checkbox[i].isSelected()==true) {
                  carddao.removeCard(cards.get(i));
                  new CardManagement(user);
                  jf.dispose();
               }
            }
            
         }
      });
      sub.add(delete);
      jp.add(sub);
   }

   // 계좌관리 상단 부분
   public void LabelAccount() {
      sub1.setSize(360, 60);
      sub1.setLayout(null);
      sub1.setLocation(0, 0);
      sub1.setBackground(new Color(117, 102, 205));

      // 뒤로가기 라벨
      ImageIcon img = new ImageIcon("images/back.png");
      JLabel jl = new JLabel(img);
      jl.setSize(50, 50);
      jl.setLocation(5, 5);

      // MainScreen_14로 넘어가기

      jl.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            jf.setVisible(false);
            new MainScreen_14(user);
         }
      });

      JLabel name = new JLabel("계좌 관리 ");
      name.setSize(150, 20);
      name.setLocation(140, 20);
      name.setForeground(Color.WHITE);
      name.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      sub1.add(name);
      sub1.add(jl);
      jp.add(sub1);
   }
}