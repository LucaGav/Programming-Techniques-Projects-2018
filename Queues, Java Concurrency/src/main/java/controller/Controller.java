package controller;

import view.View;

public class Controller {
	
	private Simulation s;
	private View view;
	
	public Controller() {
		View view = new View();
		view.init();//initialize view attribute
		view.start(e->{//once Start is pressed, create a new simulation based on the parameters given by the user in the GUI
			int time = Integer.parseInt(view.getTimeOfSimulation().getText());
			int clients = Integer.parseInt(view.getCustomers().getText());
			int nrservers = Integer.parseInt(view.getServers().getText());
			int minATime = Integer.parseInt(view.getMinAr().getText());
			int maxATime = Integer.parseInt(view.getMaxAr().getText());
			int minSTime = Integer.parseInt(view.getMinSer().getText());
			int maxSTime = Integer.parseInt(view.getMaxSer().getText());
			s = new Simulation(time,clients,nrservers,minATime,maxATime,minSTime,maxSTime,view);
			Thread t = new Thread(s);//create and start main simulation thread
			t.start();
		});
	}
}
