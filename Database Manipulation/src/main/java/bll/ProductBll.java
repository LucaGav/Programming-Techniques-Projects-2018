package bll;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import dao.ProductDAO;
import model.Product;

public class ProductBll {
	
	private static ProductDAO p1;
	
	public ProductBll() {
		p1 = new ProductDAO();
	}
	
	public static Product findById(int id) {//validate findById from product
		Product p = p1.findById(id);
		if (p == null) {
			throw new NoSuchElementException("The product with id = " + id + "was not found");
		}
		return p;
		
	}
	
	public static void insertP(Product product) throws Exception {//validate insert from product
		if(product.getIdproduct()<1 || product.getProductName().isEmpty() || product.getProductManufacturer().isEmpty() || product.getStock() < 0) {
			throw new Exception("Cannot insert product");
		}
		else {
			p1.insertP(product);
		}	
	}
	
	public static void updateP(Product product) throws Exception{//validate update from product
		if(product.getIdproduct()<1 || product.getProductName().isEmpty() || product.getProductManufacturer().isEmpty() || product.getStock() < 0) {
			throw new Exception("Cannot update product");
		}
		else {
			p1.updateP(product);
		}	
	}
	
	public static void deleteP(int id) throws Exception{//validate delete from product
		if(id<1) {
			throw new Exception("Cannot delete product");
		}
		else {
			p1.deleteP(id);
		}	
			
	}
	
	public static void updateStock(int quantity, int prodid) throws Exception {//validate update stock from product
		if(quantity == 0) {
			throw new Exception("Cannot update stock");
		}else {
			p1.updateStock(quantity,prodid);
		}
	}
	
	public static ArrayList<Product> selectAllP(){//validate select all from product
		ArrayList<Product> pList = new ArrayList<Product>();
		pList = p1.selectAllP();
		return pList;
		
	}
	
	
	

}
