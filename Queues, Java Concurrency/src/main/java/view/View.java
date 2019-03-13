package view;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Client;

@SuppressWarnings("serial")
public class View extends JPanel {

	private JButton start;
	private JTextField customers;
	private JTextField servers;
	private JTextField minAr;
	private JTextField minSer;
	private JTextField maxAr;
	private JTextField maxSer;
	private JLabel simTimeText;
	private JLabel avrTime;
	private JLabel avrArrival;
	public JTextField[] queues = new JTextField[10];
	private JTextField timeOfSimulation;
	private JFrame frame;
	private JTextArea log;

	public View() {

		JLabel labelcust = new JLabel();
		JLabel labelserv = new JLabel();
		JLabel labelmina = new JLabel();
		JLabel labelmaxa = new JLabel();
		JLabel labelmins = new JLabel();
		JLabel labelmaxs = new JLabel();
		JLabel q1 = new JLabel();
		JLabel q2 = new JLabel();
		JLabel q3 = new JLabel();
		JLabel q4 = new JLabel();
		JLabel q5 = new JLabel();
		JLabel q6 = new JLabel();
		JLabel q7 = new JLabel();
		JLabel q8 = new JLabel();
		JLabel q9 = new JLabel();
		JLabel q10 = new JLabel();
		JLabel time = new JLabel();
		JLabel simTime = new JLabel();
		JLabel aTime = new JLabel();
		JLabel aAr = new JLabel();
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//press X, it exits, not closes!
		frame.getContentPane().setLayout(null);

		timeOfSimulation= new JTextField();
		timeOfSimulation.setBounds(190, 10, 40, 20);
		frame.getContentPane().add(timeOfSimulation);
		
		customers= new JTextField();
		customers.setBounds(190, 40, 40, 20);
		frame.getContentPane().add(customers);
		
		servers= new JTextField();
		servers.setBounds(190, 70, 40, 20);
		frame.getContentPane().add(servers);
		
		minAr= new JTextField();
		minAr.setBounds(190, 100, 40, 20);
		frame.getContentPane().add(minAr);
		
		maxAr= new JTextField();
		maxAr.setBounds(190, 130, 40, 20);
		frame.getContentPane().add(maxAr);
		
		minSer= new JTextField();
		minSer.setBounds(190, 160, 40, 20);
		frame.getContentPane().add(minSer);
		
		maxSer= new JTextField();
		maxSer.setBounds(190, 190, 40, 20);
		frame.getContentPane().add(maxSer);
		
		simTimeText = new JLabel();
		simTimeText.setBounds(410, 15, 40, 20);
		simTimeText.setText("0");
		frame.getContentPane().add(simTimeText);
		
		simTime.setBounds(260, 10, 140, 30);
		simTime.setText("Simulation Current Time:");
		frame.getContentPane().add(simTime);
		
		avrTime = new JLabel();
		avrTime.setBounds(410, 45, 40, 20);
		avrTime.setText("-");
		frame.getContentPane().add(avrTime);
		
		aTime.setBounds(260, 40, 140, 30);
		aTime.setText("Average Waiting Time:");
		frame.getContentPane().add(aTime);
		
		avrArrival = new JLabel();
		avrArrival.setBounds(410, 75, 40, 20);
		avrArrival.setText("-");
		frame.getContentPane().add(avrArrival);
		
		aAr.setBounds(260, 70, 140, 30);
		aAr.setText("Average Arrival Time:");
		frame.getContentPane().add(aAr);
		
		
		time.setBounds(40, 10, 130, 20);
		time.setText("Time of Simulation: ");
		frame.getContentPane().add(time);
		
		labelcust.setBounds(40, 40, 130, 20);
		labelcust.setText("Number of Customers:");
		frame.getContentPane().add(labelcust);
		
		labelserv.setBounds(40, 70, 130, 20);
		labelserv.setText("Number of Servers:");
		frame.getContentPane().add(labelserv);
		
		labelmina.setBounds(40, 100, 130, 20);
		labelmina.setText("Arrival Time:             Min");
		frame.getContentPane().add(labelmina);
		
		labelmaxa.setBounds(40, 130, 130, 20);
		labelmaxa.setText("                                   Max");
		frame.getContentPane().add(labelmaxa);
		
		labelmins.setBounds(40, 160, 130, 20);
		labelmins.setText("Service Time:           Min");
		frame.getContentPane().add(labelmins);
		
		labelmaxs.setBounds(40, 190, 130, 20);
		labelmaxs.setText("                                   Max");
		frame.getContentPane().add(labelmaxs);


		start = new JButton();
		start.setText("Start");
		start.setBounds(80, 220, 120, 30);
		frame.getContentPane().add(start);
		
		queues[0]= new JTextField();
		queues[0].setBounds(690, 40, 500, 20);
		frame.getContentPane().add(queues[0]);
		
		queues[1]= new JTextField();
		queues[1].setBounds(690, 70, 500, 20);
		frame.getContentPane().add(queues[1]);
		
		queues[2]= new JTextField();
		queues[2].setBounds(690, 100, 500, 20);
		frame.getContentPane().add(queues[2]);
		
		queues[3]= new JTextField();
		queues[3].setBounds(690, 130, 500, 20);
		frame.getContentPane().add(queues[3]);
		
		queues[4]= new JTextField();
		queues[4].setBounds(690, 160, 500, 20);
		frame.getContentPane().add(queues[4]);
		
		queues[5]= new JTextField();
		queues[5].setBounds(690, 190, 500, 20);
		frame.getContentPane().add(queues[5]);
		
		queues[6]= new JTextField();
		queues[6].setBounds(690, 220, 500, 20);
		frame.getContentPane().add(queues[6]);
		
		queues[7]= new JTextField();
		queues[7].setBounds(690, 250, 500, 20);
		frame.getContentPane().add(queues[7]);
		
		queues[8]= new JTextField();
		queues[8].setBounds(690, 280, 500, 20);
		frame.getContentPane().add(queues[8]);
		
		queues[9]= new JTextField();
		queues[9].setBounds(690, 310, 500, 20);
		frame.getContentPane().add(queues[9]);
		
	
		q1.setBounds(630, 40, 50, 20);
		q1.setText("Queue0: ");
		frame.getContentPane().add(q1);
		
		q2.setBounds(630, 70, 50, 20);
		q2.setText("Queue1: ");
		frame.getContentPane().add(q2);
		
		q3.setBounds(630, 100, 50, 20);
		q3.setText("Queue2: ");
		frame.getContentPane().add(q3);
		
		q4.setBounds(630, 130, 50, 20);
		q4.setText("Queue3: ");
		frame.getContentPane().add(q4);
		
		q5.setBounds(630, 160, 50, 20);
		q5.setText("Queue4: ");
		frame.getContentPane().add(q5);
		
		q6.setBounds(630, 190, 50, 20);
		q6.setText("Queue5: ");
		frame.getContentPane().add(q6);
		
		q7.setBounds(630, 220, 50, 20);
		q7.setText("Queue6: ");
		frame.getContentPane().add(q7);
		
		q8.setBounds(630, 250, 50, 20);
		q8.setText("Queue7: ");
		frame.getContentPane().add(q8);
		
		q9.setBounds(630, 280, 50, 20);
		q9.setText("Queue8: ");
		frame.getContentPane().add(q9);
		
		q10.setBounds(630, 310, 50, 20);
		q10.setText("Queue9: ");
		frame.getContentPane().add(q10);
		
		log = new JTextArea(15, 300);
		log.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(log);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(10, 290, 500, 300);
		frame.add(scrollPane2);	
	}
	
