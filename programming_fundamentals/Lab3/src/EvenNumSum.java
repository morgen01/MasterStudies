// *******************************************************************************
// EvenNumSum.java			Author: Christina
//
// Even Number Summer
// *******************************************************************************

import java.util.Scanner;

public class EvenNumSum 
{
	//--------------------------------------------------------------------------
	// This application reads an even integer value from the user and computes
	// the sum of all even integers between 2 and the input value (incl.)
	//--------------------------------------------------------------------------

	public static void main(String[] args) 
	{
		int num, input, sum = 0; 
		
		// Reads input integer from user
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter an even integer value: ");
		num = scan.nextInt();
		input = num;
		
		// checks if entered value is greater than 2 and an even value
		if (num < 2 || num%2 > 0)
		{
			System.out.print("Please enter an even integer value greater than 2: ");
			num = scan.nextInt();
		}
		
		// computes the sum of all even integers between 2 and input value
		do
		{
			sum = sum + num;
			num -= 2;
		}	
		while (num >= 2);
		
		System.out.println("The sum of even numbers between 2 and " + input + " is: " + sum);
		
		scan.close();
		
	}
	
}
