// *******************************************************************************
// VowelCounter.java			Author: Christina
//
// Counting vowels app
// *******************************************************************************

import java.util.Scanner;

public class VowelCounter 
{
	//--------------------------------------------------------------------------
	// This app reads a string from the user and determines how many of each 
	// lower case vowels appear in the entire string. The remaining number
	// of consonants is also printed.
	//--------------------------------------------------------------------------

	public static void main(String[] args) 
	{
		// Declaring and initialisation of variables
		char a, e, i, o , u;
		int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0, Count = 0;
		
		// Reading input string from user
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a string of your choice in lower case letters (no spaces): ");
		String str = scan.nextLine();
		
		// Looping through the entered string and matching specific vowels 
		for (int j=0;j<str.length();++j)
		{	
		
	    switch (str.charAt(j))
	    {
	    case 'a':
	    	aCount++;
	    	break;
	    case 'e':
	    	eCount++;
	    	break;
	    case 'i':
	    	iCount++;
	    	break;
	    case 'o':
	    	oCount++;
	    	break;
	    case 'u':
	    	uCount++;
	    	break;     
	    default:
	    	Count++;
	    	
	    }
		}
		
		System.out.println("Your string contains: \n a vowels: " + aCount + "\n e vowels: " + eCount +
				"\n i vowels: " + iCount + "\n o vowels: " + oCount + "\n u vowels: " + uCount + 
				"\n consonants: " + Count);
		
		scan.close();
		
	}
	
}
