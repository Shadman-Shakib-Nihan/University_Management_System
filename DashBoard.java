package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener
{  
  public DashBoard()
  {
    setSize(1440, 800);
    Font menuFont = new Font("Times New Roman", Font.PLAIN, 16);

      
    JMenuBar mb = new JMenuBar();
  
  mb.setFont(menuFont);
  
            ImageIcon i1 = new ImageIcon("icons/hallroom.jpg");
            Image i2 = i1.getImage().getScaledInstance(1440, 760, Image.SCALE_DEFAULT); // Image portion
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            add(image);
      
      //ABOUT      
    JMenu about = new JMenu(" ABOUT ");
    about.setForeground(Color.BLUE);
    about.addActionListener(this);
     mb.add (about);

    JMenuItem aboutItem = new JMenuItem("Information");
    aboutItem.setBackground(Color.YELLOW);
    aboutItem.addActionListener(this);
    about.add(aboutItem);
    
    // DETAILS

    JMenu details = new JMenu(" SHOW DETAILS ");
    details.setForeground(Color.BLUE);
    mb.add(details);

    JMenuItem facultydetails = new JMenuItem("FACULTY");
    facultydetails.setBackground(Color.YELLOW);
    facultydetails.addActionListener(this);
    details.add(facultydetails);

    JMenuItem studentdetails = new JMenuItem("STUDENT");
    studentdetails.setBackground(Color.YELLOW);
    studentdetails.addActionListener(this);
    details.add(studentdetails);
  


    // ADD

    JMenu add = new JMenu("ADD FACULTY ");
    add.setForeground(Color.BLUE);
    mb.add(add);
  
    JMenuItem managefaculty = new JMenuItem("MANAGE FACULTY DETAILS");
    managefaculty.setBackground(Color.YELLOW);
    managefaculty.addActionListener(this);
    add.add(managefaculty);




     // SECTION
  
  JMenu section = new JMenu ("SECTION ");
  section.setForeground(Color.BLUE);
  section.addActionListener(this);
  mb.add(section);
  
  JMenuItem sectionItem = new JMenuItem ("SECTION MANAGEMENT");
  sectionItem.setBackground(Color.YELLOW);
  sectionItem.addActionListener(this);
  section.add(sectionItem);
  
  setFontForMenuItems(mb, menuFont);
    setJMenuBar(mb);
    setVisible(true);


    // Financial Details

    JMenu financialdetails = new JMenu("FINANCIAL DETAILS");
    financialdetails.setForeground(Color.BLUE);
    mb.add(financialdetails);

    JMenuItem fund = new JMenuItem("FUND");
    fund.setBackground(Color.YELLOW);
    fund.addActionListener(this);
    financialdetails.add(fund);


    // EXIT

    JMenu exit = new JMenu("EXIT");
    exit.setForeground(Color.BLUE);
    mb.add(exit);

    JMenuItem ex = new JMenuItem("EXIT");
    ex.setBackground(Color.YELLOW);
    ex.addActionListener(this);
    exit.add(ex);
  
    setFontForMenuItems(mb, menuFont);
    setJMenuBar(mb);

    setVisible(true);
  
  }
  
private void setFontForMenuItems(JMenuBar menuBar, Font font) {
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            menu.setFont(font);

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem menuItem = menu.getItem(j);
                if (menuItem != null) {
                    menuItem.setFont(font);
                }
            }
        }
    }

  public void actionPerformed(ActionEvent ae)
  {
    String msg = ae.getActionCommand();

    if (msg.equals("EXIT")){
      new Login();
      setVisible(false);
    }
  else if (msg.equals("MANAGE FACULTY DETAILS"))
  {
      new AddTeacher();

      setVisible(false);
  }
  else if(msg.equals("FUND")){
    
    new FundManagement();
    setVisible(false);

  }else if (msg.equals("FACULTY")){
    new ShowTeacherDetails();
    setVisible(false);
  }else if(msg.equals("STUDENT")){
    new ShowStudentDetails();
    setVisible(false);
  }else if (msg.equals("SECTION MANAGEMENT"))
  {
    new SectionFrame();
    setVisible(false);
  }else if (msg.equals("Information"))
  {
    new About();
    setVisible(false);
  }
} 
 
 }

