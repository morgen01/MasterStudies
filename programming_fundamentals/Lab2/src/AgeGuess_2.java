// *******************************************************************************
// AgeGuess_2.java			Author: Christina
//
// Random AgeGuess 
// *******************************************************************************

import java.util.Scanner;
import java.util.Random;

public class AgeGuess_2 
{
	
	//--------------------------------------------------------------------------
	// Generates a random integer number between 0 and 100, 
	// prompts the user for an age guess and prints both values.
	//--------------------------------------------------------------------------

	public static void main(String[] args) 
	{
		int ageGuess, age;
		
		Random generator = new Random();
		age = generator.nextInt(101);
		
		Scanner scan = new Scanner (System.in);
		System.out.print ("Enter your age guess: ");
		ageGuess = scan.nextInt();
	    
	    System.out.println ("You guessed: " + ageGuess);
	    System.out.println ("The correct answer is: " + age);
		
	}

}