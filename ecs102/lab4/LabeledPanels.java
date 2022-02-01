//LabeledPanels.java   Author: Baruch
//Introduce: Frames, Panels, Labels, color

import java.awt.*;
import javax.swing.*;

public class LabeledPanels
{
   public static void main (String[] args)
   {
      // create a window with a title
      JFrame frame = new JFrame ("Color Panels");
      
      // tell it what to do when the close button is clicked
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      
      // Set up  first subpanel
      JPanel leftPanel = new JPanel();
      // set 150 pixels by 100 pixels
      leftPanel.setPreferredSize (new Dimension(150, 100));
      // set the color to green
      leftPanel.setBackground(Color.green);
      //Add text to the Panel
      JLabel label1 = new JLabel ("Left");
      leftPanel.add(label1);
      
      // Set up second subpanel
      JPanel rightPanel = new JPanel();
      rightPanel.setPreferredSize (new Dimension(20,100));
      rightPanel.setBackground(Color.yellow);
      JLabel label2 = new JLabel ("Right");
      JLabel label3 = new JLabel ("Yellow");
      JLabel label4 = new JLabel ("Small");
      rightPanel.add(label2);
      
      // Set up primary panel
      JPanel primary = new JPanel();
      primary.setBackground(Color.blue);
      JLabel labelBig = new JLabel ("Primary");
      primary.add(labelBig);
      
      primary.add(leftPanel);
      primary.add(rightPanel);
      
      // Add panels to frame
      frame.getContentPane().add(leftPanel);
      frame.pack();
      frame.setVisible(true);   
   } // end main
}// end class