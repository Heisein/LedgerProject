package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CardDAO {
	ArrayList<Card> cards = new ArrayList<Card>();
	User user;
	Card card;
	String fileName;
	String cardNum;
	public CardDAO(User user) {
		this.user = user;
		cardNum ="1";
		fileName = "dats/" + user.getUserID() + ".dat";
		loadCard();
	}
	
	
	public void insertCard(String userID,String account,String bankName) {
		cards.add(new Card(userID,account,bankName));
		this.saveCard();
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void setCardData(Card c, String userID, String account, String bankName) {
		for(Card ctemp : cards) {
			if(c.getUserID().equals(ctemp.getUserID())&&c.getAccount().equals(ctemp.getAccount())&&c.getBankName().equals(ctemp.getAccount())) {
				ctemp.setUserID(userID);
				ctemp.setAccount(account);;
				ctemp.setBankName(bankName);;
				
			}
		}
	}
	
	public void removeCard(Card c) {
		Card c2 = null;
		for(int i = 0; i < cards.size(); i++)	{
			c2 = cards.get(i);
			if(c.getUserID().equals(c2.getUserID()) && c.getAccount().equals(c2.getAccount()) 
					&& c.getBankName().equals(c2.getBankName())) {
				cards.remove(c2);
			}
		}
	}
	
	public void setCard(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	
	public void saveCard() {
		try (BufferedWriter bOut = new BufferedWriter(new FileWriter(fileName))) {
			for (int i = 0; i < cards.size(); i++) {
				bOut.write(cards.get(i).toString() + "\n");
			}
			
			System.out.println(fileName + " 파일 저장!!");
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 존재하지 않음 : 새로 만들어짐");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadCard() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while (true) {
				String str = br.readLine();

				if (str == null) {
					System.out.println(fileName + " 파일 읽기 완료");
					break;
				}

				String[] sArr = str.split(",");

				Card cardTemp = new Card(sArr[0], sArr[1], sArr[2]);

				cards.add(cardTemp);

			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 존재하지 않음!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
