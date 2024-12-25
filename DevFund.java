package entity;
import java.lang.*;

public class DevFund extends Fund
{
	
	public DevFund()
	{
		
	}
	public DevFund( double balance)
	{
		super(balance); 
		
	}
	
	public String display()
	{
		
		return "Development Fund "+getBalance();
		
	}
}