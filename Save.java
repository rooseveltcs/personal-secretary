/*
Takes all of the information that user has and saves it onto a new textfile to be accessed again at a later date

@author Nhi Ngo 
@version 06/16/2014
*/

import java.util.*;
import java.io.*;

public class Save {
   private ArrayList<Class> classes;
   private ArrayList<String> names;
   private int quarter;
   private PrintWriter out;
   private Scanner scanData;
   private File savedData;
   
   /*Initializes instance fields*/
   public Save(ArrayList<Class> classes, ArrayList<String> names, int quarter)throws IOException{
      this.classes = classes;
      this.names = names;
      this.quarter = quarter; 
      savedData = new File("savedData.txt");
      scanData = new Scanner(savedData);
      out = new PrintWriter(savedData);
      print();    
      
   }
   /*Sends out all of the user's information into the new text document*/
   private void print(){
         for (int i = 0; i < names.size(); i++) {
            out.print(names.get(i) + " ");
         }
         out.println(" " + quarter);
         for (int i = 0; i < classes.size(); i++) {
            out.print(classes.get(i).getName() + " ");
            out.print(classes.get(i).getTeacher() + " ");
            out.print(classes.get(i).getTime() + " ");
         }
         out.close();
   }
}