package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class About extends JFrame  implements ActionListener{
	
	private ImageIcon img;
	private JLabel imgLabe1;
	private JButton back;

    public About() {
        setSize(1440, 800);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading1 = new JLabel("University Management System");
        heading1.setBounds(500, 20, 750, 50);
        heading1.setFont(new Font("serif", Font.ITALIC, 40));
        add(heading1);

        addPersonInfo(70, 120, "SHADMAN SHAKIB", "Id number: 23-50200-1", " Contribution: 35% ");

        addPersonInfo(70, 220, "AYON KUMAR BHOWMICK OVI", "Id number: 23-51050-1", " Contribution: 25% ");

        addPersonInfo(70, 320, "MAHARIN BINTA KIBRIA EASHA", "Id number: 22-49593-3", " Contribution: 20% ");

        addPersonInfo(70, 420, "MD. MOUDUD AHMED ALVE", "Id number: 23-50224-1", " Contribution: 20% ");



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/group.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700, 200, 700, 400);
        add(image);

	   
	    
		back = new JButton("BACK");
        back.setBounds(1240, 700, 100, 40);
        back.setFont(new Font("Tahoma", Font.ITALIC, 30));
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setVisible(true);
    }

    private void addPersonInfo(int x, int y, String name, String id, String contribution) {
        JLabel nameLabel = new JLabel(" " + name);
        nameLabel.setBounds(x, y, 550, 40);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(nameLabel);

        JLabel idLabel = new JLabel(" " + id);
        idLabel.setBounds(x, y + 30, 550, 40);
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(idLabel);

        JLabel contributeLabel = new JLabel(contribution);
        contributeLabel.setBounds(x, y + 60, 550, 40);
        contributeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contributeLabel);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
        	new DashBoard();

        	setVisible(false);
        }
       
     }

    
}
