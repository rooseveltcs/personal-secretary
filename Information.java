import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Information{
   private ArrayList<JTextField> lists;
   private String text;

   public Information(JTextField fName, JTextField lName, JTextField sName) {
      lists = new ArrayList<JTextField>();
      lists.add(fName);
      lists.add(lName);
      lists.add(sName);
   }
   
   public void setListener() {
      lists.get(0).addActionListener(new NewTextListener());     
   }
   
   public void actionPerformed(ActionEvent evt) {
      text = lists.get(0).getText();
      System.out.println(text);
   }
   
}