package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;  
import java.io.FileReader;      
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;
public class Login extends JFrame implements ActionListener{
   JButton login,sign,exit;
   JTextField tfusername  ;
  JPasswordField tfpassword;

   public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        JLabel jusername = new JLabel("Username");
        jusername.setBounds(40, 20, 100, 20);
        add(jusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        JLabel jpassword = new JLabel("Password");
        jpassword.setBounds(40, 70, 100, 20);
        add(jpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        //login.setBackground(Color.PINK);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        sign = new JButton("Sign up");
        sign.setBounds(180, 140, 120, 30);
        //registration.setBackground(Color.BLACK);
        sign.setForeground(Color.BLACK);
        sign.addActionListener(this);
        add(sign);

        exit = new JButton("Exit");
        exit.setBounds(460, 220, 120, 30);
        //registration.setBackground(Color.BLACK);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bird.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);

   }

     public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == login) {
        String username = tfusername.getText();
        String password = tfpassword.getText();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/user_credentials.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String savedUsername = parts[0];
                String savedPassword = parts[1];

                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    found = true;
                    setVisible(false);
                    new StudentDash();
                    break; 
                }
            }

            
            if (!found && (username.equals("admin") && password.equals("admin")) ||
                    (username.equals("nihan") && password.equals("nihan")) ||
                    (username.equals("mazid") && password.equals("mazid")) ||
                    (username.equals("ayon") && password.equals("ayon")) ||
                    (username.equals("easha") && password.equals("easha")) ||
                    (username.equals("alvi") && password.equals("alvi"))) {
                found = true;
                setVisible(false);
                new DashBoard();
            }

            if (!found) {
                showMessageDialog(null, "Invalid Username or password!");
            }
        } catch (IOException e) {
            showMessageDialog(null, "Error reading user credentials. Try again!");
        }
    } else if (ae.getSource() == sign) {
        new SignUp();
        
        setVisible(false);
    } else if (ae.getSource() == exit) {
        setVisible(false);
    }
}
 }
