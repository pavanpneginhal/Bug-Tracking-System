import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class gui extends JFrame
{
     JButton b1,b2,b3;
     JLabel lbl;
     gui()
     {
          b1 = new JButton("File a bug");
          b2 = new JButton ("Change the status of the bug");
          b3 = new JButton ("View the bug");
          lbl = new JLabel ("Bug Tracking System");
          lbl.setFont(new Font("Courier", Font.BOLD, 20));
          setLayout (new GridLayout(4,1));
          setSize (400,200);
          add(lbl);
          add(b1);
          add(b2);
          add(b3);
          setVisible(true);

          //setDefaultCloseOperation(JFrame.EXIT_NO_CLOSE);
          ButtonHandler bh = new ButtonHandler();
          b1.addActionListener(bh);
          b1.addActionListener(bh);
          b2.addActionListener(bh);
          b3.addActionListener(bh);
     }
     class ButtonHandler implements ActionListener
     {
          public void actionPerformed(ActionEvent ae)
          {
               if (ae.getSource()==b1)
               {
                    file f = new file();
                    f.setVisible(true);
                    f.setBounds(500, 100, 500, 500);
                    f.setResizable(true);

               }
               else if (ae.getSource()==b2)
               {
                    stat f = new stat();
                    f.setVisible(true);
                    f.setBounds(500, 100, 500, 300);
                    f.setResizable(true);

               }
               else if (ae.getSource()==b3)
               {
                    view f = new view();
                    f.setVisible(true);
                    f.setBounds(500, 100, 500, 400);
                    f.setResizable(true);
               }
          }
     }
     public static void main(String args[])
     {
          new gui();
     }
}