import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class ClassDisplay {
   private ArrayList<String> names;
   private ArrayList<Class> listOfClass;
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
         public void actionPerformed(ActionEvent event) {
            addClassesScreen();
         }
      });
      save.addActionListener(new ActionListener() {
         @Override
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
   
   public JPanel listOfClasses() {
      main.add(mainInfo, BorderLayout.NORTH);
      addClasses("Time", "Class Name", "Teacher Name", 100);
      main.add(listClasses, BorderLayout.CENTER);
      return main;
   }
   
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
   
   private JLabel label(String name) {
      JLabel label = new JLabel(name, JLabel.CENTER);
      label.setPreferredSize(new Dimension(100, 15));
      return label;  
   }
   private JTextField text(){
      JTextField text = new JTextField();
      text.setPreferredSize(new Dimension(85, 20));
      return text;
   }   
   private JButton button(String name) {
      JButton button = new JButton(name);
      button.setText(name);
      button.setBackground(Color.WHITE);
      //button.addActionListener(this);
      
      return button;
   }
}