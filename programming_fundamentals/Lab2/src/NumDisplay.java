// *******************************************************************************
// NumDisplay.java			Author: Christina
//
// Number Display
// *******************************************************************************

import java.util.Scanner;

public class NumDisplay 
{
	//--------------------------------------------------------------------------
	// Prompts the user for a number between 0 and 9 and returns the 
	// corresponding word.
	//--------------------------------------------------------------------------
	
	public static void main(String[] args) 
	{
	    Scanner scan = new Scanner (System.in);
	    System.out.print ("Please enter a number between 0 and 9: ");
	    int number = scan.nextInt();
	    
	    //evaluation of number and matching to corresponding case value
	    switch (number)
	    {
	    case 0:
	    	System.out.print("That number is spelled: zero");
	    	break;
	    case 1:
	    	System.out.print("That number is spelled: one");
	    	break;
	    case 2:
	    	System.out.print("That number is spelled: two");
	    	break;
	    case 3:
	    	System.out.print("That number is spelled: three");
	    	break;
	    case 4:
	    	System.out.print("That number is spelled: four");
	    	break;
	    case 5:
	    	System.out.print("That number is spelled: five");
	    	break;
	    case 6:
	    	System.out.print("That number is spelled: six");
	    	break;
	    case 7:
	    	System.out.print("That number is spelled: seven");
	    	break;
	    case 8:
	    	System.out.print("That number is spelled: eight");
	    	break;
	    case 9:
	    	System.out.print("That number is spelled: nine");
	    	break;
	    default:
	    	System.out.print("You didn´t enter a number between 0 and 9!");
	    }
	       

	}

}
