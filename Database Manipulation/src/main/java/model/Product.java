package model;

public class Product {
	
	private int idproduct;
	private String productName;
	private String productManufacturer;
	private int stock;
	
	
	public Product(int idproduct, String productName, String productManufacturer, int stock) {//constructor for Product using its attributes
		this.idproduct = idproduct;
		this.productName = productName;
		this.productManufacturer = productManufacturer;
		this.stock = stock;
	}
	
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {//toString method for Product
		String s = null;
		s = this.getIdproduct()+" " + this.getProductName()+" " + this.getProductManufacturer()+ " " +this.getStock();
		return s;
	}

}
