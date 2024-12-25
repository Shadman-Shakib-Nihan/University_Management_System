package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddTeacher extends JFrame  implements ActionListener{
    
    private JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfdob,tfblood, tfid;
    private JComboBox cbcourse, cbbranch;
    private JButton submit, back;
    
    
    public AddTeacher() {

       
        
        setSize(1440, 800);
       
        
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/mT.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(850, 100, 500, 500);
        add(image);

        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
     //---------------------------  


        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
     //----------------------------
        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempId);

        tfid = new JTextField();
        tfid.setBounds(200, 200, 150, 30);
        add(tfid);
     

     //----------------------------------------   
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        tfdob = new JTextField();
        tfdob.setBounds(600, 200, 150, 30);
        add(tfdob);
        

    //---------------------------------------

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
         add(tfaddress);
    //---------------------------------------


        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

     //==---------------------------------
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 150, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        //==---------------------------------

        
        JLabel lblbloodg = new JLabel("Blood Group");
        lblbloodg.setBounds(400, 300, 200, 30);
        lblbloodg.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbloodg);
        
        tfblood = new JTextField();
        tfblood.setBounds(600, 300, 150, 30);
        add(tfblood);
        
        //==---------------------------------
        
       
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course[] = {"PhD", "BBA",  "Bsc", "Msc", "MBA","MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[] = {"Computer Science", "Electronics", "BBA", "English", "Law"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        //submit.setBackground(Color.BLACK);
        //submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 120, 30);
        //cancel.setBackground(Color.BLACK);
        //cancel.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        setVisible(true);
        
       
    }



    private void writeToFile(String data) {
    try (FileWriter fileWriter = new FileWriter("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/teachers.txt", true);
         BufferedWriter writer = new BufferedWriter(fileWriter)) {

        writer.write(data);
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
        
    }
}

    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            if(!tffname.getText().isEmpty() && !tfdob.getText().isEmpty() && !tfaddress.getText().isEmpty() && 
                !tfphone.getText().isEmpty()&& !tfemail.getText().isEmpty()&& !tfblood.getText().isEmpty()&& !tfid.getText().isEmpty())
            {

               
            String name = tfname.getText();
            String fname=tffname.getText();
            String birthDate =  tfdob.getText();
            String id = tfid.getText();
            String address = tfaddress.getText();
            int phonenumber = Integer.parseInt(tfphone.getText()); 
            String email = tfemail.getText();
            String bloodGroup = tfblood.getText();
            
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            String teacherDetails ="ID : " + id +"      Phone :" + phonenumber + "      Name :" +name + "      F.Name :"+fname+"      birthDate : " + birthDate +"      Address : " + address + "      Email :"+ email + "      bloodGroup :" + bloodGroup + "      Qualification :" + course + "      Department :" + branch;
            writeToFile(teacherDetails);

          
            
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                new AddTeacher();
                setVisible(false);
            
        } else{
            JOptionPane.showMessageDialog(null, "Give all information!");
        }
         
        }else if(ae.getSource()==back){
            new DashBoard();
            setVisible(false);
        }
    }
  
}