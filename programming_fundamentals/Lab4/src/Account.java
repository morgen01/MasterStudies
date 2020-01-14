// *******************************************************************************
// Account.java			Author: Christina
//
// Account counter
// *******************************************************************************

public class Account 
{

	// static variable to count number of accounts
	private static int numAccounts = 0;
	

	// constructor method to count the number of account objects
	public Account()
	{
		numAccounts++;
	}
	
	
	// static method returning number of accounts
	public static int getNumAccounts()
	{
		return numAccounts;
	}
	
	// main method to execute the program
	public static void main(String[] args) 
	{
		// creating new account objects
		Account acct1 = new Account();
		Account acct2 = new Account();
		Account acct3 = new Account();
		Account acct4 = new Account();
		Account acct5 = new Account();
		
		
		// printing the number of accounts entered
	    System.out.println("There are " + getNumAccounts() + " accounts in the system!");

	}

}
