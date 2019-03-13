package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MonitoredData {

	private  LocalDateTime startTime, endTime;
	private String activity;
	
	
	public MonitoredData(String startTime, String endTime, String activity) throws ParseException {
		DateTimeFormatter start = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.startTime = LocalDateTime.parse(startTime, start);
		DateTimeFormatter end = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.endTime = LocalDateTime.parse(endTime, end);
		this.activity = activity;
	}

	/*
	 * getters and setters for the attributes + toString method + getDuration method
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public int getStartDay() {
		return startTime.getDayOfYear();
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
	public Duration getDuration() {
		Duration dur = Duration.between(this.getStartTime(), this.getEndTime());
		return dur;
	}

	@Override
	public String toString() {
		return "MonitoredData [startTime=" + startTime + ", endTime=" + endTime + ", activity=" + activity + "]";
	}

	
}
