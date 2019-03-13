package model;



public class Client implements Comparable<Client> {
	
	private int id;
	private int arrivalTime;
	private int serviceTime;
	
	public Client(int id, int arrivalTime, int serviceTime) {//constructor for the Client class
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}

	/*
	 * getters and setters for the attributes of Client
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	//toString method
	public String toString() {
		
		 return "C(i:" + Integer.toString(id) + ", aT:"  + Integer.toString(arrivalTime) + 
				 ", sT:" + Integer.toString(serviceTime) + ")";
	}

	//compareTo method based on arrivalTime
	public int compareTo(Client c) {
		if(this.arrivalTime > c.arrivalTime) {
			return 1;
		}
		else return -1;
	}

}
	

