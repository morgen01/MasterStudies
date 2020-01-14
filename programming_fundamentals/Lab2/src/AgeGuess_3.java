// *******************************************************************************
// AgeGuess_3.java			Author: Christina
//
// Guessing age game
// *******************************************************************************

import java.util.Scanner;
import java.util.Random;

public class AgeGuess_3 
{
	//--------------------------------------------------------------------------
	// Generates a random age between 0 and 100, prompts the user for an 
	// age guess and tells user when she is wrong. 
	//--------------------------------------------------------------------------

	public static void main(String[] args) 
	{
		int ageGuess, age; 
		
		Scanner scan = new Scanner (System.in);
		System.out.print ("Enter your age guess: ");
		ageGuess = scan.nextInt();
		
		Random generator = new Random();
		age = generator.nextInt(101);
		
		if (ageGuess != age)
			{
			System.out.println("You guessed wrong!");
			if (ageGuess > age)
				System.out.println("Younger!");
			else 
				System.out.println("Older!");
			    System.out.println ("The correct answer is: " + age);
			}
		
	}

}