	public JLabel getAvrArrival() {
		return avrArrival;
	}

	public void setAvrArrival(JLabel avrArrival) {
		this.avrArrival = avrArrival;
	}

	public JLabel getAvrTime() {
		return avrTime;
	}

	public void setAvrTime(JLabel avrTime) {
		this.avrTime = avrTime;
	}

	public JLabel getSimTimeText() {
		return simTimeText;
	}

	public void setSimTimeText(JLabel simTimeText) {
		this.simTimeText = simTimeText;
	}

	public void setQueues(String s,int i) {
			queues[i].setText(s);
	}

	public JTextArea getLog() {
		return log;
	}
	public void setLog(Client c) {
		this.log.append("Client" + c.getId());
	}
	public JTextField getCustomers() {
		return customers;
	}
	public void setCustomers(JTextField customers) {
		this.customers = customers;
	}
	public JTextField getServers() {
		return servers;
	}
	public void setServers(JTextField servers) {
		this.servers = servers;
	}
	public JTextField getMinAr() {
		return minAr;
	}
	public void setMinAr(JTextField minAr) {
		this.minAr = minAr;
	}
	public JTextField getMinSer() {
		return minSer;
	}
	public void setMinSer(JTextField minSer) {
		this.minSer = minSer;
	}
	public JTextField getMaxAr() {
		return maxAr;
	}
	public void setMaxAr(JTextField maxAr) {
		this.maxAr = maxAr;
	}
	public JTextField getMaxSer() {
		return maxSer;
	}
	public void setMaxSer(JTextField maxSer) {
		this.maxSer = maxSer;
	}
	public JTextField getTimeOfSimulation() {
		return timeOfSimulation;
	}
	public void setTimeOfSimulation(JTextField timeOfSimulation) {
		this.timeOfSimulation = timeOfSimulation;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public void init() {
		frame.setVisible(true);
		frame.setResizable(false);//initialize the frame
	}
	
	public void start(ActionListener e) {
		this.start.addActionListener(e);
	}
}
