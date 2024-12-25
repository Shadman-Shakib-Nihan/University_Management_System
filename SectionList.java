package entity;
import classes.*;
import interfaces.*;


public class SectionList implements ISectionList {
    private Section sections[];

    public SectionList() {
        sections = new Section[20];
    }

    public SectionList(int size) {
        sections = new Section[size];
    }

    public void insert(Section s) {
        boolean flag = false;
        for (int i = 0; i < sections.length; i++) {
            if (sections[i] == null) {
                sections[i] = s;
                flag = true;
                break;
            }
        }
        if (flag) {
           // System.out.println("Insertation Section Succesfull");
        } else {
           // System.out.println("Insertation Section Failed");
        }
    }

    public Section getSectionName(String sectionName) {
        for (int i = 0; i < sections.length; i++) {
            if (sections[i] != null && sections[i].getSectionName().equals(sectionName)) {
                return sections[i];
            }
        }
        return null;
    }

    public boolean deleteByName(String sectionName) {
        boolean flag = false;
        for (int i = 0; i < sections.length; i++) {
            if (sections[i] != null && sections[i].getSectionName().equals(sectionName)) {
                sections[i] = null;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void searchByName(String sectionName) {
        for (int i = 0; i < sections.length; i++) {
            if (sections[i] != null && sections[i].getSectionName().equals(sectionName)) {
                System.out.println("Section Found ");
                sections[i].showAllSectionInfo();
                return;
            }
        }
    }

    public void showAllSection() {
        
        for (int i = 0; i < sections.length; i++) {
            if (sections[i] != null) {
                sections[i].showAllSectionInfo();
            }
        }
    }

    public String getAllSection() {
        StringBuilder allsections = new StringBuilder();
        for (int i = 0; i < sections.length; i++) {
            if (sections[i] != null) {
                allsections.append(sections[i].getSectionInfo()).append("\n");
            }
        }
        return allsections.toString();
    }

    public Section[] getAllSections() {
        return sections;
    }

    public String getSectionInfoAsString(Section section) 
    {
    return section.getSectionName() + ";" + section.getDepartmentName() + ";" +
           section.getDepartmentTime() + ";" + section.getSectionQuantity() + ";" +
           section.getRoomNumber();
   }

}
