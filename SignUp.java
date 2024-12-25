package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

public class SignUp extends JFrame {
    JButton b1, b2;
    JTextField t1, t2;

    public SignUp() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);

        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 20);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 20);
        add(t1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 20);
        add(l2);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 20);
        add(t2);

        b1 = new JButton("Signup");
        b1.setBounds(180, 140, 120, 30);
        b1.setForeground(Color.BLACK);
        
        b1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {

                if(!t1.getText().isEmpty() && !t2.getText().isEmpty()){
                String username = t1.getText();
                char[] password = ((JPasswordField) t2).getPassword();
                try {
                    register(username, password);
                    showMessageDialog(null, "Signup successful!");
                } catch (IOException ex) {
                    showMessageDialog(null, "Error during signup. Try again!");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "Give all information");
            }
            }
        });
        add(b1);

        b2 = new JButton("Back to Login");
        b2.setBounds(50, 140, 120, 30);
        b2.setForeground(Color.BLACK);
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
        add(b2);

        setSize(600, 300);
        setLocation(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void register(String username, char[] password) throws IOException {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/user_credentials.txt", true))) {
            writer.write(username + "," + String.valueOf(password) + "\n");
        }
    }

    
}