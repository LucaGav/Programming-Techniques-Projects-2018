package presentation;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import bll.CustomerBll;
import bll.OrderBll;
import bll.ProductBll;
import connection.Connect;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Customer;
import model.Order;
import model.Product;

public class Controller {
	
	private Customer c1;
	private CustomerBll cBll;
	private Product p1;
	private ProductBll pBll;
	private Order o1;
	private OrderBll oBll;
	private View view;
	
	public Controller() {
		
		view = new View();
		view.init();//initialise main frame
		
		/*Using the ActionListener methods in the view class for the frame's buttons*/
	
		view.insertC(e->{
			int id = Integer.parseInt(view.getId().getText());
			c1 = new Customer(id,view.getNamec().getText(),view.getAddress().getText(),view.getEmail().getText(),view.getPhoneNumber().getText());
			try {
				cBll.insert(c1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		view.updateC(e->{
			int id = Integer.parseInt(view.getId().getText());
			c1 = new Customer(id,view.getNamec().getText(),view.getAddress().getText(),view.getEmail().getText(),view.getPhoneNumber().getText());
			try {
				cBll.update(c1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		view.deleteC(e->{
			int id = Integer.parseInt(view.getId().getText());
			try {
				cBll.delete(id);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		view.insertP(e->{
			int idp = Integer.parseInt(view.getIdprod().getText());
			int stock = Integer.parseInt(view.getStock().getText());
			p1 = new Product(idp,view.getProdName().getText(),view.getManufacturer().getText(),stock);
			try {
				pBll.insertP(p1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			});
		
		view.updateP(e->{
			int idp = Integer.parseInt(view.getIdprod().getText());
			int stock = Integer.parseInt(view.getStock().getText());
			p1 = new Product(idp,view.getProdName().getText(),view.getManufacturer().getText(),stock);
			try {
				pBll.updateP(p1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		view.deleteP(e->{
			int idp = Integer.parseInt(view.getIdprod().getText());
			try {
				pBll.deleteP(idp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		view.insertO(e->{
			int prodid = Integer.parseInt(view.getProdId().getText());
			int cusid = Integer.parseInt(view.getCusId().getText());
			int quantity = Integer.parseInt(view.getQuantity().getText());
			o1 = new Order(cusid,prodid,quantity);
			try {
				oBll.insertO(o1);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				pBll.updateStock(quantity, prodid);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Product p = pBll.findById(prodid);
			int stock = p.getStock();
			if(stock >= 0) {
				view.getStocklabel().setText("Stock availability: Enough products left in stock");	//use the stock label to show whether or not there still are 
				view.getStocklabel().setForeground(Color.GREEN);//enough products for the order
			}
			else {
				 view.getStocklabel().setText("Stock availability: Sorry, not enough products in stock ");
				 view.getStocklabel().setForeground(Color.RED);
				 p.setStock(0);
				 try {
					pBll.updateP(p);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 try {
					oBll.deleteO(cusid, prodid);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			System.out.println(stock);
			});
		
		
		view.deleteO(e->{
			int prodid = Integer.parseInt(view.getProdId().getText());
			int cusid = Integer.parseInt(view.getCusId().getText());
			int quantity = oBll.selectQ(cusid, prodid);
			try {
				oBll.deleteO(cusid, prodid);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try {
				pBll.updateStock(-quantity, prodid);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		/*This is where we show the reflexively built 
		JTable that shows all of our clients or all of our products*/
		view.viewC(e->{
			ArrayList a = new ArrayList<Object>();
			a = cBll.selectAllC();
			JTable j = new JTable();
			try {
				view.initViewC(view.viewAllTable(a));
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		});
		view.viewP(e->{
			ArrayList a = new ArrayList<Object>();
			a = pBll.selectAllP();
			JTable j = new JTable();
			try {
				view.initViewP(view.viewAllTable(a));
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
	

}
