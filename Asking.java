import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Asking extends Program implements ActionListener{
   private JPanel questions;
   private JTextPane intro;
   private JPanel quarterHS;
   private int highS;
   private int colle;
   private int placeholder;
   private JPanel quarterC;
   private JPanel overallInfo;
   private JPanel userInfo;
   private JPanel schoolAsk;
   private JPanel empty;
   private JPanel overall;
   private int quarterNum;
   private JPanel info;
   private JTextField firstName;
   private JTextField lastName;
   private JTextField schoolName;
   private ArrayList<String> names;
   
   public Asking() {
      highS = 0;
      colle = 0;
      placeholder = 0;
      questions = new JPanel(new BorderLayout());
      overallInfo = new JPanel (new BorderLayout());
      userInfo = new JPanel(new GridLayout(1,6));
      empty = new JPanel();
      schoolAsk = new JPanel (new GridLayout(3,1));
      quarterHS = new JPanel(new FlowLayout());
      quarterC = new JPanel(new FlowLayout());
      overall = new JPanel(new GridLayout(1,1));
      info = new JPanel(new BorderLayout());
      overall.add(quarterC);    
      overall.add(quarterHS);
      info.add(overall, BorderLayout.NORTH);
      overallInfo.add(info, BorderLayout.SOUTH);  
      names = new ArrayList<String>();    
   }
   public JPanel ask() {
      questions.add(empty, BorderLayout.CENTER); 
      intro = introText();         
      questions.add(intro, BorderLayout.NORTH);
      personalInfo();
      schoolAsk();
      //quarterInfo();
      overallInfo.add(userInfo, BorderLayout.NORTH);
      overallInfo.add(schoolAsk, BorderLayout.CENTER);
      questions.add(overallInfo, BorderLayout.SOUTH);     
      return questions;
   }
   
   private JLabel label(String name) {
      JLabel label = new JLabel(name, JLabel.CENTER);
      label.setPreferredSize(new Dimension(80, 15));
      return label;  
   }
   
   private JTextField text(){
      JTextField text = new JTextField();
      text.setPreferredSize(new Dimension(85, 20));
      return text;
   }
   private JTextPane introText() {
      JTextPane text = new JTextPane();
      text.setEditable(false);
      text.setText(" Welcome to Personal Secretary Student Version! Before we start organizing your schedule and\n time, let's set up your profile so you can access it again. All we need is basic information. \n You can edit this information later in the settings option. If you do not wish to answer, feel\n free to leave it blank.");
      return text;
  }
  
  private void personalInfo() {
      JLabel fName = label("First Name");
      JLabel lName = label("Last Name");
      JLabel sName = label("School Name");
      firstName = text();
      lastName = text();
      schoolName = text();
      userInfo.add(fName);
      userInfo.add(firstName);
      userInfo.add(lName);
      userInfo.add(lastName);
      userInfo.add(sName);
      userInfo.add(schoolName); 
  }
  
  private void schoolAsk(){
      schoolAsk = new JPanel(new GridLayout(1, 3));
      JLabel question = new JLabel ("What school are you in?", JLabel.CENTER);
      JRadioButton highSchool = radioButton ("High School");
      JRadioButton college = radioButton ("College");
      schoolAsk.add(question);
      ButtonGroup group = new ButtonGroup();
      group.add(highSchool);
      group.add(college);
      schoolAsk.add(highSchool);
      schoolAsk.add(college);
  }
  
  private void highSchool(){
      overall.remove(quarterC);
      overall.revalidate();
      colle += 2;
      if (highS == 0) {
         JRadioButton firstSem = radioButton("1st Semester");
         JRadioButton secondSem = radioButton("2nd Semester");
         
         ButtonGroup group = new ButtonGroup();
         group.add(firstSem);
         group.add(secondSem);
         quarterHS.add(firstSem);
         quarterHS.add(secondSem);
      }
      if(highS == 0 || highS % 2 == 0) {
        // overall.remove(quarterC);
         overall.add(quarterHS);
      } 
      overall.revalidate();
  }
  
  private void college() {
      overall.remove(quarterHS);
      overall.revalidate();
      highS += 2;
      if (colle <= 2) {
         JRadioButton fall = radioButton("Fall");
         JRadioButton winter = radioButton("Winter");
         JRadioButton spring = radioButton("Spring");
         JRadioButton summer = radioButton("Summer");
         
         ButtonGroup group = new ButtonGroup();
         group.add(fall);
         group.add(winter);
         group.add(spring);
         group.add(summer);
         
         quarterC.add(fall);
         quarterC.add(winter);
         quarterC.add(spring);
         quarterC.add(summer);
      }
      if(colle == 0 || colle % 2 == 0) {
         //overall.remove(quarterHS);
         overall.add(quarterC);    
      } 
      overall.revalidate();
  }
  
  private void next() {
      JButton next = button("Continue");
      info.add(next, BorderLayout.CENTER);
      setNames();
      overall.revalidate();
  }

  public void setNames() {
      names = new ArrayList<String>();
      names.add(firstName.getText());
      names.add(lastName.getText());
      names.add(schoolName.getText()); 
  }
  
  private JRadioButton radioButton(String name){
      JRadioButton box = new JRadioButton(name);
      box.setSelected(false);
      box.addActionListener(this);
      
      return box;
  }
  private JButton button(String name) {
      JButton button = new JButton(name);
      button.setText(name);
      button.setBackground(Color.WHITE);
      button.addActionListener(this);
      
      return button;
   }
  
   public void actionPerformed(ActionEvent event) {
      if (event.getActionCommand().equals("High School")) {
         highSchool();
      } else if(event.getActionCommand().equals("College")) {
         college();                                     
      } else if (event.getActionCommand().equals("Continue")){
         questions.setVisible(false);
         super.classInfo(names, quarterNum);
      } else{
         if(event.getActionCommand().equals("Fall")){
            quarterNum = 1;
            placeholder++;
         } else if(event.getActionCommand().equals("Winter")){
            quarterNum = 2;
            placeholder++;
         } else if(event.getActionCommand().equals("Spring")) {
            quarterNum = 3;
            placeholder++;
         } else if(event.getActionCommand().equals("Summer")) {
            quarterNum = 4;
            placeholder++;
         } else if(event.getActionCommand().equals("1st Semester")) {
            quarterNum = 5;
            placeholder++;
         } else if(event.getActionCommand().equals("2nd Semester")) {
            quarterNum = 6;
            placeholder++;
         }
         if (placeholder == 1) {
            next();
         }
      }
   }     
  
}