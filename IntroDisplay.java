/*
Displays beginning options that user can pick. New, Load, Credits. Depending on what the users pick, 
the display will change accordingly. Also displays the logo of the program.
@author Nhi Ngo
@version 06/15/2014
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class IntroDisplay extends Program{
   private JPanel main; //main frame
   private JButton newUser; //new User button
   private JButton loadUser; //load user button
   private JButton credits; //credits button
   private JLabel logo; //logo label
   
   /*
   *Initializes the fields of this class
   */
   public IntroDisplay(){
      newUser = button("New");
      loadUser = button("Load");
      credits = button("Credits");
      newUser.addActionListener(new ActionListener() {
         @Override
         /*sets main to false and calls askInfo method of super class*/
         public void actionPerformed(ActionEvent event) {
            main.setVisible(false);
            askInfo();
         }
      });      
      loadUser.addActionListener(new ActionListener() {
         @Override
         /*sets main to false and calls load method of super class*/
         public void actionPerformed(ActionEvent event) {
            main.setVisible(false);
            load();
         }
      });
      credits.addActionListener(new ActionListener() {
         @Override
         /*sets main to false and calls credits method of super class*/
         public void actionPerformed(ActionEvent event) {
            main.setVisible(false);
            credits();
         }
      });
      logo = new JLabel(new ImageIcon("images.jpg"));
   }
   
   /*
   *Set the settings of a button
   *@param name the text that is on the button
   *@return button modified and setted button
   */
   private JButton button(String name) {
      JButton button = new JButton(name);
      button.setText(name);
      button.setBackground(Color.WHITE); 
      return button;
   }
   
   /*
   *Add all objects to the main frame
   *@return main calls the main frame
   */
   public JPanel start() {
      main = new JPanel(new BorderLayout());
      main.add(logo, BorderLayout.NORTH);
      JPanel buttons = new JPanel(new GridLayout(1,3));
      buttons.add(newUser);
      buttons.add(loadUser);
      buttons.add(credits);
      main.add(buttons, BorderLayout.SOUTH);
      return main;
   }
}