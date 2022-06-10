import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.io.*;
 
public class file extends JFrame {
 
    JLabel message;
    JLabel name, bugtype, bugdescription, bugpriority, bugstatus;  
    JTextField nameField, bugtypeField, bugdesField, bugpriField;

    JComboBox<String> bugstatusList;
 
    JButton submitBtn;
    Container container;
 
    public file() {
        message = new JLabel("File a Bug");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        name = new JLabel("Your Name");
        nameField = new JTextField();
 
        bugtype = new JLabel("Bug type");
        bugtypeField = new JTextField();
 
        bugdescription = new JLabel("Bug description");
        bugdesField = new JTextField();
 
        bugpriority = new JLabel("Bug priority");
        bugpriField = new JTextField();
 
        bugstatus = new JLabel("Bug status");
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
                String bugtype = bugtypeField.getText();
                String bugdescription = bugdesField.getText();
                String bugpriority = bugpriField.getText();
                String bugstatus = (String) bugstatusList.getSelectedItem();

                // Current Time
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                File f;

                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your name");
                }
                else if(bugtype.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a bug type");
                }
                else if(bugdescription.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a bug description");
                }
                else if(bugpriority.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a bug priority");
                }
                else{
                    try {
                        int max = 100;int min = 1;
                        Random randomNum = new Random();
                        int id = min + randomNum.nextInt(max);
                        String filename = name + id + ".txt";
                        f = new File(filename);  

                        if (f.createNewFile()) {
                            FileWriter fwrite = new FileWriter(filename);
                            fwrite.write("DATE AND TIME : " + dtf.format(now));
                            fwrite.write("\n");

                            fwrite.write("BUG ID : " + id);
                            fwrite.write("\n");

                            fwrite.write("BUG FILED BY: " + name);
                            fwrite.write("\n");

                            fwrite.write("TYPE OF BUG: " + bugtype);
                            fwrite.write("\n");

                            fwrite.write("BUG PRIORITY: " + bugpriority);
                            fwrite.write("\n");

                            fwrite.write("BUG DESCRIPTION: " + bugdescription);
                            fwrite.write("\n");
                            fwrite.write("BUG STATUS:");
                            fwrite.write(bugstatus);
                            fwrite.close();
                            JOptionPane.showMessageDialog(null, "Bug filed succesfuly");
                            dispose();


                        } else {
                            System.out.println("File already exists.");
                            JOptionPane.showMessageDialog(null, "File already exists.");
                        }
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
        nameField.setBounds(130, 60, 200, 30);
 
        bugtype.setBounds(50, 160, 100, 30);
        bugtypeField.setBounds(130, 160, 200, 30);
 
        bugdescription.setBounds(50, 210, 100, 30);
        bugdesField.setBounds(150, 210, 200, 30);
 
        bugpriority.setBounds(50, 260, 100, 30);
        bugpriField.setBounds(130, 260, 200, 30);
 
        bugstatus.setBounds(50, 310, 310, 30);
        bugstatusList.setBounds(130, 310, 200, 30);
 
        submitBtn.setBounds(130, 400, 200, 30);
    }
 
    public void addComponents() {
        container.add(message);
        container.add(name);
        container.add(nameField);
        container.add(bugtype);
        container.add(bugtypeField);
        container.add(bugdescription);
        container.add(bugdesField);
        container.add(bugpriority);
        container.add(bugpriField);
        container.add(bugstatus);
        container.add(bugstatusList);
        container.add(submitBtn);
    }
 
    public static void main(String[] args) {
        file frame = new file();
        frame.setTitle("File a Bug");
        frame.setVisible(true);
 
    }
 
}