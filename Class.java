/*
Holds all information regarding class information that user has inputed

@author Nhi Ngo
@version 06/15/2014
*/

public class Class {
	private String time;
	private String name;
	private String teacher;
   private Assignment assignment;
   private int number;

   /*
   *Initializes all instance fields
   *@param time the time the class begins
   *@param name name of the class
   *@param teacher name of the teacher/professor
   *@param classNumber placeholder to know which class to remove later on
   */	
	public Class (String time, String name, String teacher, int classNumber){
		this.time = time;
 		this.name = name;
		this.teacher = teacher;
      this.number = classNumber;
	}
	
   /*
   *Gets the time of the class
   *@returns time the time of the class
   */
	public String getTime(){
		return time;
	}

   /*
   *Gets the name of the class
   *@returns name the name of the class
   */	
	public String getName(){
		return name;
	}
	
   /*
   *Gets the name of the teacher of the class
   *@returns teacher the name of the teacher of the class
   */   
	public String getTeacher(){
		return teacher;
	}
}