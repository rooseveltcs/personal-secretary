public class Class {
	private String time;
	private String name;
	private String teacher;
   private Assignment assignment;
   private int number;
	
	public Class (String time, String name, String teacher, int classNumber){
		this.time = time;
 		this.name = name;
		this.teacher = teacher;
      this.number = classNumber;
	}
	
	public String getTime(){
		return time;
	}
	
	public String getName(){
		return name;
	}
	
	public String getTeacher(){
		return teacher;
	}
   
   public void newAssignment(String name, int hour, int minute, int month, int day, String descript) {
      assignment = new Assignment(name, hour, minute, month, day, descript);
   } 
}