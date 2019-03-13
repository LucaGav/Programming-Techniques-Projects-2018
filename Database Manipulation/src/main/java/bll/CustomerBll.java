package bll;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import dao.CustomerDAO;
import dao.ProductDAO;
import model.Customer;
import model.Product;
/*BusinessLogic class for Customer*/
 
public class CustomerBll {
	
	private static CustomerDAO c1;
	
	public CustomerBll() { //class constructor
		c1 = new CustomerDAO();
	}
	
	public static Customer findById(int id) { //validate findById from customer
		Customer c = c1.findById(id);
		if (c == null) {
			throw new NoSuchElementException("The product with id = " + id + "was not found");
		}
		return c;	
	}
	
	public static void insert(Customer customer) throws Exception { //validate insert from customer
		if(customer.getId()<0 || customer.getName().isEmpty() || customer.getAddress().isEmpty() || 
				customer.getEmail().isEmpty() || customer.getPhoneNumber().isEmpty()) {
				throw new Exception("Cannot insert customer");
		}
		else {
			c1.insert(customer);
		}	
		
	}
	
	public static void update(Customer customer) throws Exception { // validate update from customer
		if(customer.getId()<0 || customer.getName().isEmpty() || customer.getAddress().isEmpty() || 
				customer.getEmail().isEmpty() || customer.getPhoneNumber().isEmpty()) {
				throw new Exception("Cannot update customer");
		}
		else {
			c1.update(customer);
		}		
	}
	
	public static void delete(int id) throws Exception{//validate delete from customer
		if(id<1) {
			throw new Exception("Cannot delete customer");
		}
		else {
			c1.delete(id);
		}		
	}
	
	public static ArrayList<Customer> selectAllC(){//validate selectAllC from customer
		ArrayList<Customer> cList = new ArrayList<Customer>();
		cList = c1.selectAllC();
		return cList;
		
	}
	
}
