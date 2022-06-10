import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
 
public class view extends JFrame {
 
    JLabel message;
    JLabel name;  
    JTextField nameField;
 
    JButton submitBtn;
    Container container;
 
    public view() {
        message = new JLabel("View the Bug");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        name = new JLabel("Your Bug filename");
        nameField = new JTextField();
 
        submitBtn = new JButton("View");
        container = getContentPane();
        container.setLayout(null);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter bug filename");
                }
                else{
                    try {
                        String filename = name + ".txt";
                        // Opening the Bug in Append Mode
                        File u = new File(filename); 
                        Desktop d = Desktop.getDesktop(); 
                        d.open(u); 
                    } catch (IOException er) {
                        JOptionPane.showMessageDialog(null, "An error occured");
                        er.printStackTrace();
                    } 
                }
            }
        });

        setBounds();
        addComponents();
 
    }

    public void setBounds() {
        message.setBounds(50, 10, 600, 30);
        name.setBounds(50, 60, 100, 30);
        nameField.setBounds(160, 60, 200, 30);
 
        submitBtn.setBounds(130, 160, 200, 30);
    }
 
    public void addComponents() {
        container.add(message);
        container.add(name);
        container.add(nameField);
        container.add(submitBtn);
    }
 
    public static void main(String[] args) {
        view frame = new view();
        frame.setTitle("View the bug");
        frame.setVisible(true);
 
    }
 
}