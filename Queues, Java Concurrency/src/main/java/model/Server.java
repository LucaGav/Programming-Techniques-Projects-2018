package model;

import java.util.ArrayList;
import java.util.logging.Logger;

import view.View;

public class Server implements Runnable {

	private ArrayList<Client> queue;
	

	public Server() {//constructor for the Server class
		this.queue = new ArrayList<Client>();

	}

	/*
	 * getter and setter
	 */
	public ArrayList<Client> getQueue() {
		return queue;
	}

	public void setQueue(ArrayList<Client> queue) {
		this.queue = queue;
	}

	/*
	 * enqueue and dequeue methods, specific for this class
	 */
	public void enqueue(Client c) {
		this.queue.add(c);
	}

	public void dequeue() {
		this.queue.remove(0);
	}
	//toString method
	public String toString() {
		String s = "";
		for (Client c : queue) {
			s = s + c.toString() + " ";
		}
		return s;
	}
	//overridden run method for dequeuing each server
	public void run() {
		int serv;
		String s = "";
		while (!this.queue.isEmpty()) {
			serv = this.queue.get(0).getServiceTime();
			try {
				Thread.sleep(serv * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!queue.isEmpty()) {
				this.dequeue();
			}
		}
	}
}
