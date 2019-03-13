package model;

public class SpendingAccount extends Account implements java.io.Serializable{
	
	private static final double FEE = 1.5;//the fee taken from the client with each transaction

	public SpendingAccount(int accID, String holder, double money, String typeOfAccount) {//Constructor for the SpendingAccount class
		super(accID, holder, money, typeOfAccount);//call to the super class' constructor
	}

	@Override
	public void withdraw(double amount) {////the overridden withdraw method, using the FEE attribute
		if((this.money - amount) >= FEE) {
			money = money - (amount + FEE);
		} else {
			System.out.println("Cannot withdraw");
		}
		
	}

	@Override
	public void deposit(double amount) {//the overridden deposit method, using the FEE attribute
		money = money + amount - FEE;
	}

	@Override
	public String toString() {//toString method for the SpendingAccount class
		return "SpendingAccount [accID=" + this.getAccID() + ", client=" + this.getHolder() + ", money=" + money + ", typeOfAccount="
				+ this.getTypeOfAccount() + ", FEE = 1.5 ]";
	}
	
	

}
