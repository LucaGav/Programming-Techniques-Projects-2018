package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JPanel {

	private JButton buttonadd;
	private JButton buttonsub;
	private JButton buttonmul;
	private JButton buttondiff;
	private JButton buttoninteg;
	private JTextField poly1;
	private JTextField poly2;
	private JLabel result;
	private JLabel error;
	private JFrame frame;

	public View() {

		JLabel labelp1 = new JLabel();
		JLabel labelp2 = new JLabel();
		JLabel labelres = new JLabel();
		JLabel labelexplain = new JLabel();
		JLabel labelrequest = new JLabel();
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//press X, it exits, not closes!
		frame.getContentPane().setLayout(null);

		labelrequest.setBounds(40, 20, 360, 30);
		labelrequest.setText(
				"<html>For a coherent result display, please insert the polynomials as such: a(n)*x^n+a(n-1)*x^(n-1)+...+a(1)*x^1+a(0).</html>");//for help
		frame.getContentPane().add(labelrequest);

		poly1 = new JTextField();
		poly1.setBounds(80, 90, 150, 30);
		frame.getContentPane().add(poly1);

		labelp1.setBounds(120, 60, 80, 30);
		labelp1.setText("Polynomial 1:");
		frame.getContentPane().add(labelp1);

		poly2 = new JTextField();
		poly2.setBounds(280, 90, 150, 30);
		frame.getContentPane().add(poly2);

		labelp2.setBounds(320, 60, 80, 30);
		labelp2.setText("Polynomial 2:");
		frame.getContentPane().add(labelp2);

		result = new JLabel();
		result.setBounds(80, 280, 250, 30);
		result.setText("N/A");
		frame.getContentPane().add(result);

		labelres.setBounds(40, 280, 80, 30);
		labelres.setText("Result:");
		frame.getContentPane().add(labelres);

		error = new JLabel();
		error.setBounds(40, 320, 320, 30);
		error.setForeground(Color.RED);
		error.setText("");
		frame.getContentPane().add(error);

		labelexplain.setBounds(40, 140, 450, 30);
		labelexplain.setText(
				"<html>Please select the operation you wish to get the result of. For differentiation or integration, please use polynomial 1.</html> ");//for help
		frame.getContentPane().add(labelexplain);

		buttonadd = new JButton();
		buttonadd.setText("Addition");
		buttonadd.setBounds(70, 200, 120, 30);
		frame.getContentPane().add(buttonadd);

		buttonsub = new JButton();
		buttonsub.setText("Subtraction");
		buttonsub.setBounds(190, 200, 120, 30);
		frame.getContentPane().add(buttonsub);

		buttonmul = new JButton();
		buttonmul.setText("Multiplication");
		buttonmul.setBounds(310, 200, 120, 30);
		frame.getContentPane().add(buttonmul);


		buttondiff = new JButton();
		buttondiff.setText("Differentiation");
		buttondiff.setBounds(130, 230, 120, 30);
		frame.getContentPane().add(buttondiff);

		buttoninteg = new JButton();
		buttoninteg.setText("Integration");
		buttoninteg.setBounds(250, 230, 120, 30);
		frame.getContentPane().add(buttoninteg);

		JLabel labelimage = new JLabel("New Label");
		labelimage.setIcon(new ImageIcon(this.getClass().getResource("/p1.jpg")));//set background picture
		labelimage.setBounds(0, 0, 500, 400);
		frame.getContentPane().add(labelimage);

	}
	public void init() {

		frame.setVisible(true);
		frame.setResizable(false);//initialize the frame

	}
	public JLabel getError() {
		return error;
	}

	public void setError(JLabel error) {
		this.error = error;
	}

	public JLabel getResult() {
		return result;
	}

	public void setResult(JLabel result) {
		this.result = result;
	}

	
	//methods that will be used in Controller, based on what button the user presses
	public void addition(ActionListener e) {
		this.buttonadd.addActionListener(e);
	}

	public void subtraction(ActionListener e) {
		this.buttonsub.addActionListener(e);
	}

	public void multiplication(ActionListener e) {
		this.buttonmul.addActionListener(e);
	}

	public void differentiation(ActionListener e) {
		this.buttondiff.addActionListener(e);
	}

	public void integration(ActionListener e) {
		this.buttoninteg.addActionListener(e);
	}
	
	//for reading the polynomials
	public JTextField getPoly1() {
		return poly1;
	}

	public void setPoly1(JTextField poly1) {
		this.poly1 = poly1;
	}

	public JTextField getPoly2() {
		return poly2;
	}

	public void setPoly2(JTextField poly2) {
		this.poly2 = poly2;
	}

}
