package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Bank implements BankProc {

	private HashMap<Client, ArrayList<Account>> bank;//HashMap attribute of the Bank class

	public Bank() {
		bank = new HashMap<Client, ArrayList<Account>>();//instantiate a new HashMap when creating a new Bank object
	}

	public HashMap<Client, ArrayList<Account>> getBank() {
		return bank;
	}

	public void setBank(HashMap<Client, ArrayList<Account>> bank) {
		this.bank = bank;
	}
	
	/*
	 * Each method defined in the BankProc interface has their respective
	 * pre and postconditions checked, using the assert statement
	 */

	public void addClient(Client client) {//add a client to the bank
		assert(client != null) : "NULL client";
		ArrayList<Account> accounts = new ArrayList();
		if (bank.containsKey(client) == false) {
			bank.put(client, accounts);
			System.out.println("Client:" + client + "was introduced in bank");
		} else {
			System.out.println("Client already in bank");
		}
	}

	public void editClient(Client client) {//edit a client in the bank
		assert(client != null) : "NULL client";
		// TODO Auto-generated method stub
		Set aux = bank.keySet();
		int check = 0;
		Iterator<Client> iterator = aux.iterator();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (c.getSsn().equals(client.getSsn())) {
				check = 1;
				c.setUsername(client.getUsername());
				c.setFirstname(client.getFirstname());
				c.setLastname(client.getLastname());
				c.setAddress(client.getAddress());
				c.setPassword(client.getPassword());
			}
		}
		assert (check != 0) : "No client with matching ssn found";
	}

	public void removeClient(String ssn) {//remove a client from the bank
		assert(ssn != null) : "Invalid ssn";
		// TODO Auto-generated method stub
		HashMap<Client, ArrayList<Account>> bankaux = new HashMap<Client, ArrayList<Account>>();
		Set aux = bank.keySet();
		int s = bank.size();
		Iterator<Client> iterator = aux.iterator();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (!c.getSsn().equals(ssn)) {
				bankaux.put(c, bank.get(c));
			}
		}
		bank = bankaux;
		assert(bank.size() == s-1) : "The size is the same, no removal";
	}

	public void addAccount(Client client, Account account) {//add an account to the bank
		assert(account != null) : "NULL account";
		assert(client!= null) : "NULL client";
		int check = 0;
		Set aux = bank.keySet();
		Iterator<Client> iterator = aux.iterator();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (c.equals(client)) {
				check = 1;
				bank.get(c).add(account);
			}
		}
		
		assert(check != 0) : "Client not found";
	}

	public void editAccount(Client client, Account account) {//edit an account's type from the bank
		assert(account != null) : "NULL account";
		assert(client!= null) : "NULL client";
		int check = 0;
		Set aux = bank.keySet();
		Iterator<Client> iterator = aux.iterator();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (c.equals(client)) {
				check = 1;
				for (Account a : bank.get(c)) {
					if (a.getAccID() == account.getAccID()) {
						String s = account.getTypeOfAccount();
						System.out.println(s);
						a.setTypeOfAccount(s);
					}
				}
			}
		}
		assert(check != 0) : "Client not found";
	}

	public void removeAccount(Client client, int accID) {//remove an account from the bank
		assert(accID != 0) : "NULL account id";
		assert(client!= null) : "NULL client";
		int check = 0;
		Set aux = bank.keySet();
		Iterator<Client> iterator = aux.iterator();
		ArrayList<Account> accounts = new ArrayList<Account>();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (c.equals(client)) {
				check = 1;
				for (Account a : bank.get(c)) {
					if (a.getAccID() != accID) {
						accounts.add(a);
					}
					bank.put(c, accounts);
				}	
			}
		}
		assert(check != 0) : "Client not found";
	}

	@Override
	public void deposit(Client client, int accId, double amount) {//deposit an amount of money to an account specified by the accId
		// TODO Auto-generated method stub
		assert (client != null) : "NULL Client";
		assert (accId != 0) : "NULL accId";
		assert (amount > 0) : "Bad amount";
		Set aux = bank.keySet();
		Iterator<Client> iterator = aux.iterator();
		ArrayList<Account> accounts = new ArrayList<Account>();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (c.equals(client)) {
				for (Account a : bank.get(c)) {
					if (a.getAccID() == accId) {
						a.deposit(amount);
						System.out.println(a.toString());
					}
				}
				System.out.println("Account with accountid" + accId + "received an amount = " + amount);
			}
		}
	}

	@Override
	public void withdraw(Client client, int accId, double amount) {//withdraw an amount of money from an account specified by the accId
		assert(client!=null) : "NULL Client";
		assert(accId!=0) : "NULL accId";
		assert(amount > 0) : "Bad amount";
		Set aux = bank.keySet();
		Iterator<Client> iterator = aux.iterator();
		ArrayList<Account> accounts = new ArrayList<Account>();
		while (iterator.hasNext()) {
			Client c = iterator.next();
			if (c.equals(client)) {
				for (Account a : bank.get(c)) {
					if (a.getAccID() == accId) {
						a.withdraw(amount);
						System.out.println(a.toString());
					}
				}
				System.out.println("Account with accountid" + accId + "withdrew an amount = " + amount);
			} 
		}
	}
	
	public void readBank() {//method that uses java.io components to get bank information from the bank.txt file
		try {
			FileInputStream bankdata = new FileInputStream("bank.txt");
			ObjectInputStream object = new ObjectInputStream(bankdata);
			this.bank = (HashMap<Client, ArrayList<Account>>) object.readObject();
			object.close();
			bankdata.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeBank() {//method that uses java.io components to write bank information to the bank.txt file
		try {
			FileOutputStream bankdata2 = new FileOutputStream("bank.txt");
			ObjectOutputStream object = new ObjectOutputStream(bankdata2);
			object.writeObject(bank);
			object.close();
			bankdata2.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
