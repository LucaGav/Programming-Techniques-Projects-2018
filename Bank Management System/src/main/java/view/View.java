package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JPanel {
	
	private JFrame framelog;
	private JFrame frameadmin;
	private JFrame frameadmin2;
	private JFrame frameclient;
	private JTextField user;
	private JPasswordField pass;
	private JButton admin;
	private JButton login;
	private JButton addClient;
	private JButton editClient;
	private JButton deleteClient;
	private JButton addAccount;
	private JButton deleteAccount;
	private JButton updateAccount;
	private JButton withdrawS;
	private JButton depositS;
	private JTextField username;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField address;
	private JTextField ssn;
	private JPasswordField password;
	private JTextField accID;
	private JTextField clientAcc;
	private JTextField moneys;
	private JTextField typeOfAccountt;
	private JTextField interestRatee;
	private JTable clients;
	private JTable accounts;
	DefaultTableModel tablemodel;
	DefaultTableModel tablemodel2;
	private JScrollPane c;
	private JScrollPane a;
	private JTextField idwithdr;
	private JTextField iddeposit;
	private JTextField sumwithdr;
	private JTextField sumdeposit;
	private JPanel panel1;
	private JPanel panel2;
	private JButton save;
	
	public View() {
		JLabel labeluser = new JLabel();
		JLabel labelpass = new JLabel();
		JLabel labelusername = new JLabel();
		JLabel labelfirstname = new JLabel();
		JLabel labellastname = new JLabel();
		JLabel labeladdress = new JLabel();
		JLabel labelssn = new JLabel();
		JLabel labelpassword = new JLabel();
		JLabel labelinfolog = new JLabel();
		JLabel client = new JLabel();
		JLabel account = new JLabel();
		JLabel id = new JLabel();
		JLabel clientAc = new JLabel();
		JLabel money = new JLabel();
		JLabel typeOfAccount = new JLabel();
		JLabel interestRate = new JLabel();
		JLabel withdraw = new JLabel();
		JLabel deposit = new JLabel();
		JLabel idtodeposit = new JLabel();
		JLabel sumtodeposit = new JLabel();
		JLabel idtowithdraw = new JLabel();
		JLabel sumtowithdraw = new JLabel();
		
		framelog = new JFrame();
		framelog.setBounds(100, 100, 300, 300);
		framelog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//press X, it exits, not closes!
		framelog.getContentPane().setLayout(null);
		
		frameadmin = new JFrame();
		frameadmin.setBounds(100,100,600,600);
		frameadmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameadmin.getContentPane().setLayout(null);
		
		frameadmin2 = new JFrame();
		frameadmin2.setBounds(100,100,600,600);
		frameadmin2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameadmin2.getContentPane().setLayout(null);
		
		frameclient = new JFrame();
		frameclient.setBounds(100,100,400,350);
		frameclient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameclient.getContentPane().setLayout(null);
		
		labeluser.setBounds(20, 60, 70, 20);
		labeluser.setText("Username:");
		framelog.getContentPane().add(labeluser);
		
		labelpass.setBounds(20, 90, 70, 20);
		labelpass.setText("Password:");
		framelog.getContentPane().add(labelpass);
		
		labelinfolog.setBounds(20, 20, 200, 20);
		labelinfolog.setText("Login Frame:");
		framelog.getContentPane().add(labelinfolog);
		
		user = new JTextField();
		user.setBounds(100, 60, 100, 20);
		framelog.getContentPane().add(user);
		
		pass = new JPasswordField();
		pass.setBounds(100, 90, 100, 20);
		framelog.getContentPane().add(pass);
		
		admin = new JButton("ADMIN");
		admin.setBounds(20, 130, 100, 20);
		framelog.getContentPane().add(admin);
		
		login = new JButton("LOGIN");
		login.setBounds(150, 130, 100, 20);
		framelog.getContentPane().add(login);
		
		save = new JButton("Save");
		save.setBounds(10, 200, 80, 20);
		framelog.getContentPane().add(save);
		
		client.setBounds(20, 20 , 80, 20);
		client.setText("Client:");
		frameadmin.getContentPane().add(client);
		
		labelusername.setBounds(20, 50 , 80, 20);
		labelusername.setText("Username:");
		frameadmin.getContentPane().add(labelusername);
		
		labelfirstname.setBounds(20, 80 , 80, 20);
		labelfirstname.setText("First Name:");
		frameadmin.getContentPane().add(labelfirstname);
		
		labellastname.setBounds(20, 110 , 80, 20);
		labellastname.setText("Last Name:");
		frameadmin.getContentPane().add(labellastname);
		
		labeladdress.setBounds(20, 140 , 80, 20);
		labeladdress.setText("Address:");
		frameadmin.getContentPane().add(labeladdress);
		
		labelssn.setBounds(20, 170 , 80, 20);
		labelssn.setText("SSN:");
		frameadmin.getContentPane().add(labelssn);
		
		labelpassword.setBounds(20, 200 , 80, 20);
		labelpassword.setText("Password:");
		frameadmin.getContentPane().add(labelpassword);
		
		account.setBounds(20, 20, 80, 20);
		account.setText("Account:");
		frameadmin2.getContentPane().add(account);
		
		id.setBounds(20, 50, 80, 20);
		id.setText("AccountID:");
		frameadmin2.getContentPane().add(id);
		
		clientAc.setBounds(20, 80, 80, 20);
		clientAc.setText("Client:");
		frameadmin2.getContentPane().add(clientAc);
		
		money.setBounds(20, 110, 80, 20);
		money.setText("Sum account:");
		frameadmin2.getContentPane().add(money);
		
		typeOfAccount.setBounds(20, 140, 80, 20);
		typeOfAccount.setText("TypeofAcc:");
		frameadmin2.getContentPane().add(typeOfAccount);
		
		interestRate.setBounds(20, 170, 80, 20);
		interestRate.setText("InterestRate:");
		frameadmin2.getContentPane().add(interestRate);
		
		username = new JTextField();
		username.setBounds(110, 50, 100, 20);
		frameadmin.getContentPane().add(username);
		
		firstname = new JTextField();
		firstname.setBounds(110, 80, 100, 20);
		frameadmin.getContentPane().add(firstname);
		
		lastname = new JTextField();
		lastname.setBounds(110, 110, 100, 20);
		frameadmin.getContentPane().add(lastname);
		
		address = new JTextField();
		address.setBounds(110, 140, 100, 20);
		frameadmin.getContentPane().add(address);
		
		ssn = new JTextField();
		ssn.setBounds(110, 170, 100, 20);
		frameadmin.getContentPane().add(ssn);
		
		password = new JPasswordField();
		password.setBounds(110, 200, 100, 20);
		frameadmin.getContentPane().add(password);
		
		accID = new JTextField();
		accID.setBounds(110, 50, 100, 20);
		frameadmin2.getContentPane().add(accID);
		
		clientAcc = new JTextField();
		clientAcc.setBounds(110, 80, 100, 20);
		frameadmin2.getContentPane().add(clientAcc);
		
		moneys = new JTextField();
		moneys.setBounds(110, 110, 100, 20);
		frameadmin2.getContentPane().add(moneys);
		
		typeOfAccountt = new JTextField();
		typeOfAccountt.setBounds(110, 140, 100, 20);
		frameadmin2.getContentPane().add(typeOfAccountt);
		
		interestRatee = new JTextField();
		interestRatee.setBounds(110, 170, 100, 20);
		frameadmin2.getContentPane().add(interestRatee);
		
		addAccount = new JButton("Add Account");
		addAccount.setBounds(230, 60, 140, 20);
		frameadmin2.getContentPane().add(addAccount);
		
		updateAccount = new JButton("Update Account");
		updateAccount.setBounds(230, 110, 140, 20);
		frameadmin2.getContentPane().add(updateAccount);
		
		
		deleteAccount = new JButton("Remove Account");
		deleteAccount.setBounds(230, 160, 140, 20);
		frameadmin2.getContentPane().add(deleteAccount);
		
		addClient = new JButton("Add Client");
		addClient.setBounds(230, 50, 140, 20);
		frameadmin.getContentPane().add(addClient);
		
		editClient = new JButton("Edit Client");
		editClient.setBounds(230, 100, 140, 20);
		frameadmin.getContentPane().add(editClient);
		
		deleteClient = new JButton("Remove Client");
		deleteClient.setBounds(230, 150, 140, 20);
		frameadmin.getContentPane().add(deleteClient);
		
		/*
		 *Add the two panels to their respective frames. Create the JTables 
		 */
		
		panel1 = new JPanel();
		panel1.setBounds(0, 250, 600, 350);
		frameadmin.getContentPane().add(panel1);
		Object[] columns = {"Username","FirstName","LastName","Address","SSN","Password"};
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columns);
		clients = new JTable();
		clients.setModel(tablemodel);
		
		JScrollPane scroll = new JScrollPane(clients,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel1.add(scroll);
		panel1.setVisible(true);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 250, 600, 350);
		frameadmin2.getContentPane().add(panel2);
		
		Object[] columnsa = {"AccountID","Client","Sum","Type Of Account"};
		tablemodel2 = new DefaultTableModel();
		tablemodel2.setColumnIdentifiers(columnsa);
		accounts = new JTable();
		accounts.setModel(tablemodel2);
		
		JScrollPane scroll2 = new JScrollPane(accounts,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel2.add(scroll2);
		panel2.setVisible(true);
		
		deposit.setBounds(20, 20, 70, 20);
		deposit.setText("Deposit:");
		frameclient.getContentPane().add(deposit);
		
		idtodeposit.setBounds(20, 50, 120, 20);
		idtodeposit.setText("AccountID:");
		frameclient.getContentPane().add(idtodeposit);
		
		sumtodeposit.setBounds(20, 80, 120, 20);
		sumtodeposit.setText("Sum to deposit:");
		frameclient.getContentPane().add(sumtodeposit);
		
		withdraw.setBounds(20, 150, 70, 20);
		withdraw.setText("Withdraw");
		frameclient.getContentPane().add(withdraw);
		
		idtowithdraw.setBounds(20, 180, 70, 20);
		idtowithdraw.setText("AccountID:");
		frameclient.getContentPane().add(idtowithdraw);
		
		sumtowithdraw.setBounds(20, 210, 120, 20);
		sumtowithdraw.setText("Sum to withdraw:");
		frameclient.getContentPane().add(sumtowithdraw);
		
		idwithdr = new JTextField();
		idwithdr.setBounds(140, 180, 100, 20);
		frameclient.getContentPane().add(idwithdr);
		
		sumwithdr = new JTextField();
		sumwithdr.setBounds(140, 210, 100, 20);
		frameclient.getContentPane().add(sumwithdr);
		
		iddeposit = new JTextField();
		iddeposit.setBounds(140,50,100,20);
		frameclient.getContentPane().add(iddeposit);
		
		sumdeposit = new JTextField();
		sumdeposit.setBounds(140,80,100,20);
		frameclient.getContentPane().add(sumdeposit);
		
		depositS = new JButton("Deposit");
		depositS.setBounds(250, 70, 100, 20);
		frameclient.getContentPane().add(depositS);
		
		withdrawS = new JButton("Withdraw");
		withdrawS.setBounds(250, 195 , 100, 20);
		frameclient.getContentPane().add(withdrawS);	
		
	}
	
	public void Save(ActionListener e) {
		this.save.addActionListener(e);
	}
	public JTextField getIdwithdr() {
		return idwithdr;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public void setIdwithdr(JTextField idwithdr) {
		this.idwithdr = idwithdr;
	}

	public JTextField getIddeposit() {
		return iddeposit;
	}

	public void setIddeposit(JTextField iddeposit) {
		this.iddeposit = iddeposit;
	}

	public JTextField getSumwithdr() {
		return sumwithdr;
	}

	public void setSumwithdr(JTextField sumwithdr) {
		this.sumwithdr = sumwithdr;
	}

	public JTextField getSumdeposit() {
		return sumdeposit;
	}

	public void setSumdeposit(JTextField sumdeposit) {
		this.sumdeposit = sumdeposit;
	}

	public void addClient(ActionListener e) {
		this.addClient.addActionListener(e);
	}
	
	public void editClient(ActionListener e) {
		this.editClient.addActionListener(e);
	}
	
	public void deleteClient(ActionListener e) {
		this.deleteClient.addActionListener(e);
	}
	
	public void addAccount(ActionListener e) {
		this.addAccount.addActionListener(e);
	}
	
	public void updateAccount(ActionListener e) {
		this.updateAccount.addActionListener(e);
	}
	
	public void deleteAccount(ActionListener e) {
		this.deleteAccount.addActionListener(e);
	}
	
	public void deposit(ActionListener e) {
		this.depositS.addActionListener(e);
	}
	
	public void withdraw(ActionListener e) {
		this.withdrawS.addActionListener(e);
	}
	
	public void adminB(ActionListener e) {
		this.admin.addActionListener(e);
	}
	
	public void loginB(ActionListener e) {
		this.login.addActionListener(e);
	}

	public JFrame getFramelog() {
		return framelog;
	}

	public void setFramelog(JFrame framelog) {
		this.framelog = framelog;
	}

	public JFrame getFrameadmin() {
		return frameadmin;
	}

	public void setFrameadmin(JFrame frameadmin) {
		this.frameadmin = frameadmin;
	}

	public JFrame getFrameclient() {
		return frameclient;
	}

	public void setFrameclient(JFrame frameclient) {
		this.frameclient = frameclient;
	}

	public JTextField getUser() {
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public JPasswordField getPass() {
		return pass;
	}

	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}

	public JButton getAdmin() {
		return admin;
	}

	public void setAdmin(JButton admin) {
		this.admin = admin;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getAddClient() {
		return addClient;
	}

	public void setAddClient(JButton addClient) {
		this.addClient = addClient;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getFirstname() {
		return firstname;
	}

	public void setFirstname(JTextField firstname) {
		this.firstname = firstname;
	}

	public JTextField getLastname() {
		return lastname;
	}

	public void setLastname(JTextField lastname) {
		this.lastname = lastname;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getSsn() {
		return ssn;
	}

	public void setSsn(JTextField ssn) {
		this.ssn = ssn;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	
	public void initlog() {
		framelog.setVisible(true);
		framelog.setResizable(false);
	}
	
	public void initadmin() {
		frameadmin.setVisible(true);
		frameadmin.setResizable(false);
		
	}
	
	public void initadmin2() {
		frameadmin2.setVisible(true);
		frameadmin2.setResizable(false);
		
	}
	
	public void initclient() {
		frameclient.setVisible(true);
		frameclient.setResizable(false);
	}
		
	public DefaultTableModel getTablemodel() {
		return tablemodel;
	}

	public void setTablemodel(DefaultTableModel tablemodel) {
		this.tablemodel = tablemodel;
	}

	public JTextField getAccID() {
		return accID;
	}

	public void setAccID(JTextField accID) {
		this.accID = accID;
	}

	public JTextField getClientAcc() {
		return clientAcc;
	}

	public void setClientAcc(JTextField clientAcc) {
		this.clientAcc = clientAcc;
	}

	public JTextField getMoneys() {
		return moneys;
	}

	public void setMoneys(JTextField moneys) {
		this.moneys = moneys;
	}

	public JTextField getTypeOfAccountt() {
		return typeOfAccountt;
	}

	public void setTypeOfAccountt(JTextField typeOfAccountt) {
		this.typeOfAccountt = typeOfAccountt;
	}

	public JTextField getInterestRatee() {
		return interestRatee;
	}

	public void setInterestRatee(JTextField interestRatee) {
		this.interestRatee = interestRatee;
	}

	public DefaultTableModel getTablemodel2() {
		return tablemodel2;
	}

	public void setTablemodel2(DefaultTableModel tablemodel2) {
		this.tablemodel2 = tablemodel2;
	}


	
}
