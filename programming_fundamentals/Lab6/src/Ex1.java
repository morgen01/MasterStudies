// *******************************************************************************
// Ex1.java			Author: Christina
//
// Cube Volume Calculator
// *****************************************************************************

import java.util.Scanner;

// Calculates the volume of a cube with desired length
public class Ex1 
{
	// Method to calculate cube volume
	public static double cube (double n)
	{
		double volume = Math.pow(n, 3);
		return volume;
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		System.out.print("Please enter a value for the side of the cube: ");
		double n = scan.nextInt();
		
		System.out.print("The volume of the cube with side " + n + " is " + cube(n)); 
		
		scan.close();

	}

}
