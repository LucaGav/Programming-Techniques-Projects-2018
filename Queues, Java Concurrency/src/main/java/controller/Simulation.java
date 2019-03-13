package controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import model.Client;
import model.Server;
import view.View;

public class Simulation implements Runnable {

	private ArrayList<Client> clients;
	private ArrayList<Server> queues;
	private int simulationTime;
	private View view;
	private int nrC, nrS, minA, maxA, minS, maxS;
	private final static Logger LOGGER = Logger.getLogger(Simulation.class.getName());

	public Simulation(int simulationTime, int nrClients, int nrServers, int minATime, int maxATime, int minSTime,
			int maxSTime, View view) {//constructor for the Simulation class, generate the lists of queues and clients
		this.view = view;
		this.simulationTime = simulationTime;
		this.nrC = nrClients;
		this.nrS = nrServers;
		this.minA = minATime;
		this.maxA = maxATime;
		this.minS = minSTime;
		this.maxS = maxSTime;
		clients = generateClients(nrC);
		queues = generateQueues(nrS);
	}

	public int getSimulationTime() {
		return simulationTime;
	}

	public void setSimulationTime(int simulationTime) {
		this.simulationTime = simulationTime;
	}

	//randomly generate the list of clients based on arrivalTime and serviceTime intervals
	public ArrayList<Client> generateClients(int nrC) {
		int i, aTime, sTime;
		clients = new ArrayList<Client>();
		for (i = 0; i < nrC; i++) {
			Random rand = new Random();
			aTime = rand.nextInt((maxA - minA) + 1) + minA;
			sTime = rand.nextInt((maxS - minS) + 1) + minS;
			Client c = new Client(i, aTime, sTime);
			this.clients.add(c);

		}
		Collections.sort(clients);
		return clients;
	}
	//generate the queues based on the number given by the user
	public ArrayList<Server> generateQueues(int nrS) {
		queues = new ArrayList<Server>();
		for (int i = 0; i < nrS; i++) {
			Server s = new Server();
			this.queues.add(s);
		}
		return queues;
	}
	
	//return the index of the least populated queue
	public int getMinimalQueue() {
		int min = 99;
		int i = 0;
		for (Server s : this.queues) {
			if (s.getQueue().size() < min) {
				min = s.getQueue().size();
				i = this.queues.indexOf(s);
			}
		}
		return i;
	}

	public void run() {//the simulation based on the parameters (attributes) and multithreading, thread sleeps once a second
		int currentTime = 0;
		int minQ, nr = 0, t = 0, a = 0;
		Client client;
		while (currentTime <= simulationTime) {
			Iterator<Client> it = clients.iterator();
			if (it.hasNext()) {
				client = it.next();
				while (client.getArrivalTime() <= currentTime) {
					nr++;
					t += client.getServiceTime();
					a += client.getArrivalTime();
					minQ = getMinimalQueue();
					queues.get(minQ).enqueue(client);
					view.getLog().append("Client " + client.toString() + " entered queue" + minQ + "\n");
					// LOGGER.info("Client " + client.toString() + " entered queue " + minQ);
					if (it.hasNext()) {
						it.remove();
						client = it.next();
					} else {
						it.remove();
						break;
					}
				}
				startQueues();
			}
			showQueues();
			currentTime++;
			showTime(currentTime);//loop through while currentTime is smaller than SimulationTime
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		averageWaiting(nr, t);//call averageWaiting method
		averageArrival(nr, a);//call averageArrival method
	}

	public void showTime(int time) {
		if (time <= simulationTime) {
			String s = Integer.toString(time);
			view.getLog().append("Current simulation time is :" + time + "\n");
			// LOGGER.info("Current simulation time is :" + time + "\n" + "\n");
			view.getSimTimeText().setText(s);
		} else {
			view.getLog().append("Simulation has finished\n");
			// LOGGER.info("Simulation has finished" + "\n");
		}
	}

	public void showQueues() {
		for (int i = 0; i < queues.size(); i++) {
			view.setQueues(queues.get(i).toString(), i);
			if (queues.get(i).toString() == "") {
				view.getLog().append("Queue" + i + ": " + "is empty" + "\n");
			} else {
				view.getLog().append("Queue" + i + ": " + queues.get(i).toString() + "\n");
			}
		}
	}

	public void startQueues() {//start threads for the queues of the simulation
		for (Server server : this.queues) {
			Thread t = new Thread(server);
			t.start();
		}
	}

	public void averageWaiting(int noClients, int service) {
		double avg = (double) service / (double) noClients;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		view.getAvrTime().setText(String.valueOf(numberFormat.format(avg)));
	}

	public void averageArrival(int noClients, int arrival) {
		double avg = (double) arrival / (double) noClients;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		view.getAvrArrival().setText(String.valueOf(numberFormat.format(avg)));
	}

}