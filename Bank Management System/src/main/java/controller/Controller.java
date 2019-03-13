package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

import model.Account;
import model.Bank;
import model.Client;
import model.SavingsAccount;
import model.SpendingAccount;
import view.View;

public class Controller {
	
	private View view;
	private Bank bank;
	
	public Controller() {
		//We first initialize the two attributes, view and bank
		view = new View();
		view.initlog();
		bank = new Bank();
		//call the readBank method to read form the file "bank.txt"
		bank.readBank();
		
		
		/*
		 * Call the specific actionListener methods from the View class.
		 * Implement the required functionalities of the buttons
		 */
		view.adminB(e->{
			
			String pass = String.valueOf(view.getPass().getPassword());
			String user = view.getUser().getText();
			System.out.println(view.getUser().getText());
			if(user.equals("admin") && pass.equals("admin")) {
				view.initadmin();
				view.initadmin2();
				JOptionPane.showMessageDialog(null, "Successful login");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Bad login input");
			}
		});
		
		view.addClient(e->{
			view.getTablemodel().setRowCount(0);
			String pass = String.valueOf(view.getPassword().getPassword());
			Client c1 = new Client(view.getUsername().getText(),view.getFirstname().getText(),view.getLastname().getText(),view.getAddress().getText(),
					view.getSsn().getText(),pass);
			bank.addClient(c1);
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				String s = c.toString();
				System.out.println(s);
				view.getTablemodel().addRow(new Object[] {c.getUsername(),c.getFirstname(),c.getLastname(),c.getAddress(),c.getSsn(),c.getPassword()});
			}
			
			JOptionPane.showMessageDialog(null, "Client was added");
			
		});
		
