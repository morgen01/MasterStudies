
// *******************************************************************************
// AgeGuess.java			Author: Christina
//
// Time converter
// *******************************************************************************

import java.util.Scanner;

public class AgeGuess {

	// --------------------------------------------------------------------------
	// Uses the Scanner object´s method to read name and ageGuess from keyboard
	// --------------------------------------------------------------------------

	public static void main(String[] args) {
		String name;
		int ageGuess;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your name: ");

		name = scan.nextLine();

		System.out.print("Enter your age:");

		ageGuess = scan.nextInt();

		System.out.println("You entered your name \"" + name + " and your age \"" + ageGuess + "\"");

	}

}
