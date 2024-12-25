package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entity.*;
public class SectionFrame extends JFrame implements ActionListener {
    // Labels
    private JLabel lsname;
    private JLabel ldname;
    private JLabel ldtime;
    private JLabel lsquantity;
    private JLabel lrnumber; 

    // Textfields
    private JTextField sname;
    private JTextField dname;
    private JTextField dtime;
    private JTextField squantity;
    private JTextField rnumber;

    private JTextArea display;

    // Buttons
    private JButton insertBtn,deleteBtn,displayBtn,searchBtn,backBtn,submitInsert,submitDelete,submitDisplay,submitSearch,submitBtn;
    
 
    JFrame frame;
    JScrollPane scrolltxt;

    private SectionList sectionList;

    public SectionFrame() 
	{
        sectionList = new SectionList();

        setTitle("Section Frame");
        setSize(1440, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        frame = this;

        lsname = new JLabel(" Section Name ");
        
        lsname.setForeground(Color.red);

        ldname = new JLabel("Department Name");
        ldname.setForeground(Color.red);

        ldtime = new JLabel("Department Time");
        ldtime.setForeground(Color.red);
        // ldtime.setForeground(new Color(240, 248, 260));

        lsquantity = new JLabel("Section Quantity ");
        lsquantity.setForeground(Color.red);
        // lsquantity.setForeground(new Color(240, 248, 260));

        lrnumber = new JLabel(" Room Number ");
        lrnumber.setForeground(Color.red);
        // lrnumber.setForeground(new Color(240, 248, 260));


        JLabel heading = new JLabel("Manage Sections");
        heading.setBounds(610, 30, 500, 50);
        heading.setFont(new Font("serif", Font.ITALIC, 30));
        add(heading);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/classes.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(750, 200, 600, 400);
        add(image);
  

        sname = new JTextField();
        dname = new JTextField();
        dtime = new JTextField();
        squantity = new JTextField();
        rnumber = new JTextField();

        display = new JTextArea();

        insertBtn = new JButton("Insert");
        deleteBtn = new JButton("Delete");
        displayBtn = new JButton("Display");
        backBtn= new JButton("Back");
        
        submitBtn = new JButton("--");

        submitInsert = new JButton("Submit");
        submitDelete = new JButton("Submit");
        submitDisplay = new JButton("Submit");
        submitSearch = new JButton("Submit");

        searchBtn = new JButton("Search");

        sectionList = new SectionList();

        this.add(lsname);
        frame.add(backBtn);
        frame.add(ldname);
        frame.add(ldtime);
        frame.add(lsquantity);
        frame.add(lrnumber);

        frame.add(sname);
        frame.add(dname);
        frame.add(dtime);
        frame.add(squantity);
        frame.add(rnumber); 

        frame.add(submitBtn);
        frame.add(insertBtn);
        frame.add(deleteBtn);
        frame.add(displayBtn);
        frame.add(searchBtn);

        frame.add(submitInsert);
        frame.add(submitDelete);
        frame.add(submitDisplay);
        frame.add(submitSearch);

        
        
        display.setBounds(45, 100, 490, 250);
        display.setBackground(Color.black);
        display.setForeground(Color.white);

        scrolltxt = new JScrollPane(display);
        scrolltxt.setBounds(45, 100, 490, 250);

        
        frame.add(scrolltxt);

        lsname.setBounds(45, 100, 110, 35);
        ldname.setBounds(45, 140, 110, 35);
        ldtime.setBounds(45, 180, 110, 35);
        lsquantity.setBounds(45, 220, 110, 35);
        lrnumber.setBounds(45, 260, 110, 35);
 

        sname.setBounds(170, 100, 110, 35);
        dname.setBounds(170, 140, 110, 35);
        dtime.setBounds(170, 180, 110, 35);
        squantity.setBounds(170, 220, 110, 35);
        rnumber.setBounds(170, 260, 110, 35);


        submitBtn.setBounds(170, 300, 110, 35);


        displayBtn.setBounds(45, 190, 390, 100);
        insertBtn.setBounds(45, 370, 90, 35);
        deleteBtn.setBounds(140, 370, 90, 35);
        displayBtn.setBounds(235, 370, 90, 35);
        submitInsert.setBounds(330, 370, 90, 35);
        submitDelete.setBounds(170, 250, 90, 35);
        submitDisplay.setBounds(270, 250, 90, 35);
        submitSearch.setBounds(370, 250, 90, 35);
        searchBtn.setBounds(370, 370, 90, 35);
        backBtn.setBounds(480, 370, 90, 35);

        lsname.setVisible(false);
        ldname.setVisible(false);
        ldtime.setVisible(false);
        lsquantity.setVisible(false);
        lrnumber.setVisible(false);
        // display.setVisible(false);
        scrolltxt.setVisible(false);
        display.setEditable(false);

        sname.setVisible(false);
        dname.setVisible(false);
        dtime.setVisible(false);
        squantity.setVisible(false);
        rnumber.setVisible(false);
        submitInsert.setVisible(false);
        submitDelete.setVisible(false);
        submitSearch.setVisible(false);
        submitDisplay.setVisible(false);

        submitBtn.setVisible(false);

        backBtn.addActionListener(this);
        submitBtn.addActionListener(this);
        insertBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        displayBtn.addActionListener(this);
        submitInsert.addActionListener(this);
        submitDelete.addActionListener(this);
        submitDisplay.addActionListener(this);
        submitSearch.addActionListener(this);

        SectionsFileIO.loadSectionData(sectionList);
     

        showDisplayFirst();
        setVisible(true);
    }

    // public void searchByName()
    
    public void showDisplayFirst()
	{
        
        scrolltxt.setVisible(true);
        showDisplay();

    }
    public void showDisplay()
	{
        
        sectionList = new SectionList();
        
        SectionsFileIO.loadSectionData(sectionList);
        
        Section[] sec=  sectionList.getAllSections();
        String disText= "";
        for (int i = 0; i < sec.length; i++) {
            if (sec[i] != null) {
                disText += sec[i].getSectionInfoNew()+"\n";
            }
        }

        display.setText(disText);
    }
    public void deleteById(String id)
	{

    }
    public void actionPerformed(ActionEvent e) {
        // all visible off

        submitBtn.setVisible(false);
        //submitBtn.setText("");
        lsname.setVisible(false);
        ldname.setVisible(false);
        ldtime.setVisible(false);
        lsquantity.setVisible(false);
        lrnumber.setVisible(false);
        scrolltxt.setVisible(false);
 
        sname.setVisible(false);
        dname.setVisible(false);
        dtime.setVisible(false);
        squantity.setVisible(false);
        rnumber.setVisible(false);
        submitInsert.setVisible(false);
        submitDelete.setVisible(false);
        submitSearch.setVisible(false);
        submitDisplay.setVisible(false);

        if(e.getSource() == backBtn)
		{   
            new DashBoard();
            setVisible(false);
        

        }
        else if (e.getSource() == insertBtn)
			{
            //labels
             lsname.setVisible(true);
             ldname.setVisible(true);
             ldtime.setVisible(true);
             lsquantity.setVisible(true);
             lrnumber.setVisible(true); 
             submitBtn.setText("Insert");
             submitBtn.setVisible(true);

             //input fields 
            sname.setVisible(true);
            dname.setVisible(true);
            dtime.setVisible(true);
            squantity.setVisible(true);
            rnumber.setVisible(true);


        } else if (e.getSource() == deleteBtn) 
		{
            lsname.setVisible(true);
            sname.setVisible(true);
            submitBtn.setText("Delete");
            submitBtn.setVisible(true);

             showDisplay();
        
        } else if (e.getSource() == displayBtn)
			{
            //display alll info
            
        scrolltxt.setVisible(true);
        showDisplay();
        } else if (e.getSource() == searchBtn)
			{
            
            lsname.setVisible(true);
            sname.setVisible(true);
            submitBtn.setText("Search");
            submitBtn.setVisible(true);


        } else if (e.getSource() == submitBtn) 
		{
            if(submitBtn.getText().equals("Insert"))
			{
                
             lsname.setVisible(true);
             ldname.setVisible(true);
             ldtime.setVisible(true);
             lsquantity.setVisible(true);
             lrnumber.setVisible(true);
             submitBtn.setText("Insert");
             submitBtn.setVisible(true);

             //input fields 
            sname.setVisible(true);
            dname.setVisible(true);
            dtime.setVisible(true);
            squantity.setVisible(true);
            rnumber.setVisible(true);


                //insert koro 
                Section insertSec= new Section(
                    sname.getText(),
                    dname.getText(),
                    Double.parseDouble(dtime.getText()),
                    Integer.parseInt(squantity.getText()),
                    rnumber.getText()

                );
               String newData=  insertSec.getSectionInfoAsString();
               System.out.println(newData);
               SectionsFileIO.insertSectionDetails(newData);
               sname.setText("");
            dname.setText("");
            dtime.setText("");
            squantity.setText("");
            rnumber.setText("");
               JOptionPane.showMessageDialog(null, "Insert Successfull");

             //  showDisplay();

                
            }
			else if(submitBtn.getText().equals("Delete"))
			{

                
            lsname.setVisible(true);
            sname.setVisible(true);
            submitBtn.setText("Delete");
            submitBtn.setVisible(true);

                //delete koro
                if(sectionList.deleteByName(sname.getText()))
				{
                    SectionsFileIO.saveSectionsInFile(sectionList);
                    JOptionPane.showMessageDialog(null, "Delete Successfull");

                }
				else
				{
                    JOptionPane.showMessageDialog(null, "Delete Error!");
                }

            sname.setText("");

                

            }
            else if(submitBtn.getText().equals("Search"))
			{

                String disText= "";
                boolean isGot= false;
                Section sections[] = sectionList.getAllSections();
                
                for (int i = 0; i < sections.length; i++) 
				{
                    if (sections[i] != null && sections[i].getSectionName().equals(sname.getText())) {
                 
                isGot= true;
                disText += sections[i].getSectionInfoNew()+"\n";
                 
                }
            }

            if(isGot){

            display.setText(disText);
            }else
			{
                
            display.setText("No results found!");
            }

        scrolltxt.setVisible(true);



            }else
			{
                
                 
            }
         // return;


            // String sectionNameText = sname.getText();
            // String departmentNameText = dname.getText();
            // double departmentTimeText = Double.parseDouble(dtime.getText());
            // int sectionQuantityText = Integer.parseInt(squantity.getText());
            // String roomNumberText = rnumber.getText();

            // Section newSection = new Section(sectionNameText, departmentNameText, departmentTimeText,
            //         sectionQuantityText, roomNumberText);

            // sectionList.insert(newSection);
            // SectionsFileIO.insertSectionDetails(newSection.getSectionInfo(), "Sectionlist.txt");

            // sname.setText("");
            // dname.setText("");
            // dtime.setText("");
            // squantity.setText("");
            // rnumber.setText("");


        }
        //  else if (e.getSource() == submitDelete) {
        //     String sectionNameText = sname.getText();
        //     sectionList.deleteByName(sectionNameText);
        // } else if (e.getSource() == submitDisplay) {
        //     display.setText(sectionList.getAllSection());
        // } else if (e.getSource() == submitSearch) {
        //     String sectionNameText = sname.getText();
        //     sectionList.searchByName(sectionNameText);
        // }
    }

    public static void main(String[] args) {
         
            new SectionFrame().setVisible(true);
         
    }
}
