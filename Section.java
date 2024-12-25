package classes;
import entity.*;
import interfaces.*;

public class Section implements ISection {
    private String sectionName;
    private String departmentName;
    private double departmentTime;
    private int sectionQuantity;
    private String roomNumber;

    public Section() {
    }

    public Section(String sectionName, String departmentName, double departmentTime, int sectionQuantity, String roomNumber) {
        this.sectionName = sectionName;
        this.departmentName = departmentName;
        this.departmentTime = departmentTime;
        this.sectionQuantity = sectionQuantity;
        this.roomNumber = roomNumber;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentTime(double departmentTime) {
        this.departmentTime = departmentTime;
    }

    public void setSectionQuantity(int sectionQuantity) {
        this.sectionQuantity = sectionQuantity;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getDepartmentTime() {
        return departmentTime;
    }

    public int getSectionQuantity() {
        return sectionQuantity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void showAllSectionInfo() {
        System.out.println("SectionName :     " + sectionName);
        System.out.println("DepartmentName:   " + departmentName);
        System.out.println("DepartmentTime :  " + departmentTime);
        System.out.println("SectionQuantity : " + sectionQuantity);
        System.out.println("RoomNumber :      " + roomNumber);
    }

    public void insertSectionQuantity(int x) {
        sectionQuantity = sectionQuantity + x;
    }

    public String getSectionInfo() {
        return sectionName + ";" + departmentName + ";" + departmentTime + ";" + sectionQuantity + ";" + roomNumber;
    }
    public String getSectionInfoNew() {
        return 
       "Section Name: " + sectionName + "\n" +
       "Department Name: "+ departmentName + "\n"+
       "Department Time: " + departmentTime + "\n"+
       "Section Quantity: " + sectionQuantity + "\n" +
       "Room Number: " + roomNumber+"\n\n";
    }

    public String getSectionInfoAsString() {
        return sectionName + ";" + departmentName + ";" + departmentTime + ";" + sectionQuantity + ";" + roomNumber;
    }
}
