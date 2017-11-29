package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LedgerDAO{
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
	
	// ������ ��� : ���ڰ� ������ ��ü
	public int calcTotal(){
	int total = 0;
		
		for(Ledger l : ledgers){
			if(l.isExpense()){
				total += Integer.parseInt(l.getPay());
			}
		}
		
		return total;
	}
	
	// ������ ��� : ���ڰ� ������ �ش� ī�װ���
	public int calcTotal(String category){
		int total = 0;
		
		for(Ledger l : ledgers){
			if(category.equals(l.getCategory()) && l.isExpense()){
				total += Integer.parseInt(l.getPay());
			}
		}
		
		return total;
	}

	public void insertLedger(String pay, String locate, String date, boolean isExpense, String category,
			String comment) {
		ledgers.add(new Ledger(pay, locate, date, isExpense, category, comment));
	}

	public ArrayList<Ledger> getLedgers() {
		return ledgers;
	}
	
	public ArrayList<Ledger> getLedgers(String category) {
		ArrayList<Ledger> categorizedLedgers = new ArrayList<Ledger>();
		
		for(Ledger l : ledgers){
			if(l.getCategory().equals(category))
				categorizedLedgers.add(l);
		}
		
		return categorizedLedgers;
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
			
			System.out.println(fileName + " ���� ����!!");
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " �������� ���� : ���� �������");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadLedger() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while (true) {
				String str = br.readLine();

				if (str == null) {
					System.out.println(fileName + " ���� �б� �Ϸ�");
					break;
				}

				String[] sArr = str.split(",");
				boolean isExpenseTemp = true;

				if (sArr[3].equals("true"))
					isExpenseTemp = true;
				else
					isExpenseTemp = false;

				String memoStr = "";
				
				if(sArr[5] != null) memoStr = sArr[5];
				
				Ledger ledgerTemp = new Ledger(sArr[0], sArr[1], sArr[2], isExpenseTemp, sArr[4], memoStr);

				ledgers.add(ledgerTemp);

			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " �������� ����!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}