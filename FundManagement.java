package classes;
import entity.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FundManagement extends JFrame implements ActionListener{

    JTextField tfTef,tfUf,tfDf;
    JButton depT,depU,depD,show,back,clear;


        Fund f1 =new TeacherSalFund(0);
        Fund f2 =new UtilityFund(0);
        Fund f3 =new DevFund(0);

        Management m =new Management("University",4);

        

    public FundManagement()
    {
        
    	setSize(1440, 800);
        setLocation(350, 50);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Fund Management");
        heading.setBounds(600, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lbltef = new JLabel("Teacher Salary Fund");
        lbltef.setBounds(40, 140, 200, 30);
        lbltef.setFont(new Font("serif", Font.BOLD, 20));
        add(lbltef);
        
        tfTef = new JTextField();
        tfTef.setBounds(370, 140, 200, 30);
        add(tfTef);

        depT = new JButton("Deposit");
        depT.setBounds(720, 140, 140, 30);
        depT.addActionListener(this);
        depT.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(depT);
//-------------------------------------------------------------------

        JLabel lblUf = new JLabel("Utility Fund");
        lblUf.setBounds(40, 200, 200, 30);
        lblUf.setFont(new Font("serif", Font.BOLD, 20));
        add(lblUf);
        
        tfUf = new JTextField();
        tfUf.setBounds(370, 200, 200, 30);
        add(tfUf);

        depU = new JButton("Deposit");
        depU.setBounds(720, 200, 140, 30);
        depU.addActionListener(this);
        depU.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(depU);

//------------------------------------------------------------------

        JLabel lblDf = new JLabel("Development Fund");
        lblDf.setBounds(40, 260, 200, 30);
        lblDf.setFont(new Font("serif", Font.BOLD, 20));
        add(lblDf);
        
        tfDf = new JTextField();
        tfDf.setBounds(370, 260, 200, 30);
        add(tfDf);

        depD = new JButton("Deposit");
        depD.setBounds(720, 260, 140, 30);
        depD.addActionListener(this);
        depD.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(depD);


//---------------------------------------------------------------------

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/money.jpg"));
        Image i2 = i1.getImage().getScaledInstance(340, 340, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 315, 300, 300);
        add(image);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Pie.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel pic = new JLabel(i6);
        pic.setBounds(980, 250, 400, 400);
        add(pic);



//----------------------------------------------------------------------

        show = new JButton("Show Total Fund");
        show.setBounds(40, 450, 200, 30);
        show.addActionListener(this);
        show.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(show);
//-----------------------------------------------------------------------

        back = new JButton("Back");
        back.setBounds(750, 590, 120, 30);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

//-----------------------------------------------------------------------


        clear = new JButton("Clear");
        clear.setBounds(750, 450, 120, 30);
        clear.addActionListener(this);
        //clear.setForeground(Color.BLACK);
        clear.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(clear);


        m.addFund(f1);
        m.addFund(f2);
        m.addFund(f3);

        setVisible(true);

    }


    private void writeToFile(String data) {
    try (FileWriter fileWriter = new FileWriter("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/fund.txt", true);
         BufferedWriter writer = new BufferedWriter(fileWriter)) {

        writer.write(data);
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
        
    }
}

            

    

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == back) {
            new DashBoard();
            setVisible(false);
        }

       else if(!tfTef.getText().isEmpty() || !tfUf.getText().isEmpty() || !tfDf.getText().isEmpty()){

        if (e.getSource() == depT) {
            // Perform deposit for Teacher Salary Fund
            double amount = Double.parseDouble(tfTef.getText());
            
            m.performDeposite(f1, amount);
              

            //setVisible(false);
        } else if (e.getSource() == depU) {
            // Perform deposit for Utility Fund
            double amount = Double.parseDouble(tfUf.getText());
            m.performDeposite(f2, amount);
            
        } else if (e.getSource() == depD) {
            // Perform deposit for Development Fund
           double amount = Double.parseDouble(tfDf.getText());
            m.performDeposite(f3, amount);
            
        } else if (e.getSource() == show) {
            // Show total fund details
            String details = m.information();
            writeToFile(details);
            


            JOptionPane.showMessageDialog(this, details, "Total Fund Details",JOptionPane.INFORMATION_MESSAGE); 
            
        }


        else if(e.getSource()==clear){

            tfTef.setText("");
            tfUf.setText("");
            tfDf.setText("");

        }

         }else{
            JOptionPane.showMessageDialog(null,"Deposit some funds  ");
        }


    }


}
