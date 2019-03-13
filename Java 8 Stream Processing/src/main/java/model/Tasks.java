package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {

	private List<MonitoredData> list;

	public Tasks() {
		this.list = new ArrayList<MonitoredData>();
	}

	public void readFile() {//Read from txt file and create MonitoredData objects
		String fileName = "Activities.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(s -> {
				try {
					list.add(new MonitoredData(s.split("\t\t")[0], s.split("\t\t")[1], s.split("\t\t")[2]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
	}

	public long countDistinct() {//Count distinct days
		List<String> listk = new ArrayList<String>();
		list.forEach(e -> listk.add(e.getStartTime().toString().substring(0, 10)));
		list.forEach(e -> listk.add(e.getEndTime().toString().substring(0, 10)));
		return listk.stream().distinct().sorted().count();

	}

	public Map<String, Integer> distinctActivity() {//Count occurences of activities
		List<String> listk = new ArrayList<String>();
		list.forEach(e -> listk.add(e.getActivity()));
		return listk.stream().collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));

	}

	public Map<Integer, Map<String, Integer>> countDaily() {//Count activities for each day

		Map<Integer, Map<String, Integer>> map = list.stream().collect(Collectors.groupingBy(MonitoredData::getStartDay,
				Collectors.groupingBy(MonitoredData::getActivity, Collectors.reducing(0, s -> 1, Integer::sum))));
		return map;
	}

	public Map<String, Duration> duration() {//Get the activities where max duration > 10 h
		Map<String, Duration> map = list.stream()
				.collect(Collectors.toMap(MonitoredData::getActivity, MonitoredData::getDuration, Duration::plus));
		Map<String, Duration> result = map.entrySet().stream().filter(e -> e.getValue().toHours() >= 10)
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		return result;
	}

	public List<String> lessThan() {//the final filtering task with < 5 minutes in 90% of occurences
		Map<String, List<MonitoredData>> map = list.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.toList()));
		List<String> s = map.entrySet().stream().filter(e -> {
			int count = 0;
			for(MonitoredData i : e.getValue()) {
				if (i.getDuration().toMinutes() < 5) {
					count++;
				}
			}
			boolean condition = (count / (double) e.getValue().size() > 0.9);
			if (condition == true) {
				return true;
			}
			return false;
		}).map(Map.Entry::getKey).collect(Collectors.toList());
		return s;

	}

}
