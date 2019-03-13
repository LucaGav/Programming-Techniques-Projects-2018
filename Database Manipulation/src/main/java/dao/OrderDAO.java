package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.Connect;
import model.Order;

public class OrderDAO {

	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO warehouse.order(customerID,productID,quantity)" + "VALUES(?,?,?)";
	private static final String updateStatementString = "UPDATE warehouse.order SET quantity = ? WHERE customerID=? and productID=?";
	private static final String deleteStatementString = "DELETE FROM warehouse.order WHERE customerID=? and productID = ?";
	private static final String selectQStatementString ="SELECT quantity FROM warehouse.order WHERE customerID=? and productID =?";
	
	
	public static int selectQ(int cusid, int prodid) {
		int quantity = 0;
		Connection con = Connect.getConnection();
		PreparedStatement select = null;
		ResultSet rs = null;
		try {
			select = con.prepareStatement(selectQStatementString);
			select.setInt(1, cusid);
			select.setInt(2, prodid);
			rs = select.executeQuery();
			rs.next();
			quantity = rs.getInt("quantity");
		}catch(SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:selectQ" + e.getMessage());
		}finally {
			Connect.close(rs);
			Connect.close(select);
			Connect.close(con);
		}
		return quantity;	
	}
	public static void insertO(Order order) {//use SQL query to insert order
		Connection con = Connect.getConnection();
		PreparedStatement insert = null;
		try {
			insert = con.prepareStatement(insertStatementString);
			insert.setInt(1, order.getCustomerID());
			insert.setInt(2, order.getProductID());
			insert.setInt(3, order.getQuantity());
			insert.executeUpdate();	
		} catch(SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:insertO " + e.getMessage());
		}finally {
			Connect.close(insert);
			Connect.close(con);
		}
		
	}
	
	public static void deleteO(int idcus,int idprod) {//use SQL query to delete order
		Connection con = Connect.getConnection();
		PreparedStatement delete = null;
		try {
			delete = con.prepareStatement(deleteStatementString,Statement.RETURN_GENERATED_KEYS);
			delete.setInt(1, idcus);
			delete.setInt(2,idprod);
			delete.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO: delete" + e.getMessage());
		} finally {
			Connect.close(delete);
			Connect.close(con);
		}
	}
	
}
