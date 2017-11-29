package model;

public class Ledger implements java.io.Serializable, Comparable{
	private static final long serialVersionUID = 1L;
	private String pay;
	private String locate;
	private String date;
	private boolean isExpense;
	private String category;
	private String comment;

	public Ledger() {

	}

	public Ledger(String pay, String locate, String date, boolean isExpense, String category, String comment) {
		super();
		this.pay = pay;
		this.locate = locate;
		this.date = date;
		this.isExpense = isExpense;
		this.category = category;
		this.comment = comment;
	}
	
	@Override
	public String toString(){
		return pay + "," + locate + "," + date + "," + isExpense + "," + category + "," + comment;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public boolean isExpense() {
		return isExpense;
	}

	public void setExpense(boolean isExpense) {
		this.isExpense = isExpense;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int compareTo(Object o) {
		Ledger l = (Ledger) o;
		int thisDate = Integer.parseInt(this.date);
		int otherDate = Integer.parseInt(l.getDate());
		
		return thisDate - otherDate;
		
	}

}
