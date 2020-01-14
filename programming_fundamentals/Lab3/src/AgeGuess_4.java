// *******************************************************************************
// AgeGuess_4.java			Author: Christina
//
// Child age guessing
// *******************************************************************************

import java.util.Scanner;
import java.util.Random;

public class AgeGuess_4 
{
	//--------------------------------------------------------------------------
	// Generates a random age between 0 and 10, prompts the user for an 
	// age guess and continues to execute until the guessing matches the random
	// age. 
	//--------------------------------------------------------------------------

	public static void main(String[] args) 
	{
		int ageGuess, age; 
		
		Scanner scan = new Scanner (System.in);
		System.out.print ("Guess, how old the child is (Enter age between 0 and 10): ");
		ageGuess = scan.nextInt();
		
		// Generation of an age value between 0 and 10 using the random object.
		Random generator = new Random();
		age = generator.nextInt(11);
		
		// user should keep guessing, until the correct age was guessed.
		while (ageGuess != age)
		{	
			System.out.println("You guessed wrong!");
			System.out.print("Try again. Enter your age guess (age between 0 and 10): ");
			ageGuess = scan.nextInt();
			
			// prompt for valid input, if value entered is outside the range.
			if (ageGuess < 0 || ageGuess > 10)
			{
			    System.out.print("Please enter a valid age between 0 and 10: ");
			    ageGuess = scan.nextInt();
			}
		}
			
		if (ageGuess == age)
			{
			System.out.println("Eureka! You guessed it! " + age + " is the age, I was thinking of.");
			}
		
		scan.close();
	}

}
