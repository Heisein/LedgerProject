package model;

public class Card implements java.io.Serializable{
	private String userID;
	private String account;
	private String bankName;
	public Card() {
		
	}
	public Card(String userID,String account, String bankName) {
		this.userID=userID;
		this.account=account;
		this.bankName=bankName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return userID + "," + account + "," + bankName;
	}
	
}

