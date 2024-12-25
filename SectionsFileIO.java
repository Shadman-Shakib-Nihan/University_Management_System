package classes;
import entity.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 

public class SectionsFileIO 
{
    public static void loadSectionData(SectionList sectionList)
	{
        try {
            Scanner sc = new Scanner(new File("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/Sectionlist.txt"));
            while (sc.hasNextLine()) {
                String myLine= sc.nextLine();
                if(myLine.isEmpty()){
                    continue;
                }
                String[] data =myLine.split(";");

                String sectionName = data[0];
                String departmentName = data[1];
                double departmentTime = Double.parseDouble(data[2]);
                String roomNumber = data[3];
                int sectionQuantity = Integer.parseInt(data[4]);

                Section s = new Section(sectionName, departmentName, departmentTime, sectionQuantity, roomNumber);
                sectionList.insert(s);
            }
			
            sc.close();
        } 
		catch (Exception e) 
		{
            System.out.println("Cannot Read File");
            e.printStackTrace();
        }
    }

    public static void insertSectionDetails(String s)
	{
        String filename = "/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/Sectionlist.txt";
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(s + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot Write In File");
        }
    }

    public static void saveSectionsInFile(SectionList sectionList) 
	{
    try {
        FileWriter writer = new FileWriter("/Users/shadmanshakib/Desktop/University management SYSTEM1/OOP project/File/Sectionlist.txt");
        Section sections[] = sectionList.getAllSections();

        for (int i = 0; i < sections.length; i++) 
		{
            if (sections[i] != null) {
                // Pass the section to the method
                writer.write(sectionList.getSectionInfoAsString(sections[i]) + "\n");
            }
        }

        writer.close();
    } catch (IOException e)
	 {
        System.out.println("Cannot Write in File");
     }
   }

}
