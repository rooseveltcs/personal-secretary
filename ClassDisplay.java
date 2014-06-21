/*
Displays all the classes that user has inputed and setted. Also displays user's information as well

@author Nhi Ngo
@version 06/15/2014
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class ClassDisplay {
   private ArrayList<String> names; // list of names
   private ArrayList<Class> listOfClass; //lists of classes
   private JPanel mainInfo;
   private JPanel main; 
   private JPanel listClasses;
   private JPanel profile;
   private String fullName;
   private String schoolName;
   private int quarter;
   private String quarterNow;
   private JTextField hour; 
   private JTextField minutes;
   private JTextField clName;
   private JTextField teName;
   private JFrame newClass;
   private int classNum;
   private JPanel clasS;
   
   /*
   *Initializes all instance fields.
   *@param lists contains the first, last, and school name of user
   *@param quarterY the # of quarter that the user is in currently.
   */
   public ClassDisplay(ArrayList<String> lists, int quarterY) {
      quarter = quarterY;
      names = lists;
      classNum = 0;
      this.quarter = quarter;
      main = new JPanel(new BorderLayout());
      mainInfo = new JPanel(new BorderLayout());
      listClasses = new JPanel(new GridLayout(13, 1));
      profile = new JPanel(new GridLayout(1, 3));
      listOfClass = new ArrayList<Class>();
      JButton add = new JButton("Add new Class");
      JButton save = new JButton("Save");
      add.addActionListener(new ActionListener() {
         @Override
         /*Adds a new class to screen*/
         public void actionPerformed(ActionEvent event) {
            addClassesScreen();
         }
      });
      save.addActionListener(new ActionListener() {
         @Override
         /*Saves all information that user has given*/
         public void actionPerformed(ActionEvent event){
            try {
               Save screen = new Save(listOfClass, names, quarter);
            }catch (IOException e) {
            }
         }
      });      
      JPanel tempGrid = new JPanel(new GridLayout(2, 1));
      tempGrid.add(add, BorderLayout.NORTH);
      tempGrid.add(save, BorderLayout.SOUTH);
      main.add(tempGrid, BorderLayout.SOUTH);
      setProfile();
   }
   
   /*Sets up display to show all of the user's information at the top of the main panel/frame*/
   private void setProfile() {
      fullName = names.get(0) + " " + names.get(1);
      schoolName = names.get(2);
      if(quarter >= 5) {
         schoolName += " High School";
         if(quarter == 5){
            quarterNow = "1st Semester";
         } else {
            quarterNow = "2nd Semester";
         }
      } else {
         if(quarter == 1) {
            quarterNow = "Fall";
         }else if (quarter == 2){
            quarterNow = "Winter";
         }else if (quarter == 3) {
            quarterNow = "Spring"; 
         }else if (quarter == 4){
            quarterNow = "Summer";
         }
      } 
      JLabel name = new JLabel(fullName, JLabel.CENTER);
      JLabel school = new JLabel(schoolName, JLabel.CENTER);
      JLabel quarterS = new JLabel(quarterNow, JLabel.CENTER);
      profile.add(name);
      profile.add(school);
      profile.add(quarterS);
      JLabel label = new JLabel("List of Classes", JLabel.CENTER);
      mainInfo.add(label, BorderLayout.CENTER);
      mainInfo.add(profile, BorderLayout.NORTH);

   }
   
   /*Sets the beginning layout of the classes screen*/
   public JPanel listOfClasses() {
      main.add(mainInfo, BorderLayout.NORTH);
      addClasses("Time", "Class Name", "Teacher Name", 100);
      main.add(listClasses, BorderLayout.CENTER);
      return main;
   }
   
   /*
   *Add a new class to the list of classes
   *@param time the time of their class
   *@param className name of the class
   *@param teachName name of the teacher
   *@param classNumber benchmark number so program knows which one to remove later
   */
   private void addClasses(String time, String className, String teachName, int classNumber) {
      Class newAdd = new Class(time, className, teachName, classNumber);
      clasS = new JPanel(new GridLayout(1, 5));
      JLabel timeSet = new JLabel(newAdd.getTime(), JLabel.CENTER);
      JLabel classNam = new JLabel(newAdd.getName(), JLabel.CENTER);
      JLabel teacherName = new JLabel(newAdd.getTeacher(), JLabel.CENTER);
      clasS.add(classNam);
      clasS.add(teacherName);
      clasS.add(timeSet);
      if (time.equals("Time")) {
         clasS.add(new JLabel());
         clasS.add(new JLabel());
      } 
      else{
         JButton viewMoreInfo = new JButton("View Class");
         JButton remove = new JButton("Remove");
         remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               System.out.println("hello");
            }
         });
         clasS.add(viewMoreInfo);
         clasS.add(remove);
         listOfClass.add(newAdd);
      }
      listClasses.add(clasS);
      listClasses.revalidate();
   }
   
   /*Continuation of setting up the layout of the classes screen*/
   private void addClassesScreen() {
      newClass = new JFrame("Add a New Class");
      newClass.setLayout(new FlowLayout());
      JLabel className = label("Class");
      JLabel teacherName = label("Teacher Name");
      clName = text();
      teName = text();
      newClass.add(className);
      newClass.add(clName); 
      newClass.add(teacherName);
      newClass.add(teName);
      JLabel time = label("Class Time");
      hour = new JTextField(2);
      JLabel colon = label(":"); 
      colon.setPreferredSize(new Dimension(10, 15));
      minutes = new JTextField(2);
      newClass.add(time);
      newClass.add(hour);
      newClass.add(colon);
      newClass.add(minutes);
      JButton add = button("Add");
      add.addActionListener(new ActionListener() {
         @Override
         /*
         *Receives all information of the classes time, and converts it to a string so it looks like it shows the
         *time
         */
         public void actionPerformed(ActionEvent event) {
            addClasses(hour.getText() + ":" + minutes.getText(), clName.getText(), teName.getText(), classNum);
            newClass.setVisible(false);
            classNum++;
         }
      });
      newClass.add(add);
      newClass.setVisible(true);
      newClass.pack();
   }
   
   /*
   *Sets the setting of the label
   *@param name text that will appear on the label
   */
   private JLabel label(String name) {
      JLabel label = new JLabel(name, JLabel.CENTER);
      label.setPreferredSize(new Dimension(100, 15));
      return label;  
   }
   
   /*Creates and set the settings of textfield*/
   private JTextField text(){
      JTextField text = new JTextField();
      text.setPreferredSize(new Dimension(85, 20));
      return text;
   }   
   
   /*
   *Creates and set the settings for button
   *@param name the text that will appear on the button
   */
   private JButton button(String name) {
      JButton button = new JButton(name);
      button.setText(name);
      button.setBackground(Color.WHITE);
      return button;
   }
}