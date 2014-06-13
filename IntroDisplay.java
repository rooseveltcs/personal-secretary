import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class IntroDisplay extends Program{
   private JPanel main;
   
   private JButton newUser;
   private JButton loadUser;
   private JButton credits;
   
   private JLabel logo;
   
   
   public IntroDisplay(){
      newUser = button("New");
      loadUser = button("Load");
      credits = button("Credits");
      newUser.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            main.setVisible(false);
            askInfo();
         }
      });      
      loadUser.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            main.setVisible(false);
            load();
         }
      });
      credits.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            main.setVisible(false);
            credits();
         }
      });


      logo = new JLabel(new ImageIcon("images.jpg"));
   }
   
   private JButton button(String name) {
      JButton button = new JButton(name);
      button.setText(name);
      button.setBackground(Color.WHITE); 
      return button;
   }
   
   
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
   
/*   public void actionPerformed(ActionEvent event) {
      main.setVisible(false);
      if(event.getActionCommand().equals("New")) {
         super.askInfo();
      } else if(event.getActionCommand().equals("Load")){
         super.load();
      } else {
         super.credits();
      }
   }   */
}