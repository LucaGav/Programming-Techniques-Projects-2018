package controller;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.IntegerMonomial;
import model.Monomial;
import model.Polynomial;
import view.View;

public class Controller {

	private Polynomial poli1;
	private Polynomial poli2;
	private View view;

	public Controller() {

		/*We first initialize the 3 attributes held by the controller class,
		after which we continue with the necessary calls to the action listener
		methods for each operation
		 */
		view = new View();
		view.init();//setVisible becomes true, setResizable becomes false for our view
		poli1 = new Polynomial();
		poli2 = new Polynomial();
		view.addition(e -> {
			String pol = view.getPoly1().getText();
			String pol2 = view.getPoly2().getText();//get contents of JTextFields
			try {
				poli1 = poli1.readPolynom(pol);
				poli2 = poli2.readPolynom(pol2);//try to transform the string into a Polynomial object
				view.getError().setText("Ok");
				view.getError().setForeground(Color.GREEN);
			} catch (Exception ex) {
				view.getError().setText("Bad input, please check for errors!");//if readPolynom failed, the input is bad
				view.getError().setForeground(Color.RED);

			}

			poli1 = poli1.polynomialAddition(poli2);//addition of poli1 and poli2
			view.getResult().setText(poli1.toString());

		});


		view.subtraction(e -> {
			String pol = view.getPoly1().getText();
			String pol2 = view.getPoly2().getText();//get contents of JTextFields
			try {
				poli1 = poli1.readPolynom(pol);
				poli2 = poli2.readPolynom(pol2);
				view.getError().setText("Ok");
				view.getError().setForeground(Color.GREEN);
			} catch (Exception ex) {
				view.getError().setText("Bad input, please check for errors!");//if readPolynom failed, the input is bad
				view.getError().setForeground(Color.RED);

			}
			poli1 = poli1.polynomialSubtraction(poli2);//subtraction of poli2 from poli1
			view.getResult().setText(poli1.toString());//set the result of the operation to the result label

		});
		
		view.multiplication(e -> {
			String pol = view.getPoly1().getText();
			String pol2 = view.getPoly2().getText();//get contents of JTextFields
			try {
				poli1 = poli1.readPolynom(pol);
				poli2 = poli2.readPolynom(pol2);
				view.getError().setText("Ok");
				view.getError().setForeground(Color.GREEN);
			} catch (Exception ex) {
				view.getError().setText("Bad input, please check for errors!");//if readPolynom failed, the input is bad
				view.getError().setForeground(Color.RED);

			}
			poli1 = poli1.polynomialMultiplication(poli2);//multiplication of poli2 from poli1
			view.getResult().setText(poli1.toString());//set the result of the operation to the result label

		});
		
		view.differentiation(e -> {
			String pol = view.getPoly1().getText();//get contents of JTextField
			JTextField p2 = new JTextField();
			try {
				poli1 = poli1.readPolynom(pol);
				view.getError().setText("Ok");
				view.getError().setForeground(Color.GREEN);
			} catch (Exception ex) {
				view.getError().setText("Bad input, please check for errors!");//if readPolynom failed, the input is bad
				view.getError().setForeground(Color.RED);

			}
			poli1.polynomialDifferentiation();//differentiate
			view.getResult().setText(poli1.toString());//set the result of the operation to the result label
			view.getPoly2().setText("N/A");//set poli2 text field so the user knows it is not used

		});

		view.integration(e -> {
			String pol = view.getPoly1().getText();//get contents of JTextField
			JTextField p2 = new JTextField();
			try {
				poli1 = poli1.readPolynom(pol);
				view.getError().setText("Ok");
				view.getError().setForeground(Color.GREEN);
			} catch (Exception ex) {
				view.getError().setText("Bad input, please check for errors!");//if readPolynom failed, the input is bad
				view.getError().setForeground(Color.RED);

			}
			poli1.polynomialIntegration();//integrate
			view.getResult().setText(poli1.toString());//set the result of the operation to the result label
			view.getPoly2().setText("N/A");//set poli2 text field so the user knows it is not used

		});
		 
	}
	
}
