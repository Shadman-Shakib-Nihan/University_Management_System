package entity;
import classes.*;
import interfaces.*;

public abstract class Fund implements IFund 
{

	private double balance;
	
	public Fund()
	{
		
	}


	public Fund( double balance)
	{
		this.balance = balance;
	}
	

	public void setBalance(double balance)
	{
		
		this.balance = balance;
	}
	

	public double getBalance()
	{
		return balance;
	}
	
	

	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance = balance+amount;
		}
		else
		{
			System.out.println("Invalid Amount");
		}
	}

	public abstract String display();
	
	
}
