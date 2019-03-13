package model;


public abstract class Monomial  {
	
	private Number coefficient;
	protected int degree;
	
	public Monomial() {
		// we initialize both degree and coefficient in the subclasses
	}
	
		
	public int getDegree() {//getter for the degree
		return degree;
	}
	public void setDegree(int degree) {//setter for the degree
		this.degree = degree;
	}
	
	public abstract Number getCoefficient();//abstract method getCoefficient, we only need implementations in the subclasses
	
	public abstract void setCoefficient(Number coefficient);//abstract method setCoefficient, we implement differently depending on coefficient type
	
	public abstract String toString();//abstract method, to be described in both subclasses differently ( override)
	
}
