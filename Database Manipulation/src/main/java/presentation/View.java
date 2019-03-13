package presentation;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JPanel {
	
	private JButton buttonDelC;
	private JButton buttonInsC;
	private JButton buttonUpC;
	private JButton buttonDelP;
	private JButton buttonInsP;
	private JButton buttonUpP;
	private JButton buttonDelO;
	private JButton buttonInsO;
	private JButton buttonViewClients;
	private JButton buttonViewProducts;
	private JTextField id;
	private JTextField namec;
	private JTextField address;
	private JTextField email;
	private JTextField phoneNumber;
	private JTextField idprod;
	private JTextField prodName;
	private JTextField Manufacturer;
	private JTextField stock;
	private JTextField cusId;
	private JTextField prodId;
	private JTextField quantity;
	private JFrame frame;
	private JLabel stocklabel;
	private JTable jtable;
	private JFrame framecl;
	private JFrame framepr;
	
	public View() {
		
		JLabel labelid = new JLabel();
		JLabel labelname = new JLabel();
		JLabel labeladdress = new JLabel();
		JLabel labelemail = new JLabel();
		JLabel labelphoneNumber = new JLabel();
		JLabel labelcustomer = new JLabel ();
		JLabel labelidpr = new JLabel();
		JLabel labelprName = new JLabel();
		JLabel labelprMan = new JLabel();
		JLabel labelStock = new JLabel();
		JLabel labelproduct = new JLabel();
		JLabel labelcusId = new JLabel();
		JLabel labelprodId = new JLabel();
		JLabel labelquant = new JLabel();
		JLabel labelorder = new JLabel();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//press X, it exits, not closes!
		frame.getContentPane().setLayout(null);
		
		framecl = new JFrame();
		framecl.setSize(600, 500);
		framecl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		framepr = new JFrame();
		framepr.setSize(600, 500);
		framepr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		labelcustomer.setBounds(20, 10, 70, 20);
		labelcustomer.setText("Customer:");
		frame.getContentPane().add(labelcustomer);
		
		stocklabel = new JLabel();
		stocklabel.setBounds(20,680, 500 , 30);
		stocklabel.setText("Stock availability: ");
		frame.getContentPane().add(stocklabel);
		
		labelid.setBounds(20,40,70,20);
		labelid.setText("ID:");
		frame.getContentPane().add(labelid);
		
		labelname.setBounds(20,70,70,20);
		labelname.setText("Name:");
		frame.getContentPane().add(labelname);
		
		labeladdress.setBounds(20,100,70,20);
		labeladdress.setText("Address:");
		frame.getContentPane().add(labeladdress);
		
		labelemail.setBounds(20,130,70,20);
		labelemail.setText("Email:");
		frame.getContentPane().add(labelemail);
		
		labelphoneNumber.setBounds(20,160,70,20);
		labelphoneNumber.setText("Phone Nr:");
		frame.getContentPane().add(labelphoneNumber);
		
		labelproduct.setBounds(20,290,70,20);
		labelproduct.setText("Product:");
		frame.getContentPane().add(labelproduct);
		
		labelidpr.setBounds(20,320,70,20);
		labelidpr.setText("ID:");
		frame.getContentPane().add(labelidpr);
		
		labelprName.setBounds(20,350,70,20);
		labelprName.setText("Name:");
		frame.getContentPane().add(labelprName);
		
		labelprMan.setBounds(20,380,70,20);
		labelprMan.setText("Manufact:");
		frame.getContentPane().add(labelprMan);
		
		labelStock.setBounds(20, 410, 70, 20);
		labelStock.setText("Stock: ");
		frame.getContentPane().add(labelStock);
		
		labelorder.setBounds(20, 540, 70, 20);
		labelorder.setText("Order: ");
		frame.getContentPane().add(labelorder);
		
		labelcusId.setBounds(20, 570, 80, 20);
		labelcusId.setText("CustomerID: ");
		frame.getContentPane().add(labelcusId);
		
		labelprodId.setBounds(20, 600, 70, 20);
		labelprodId.setText("ProductID: ");
		frame.getContentPane().add(labelprodId);
		
		labelquant.setBounds(20, 630, 70, 20);
		labelquant.setText("Quantity: ");
		frame.getContentPane().add(labelquant);
		
		cusId = new JTextField();
		cusId.setBounds(100, 570, 100, 20);
		frame.getContentPane().add(cusId);
		
		prodId = new JTextField();
		prodId.setBounds(100, 600, 100, 20);
		frame.getContentPane().add(prodId);
		
		quantity = new JTextField();
		quantity.setBounds(100, 630, 100, 20);
		frame.getContentPane().add(quantity);
		
		buttonDelO = new JButton("Delete");
		buttonDelO.setBounds(210, 580, 100, 30);
		frame.getContentPane().add(buttonDelO);
		
		buttonInsO = new JButton("Insert");
		buttonInsO.setBounds(210, 620, 100, 30);
		frame.getContentPane().add(buttonInsO);
		
		idprod = new JTextField();
		idprod.setBounds(100, 320 , 100, 20);
		frame.getContentPane().add(idprod);
		
		prodName = new JTextField();
		prodName.setBounds(100, 350, 100, 20);
		frame.getContentPane().add(prodName);
		
		Manufacturer = new JTextField();
		Manufacturer.setBounds(100, 380, 100, 20);
		frame.getContentPane().add(Manufacturer);
		
		stock = new JTextField();
		stock.setBounds(100,410,100,20);
		frame.getContentPane().add(stock);
		
		
		buttonDelP = new JButton("Delete");
		buttonDelP.setBounds(210, 320, 100, 30);
		frame.getContentPane().add(buttonDelP);
		
		buttonInsP = new JButton("Insert");
		buttonInsP.setBounds(210,360,100,30);
		frame.getContentPane().add(buttonInsP);
		
		buttonUpP = new JButton("Update");
		buttonUpP.setBounds(210, 400, 100, 30);
		frame.getContentPane().add(buttonUpP);
	
		
		id = new JTextField();
		id.setBounds(100, 40, 100, 20);
		frame.getContentPane().add(id);
		
		namec = new JTextField();
		namec.setBounds(100, 70, 100, 20);
		frame.getContentPane().add(namec);
		
		address = new JTextField();
		address.setBounds(100, 100, 100, 20);
		frame.getContentPane().add(address);
		
		email = new JTextField();
		email.setBounds(100, 130, 100, 20);
		frame.getContentPane().add(email);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(100, 160, 100, 20);
		frame.getContentPane().add(phoneNumber);
		
		buttonDelC = new JButton("Delete");
		buttonDelC.setBounds(210, 50 , 100, 30);
		frame.getContentPane().add(buttonDelC);
		
		buttonInsC = new JButton("Insert");
		buttonInsC.setBounds(210, 90 , 100, 30);
		frame.getContentPane().add(buttonInsC);
		
		buttonUpC = new JButton("Update");
		buttonUpC.setBounds(210, 130 , 100, 30);
		frame.getContentPane().add(buttonUpC);
		
		buttonViewClients = new JButton("View Clients");
		buttonViewClients.setBounds(90, 190, 120, 30);
		frame.getContentPane().add(buttonViewClients);
		
		buttonViewProducts = new JButton("View Products");
		buttonViewProducts.setBounds(90, 440, 120,30);
		frame.getContentPane().add(buttonViewProducts);
		
	}

	public JTextField getIdprod() {
		return idprod;
	}
	public void setIdprod(JTextField idprod) {
		this.idprod = idprod;
	}
	public JTextField getProdName() {
		return prodName;
	}
	public void setProdName(JTextField prodName) {
		this.prodName = prodName;
	}
	public JTextField getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(JTextField manufacturer) {
		Manufacturer = manufacturer;
	}
	public JTextField getStock() {
		return stock;
	}
	public JLabel getStocklabel() {
		return stocklabel;
	}

	public void setStocklabel(JLabel stocklabel) {
		this.stocklabel = stocklabel;
	}

	public void setStock(JTextField stock) {
		this.stock = stock;
	}
	public JTextField getCusId() {
		return cusId;
	}
	public void setCusId(JTextField cusId) {
		this.cusId = cusId;
	}
	public JTextField getProdId() {
		return prodId;
	}
	public void setProdId(JTextField prodId) {
		this.prodId = prodId;
	}
	public JTextField getQuantity() {
		return quantity;
	}
	public void setQuantity(JTextField quantity) {
		this.quantity = quantity;
	}
	public JTextField getId() {
		return id;
	}
	public void setId(JTextField id) {
		this.id = id;
	}
	
	public JTextField getNamec() {
		return namec;
	}
	public void setName(JTextField name) {
		this.namec = namec;
	}
	public JTextField getAddress() {
		return address;
	}
	public void setAddress(JTextField address) {
		this.address = address;
	}
	public JTextField getEmail() {
		return email;
	}
	public void setEmail(JTextField email) {
		this.email = email;
	}
	public JTextField getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(JTextField phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void insertC(ActionListener e) {
		this.buttonInsC.addActionListener(e);
	}
	
	public void updateC(ActionListener e) {
		this.buttonUpC.addActionListener(e);
	}
	
	public void deleteC(ActionListener e) {
		this.buttonDelC.addActionListener(e);
	}
	
	public void insertP(ActionListener e) {
		this.buttonInsP.addActionListener(e);
	}
	
	public void updateP(ActionListener e) {
		this.buttonUpP.addActionListener(e);
	}
	
	public void deleteP(ActionListener e) {
		this.buttonDelP.addActionListener(e);
	}
	
	public void insertO(ActionListener e) {
		this.buttonInsO.addActionListener(e);
	}
	
	public void deleteO(ActionListener e) {
		this.buttonDelO.addActionListener(e);
	}
	
	public void viewC(ActionListener e) {
		this.buttonViewClients.addActionListener(e);
	}
	
	public void viewP(ActionListener e) {
		this.buttonViewProducts.addActionListener(e);
	}
	
	public void init() {

		frame.setVisible(true);
		frame.setResizable(false);//initialize the frame

	}
	
	//initialise the two frames that contain the JTable
	
	public void initViewC(JTable j) {
		framecl.setVisible(true);
		framecl.setResizable(false);
		JScrollPane scroll = new JScrollPane(j,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		framecl.add(scroll);
	}
	
	public void initViewP(JTable j) {
		framepr.setVisible(true);
		framepr.setResizable(false);
		JScrollPane scroll = new JScrollPane(j,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		framepr.add(scroll);
			
	}
	
	/*The creation of a JTable done through reflexive techniques*/
	
	public static JTable viewAllTable (ArrayList<Object> objects) throws IllegalAccessException {
        Field[] fields = objects.get(0).getClass().getDeclaredFields();//fields will hold the respective column names for Customer/Product;
        String columns[] = new String[fields.length];
        int i = 0;
        for (Field field : fields) {//we iterate through the class' declared fields
            field.setAccessible(true);
            try {
                columns[i++] = field.getName();  
            } catch(IllegalArgumentException e) {
            	e.printStackTrace();
            }
        }
        DefaultTableModel tablemodel = new DefaultTableModel(columns, 0);//DefaultTableModel uses a vector of vectors to store the cell value objects.
        for (i = 0; i < objects.size(); i++) {
            Object[] tableRows = new Object[objects.get(i).getClass().getDeclaredFields().length];//now, we create the rows using reflexion
            Field[] fields2 = objects.get(i).getClass().getDeclaredFields();//we iterate through the declaredFields of each element of our Object ArrayList
            int j = 0;
            for (Field field : fields2) {
                field.setAccessible(true);
                Object obj;
                obj = field.get(objects.get(i));//we have our object, that will hold field values for each element
                tableRows[j++] = obj;
            }
            tablemodel.addRow(tableRows);
        }
        JTable table = new JTable(tablemodel);//create a JTable from our DefaultTableModel variable
        return table;
    }
	
}
