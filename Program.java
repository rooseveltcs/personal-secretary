import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Program {
   private JFrame mainDisplay;
   private JPanel introduction;
   private Asking questionaire;
   private JPanel listClasses;
   private ArrayList<String> names;
   
   public Program() {
      mainDisplay = new JFrame("Personal Secretary");
      mainDisplay.setLayout(new FlowLayout());
      mainDisplay.setSize(540,580);
      mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
   
   public void intro() {
      IntroDisplay intro = new IntroDisplay();
      introduction = intro.start();
      mainDisplay.add(introduction);
      //mainDisplay.revalidate();
      mainDisplay.setVisible(true);
   }
   
   public void askInfo() {
      //mainDisplay.setVisible(false);
      this.questionaire = new Asking();
      JPanel questions = questionaire.ask();
      mainDisplay.add(questions);
      mainDisplay.setVisible(true);
      //mainDisplay.revalidate();
   }
   
   public void classInfo(ArrayList<String> listNames, int quarter) {
      names = listNames;
      
      ClassDisplay classes = new ClassDisplay(names, quarter);
      listClasses = classes.listOfClasses();
      mainDisplay.add(listClasses);
      mainDisplay.setVisible(true);
   }
   public void load() {
      
   }
   
   public void credits() {
   
   }
}