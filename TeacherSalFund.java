package entity;
import java.lang.*;

public class TeacherSalFund extends Fund
{
	
	public TeacherSalFund()
	{
		
	}
	public TeacherSalFund( double balance)
	{
		super(balance); 
		
	}
	
	public String display()
	{
		
	return ("TeacherSal Fund "+getBalance());

		
	}
}