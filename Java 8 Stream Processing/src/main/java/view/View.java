package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View extends JPanel {
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JPanel panel;
	private JTextArea textArea;
	private JFrame frame;
	
	
	public View() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//press X, it exits, not closes!
		frame.getContentPane().setLayout(null);
		
		button1 = new JButton("Distinct days");
		button1.setBounds(20, 20, 150, 20);
		frame.getContentPane().add(button1);
		
		button2 = new JButton("Nof occurences");
		button2.setBounds(20, 60, 150, 20);
		frame.getContentPane().add(button2);
		
		button3 = new JButton("Activity count");
		button3.setBounds(20, 100, 150, 20);
		frame.getContentPane().add(button3);
		
		button4 = new JButton("Total Duration > 10");
		button4.setBounds(20, 140, 150, 20);
		frame.getContentPane().add(button4);
		
		button5 = new JButton("Duration less than 5");
		button5.setBounds(20, 180, 150, 20);
		frame.getContentPane().add(button5);
		
		textArea = new JTextArea(20,20);
		
		JScrollPane jScrollPane1 = new JScrollPane(textArea);
		
		jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JPanel panel = new JPanel();
		panel.setBounds(200, 10, 270, 450);
		panel.add(jScrollPane1);
		frame.add(panel);
			
	}
	
	public void button1(ActionListener e) {
		this.button1.addActionListener(e);
	}
	
	public void button2(ActionListener e) {
		this.button2.addActionListener(e);
	}
	
	public void button3(ActionListener e) {
		this.button3.addActionListener(e);
	}
	
	public void button4(ActionListener e) {
		this.button4.addActionListener(e);
	}
	
	public void button5(ActionListener e) {
		this.button5.addActionListener(e);
	}
	
	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public void setButton3(JButton button3) {
		this.button3 = button3;
	}

	public JButton getButton4() {
		return button4;
	}

	public void setButton4(JButton button4) {
		this.button4 = button4;
	}

	public JButton getButton5() {
		return button5;
	}

	public void setButton5(JButton button5) {
		this.button5 = button5;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void init() {
		this.frame.setVisible(true);
		this.frame.setResizable(false);
	}

	
	

}
