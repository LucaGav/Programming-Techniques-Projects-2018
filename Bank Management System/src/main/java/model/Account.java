package model;

public class Account implements java.io.Serializable{
	
	private int accID;
	private String holder;
	protected double money;
	private String typeOfAccount;
	
	public Account(int accID, String holder, double money, String typeOfAccount) {//constructor for the Account class
		this.accID = accID;
		this.holder = holder;
		this.money = money;
		this.typeOfAccount = typeOfAccount;
	}
	
	public void withdraw(double amount) {//the withdraw method, overridden in the subclasses of Account
		if((this.money - amount) >= 0) {
			money = money - amount;
		}else {
			System.out.println("Cannot withdraw");
		}
	}
	
	public void deposit(double amount) {//the deposit method, overridden in the subclasses of Account
		money = money + amount; 
	}
	
	/*
	 * Getters and setters for the attributes
	 */
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getTypeOfAccount() {
		return typeOfAccount;
	}
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	@Override
	public String toString() {//toString method for the Account class
		return "Account [accID=" + accID + ", client=" + holder + ", money=" + money + ", typeOfAccount="
				+ typeOfAccount + "]";
	}
	
		

}
