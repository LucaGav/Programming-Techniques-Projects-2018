import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;
import model.Account;
import model.Bank;
import model.Client;
import model.SavingsAccount;
import model.SpendingAccount;

public class TestUnit extends TestCase {
	
	public void testClientAdd() {
		Client c1 = new Client("Luca","Luca","Gavril","Address","124951953","1235");
		Bank bank = new Bank();
		bank.addClient(c1);
		assert (bank.getBank().containsKey(c1));
	}
	
	public void testClientEdit() {
		Client c1 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "1235");
		Bank bank = new Bank();
		bank.addClient(c1);
		Client c2 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "122135");
		bank.editClient(c2);
		Set aux = bank.getBank().keySet();
		Iterator<Client> iterator = aux.iterator();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (c.getSsn() == c2.getSsn()) {
				assert (c.getPassword().equals("122135"));
			}
		}
	}
	
	public void testClientRemoval() {
		Client c1 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "1235");
		Bank bank = new Bank();
		bank.addClient(c1);
		bank.removeClient("124951953");
		assert(!bank.getBank().containsKey(c1));
	}
	
	public void testAccountAdd() {
		Client c1 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "1235");
		Account a = new SavingsAccount(1,"Luca",213,"Savings",12);
		Bank bank = new Bank();
		bank.addClient(c1);
		bank.addAccount(c1, a);
		Set aux = bank.getBank().keySet();
		Iterator<Client> iterator = aux.iterator();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if(c.equals(c1)) {
				for(Account a2 : bank.getBank().get(c)) {
					assert(a2.equals(a));
				}
			}
		}
	}
	
	public void testAccountUpdate() {
		Client c1 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "1235");
		Account a = new SavingsAccount(1,"Luca",213,"Savings",12);
		Account a2 = new SpendingAccount(1,"Luca",213,"Spending");
		Bank bank = new Bank();
		bank.addClient(c1);
		bank.addAccount(c1, a);
		assert(bank.getBank().get(c1).get(0).getTypeOfAccount().equals("Savings"));
		bank.editAccount(c1, a2);
		assert(bank.getBank().get(c1).get(0).getTypeOfAccount().equals("Spending"));
		
	}
	
	public void testAccountRemoval() {
		Client c1 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "1235");
		Account a = new SavingsAccount(1,"Luca",213,"Savings",12);
		Bank bank = new Bank();
		bank.addClient(c1);
		bank.addAccount(c1, a);
		bank.removeAccount(c1, 1);
		assert(bank.getBank().get(c1).isEmpty());
	}
	
	public void testWithdraw() {
		Client c1 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "1235");
		Account a = new SavingsAccount(1,"Luca",213,"Savings",12);
		Bank bank = new Bank();
		bank.addClient(c1);
		bank.addAccount(c1, a);
		bank.withdraw(c1, 1, 12);
		double m = bank.getBank().get(c1).get(0).getMoney();
		assert(m == 201);
	}
	
	public void testDeposit() {
		Client c1 = new Client("Luca", "Luca", "Gavril", "Address", "124951953", "1235");
		Account a = new SavingsAccount(1,"Luca",213,"Savings",12);
		Bank bank = new Bank();
		bank.addClient(c1);
		bank.addAccount(c1, a);
		bank.deposit(c1, 1, 12);
		double m = bank.getBank().get(c1).get(0).getMoney();
		assert(m == 2700);
	}
	
}
