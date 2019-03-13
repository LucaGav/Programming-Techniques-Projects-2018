package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.Connect;
import model.Customer;
import model.Product;

public class CustomerDAO {
	
	protected static final Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO customer (id,name,address,email,phoneNumber)" + "VALUES (?,?,?,?,?)";
	private static final String selectStatementString = "SELECT * FROM customer where id = ?";
	private static final String updateStatementString = "UPDATE customer SET name = ?, address = ?, email = ?, phoneNumber = ? WHERE id = ?";
	private static final String deleteStatementString = "DELETE FROM customer WHERE id = ?";
	private static final String allCustomerStatementString = "SELECT * FROM customer";
	
	public static Customer findById(int customerId) {//use SQL query to select customer by id
		Customer toReturn = null;
		Connection con = Connect.getConnection();
		PreparedStatement select = null;
		ResultSet rs = null;
		try {
			select = con.prepareStatement(selectStatementString);
			select.setInt(1, customerId);
			rs = select.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
			String phoneNumber = rs.getString("phoneNumber");
			toReturn = new Customer(customerId, name, address, email, phoneNumber);
			System.out.println(customerId + name + address + email + phoneNumber);
		} catch(SQLException e) {
			LOGGER.log(Level.WARNING, "CustomerDAO:findById" + e.getMessage());
		} finally {
			Connect.close(rs);
			Connect.close(select);
			Connect.close(con);
		}
		return toReturn;
	}
	
	public static void insert(Customer customer) {//use SQL query to insert customer
		Connection con = Connect.getConnection();
		PreparedStatement insert = null;
		
		try {
			insert = con.prepareStatement(insertStatementString,Statement.RETURN_GENERATED_KEYS);
			insert.setInt(1, customer.getId());
			insert.setString(2, customer.getName());
			insert.setString(3, customer.getAddress());
			insert.setString(4, customer.getEmail());
			insert.setString(5, customer.getPhoneNumber());
			insert.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,  "CustomerDAO:insert " + e.getMessage());
		} finally {
			Connect.close(insert);
			Connect.close(con);
		}
		
	}
	
	public static void update(Customer customer) {//use SQL query to update customer
		Connection con = Connect.getConnection();
		PreparedStatement update = null;
		try {
			update = con.prepareStatement(updateStatementString,Statement.RETURN_GENERATED_KEYS);
			update.setInt(5, customer.getId());
			update.setString(1, customer.getName());
			update.setString(2, customer.getAddress());
			update.setString(3, customer.getEmail());
			update.setString(4, customer.getPhoneNumber());
			update.executeUpdate();
		} catch(SQLException e) {
			LOGGER.log(Level.WARNING, "CustomerDAO:update" + e.getMessage());
		} finally {
			Connect.close(update);
			Connect.close(con);
		}	
	}
	
	public static void delete(int customerId) {//use SQL query to delete customer
		Connection con = Connect.getConnection();
		PreparedStatement delete = null;
		try {
			delete = con.prepareStatement(deleteStatementString,Statement.RETURN_GENERATED_KEYS);
			delete.setInt(1, customerId);
			delete.executeUpdate();
			
		} catch(SQLException e) {
			LOGGER.log(Level.WARNING, "CustomerDAO:delete" + e.getMessage());
		}finally {
			Connect.close(delete);
			Connect.close(con);
		}
	}
	
	public static ArrayList<Customer> selectAllC(){//use SQL query to select all customers
		ArrayList<Customer> cList = new ArrayList<Customer>();
		Connection con = Connect.getConnection();
		PreparedStatement selectall = null;
		ResultSet rs = null;
		try {
			selectall = con.prepareStatement(allCustomerStatementString);
			rs = selectall.executeQuery();
			while(rs.next()) {
				int id  = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				Customer c = new Customer (id,name,address,email,phoneNumber);
				cList.add(c);
		}
	} catch(SQLException e) {
		LOGGER.log(Level.WARNING,"CustomerDAO: selectALLP" + e.getMessage());
	}finally {
		Connect.close(rs);
		Connect.close(selectall);
		Connect.close(con);
		}
		return cList;
	}	
}
