// *******************************************************************************
// Figures.java					Author: Christina Morgenstern
//										Programming Fundamentals 
//										Fall 2018
//										
// Programming Assignment 2
// *******************************************************************************

import java.util.Scanner;

// -------------------------------------------------------------------------------
// This program allows the user to print one of 3 figures of chosen size.
// -------------------------------------------------------------------------------

public class Figures 
{

	private static int size;
	private static int row, column;
	
	
	// static method to print box shape figure
	public static void printBox(int size)
	{
		for(row = 1; row <= size; row++)
		{
			for(column = 1; column <= size; column++)
			{
				System.out.print("x"); 
			}
			System.out.print("\n"); 	
		}
	}
	
	
	// static method to print diamond shape figure
	public static void printDiamond(int size)
	{
	    int width = (size+1)/2;
	    int height = (size+1)/2;
	    
	    //upper diamond half
	    for (row = 1; row <= height ; row++) 
	    {
	    	for (column = 1; column <= (-1 * row + width); column++) 
	    	{
	    			System.out.print(" ");
	    	}
	    System.out.print("x");
	    
	    	for (column = width; column <= (2 * row + width - 3); column++) 
	    	{
				System.out.print(" ");
	    	}	
	    System.out.println("x");
	    }
	        
	    //lower diamond half
	    for (row = height+1; row <= size ; row++) 
	    {
	    	for (column = 1; column <= row - width; column++) 
	    	{
	    			System.out.print(" ");
	    	}
	    System.out.print("x");
	    
	    	for (column = width; column <= (size+1)-1; column++)
	    	{
	    		System.out.print(" ");
	    	}	
	    System.out.println("x");
	    }          
	} 
	
	
	// static method to print X shape figure
	public static void printX(int size)
	{
		for(row = 1; row <= size; row++)
		{
			for(column = 1; column <= size; column++)
			{
				if (column == row || (column == size - (row - 1)))
				{
					System.out.print("x");
				}
				else
				{
					System.out.print(" ");
				}	
			}
		System.out.print("\n");
		}
	}
		
	
	public static void main(String[] args) 
	{
		
		int option = 0;
		
		
		// Printing Header
		System.out.println("Programming Fundamentals \nNAME: Christina Morgenstern"
						+ "\nPROGRAMMING ASSIGNMENT 2 \n");
		
		// Input of figure size
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the figure (odd number): ");
		size = scan.nextInt();
		
		// Loop, to check if entered value is an odd number
		while (size%2 == 0)
		{
			System.out.print("Invalid figure size - must be an odd number");
			System.out.println("\n");
			System.out.print("Renter the size of the figure: ");
			size = scan.nextInt();
		}
		
		// Repeat prompting for figures until user wants to quit
		while (size%2 != 0)
		{
			System.out.print("\nMENU: \n 1. Print box \n 2. Print diamond \n 3. Print X \n 4. Quit program  \n"
					+ " \nPlease select an option: ");
			option = scan.nextInt();
			System.out.println("\n");
		
		// Switch statement to select for figure output 	
		switch(option)
		{
		case 1:
			printBox(size);
			break;
		case 2:
			printDiamond(size);
			break;
		case 3:
			printX(size);
			break;
		case 4:
			System.out.println("Good bye! \n___________________________________________________________________");
			System.exit(0);
			break;
		default:
			System.out.print("MENU: \n 1. Print box \n 2. Print diamond \n 3. Print X \n 4. Quit program  \n"
					+ " \nPlease select an option:  ");
			option = scan.nextInt();
			break;
		}
		}
		
		scan.close();	

	}

}
