package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LedgerDAO {
   User user;
   ArrayList<Ledger> ledgers = new ArrayList<Ledger>();
   String fileName;
   String cardNum;

   public LedgerDAO(User user) {
      this.user = user;
      cardNum = "1";
      fileName = "dats/" + user.getUserID() + "_ledger" + cardNum + ".dat";

      loadLedger();
   }

   // 총지출 계산 : 불리언이 true면 지출, 아니면 수입 계산
   public int calcTotal(boolean isExpense) {
      int result = 0;

      for (Ledger l : ledgers) {
         if (l.isExpense() == isExpense) {
            result += Integer.parseInt(l.getPay());
         }
      }

      return result;
   }

   // 총지출 계산 : 해당 카테고리의 true면 지출, false면 수입 가져오기
   public int calcTotal(String category, boolean isExpense) {
      int total = 0;

      for (Ledger l : ledgers) {
         if (category.equals(l.getCategory()) && l.isExpense() == isExpense) {
            total += Integer.parseInt(l.getPay());
         }
      }

      return total;
   }

   public void insertLedger(String pay, String locate, String date, boolean isExpense, String category,
         String comment) {
      ledgers.add(new Ledger(pay, locate, date, isExpense, category, comment));
   }

   // 레더 전체 가져오기
   public ArrayList<Ledger> getLedgers() {
      return ledgers;
   }

   // 카테고리별 레더 가져오기
   public ArrayList<Ledger> getLedgers(String category) {
      ArrayList<Ledger> categorizedLedgers = new ArrayList<Ledger>();

      for (Ledger l : ledgers) {
         if (l.getCategory().equals(category))
            categorizedLedgers.add(l);
      }

      return categorizedLedgers;
   }

   // 월별 레더 가져오기
   public ArrayList<Ledger> getLedgers(String month, boolean isMonth) {
      ArrayList<Ledger> monthListedLedgers = new ArrayList<Ledger>();

      for (Ledger l : ledgers) {
         if (l.getDate().substring(2, 4).equals(month))
            monthListedLedgers.add(l);
      }

      return monthListedLedgers;
   }

   public void setLedgers(ArrayList<Ledger> ledgers) {
      this.ledgers = ledgers;
   }

   public int calcNowMoney() {
      return 0;
   }

   public void saveLedger() {
      try (BufferedWriter bOut = new BufferedWriter(new FileWriter(fileName))) {
         for (int i = 0; i < ledgers.size(); i++) {
            bOut.write(ledgers.get(i).toString() + "\n");
         }

         System.out.println(fileName + " 파일 저장!!");
      } catch (FileNotFoundException e) {
         System.out.println(fileName + " 존재하지 않음 : 새로 만들어짐");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void loadLedger() {
      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
         while (true) {
            String str = br.readLine();

            if (str == null) {
               System.out.println(fileName + " 파일 읽기 완료");
               break;
            }

            String[] sArr = str.split(",");
            boolean isExpenseTemp = true;

            if (sArr[3].equals("true"))
               isExpenseTemp = true;
            else
               isExpenseTemp = false;

            String memoStr = "";

            if (sArr[5] != null)
               memoStr = sArr[5];

            Ledger ledgerTemp = new Ledger(sArr[0], sArr[1], sArr[2], isExpenseTemp, sArr[4], memoStr);

            ledgers.add(ledgerTemp);

         }
      } catch (FileNotFoundException e) {
         System.out.println(fileName + " 존재하지 않음!");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}