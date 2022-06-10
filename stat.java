import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.io.*;
 
public class stat extends JFrame {
 
    JLabel message;
    JLabel name, bugstatus;  
    JTextField nameField;

    JComboBox<String> bugstatusList;
 
    JButton submitBtn;
    Container container;
 
    public stat() {
        message = new JLabel("Change the status of the Bug");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        name = new JLabel("Your Bug filename");
        nameField = new JTextField();
 
        bugstatus = new JLabel("New Bug status");
        bugstatusList = new JComboBox<String>();
 
        bugstatusList.addItem("NOT YET ASSIGNED");
        bugstatusList.addItem("IN PROCESS");
        bugstatusList.addItem("FIXED");
        bugstatusList.addItem("DELIVERED");
 
        submitBtn = new JButton("Submit");
        container = getContentPane();
        container.setLayout(null);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String bugstatus = (String) bugstatusList.getSelectedItem();

                // Current Time
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  

                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter bug filename");
                }
                else{
                    try {
                        String filename = name + ".txt";
                        // Opening the Bug in Append Mode
                        BufferedWriter f = new BufferedWriter(new FileWriter(filename, true));

                        f.write("\n");
                        f.write("*********Updated BUG STATUS*********\n");
                        f.write("DATE AND TIME : " + dtf.format(now));
                        f.write("\n");
                        f.write("BUG STATUS:");
                        f.write(bugstatus);
                        f.close();
                        JOptionPane.showMessageDialog(null, "Bug status was changed succesfully");
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
 
        bugstatus.setBounds(50, 160, 310, 30);
        bugstatusList.setBounds(150, 160, 200, 30);
 
        submitBtn.setBounds(130, 200, 200, 30);
    }
 
    public void addComponents() {
        container.add(message);
        container.add(name);
        container.add(nameField);
        container.add(bugstatus);
        container.add(bugstatusList);
        container.add(submitBtn);
    }
 
    public static void main(String[] args) {
        stat frame = new stat();
        frame.setTitle("Change the status of the bug");
        frame.setVisible(true);
 
    }
 
}