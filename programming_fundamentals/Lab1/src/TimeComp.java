
// *******************************************************************************
// TimeComp.java			Author: Christina
//
// Time converter
// *******************************************************************************

import java.util.Scanner;

public class TimeComp {

	// ----------------------------------------------------------------------------------------
	// Reads a time value in seconds and returns the equivalent
	// in hours, minutes and seconds
	// ----------------------------------------------------------------------------------------

	public static void main(String[] args) {
		int time, hours, minutes, seconds;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a time value in seconds: ");
		time = scan.nextInt();

		hours = time / 3600;
		minutes = (time / 60) - (hours * 60);
		seconds = time - (hours * 3600) - (minutes * 60);

		System.out.println(
				"Your time in secondes are: " + hours + " hours " + minutes + " minutes " + seconds + " seconds ");

	}

}
