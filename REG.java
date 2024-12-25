package classes;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

	public class REG extends JFrame{
		
		private Container c;
		private ImageIcon icon;
		
		private ImageIcon img;
		
		private JScrollPane scroll;
		
		private  JLabel lable1,lable2,lable3,lable4,lable5,lable6,lable7,
		lable8,lable9,lable10,lable11,lable12,lable13,imgLabe2;
		
		private JTextField textfld1,textfld2,textfld3,textfld4,textfld5,textfld6,
		textfld7,textfld8,textfld9,textfld10,textfld11;
		
		private JButton reg;
		
		private Font f,f2,f3;
		private JButton back;
		
		
	public	REG(){
		
			
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(0,0,1440,800);
			this.setTitle(" STUDENT REGISTRATION PAGE");
			c=this.getContentPane();
		    c.setLayout(null);
			
			f=new Font("Arial",Font.BOLD,18);
			f2=new Font("Arial",Font.BOLD,26);
			f3=new Font("Arial",Font.BOLD,22);
			
			lable12 = new JLabel(); 
			lable12.setText("WELLCOME TO REGISTRATION PAGE");
			lable12.setBounds(100,20,600,50);
			lable12.setFont(new Font("Arial",Font.BOLD, 26));
			lable12.setForeground(Color.WHITE);
			c.add(lable12);
			
			
			lable1 = new JLabel(); 
			lable1.setText("STUDENT NAME :");
			lable1.setBounds(80,90,180,30);
			lable1.setFont(f);
			lable1.setForeground(Color.WHITE);
			c.add(lable1);
			
			textfld1 = new JTextField(" ");
			textfld1.setBounds(260,90,300,30);
			textfld1.setFont(f);
			c.add(textfld1);
			
			lable2 = new JLabel(); 
			lable2.setText(" FATHER NAME :");
			lable2.setBounds(80,130,180,30);
			lable2.setFont(f);
			lable2.setForeground(Color.WHITE);
			c.add(lable2);
				
			textfld2 = new JTextField(" ");
			textfld2.setBounds(260,130,300,30);
			textfld2.setFont(f);
			c.add(textfld2);
			
			lable3 = new JLabel(); 
			lable3.setText("MOTHER NAME:");
			lable3.setBounds(80,170,180,30);
			lable3.setFont(f);
			lable3.setForeground(Color.WHITE);
			c.add(lable3);
					
			textfld3 = new JTextField(" ");
			textfld3.setBounds(260,170,300,30);
			textfld3.setFont(f);
			c.add(textfld3);
			
			lable4 = new JLabel(); 
			lable4.setText(" AGES :");
			lable4.setBounds(80,210,180,30);
			lable4.setFont(f);
			lable4.setForeground(Color.WHITE);
			c.add(lable4);
			
			textfld4 = new JTextField(" ");
			textfld4.setBounds(260,210,300,30);
			textfld4.setFont(f);
			c.add(textfld4);
			
			lable5 = new JLabel(); 
			lable5.setText(" PHONE NUMBER :");
			lable5.setBounds(80,250,180,30);
			lable5.setFont(f);
			lable5.setForeground(Color.WHITE);
			c.add(lable5);
			
			textfld5 = new JTextField(" ");
			textfld5.setBounds(260,250,300,30);
			textfld5.setFont(f);
			c.add(textfld5);
			
			lable6 = new JLabel(); 
			lable6.setText(" EMAIL :");
			lable6.setBounds(80,290,180,30);
			lable6.setFont(f);
			lable6.setForeground(Color.WHITE);
			c.add(lable6);
			
			textfld6 = new JTextField(" ");
			textfld6.setBounds(260,290,300,30);
			textfld6.setFont(f);
			c.add(textfld6);
			
			lable7 = new JLabel(); 
			lable7.setText(" ADDRESSS:");
			lable7.setBounds(80,330,180,30);
			lable7.setFont(f);
			lable7.setForeground(Color.WHITE);
			c.add(lable7);
			
			textfld7 = new JTextField(" ");
			textfld7.setBounds(260,330,300,30);
			textfld7.setFont(f);
			c.add(textfld7);
			
			lable8 = new JLabel(); 
			lable8.setText(" NEW ID  :");
			lable8.setBounds(80,370,180,30);
			lable8.setFont(f);
			lable8.setForeground(Color.WHITE);
			c.add(lable8);
			
			textfld8 = new JTextField(" ");
			textfld8.setBounds(260,370,300,30);
			textfld8.setFont(f);
			c.add(textfld8);
			
			
			
			
		reg= new JButton("CONFIRM REGISTRATION");
		reg.setBounds(260,460,200,40);
		c.add(reg);
		
		back = new JButton("BACK");
        back.setBounds(80, 460, 100, 40);
        c.add(back);
		
		
		reg.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        try {
            if (isAnyFieldEmpty()) {
                throw new IllegalArgumentException("Please fill in all required fields.");
            }

            String registrationData = "Name : " + textfld1.getText() +
                    "      Father : " + textfld2.getText() +
                    "      Mother : " + textfld3.getText() +
                    "      Ages : " + textfld4.getText() +
                    "      Phone : " + textfld5.getText() +
                    "      Email : " + textfld6.getText() +
                    "      Address : " + textfld7.getText() +
                    "      ID : " + textfld8.getText() ;
                         

            writeToFile(registrationData);

            JOptionPane.showMessageDialog(null, "YOUR REGISTRATION IS CONFIRMED");
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

		
		back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                new StudentDash();
                setVisible(false);
                
            }
        });
			
			
		    c.setBackground(new Color(51,102,153)); 
		
			img = new ImageIcon(getClass().getResource("reg.jpeg"));
			imgLabe2 = new JLabel (img);
		    imgLabe2.setBounds(0 ,0 ,1440,800);
		    c.add(imgLabe2);
			
			
		}
		
		private boolean isAnyFieldEmpty() {
        return textfld1.getText().trim().isEmpty() ||
                textfld2.getText().trim().isEmpty() ||
                textfld3.getText().trim().isEmpty() ||
                textfld4.getText().trim().isEmpty() ||
                textfld5.getText().trim().isEmpty() ||
                textfld6.getText().trim().isEmpty() ||
                textfld7.getText().trim().isEmpty() ||
                textfld8.getText().trim().isEmpty() ;
                
    }

    private void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/registration.txt", true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        textfld1.setText("");
        textfld2.setText("");
        textfld3.setText("");
        textfld4.setText("");
        textfld5.setText("");
        textfld6.setText("");
        textfld7.setText("");
        textfld8.setText("");
        
    }
}