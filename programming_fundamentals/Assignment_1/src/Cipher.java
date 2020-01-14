// *******************************************************************************
// Cipher.java					Author: Christina Morgenstern
//										Programming Fundamentals 
//										Fall 2018
//										
// Programming Assignment 1
// *******************************************************************************

import java.util.Scanner;
import java.util.Random;

public class Cipher 
{
	
	//--------------------------------------------------------------------------
	// This program allows you to encode the sum of 5 integer numbers 
	// using the Caesar code.
	//--------------------------------------------------------------------------

	public static void main(String[] args) 
	{
		// Printing Header
		System.out.println("Programming Fundamentals \nNAME: Christina Morgenstern"
				+ "\nPROGRAMMING ASSIGNMENT 1 \n");
		
		System.out.println ("Welcome to the Cipher program.");
		
		// Initialization of variables
		int num1, num2, num3, num4, num5, sum, key, tens, ones, code1, code2;
		
		
		// Prompts the user to enter 5 integers in the range from 0 to 19
		// and evaluates after each input if the number is in range.	
		Scanner scan = new Scanner (System.in);
		System.out.println ("Please enter 5 numbers between 0 and 19");
		
		System.out.print("1st number: ");
		num1 = scan.nextInt();
		
		if (num1 >= 0 && num1 <= 19) 	
			System.out.print("2nd number: "); 
		else
		{
			System.out.print("Please read directions and try again!");
		    System.exit(0);
		}
		
		num2 = scan.nextInt();
		
		if (num2 >= 0 && num2 <= 19) 	
			System.out.print("3rd number: "); 
		else
		{
			System.out.print("Please read directions and try again!");
		    System.exit(0);
		}
		
		num3 = scan.nextInt();
		
		if (num3 >= 0 && num3 <= 19) 	
			System.out.print("4th number: "); 
		else
		{
			System.out.print("Please read directions and try again!");
		    System.exit(0);
		}
		
		num4 = scan.nextInt();
		
		if (num4 >= 0 && num4 <= 19) 	
			System.out.print("5th number: "); 
		else
		{
			System.out.print("Please read directions and try again!");
		    System.exit(0);
		}
		
		num5 = scan.nextInt();
		
		// Sums up the 5 entered integer values
		sum = num1 + num2 + num3 + num4 + num5;
		
		if (num5 >= 0 && num5 <= 19)
			System.out.println ("Total = " + sum); 
		else
		{
			System.out.print("Please read directions and try again!");
		    System.exit(0);
		}
		
		scan.close();
		
		
		// Generation of a random key between 0 and 9
		Random generator = new Random();
		key = generator.nextInt(10);
		System.out.println ("Your random key is " + key);
		
		
		// Separation of sum digit into tens and ones 
		// and subsequent encryption using the Caesar code
		tens = sum/10;
		ones = sum%10;
		code1 = (tens + key)%10;
		code2 = (ones + key)%10;
		System.out.println ("Your encoded number is " + code1 + code2);	
		
	}

}