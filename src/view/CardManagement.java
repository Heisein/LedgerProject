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
   JFrame jf = new JFrame("�뵷��"); // ���� ������
   JPanel jp = new JPanel(); // ���� �г�
   JPanel sub = new JPanel(); // ���� �г�
   JPanel sub1 = new JPanel(); // ���� �г�

   ArrayList<Card> cards; // �Ǽ�
   Card c;
   CardDAO carddao;

   public CardManagement(User user) {
      this.user = user;
      carddao = new CardDAO(user);
      cards =carddao.getCards();

      LabelAccount();
      showAccount();

      System.out.println("���� �α����� ���� : " + user.getUserID());

      // ���� �г� �ʱ�ȭ
      jp.setLayout(null);
      jp.setBackground(new Color(117, 102, 205));
      // ���� ������ �ʱ�ȭ
      jf.add(jp);
      jf.setSize(360, 600);
      jf.setVisible(true);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // ���� �����ִ� �г�
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
         Card c = cards.get(i); // temp������ ����� Card c
System.out.println(i);
         //checkbox�� �̿��� ����
         checkbox[i]=new JCheckBox("",false);
         checkbox[i].setSize(10,10);
         checkbox[i].setBounds(5, 70 + (i * 40), 30, 15);
         checkbox[i].setBackground(Color.WHITE);
         System.out.println(c);
         // ���� �ѷ���
         bankLabel[i] = new JLabel(c.getBankName());
         bankLabel[i].setFont(new Font("���� ���", Font.PLAIN, 16));
         bankLabel[i].setBounds(35, 70 + (i * 40), 200, 15);

         // ���α׾���
         JLabel line = new JLabel();
         line.setBorder(new LineBorder(Color.GRAY, 5));
         line.setSize(325, 2);
         line.setLocation(10, 98 + (i * 40));
         line.setVisible(true);

         // ��� ���� �ѷ���
         accountLabel[i] = new JLabel(c.getAccount());
         accountLabel[i].setFont(new Font("���� ���", Font.PLAIN, 16));
         accountLabel[i].setBounds(120,70 + (i * 40), 200, 15);
         sub.add(checkbox[i]);
         sub.add(bankLabel[i]);
         sub.add(line);
         sub.add(accountLabel[i]);
      }

      
      JButton delete=new JButton("�����ϱ�");
      delete.setSize(345,30);
      delete.setBackground(Color.white);
      delete.setLocation(0,530);
      
      delete.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(cards.size()<=1) {
               JOptionPane.showMessageDialog(jf, "�ּ� �ϳ��� ���´� �־�� �մϴ�.");
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

   // ���°��� ��� �κ�
   public void LabelAccount() {
      sub1.setSize(360, 60);
      sub1.setLayout(null);
      sub1.setLocation(0, 0);
      sub1.setBackground(new Color(117, 102, 205));

      // �ڷΰ��� ��
      ImageIcon img = new ImageIcon("images/back.png");
      JLabel jl = new JLabel(img);
      jl.setSize(50, 50);
      jl.setLocation(5, 5);

      // MainScreen_14�� �Ѿ��

      jl.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            jf.setVisible(false);
            new MainScreen_14(user);
         }
      });

      JLabel name = new JLabel("���� ���� ");
      name.setSize(150, 20);
      name.setLocation(140, 20);
      name.setForeground(Color.WHITE);
      name.setFont(new Font("���� ���", Font.BOLD, 16));
      sub1.add(name);
      sub1.add(jl);
      jp.add(sub1);
   }
}