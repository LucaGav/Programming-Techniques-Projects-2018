import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;
import model.IntegerMonomial;
import model.Monomial;
import model.Polynomial;
import model.RealMonomial;

public class AssignmentTests extends TestCase {
	
	@Test
	public void testAddition() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial result = new Polynomial();
		ArrayList<Monomial> monom = new ArrayList<Monomial>();
		ArrayList<Monomial> monom2 = new ArrayList<Monomial>();
		ArrayList<Monomial> monom3 = new ArrayList<Monomial>();
		IntegerMonomial mon = new IntegerMonomial(3,3);
		IntegerMonomial mon2 = new IntegerMonomial(2,1);
		
		IntegerMonomial mon3 = new IntegerMonomial(2,2);
		IntegerMonomial mon4 = new IntegerMonomial(2,1);
		
		IntegerMonomial mon5 = new IntegerMonomial(3,3);
		IntegerMonomial mon6 = new IntegerMonomial(2,2);
		IntegerMonomial mon7 = new IntegerMonomial(4,1);
		
		monom.add(mon);
		monom.add(mon2);
		monom2.add(mon3);
		monom2.add(mon4);
		monom3.add(mon5);
		monom3.add(mon6);
		monom3.add(mon7);
		
		p1.setPolynom(monom);
		p2.setPolynom(monom2);
		result.setPolynom(monom3);
		p1 = p1.polynomialAddition(p2);
		assertEquals(p1.toString(),result.toString());
	}
	
	@Test
	public void testSubtraction() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial result = new Polynomial();
		ArrayList<Monomial> monom = new ArrayList<Monomial>();
		ArrayList<Monomial> monom2 = new ArrayList<Monomial>();
		ArrayList<Monomial> monom3 = new ArrayList<Monomial>();
		IntegerMonomial mon = new IntegerMonomial(3,3);
		IntegerMonomial mon2 = new IntegerMonomial(2,1);
		
		IntegerMonomial mon3 = new IntegerMonomial(2,2);
		IntegerMonomial mon4 = new IntegerMonomial(2,1);
		
		IntegerMonomial mon5 = new IntegerMonomial(3,3);
		IntegerMonomial mon6 = new IntegerMonomial(-2,2);
		
		
		monom.add(mon);
		monom.add(mon2);
		monom2.add(mon3);
		monom2.add(mon4);
		monom3.add(mon5);
		monom3.add(mon6);
		
		
		p1.setPolynom(monom);
		p2.setPolynom(monom2);
		result.setPolynom(monom3);
		p1 = p1.polynomialSubtraction(p2);
		assertEquals(p1.toString(),result.toString());
	}
	@Test
	public void testIntegration() {
		Polynomial p1 = new Polynomial();
		Polynomial result = new Polynomial();
		ArrayList<Monomial> monom = new ArrayList<Monomial>();
		ArrayList<Monomial> monom2 = new ArrayList<Monomial>();
		IntegerMonomial mon = new IntegerMonomial(3,3);
		RealMonomial mon2 = new RealMonomial(0.75,4);
		
		monom.add(mon);
		monom2.add(mon2);
		
		p1.setPolynom(monom);
		result.setPolynom(monom2);
		p1 = p1.polynomialIntegration();
		assertEquals(p1.toString(),result.toString());
	}
	@Test
	public void testDifferentiation() {
		Polynomial p1 = new Polynomial();
		Polynomial result = new Polynomial();
		ArrayList<Monomial> monom = new ArrayList<Monomial>();
		ArrayList<Monomial> monom2 = new ArrayList<Monomial>();
		IntegerMonomial mon = new IntegerMonomial(3,3);
		IntegerMonomial mon2 = new IntegerMonomial(9,2);
		
		monom.add(mon);
		monom2.add(mon2);
		
		p1.setPolynom(monom);
		result.setPolynom(monom2);
		p1 = p1.polynomialDifferentiation();
		assertEquals(p1.toString(),result.toString());
	}
	@Test
	public void testMultiplication() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial result = new Polynomial();
		ArrayList<Monomial> monom = new ArrayList<Monomial>();
		ArrayList<Monomial> monom2 = new ArrayList<Monomial>();
		ArrayList<Monomial> monom3 = new ArrayList<Monomial>();
		IntegerMonomial mon = new IntegerMonomial(3,3);
		IntegerMonomial mon2 = new IntegerMonomial(2,2);
		IntegerMonomial mon3 = new IntegerMonomial(6,5);
		
		monom.add(mon);
		monom2.add(mon2);
		monom3.add(mon3);
		
		p1.setPolynom(monom);
		p2.setPolynom(monom2);
		result.setPolynom(monom3);
		p1 = p1.polynomialMultiplication(p2);
		assertEquals(p1.toString(),result.toString());
	}

}
