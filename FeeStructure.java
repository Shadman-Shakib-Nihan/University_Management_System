package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FeeStructure extends JFrame implements ActionListener{
	
	 JLabel lblCr,lblAd,lblT,lblSl,lblAc,lblTl,l1,l2,l3,lblPc,l4;
	 JTextField tf1,tf2,tf3;
	 JButton back,submit,clear;
	 
	
	public FeeStructure(){

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/invest.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(920, 440, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,920,440);
        add(image);


        setSize(1440,800);
        setLayout(null);

       
		
		lblCr=new JLabel("Enter total credit:");
		lblCr.setBounds(50,560,220,30);
		lblCr.setFont(new Font("serif", Font.BOLD, 20));
		add(lblCr);
		
		tf1=new JTextField();
		tf1.setBounds(300,560,220,30);
		tf1.setFont(new Font("serif", Font.BOLD, 20));
		add(tf1);


		lblPc=new JLabel("Per credit cost:");
		lblPc.setBounds(50,500,220,30);
		lblPc.setFont(new Font("serif", Font.BOLD, 20));
		add(lblPc);
		
		
		l4=new JLabel("6000");
		l4.setBounds(300,500,70,30);
		l4.setFont(new Font("serif", Font.BOLD, 20));
		add(l4);

		
		back=new JButton("Back");
		back.setBounds(1200,700,130,50);
		//back.setBackground(Color.WHITE);
        //back.setForeground(Color.BLACK);
	    back.setFont(new Font("Arial", Font.PLAIN,30));
		
		back.addActionListener(this);
		add(back);
		
		
		submit=new JButton("Submit");
		submit.setBounds(300,620,120,50);
		//submit.setBackground(Color.WHITE);
        //submit.setForeground(Color.BLACK);
	    submit.setFont(new Font("Arial", Font.PLAIN,30));
		
		submit.addActionListener(this);
		add(submit);
		
		clear=new JButton("Clear");
		clear.setBounds(50,620,120,50);
		//clear.setBackground(Color.WHITE);
        //clear.setForeground(Color.BLACK);
	    clear.setFont(new Font("Arial", Font.PLAIN,30));
		
		clear.addActionListener(this);
		add(clear);
				
		lblAd=new JLabel("Admission  :");
		lblAd.setBounds(950,130,160,30);
		lblAd.setFont(new Font("serif", Font.BOLD, 20));
		add(lblAd);
		
	    lblT=new JLabel("Tuition    :");
		lblT.setBounds(950,190,160,30);
		lblT.setFont(new Font("serif", Font.BOLD, 20));
		add(lblT);
		
		lblSl=new JLabel("Science lab :");
		lblSl.setBounds(950,250,160,30);
		lblSl.setFont(new Font("serif", Font.BOLD, 20));
		add(lblSl);
		
		lblAc=new JLabel("Annual Charge :");
		lblAc.setBounds(950,310,160,30);
		lblAc.setFont(new Font("serif", Font.BOLD, 20));
		add(lblAc);
		
		lblTl=new JLabel("Total  :");
		lblTl.setBounds(950,420,160,40);
		lblTl.setFont(new Font("serif", Font.BOLD, 20));
		add(lblTl);
		
		l1=new JLabel("25000");
		l1.setBounds(1200,130,130,30);
		l1.setFont(new Font("serif", Font.BOLD, 20));
		add(l1);
		
		tf2=new JTextField();
		tf2.setBounds(1200,190,220,33);
		tf2.setFont(new Font("serif", Font.BOLD, 20));
		add(tf2);
		
		l2=new JLabel("5000");
		l2.setBounds(1200,250,130,30);
		l2.setFont(new Font("serif", Font.BOLD, 20));
		add(l2);
		
		l3=new JLabel("10000");
		l3.setBounds(1200,310,130,30);
		l3.setFont(new Font("serif", Font.BOLD, 20));
		add(l3);
		
		tf3=new JTextField();
		tf3.setBounds(1200,420,226,40);
		tf3.setFont(new Font("serif", Font.BOLD, 20));
		add(tf3);
		
		

		setVisible(true);
	}
	
			public void actionPerformed(ActionEvent ae) {
				
		if (ae.getSource()==back) {
		 new StudentDash();
		 setVisible(false);
         
        }

        if (ae.getSource()==submit) {
			int num=Integer.parseInt(tf1.getText());
				int result=num*6000;
				int sum= 25000+5000+10000;
				int total= result+sum;
				tf2.setText(""+result);
				tf3.setText(""+total);
        }
		if (ae.getSource()==clear) {
			tf1.setText("");
            tf2.setText("");
			tf3.setText("");
        }
	}

	
}