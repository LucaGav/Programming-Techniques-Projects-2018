package controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

import model.MonitoredData;
import model.Tasks;
import view.View;

public class Controller {

	private View view;
	private Tasks tasks;

	public Controller() {
		view = new View();
		view.init();
		tasks = new Tasks();
		tasks.readFile();//initialize the attributes of the Controller class

		/*
		 * Control the actionListener methods from the View class
		 */
		view.button1(e -> {
			long c = tasks.countDistinct();
			String s = "Number of distinct days:" + String.valueOf(c);
			view.getTextArea().setText(s);
			try {
				PrintWriter writer = new PrintWriter("Out.txt", "UTF-8");
				writer.println(s);
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

		});

		view.button2(e -> {
			String out = new String();
			Map<String, Integer> m = tasks.distinctActivity();
			Set<String> aux = m.keySet();
			Iterator<String> iterator = aux.iterator();
			while (iterator.hasNext()) {
				String s = iterator.next();
				out = out + s + m.get(s) + "\n";
			}
			view.getTextArea().setText(out);
			try {
				PrintWriter writer = new PrintWriter("Out.txt", "UTF-8");
				writer.print(out);
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		});

		view.button3(e -> {
			String out = new String();
			Map<Integer, Map<String, Integer>> m = tasks.countDaily();
			Set<Integer> aux = m.keySet();
			Iterator<Integer> iterator = aux.iterator();
			while (iterator.hasNext()) {
				int i = iterator.next();
				out = out + String.valueOf(i) + "\n" + m.get(i) + "\n" + "\n";
			}
			view.getTextArea().setText(out);
			try {
				PrintWriter writer = new PrintWriter("Out.txt", "UTF-8");
				writer.print(out);
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		});
		/*
		 * view.button4(e->{ String out = new String(); Map<String,Long> m =
		 * tasks.duration(); Set<String> aux = m.keySet(); Iterator<String> iterator =
		 * aux.iterator(); while(iterator.hasNext()) { String s = iterator.next(); out =
		 * out + s + "    " + m.get(s) + "\n"; } try { PrintWriter writer = new
		 * PrintWriter("Out.txt", "UTF-8"); writer.print(out); writer.close(); } catch
		 * (FileNotFoundException | UnsupportedEncodingException e1) {
		 * e1.printStackTrace(); } view.getTextArea().setText(out); });
		 */

		view.button4(e -> {
			String out = new String();
			Map<String, Duration> m = tasks.duration();
			Set<String> aux = m.keySet();
			Iterator<String> iterator = aux.iterator();
			while (iterator.hasNext()) {
				String s = iterator.next();
				String g = String.format("%d:%02d:%02d", m.get(s).getSeconds() / 3600,
						(m.get(s).getSeconds() % 3600) / 60, m.get(s).getSeconds() % 60);
				out = out + s + "    " + g + "\n";
			}
			try {
				PrintWriter writer = new PrintWriter("Out.txt", "UTF-8");
				writer.print(out);
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			view.getTextArea().setText(out);
		});
		view.button5(e -> {
			String out = new String();
			List<String> m = tasks.lessThan();
			Iterator<String> iterator = m.iterator();
			while (iterator.hasNext()) {
				String s = iterator.next();
				out = out + s + "\n";
			}
			try {
				PrintWriter writer = new PrintWriter("Out.txt", "UTF-8");
				writer.print(out);
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			view.getTextArea().setText(out);
		});

	}

}
