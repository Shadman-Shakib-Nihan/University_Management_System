package interfaces;
import classes.*;
public interface ISectionList

{
   
	void insert(Section s);
	boolean deleteByName(String sectionName) ;
	void searchByName(String sectionName);
	
}