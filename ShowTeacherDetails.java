package classes;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ShowTeacherDetails extends JFrame implements ActionListener {

    
    JTextArea textArea;
    JButton search, print, update, add, cancel, showAll, delete, edit;
    JTextField searchField;
    private boolean isEditMode = false;
    private boolean showAllPressed = false;

    public ShowTeacherDetails() {
        getContentPane().setBackground(new Color(210, 252, 218));

        JLabel heading = new JLabel("Search by any data");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        JLabel nm = new JLabel("Teacher details");
        nm.setBounds(650, 20, 500, 35);
        nm.setFont(new Font("serif", Font.ITALIC, 35));
        add(nm);

        searchField = new JTextField();
        searchField.setBounds(180, 20, 150, 20);
        add(searchField);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setBounds(0, 100, 1440, 700);
        add(textScrollPane);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        delete = new JButton("Delete");
        delete.setBounds(120, 70, 80, 20);
        delete.addActionListener(this);
        add(delete);

        showAll = new JButton("Show All & Edit");
        showAll.setBounds(220, 70, 160, 20);
        showAll.addActionListener(this);
        add(showAll);
        
      
        update = new JButton("Update");
        update.setBounds(420, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(520, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(1440, 800);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            searchStudentDetails();
        } else if (e.getSource() == cancel) {
            new DashBoard();
            setVisible(false);
        } else if (e.getSource() == delete) {
            deleteStudentDetails();
        } else if (e.getSource() == showAll) {
            displayAllStudentDetails();
            enableEdit();
            showAllPressed=true;
        }  else if (e.getSource() == update) {
            
            if (isEditMode) {
                updateStudentDetails();
            } else {
                JOptionPane.showMessageDialog(null, "Please enable edit mode and Press 'Show All' before updating..");
            }
        }
    }

    private void searchStudentDetails() {
        String searchName = searchField.getText().trim();

        if (searchName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter any data for search.");
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/teachers.txt"));
            StringBuilder foundDetails = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(searchName.toLowerCase())) {
                    foundDetails.append(line).append("\n");
                }
            }

            br.close();

            if (foundDetails.length() == 0) {
                JOptionPane.showMessageDialog(null, "No details found  " );
            } else {
                textArea.setText(foundDetails.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteStudentDetails() {
        String searchName = searchField.getText().trim();

        if (searchName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter  name  or id or any data for deletion.", "Delete Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/teachers.txt"));
            StringBuilder foundDetails = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(searchName.toLowerCase())) {
                    found = true;
                } else {
                    foundDetails.append(line).append("\n");
                }
            }

            br.close();

            if (!found) {
                JOptionPane.showMessageDialog(null, "No details found  " );
                return;
            }

            writeToFile(foundDetails.toString());
            textArea.setText(foundDetails.toString());

            JOptionPane.showMessageDialog(null, "All details  deleted successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   private void enableEdit() {
       if (textArea.getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Cannot enable edit mode. Text area is empty.");
       } else {
            textArea.setEditable(true);
             isEditMode = true; 
        JOptionPane.showMessageDialog(null, "Edit the details from the given data.");
       }
   }

    private void updateStudentDetails() {
        
        if (isEditMode && showAllPressed) {
            String editedData = textArea.getText();
            writeToFile(editedData);
            textArea.setEditable(false);
            isEditMode = false; 
            JOptionPane.showMessageDialog(null, " Details updated successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Please enable edit mode and Press 'Show All' before updating.");
        }
    }

    private void displayAllStudentDetails() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/teachers.txt"));
            StringBuilder allDetails = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                allDetails.append(line).append("\n");
            }
            br.close();
            textArea.setText(allDetails.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/teachers.txt", false))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}