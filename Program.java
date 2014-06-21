/*
Main class that controls which option user picks (new, load, or credits). Depending on what the user pick,
the interface changes. 
*@author Nhi Ngo
*@version 06/15/2014
*/

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
   
   /*
   *Sets the main frame that users will view from
   */
   public Program() {
      mainDisplay = new JFrame("Personal Secretary");
      mainDisplay.setLayout(new FlowLayout());
      mainDisplay.setSize(540,580);
      mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
   
   /*
   *Displays the intro by calling the IntroDisplay class. It displays three buttons ("options") for the user to
   *choose from. 
   */
   public void intro() {
      IntroDisplay intro = new IntroDisplay();
      introduction = intro.start();
      mainDisplay.add(introduction);
      mainDisplay.setVisible(true);
   }
   
   /*
   *Is called from the IntroDisplay class, and displays all asking information that pertain to 
   *new users: such as prompting to ask for name, school, and quarter.
   */
   public void askInfo() {
      this.questionaire = new Asking();
      JPanel questions = questionaire.ask();
      mainDisplay.add(questions);
      mainDisplay.setVisible(true);
   }
   
   /*
   *This method is called from the Asking class and uses all given info about the user to begin organizing
   *and asking for their classes. 
   *@param listNames the list of information of the user: first name, last name, and then school name
   *@param quarter which quarter the user is currently in in school. If it is over 4, then it is semsters.
   */
   public void classInfo(ArrayList<String> listNames, int quarter) {
      names = listNames;
      
      ClassDisplay classes = new ClassDisplay(names, quarter);
      listClasses = classes.listOfClasses();
      mainDisplay.add(listClasses);
      mainDisplay.setVisible(true);
   }
   
   /*
   *Method that begins loading information. 
   */
   public void load() {
      
   }
   
   /*
   *Method that loads the credits information
   */
   public void credits() {
   
   }
}