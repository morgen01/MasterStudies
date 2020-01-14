// *******************************************************************************
// UserNames.java			Author: Christina
//
// Username Generator  
// *******************************************************************************

import java.util.Scanner;
import java.util.Random;

public class UserNames 
{

	//--------------------------------------------------------------------------
	// Reads the first and last name of a user and generates a username 
	// by parsing the two strings and adding a random number.
	//--------------------------------------------------------------------------
	
	public static void main(String[] args) 
	{
		
		String part1, part2, first, last;
		int number;
		
		Scanner scan = new Scanner (System.in);
		Random generator = new Random();
		
		System.out.print("Enter your first name: ");
		first = scan.nextLine();
		
		System.out.print("Enter your last name: ");
		last = scan.nextLine();
	
		part1 = last.substring(0, 4);
		part2 = first.substring(0,1);
		
		number = generator.nextInt(90) + 10;
		
		System.out.print("Your username is : " + part1 + part2 + number);

	}

}
