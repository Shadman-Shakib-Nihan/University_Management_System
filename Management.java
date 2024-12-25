package entity;
import java.lang.*;

public class Management
{

	private String name;
	private Fund fd[];
	
	
	public Management(){}

	public Management(String name , int count)
	{
		this.name=name;
	    fd= new Fund[count];
	}
	

	public void addFund(Fund f)
	{
		int check = 0;
		for(int i = 0; i<fd.length; i++)
		{
			if(fd[i] == null)
			{
				fd[i] = f;
				check = 1;
				break;
			}
		}
		if(check == 1)
		{
			System.out.println("Fund added!");
		}
		else
		{
			System.out.println("Fund not added!");
		}
	}
	

	public void performDeposite(Fund f, double amount)
	{
		for(int i = 0; i<fd.length; i++)
		{
			if(fd[i] == f)
			{
				fd[i].deposit(amount);
				break;
			}
		}
	}
	
	public String information()
	{
		StringBuilder details =new StringBuilder();

		for(int i = 0; i<fd.length; i++)
		{
			if(fd[i]!=null)
			{
				details.append(fd[i].display()).append("\n");
			}
			else
			{
				
			}
			
		}
		return details.toString();
	}	

}



















