package entity;
import java.lang.*;

public class UtilityFund extends Fund
{
	
	public UtilityFund()
	{
		
	}
	public UtilityFund(double balance)
	{
		super(balance); 
		
	}
	
	public String display()
	{
		
        return "Utility Fund: "+getBalance();
	
	}
}