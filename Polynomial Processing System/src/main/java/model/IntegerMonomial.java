package model;
public class IntegerMonomial extends Monomial {
	
	private Integer coefficient;
	
	public IntegerMonomial(Integer coefficient, int degree) {//constructor that can intialize an integer coefficient monomial
		this.degree = degree;
		this.coefficient = coefficient;
	}

	public Integer getCoefficient() {
		return coefficient;//return the coefficient, Integer type
	}

	public void setCoefficient(Number coefficient) {
		this.coefficient = (Integer) coefficient;//Integer cast over coefficient
	}

	@Override
	public String toString() {
		String s = "";
		if (this.getCoefficient() == 0) {//if coef = 0 add nothing
			s = s + "";
		} else if (this.getCoefficient() == 1 && this.getDegree() != 0) {
			s = s + "x^" + this.getDegree();//if coef is 1 don't display 1
		} else if (this.getDegree() == 1) {
			s = s + this.getCoefficient() + "x";//as above , but if degree is 1 don't show it either
		} else if (this.getDegree() == 0) {
			s = s + "" + this.getCoefficient();//if degree is 0 , only add coef
		} else if (this.getCoefficient() == -1) {
			s = s + "-x^" + this.getDegree();//if coef is -1 show only minus
		} else {
			s = s + this.getCoefficient() + "x^" + this.getDegree();//normal
		}
	return s;
	}
	

}


