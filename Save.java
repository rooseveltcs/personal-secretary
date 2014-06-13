import java.util.*;
import java.io.*;

public class Save {
   private ArrayList<Class> classes;
   private ArrayList<String> names;
   private int quarter;
   private PrintWriter out;
   private Scanner scanData;
   private File savedData;
   public Save(ArrayList<Class> classes, ArrayList<String> names, int quarter)throws IOException{
      this.classes = classes;
      this.names = names;
      this.quarter = quarter; 
      savedData = new File("savedData.txt");
      scanData = new Scanner(savedData);
      out = new PrintWriter(savedData);
      print();    
      
   }
   
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