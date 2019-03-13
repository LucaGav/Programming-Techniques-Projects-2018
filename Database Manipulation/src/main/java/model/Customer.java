package model;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String email;
	private String phoneNumber;
	
	public Customer(int id, String name, String address, String email, String phoneNumber) {//Customer constructor using its attributes
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {//toString method for the customer
		String s = null;
		s = this.getId() + " " + this.getName() +" " + this.getAddress() + " " + this.getEmail() + " " + this.getPhoneNumber();
		return s;
	}

}
