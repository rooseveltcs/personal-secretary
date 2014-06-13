public class Assignment{
	private String name;
	private String description;
	private int dueHour;
	private int dueMinute;
	private int dueMonth;
	private int dueDay;
	
	public Assignment(String name, int hour, int minute, int month, int day, String descript){
		this.name = name;
		dueHour = hour;
		dueMinute = minute;
		dueMonth = month;
		dueDay = day;
		description = descript;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDueDate(){
		String date = "";
		if (dueHour > 12){
			date = dueMonth + " " + dueDay + " " + (dueHour - 12) + ":" + dueMinute;
			return date;
		} else {
			date = dueMonth + " " + dueDay + " " + dueHour + ":" + dueMinute;
			return date;
		}
	}
	
	public String getDescription(){
		return description;
	}
}