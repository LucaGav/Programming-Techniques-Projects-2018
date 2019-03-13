package model;

public class Client implements java.io.Serializable {
	
	private String username, firstname, lastname, address, ssn, password;

	public Client(String username, String firstname, String lastname, String address, String ssn, String password) {//constructor for the Client class
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.ssn = ssn;
		this.password = password;
	}

	/*
	 * getters and setters for the attributes
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	

	@Override
	public String toString() {//toString method for the Client class
		return "Client [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", ssn=" + ssn + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {//This method has to be overridden to return an integer computed based on the client’s fields
		int hash = 1;
		final int prime = 31;
		hash = prime * hash + ((username == null) ? 0 : username.hashCode());
		hash = prime * hash + ((firstname == null) ? 0 : firstname.hashCode());
		hash = prime * hash + ((lastname == null) ? 0 : lastname.hashCode());
		hash = prime * hash + ((address == null) ? 0 : address.hashCode());
		hash = prime * hash + ((ssn == null) ? 0 : ssn.hashCode());
		return hash;
			
	}

	
	@Override
	public boolean equals(Object obj) { //in order to compare key equality for get operation or to check if the object exists in the map, in case of put operation
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Client c1 = (Client) obj;
		return (!username.equals(c1.username))
				&& (!firstname.equals(c1.firstname))
				&& (!lastname.equals(c1.lastname))
				&& (!address.equals(c1.address))
				&& (!ssn.equals(c1.ssn))
				&& (!password.equals(c1.password));
	}
	
	
	
	

	
	
	

}
