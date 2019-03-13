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
import model.Product;

public class ProductDAO {
	
	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String selectStatementString = "SELECT * FROM product where idproduct = ?";
	private static final String insertStatementString = "INSERT INTO product (idproduct, productName, productManufacturer, stock)" + "VALUES (?,?,?,?)";
	private static final String updateStatementString = "UPDATE product SET productName = ?, productManufacturer = ?, stock = ? WHERE idproduct = ?";
	private static final String deleteStatementString = "DELETE FROM product WHERE idproduct = ?";
	private static final String stockStatementString = "UPDATE product SET stock = stock - ? WHERE idproduct = ?";
	private static final String allProductStatementString = "SELECT * FROM product";
	
	
	public static Product findById(int idprod) {//use SQL query to find product by id
		Product toReturn = null;
		Connection con = Connect.getConnection();
		PreparedStatement select = null;
		ResultSet rs = null;
		try {
			select = con.prepareStatement(selectStatementString);
			select.setInt(1, idprod);
			rs = select.executeQuery();
			rs.next();
			String prodName = rs.getString("productName");
			String man = rs.getString("productManufacturer");
			int st = rs.getInt("stock");
			toReturn = new Product(idprod,prodName,man,st);
		} catch(SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:findById" + e.getMessage());
		} finally {
			Connect.close(rs);
			Connect.close(select);
			Connect.close(con);
		}
		return toReturn;
	}
	
	public static void insertP(Product product) {//use SQL query to insert product
		Connection con = Connect.getConnection();
		PreparedStatement insert = null;
		try {
			insert = con.prepareStatement(insertStatementString,Statement.RETURN_GENERATED_KEYS);
			insert.setInt(1, product.getIdproduct());
			insert.setString(2, product.getProductName());
			insert.setString(3, product.getProductManufacturer());
			insert.setInt(4, product.getStock());
			insert.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insertP" + e.getMessage());
		} finally {
			Connect.close(insert);
			Connect.close(con);
		}
	}
	
	public static void updateP(Product product) {//use SQL query to update product
		Connection con = Connect.getConnection();
		PreparedStatement update = null;
		try {
			update = con.prepareStatement(updateStatementString,Statement.RETURN_GENERATED_KEYS);
			update.setString(1, product.getProductName());
			update.setString(2, product.getProductManufacturer());
			update.setInt(3, product.getStock());
			update.setInt(4, product.getIdproduct());
			update.executeUpdate();
		} catch(SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:updateP" + e.getMessage());
		} finally {
			Connect.close(update);
			Connect.close(con);
		}
	}
	
	public static void deleteP(int prodId) {//use SQL query to delete product by id
		Connection con = Connect.getConnection();
		PreparedStatement delete = null;
		try {
			delete = con.prepareStatement(deleteStatementString,Statement.RETURN_GENERATED_KEYS);
			delete.setInt(1,prodId);
			delete.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO: delete" + e.getMessage());
		} finally {
			Connect.close(delete);
			Connect.close(con);
		}
	}
	
	public static void updateStock(int quantity, int prodid) {//use SQL query to update the stock
		Connection con = Connect.getConnection();
		PreparedStatement stocky = null;
		try {
			stocky = con.prepareStatement(stockStatementString,Statement.RETURN_GENERATED_KEYS);
			stocky.setInt(1,quantity);
			stocky.setInt(2, prodid);
			stocky.executeUpdate();
		} catch(SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO: stock " + e.getMessage());
		} finally {
			Connect.close(stocky);
			Connect.close(con);
		}
		
	}
	
	public static ArrayList<Product> selectAllP(){//use SQL query to select all products
		ArrayList<Product> pList = new ArrayList<Product>();
		Connection con = Connect.getConnection();
		PreparedStatement selectall = null;
		ResultSet rs = null;
		try {
			selectall = con.prepareStatement(allProductStatementString);
			rs = selectall.executeQuery();
			while(rs.next()) {
				int id  = rs.getInt("idproduct");
				String namep = rs.getString("productName");
				String man = rs.getString("productManufacturer");
				int st = rs.getInt("stock");
				Product p = new Product (id,namep,man,st);
				pList.add(p);
		}
	} catch(SQLException e) {
		LOGGER.log(Level.WARNING,"ProductDAO: selectALLP" + e.getMessage());
	}finally {
		Connect.close(rs);
		Connect.close(selectall);
		Connect.close(con);
		}
		return pList;
	}	
}
