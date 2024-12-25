package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentDash extends JFrame implements ActionListener{

	JButton reg,tuition,lout;

	public StudentDash(){

		getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Sign.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);


        reg = new JButton("Registration");
        reg.setBounds(50, 80, 200, 35);
        reg.setFont(new Font("serif", Font.ITALIC, 25));
        reg.addActionListener(this);
        add(reg);


        tuition = new JButton("Tuition Fee");
        tuition.setBounds(50, 140, 200, 35);
        tuition.setFont(new Font("serif", Font.ITALIC, 25));
        tuition.addActionListener(this);
        add(tuition);


        lout = new JButton("Log out");
        lout.setBounds(460, 230, 120, 35);
        lout.setFont(new Font("Tahoma", Font.ITALIC, 20));
        lout.addActionListener(this);
        add(lout);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);



	}


	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reg) {
        	new REG();

        	setVisible(false);
        }
        else if(ae.getSource()==tuition){
        	new FeeStructure();

        	setVisible(false);
        }
        else if(ae.getSource()==lout){
        	new Login();

        	setVisible(false);
        }
     }

 }