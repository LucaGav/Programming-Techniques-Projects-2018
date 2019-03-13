package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;

import view.View;


public class Polynomial {

	private ArrayList<Monomial> expression;

	public Polynomial() {
	//no need to initialize with anything
	}

	public ArrayList<Monomial> getPolynom() {
		return expression;//return the expression of the polynomial
	}

	public void setPolynom(ArrayList<Monomial> polynom) {
		this.expression = polynom;//set the expression of the polynomial
	}

	public Polynomial polynomialAddition(Polynomial p2){
		int i,j;
		Polynomial respol = new Polynomial();
		ArrayList<Monomial> result =new ArrayList<Monomial>();
		for (Monomial mon : this.expression) {
			result.add(new IntegerMonomial(mon.getCoefficient().intValue(),mon.getDegree()));
			}
			for(Monomial mon2: p2.expression) {
				result.add(new IntegerMonomial(mon2.getCoefficient().intValue(),mon2.getDegree()));
			}//place every element of the 2 polynomials into the result
		for(i=0;i<result.size();i++) {
			for(j=i+1;j<result.size();j++) {
				if(result.get(i).getDegree() == result.get(j).getDegree()) {
					result.get(i).setCoefficient(result.get(i).getCoefficient().intValue()+result.get(j).getCoefficient().intValue());
					//move through the result array. If we find two elements with the same degree, add them
					result.remove(j);//remove one of the two elements with the same degree(we use j)
				}
			}
		}
		respol.setPolynom(result);
		respol.orderByDegree();
		return respol;
	}
	
	public Polynomial polynomialSubtraction(Polynomial p2){
		int i,j;
		Polynomial respol = new Polynomial();
		ArrayList<Monomial> result = new ArrayList<Monomial>();
		for (Monomial mon : this.expression) {
			result.add(new IntegerMonomial(mon.getCoefficient().intValue(),mon.getDegree()));
			}
			for(Monomial mon2: p2.expression) {
				result.add(new IntegerMonomial(-(mon2.getCoefficient().intValue()),mon2.getDegree()));
			}//place every element of the 2 polynomials into the result, the elements of p2 with changed sign.
		for(i=0;i<result.size();i++) {
			for(j=i+1;j<result.size();j++) {
				if(result.get(i).getDegree() == result.get(j).getDegree()) {
					result.get(i).setCoefficient(result.get(i).getCoefficient().intValue()+result.get(j).getCoefficient().intValue());///move through the result array. 
					//If we find two elements with the same degree, add them
					result.remove(j);//remove one of the two elements with the same degree(we use j)
				}
			}
		}
		respol.setPolynom(result);
		respol.orderByDegree();
		return respol;
	}
	
	public Polynomial polynomialMultiplication(Polynomial p2) {
		ArrayList<Monomial> result = new ArrayList<Monomial>();
		Polynomial respol = new Polynomial();
		int t = 0;
		for (Monomial mon : this.expression) {
			for (Monomial mon2 : p2.expression) {//result gets (each of polynomial1)*(each of polynomial2)
				result.add(new IntegerMonomial(mon.getCoefficient().intValue() * mon2.getCoefficient().intValue(),
						mon.getDegree() + mon2.getDegree()));
			}
		}
		for (int i = 0; i < result.size(); i++) {
			for (int j = i + 1; j < result.size(); j++) {//but we might have values in result with same degree=>we add them
				if (result.get(i).getDegree() == result.get(j).getDegree()) {
					result.get(i).setCoefficient(
							result.get(i).getCoefficient().intValue() + result.get(j).getCoefficient().intValue());
					result.remove(j);
				}
			}
		}
		respol.setPolynom(result);
		respol.orderByDegree();
		return respol;
	}
	
	public Polynomial polynomialDifferentiation() {
		ArrayList<Monomial> result = new ArrayList<Monomial>();
		for (Monomial mon : this.expression) {
			result.add(new IntegerMonomial(mon.getCoefficient().intValue() * mon.getDegree(), mon.getDegree() - 1));//der=coeff*degree*x^(degree-1)
		}

		this.setPolynom(result);
		return this;
	}

	public Polynomial polynomialIntegration() {
		ArrayList<Monomial> result = new ArrayList<Monomial>();
		double newcoef;
		for (Monomial mon : this.expression) {
			newcoef = mon.getCoefficient().doubleValue() / (mon.getDegree() + 1);
			result.add(new RealMonomial(Math.floor(newcoef * 100) / 100, (mon.getDegree() + 1)));//integ=coef/(degree+1)*x^(degree+1)
		}

		this.setPolynom(result);
		return this;
	}

	public Polynomial readPolynom(String pol) {
		expression = new ArrayList<Monomial>();
		String coeff = new String();
		String exxpo = new String();

		String str = pol.replace("-", "+-");//replace so we can split by +

		String[] arr = str.split("\\+");//split by +
		for (String p : arr) {
			if ((!p.equals(""))) {//for correct output; split(0) is always ""
				String[] coef = p.split("x");//split by x
				if (coef[0].equals("-") || coef[0].equals("")) {//read and add +-1 properly
					coeff = coef[0] + "1";
				} else {
					coeff = coef[0];
				}
				String[] expo = p.split("\\^");//now split for exponent
				if (expo.length > 1) {
					exxpo = expo[1];
				} else if (expo.length <= 1) {
					exxpo = "0";
				}
				Monomial mon = new IntegerMonomial(Integer.parseInt(coeff), Integer.parseInt(exxpo));//create new Monomial
				expression.add(mon);//add Monomial to the list
			}
		}	
		return this;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < expression.size(); i++) {
			if (i != 0) {
				if (this.expression.get(i).getCoefficient().intValue() > 0) {
					s = s + "+";
				}
			}
			s = s + expression.get(i).toString();//we build the string for our polynomial, based on the toString() functions found in the monomial subclasses
		}
		s = (s.contentEquals("")) ? "0" : s;//if nothing in the string, print 0
		s = (s.charAt(0) == '+') ? s.substring(1) : s; //if it starts with a positive value. don't print the plus
		return s;
	}
	
	public void orderByDegree() {//this method helps us order the polynomials by their degree; for a better representation of the result
		IntegerMonomial res = new IntegerMonomial(0, 0);
		for (int i = 0; i < this.expression.size() - 1; i++) {
			for (int j = i + 1; j < this.expression.size(); j++) {
				if (this.expression.get(i).getDegree() < this.expression.get(j).getDegree()) {
					res = (IntegerMonomial) this.expression.get(i);
					this.expression.set(i, this.expression.get(j));
					this.expression.set(j, res);
				}
			}
		}
	}
}
