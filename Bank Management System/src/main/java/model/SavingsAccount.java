package model;

public class SavingsAccount extends Account implements java.io.Serializable{
	
	private double interestRate;
	private static final int MIN = 5;//the minimum amount of money that has to exist in a SavingsAccount

	public SavingsAccount(int accID, String holder, double money, String typeOfAccount, double interestRate) {//Constructor for the SavingsAccount class
		super(accID, holder, money, typeOfAccount);//call to the super class' constructor
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public void deposit(double amount) {//the overridden deposit method, using the interestRate attribute
		money = (money + amount)*interestRate;
	}
	
	@Override
	public void withdraw(double amount) {//the overridden withdraw method, using the MIN attribute
			if((this.money - amount) >= MIN) {
				money = money - amount;
			}else {
				System.out.println("Cannot withdraw");
			}
		}


	public String toString() {//toString method for the SavingsAccount class
		return "SavingsAccount [accID=" + this.getAccID() + ", client=" + this.getHolder() + ", money=" + money + ", typeOfAccount="
				+ this.getTypeOfAccount() + ", interestRate = " + this.interestRate + " ]";
	}
	

}