		view.editClient(e->{
			view.getTablemodel().setRowCount(0);
			String pass = String.valueOf(view.getPassword().getPassword());
			Client c1 = new Client(view.getUsername().getText(),view.getFirstname().getText(),view.getLastname().getText(),view.getAddress().getText(),
					view.getSsn().getText(),pass);
			bank.editClient(c1);
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				String s = c.toString();
				System.out.println(s);
				view.getTablemodel().addRow(new Object[] {c.getUsername(),c.getFirstname(),c.getLastname(),c.getAddress(),c.getSsn(),c.getPassword()});
			}
			
			JOptionPane.showMessageDialog(null, "Client with ssn " + view.getSsn().getText() + " edited");
			
		});
		view.deleteClient(e->{
			
			view.getTablemodel().setRowCount(0);
			bank.removeClient(view.getSsn().getText());
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				String s = c.toString();
				System.out.println(s);
				view.getTablemodel().addRow(new Object[] {c.getUsername(),c.getFirstname(),c.getLastname(),c.getAddress(),c.getSsn(),c.getPassword()});
				}
			
			JOptionPane.showMessageDialog(null, "Client was deleted");
		});
		
		view.addAccount(e->{
			Account a = null;
			int accId = Integer.valueOf(view.getAccID().getText());
			String username = view.getClientAcc().getText();
			double money = Double.valueOf(view.getMoneys().getText());
			String type = view.getTypeOfAccountt().getText();
			double interest = Double.valueOf(view.getInterestRatee().getText());
			if(type.equals("Savings")) {
				a = new SavingsAccount(accId,username,money,type,interest);
				System.out.println(a.toString());
			}else if(type.equals("Spending")) {
				a = new SpendingAccount(accId,username,money,type);
				System.out.println(a.toString());
				view.getInterestRatee().setText("Unavailable");
			}else if(!type.equals("Spending") && !type.equals("Savings")) {
				JOptionPane.showMessageDialog(null, "Account must be of type Savings or Spending");
			}
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				if(c.getUsername().equals(username)) {
					bank.addAccount(c, a);
				    view.getTablemodel2().addRow(new Object[] {a.getAccID(),a.getHolder(),a.getMoney(),a.getTypeOfAccount()});	
				}
			}
			
			JOptionPane.showMessageDialog(null,"Account was added to client: " + username);	
		});
		
		view.updateAccount(e->{
			Account a = null;
			view.getTablemodel2().setRowCount(0);
			int accId = Integer.valueOf(view.getAccID().getText());
			String username = view.getClientAcc().getText();
			double money = Double.valueOf(view.getMoneys().getText());
			String type = view.getTypeOfAccountt().getText();
			double interest = Double.valueOf(view.getInterestRatee().getText());
			if(type.equals("Savings")) {
				a = new SavingsAccount(accId,username,money,type,interest);
				System.out.println(a.toString());
			}else if(type.equals("Spending")) {
				a = new SpendingAccount(accId,username,money,type);
				System.out.println(a.toString());
				view.getInterestRatee().setText("Unavailable");
			}else if(!type.equals("Spending") && !type.equals("Savings")) {
				JOptionPane.showMessageDialog(null, "Account must be of type Savings or Spending");
			}
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				if(c.getUsername().equals(username)) {
					bank.editAccount(c, a);
						}
				for(Account it : b.get(c)) {
					view.getTablemodel2().addRow(new Object[] {it.getAccID(),it.getHolder(),it.getMoney(),it.getTypeOfAccount()});	
				}
			}
			JOptionPane.showMessageDialog(null, "Account was edited");
						
		});
		view.deleteAccount(e->{
			Account a = null;
			view.getTablemodel2().setRowCount(0);
			int accId = Integer.valueOf(view.getAccID().getText());
			String username = view.getClientAcc().getText();
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				if(c.getUsername().equals(username)) {
					bank.removeAccount(c, accId);
				}
				for(Account it: b.get(c)) {
					view.getTablemodel2().addRow(new Object[] {it.getAccID(),it.getHolder(),it.getMoney(),it.getTypeOfAccount()});
				}
			}
			JOptionPane.showMessageDialog(null, "Account with id " + accId + " was deleted");
		});
		
		view.loginB(e->{
			String pass = String.valueOf(view.getPass().getPassword());
			String user = view.getUser().getText();
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();	
			if(user.equals(c.getUsername()) && pass.equals(c.getPassword())) {
				view.initclient();
				JOptionPane.showMessageDialog(null, "Successful login");
			}
			}
			if(!view.getFrameclient().isVisible()) {
				JOptionPane.showMessageDialog(null, "Bad login input");
			}
		});
		
		view.deposit(e->{
			view.getTablemodel2().setRowCount(0);
			int id = Integer.valueOf(view.getIddeposit().getText());
			double sum = Double.valueOf(view.getSumdeposit().getText());
			String user = view.getUser().getText();
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				if(c.getUsername().equals(user)) {
				for(Account a: b.get(c)) {
					if(a.getAccID() == id) {
						bank.deposit(c, id, sum);
						}
					}
				}
				for(Account a: b.get(c)) {
					view.getTablemodel2().addRow(new Object[] {a.getAccID(),a.getHolder(),a.getMoney(),a.getTypeOfAccount()});
					}
				}
				
			JOptionPane.showMessageDialog(null, "Successful deposit");
		});
		
		view.withdraw(e->{
			view.getTablemodel2().setRowCount(0);
			int id = Integer.valueOf(view.getIdwithdr().getText());
			double sum = Double.valueOf(view.getSumwithdr().getText());
			String user = view.getUser().getText();
			HashMap<Client, ArrayList<Account>> b = bank.getBank();
			Set aux = b.keySet();
			Iterator<Client> iterator = aux.iterator();
			while(iterator.hasNext()) {
				Client c = iterator.next();
				if(c.getUsername().equals(user)) {
				for(Account a: b.get(c)) {
					if(a.getAccID() == id) {
						bank.withdraw(c, id, sum);
						}
					}
				}
				for(Account a: b.get(c)) {
					view.getTablemodel2().addRow(new Object[] {a.getAccID(),a.getHolder(),a.getMoney(),a.getTypeOfAccount()});
					}
				}
			
			JOptionPane.showMessageDialog(null, "Successful withdrawal");
		});
		
		view.Save(e->{
			try{
				bank.writeBank();
			}catch(Exception es) {
				es.printStackTrace();
			}
		});
		
		
	}
	
	

}
