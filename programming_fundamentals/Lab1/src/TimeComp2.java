import java.util.Scanner;

public class TimeComp2 {

	public static void main(String[] args) {

		float hours, minutes, seconds, remainder, totalseconds;

		final int secondsinhour = 3600;

		final int minutesinhour = 60;

		final int secondsinminute = 60;

		// Collect total number of seconds from user

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the total number of seconds: ");

		totalseconds = scan.nextInt();

		hours = totalseconds / secondsinhour;

		remainder = totalseconds % secondsinhour;

		minutes = remainder / secondsinhour * minutesinhour;

		remainder = remainder / minutesinhour - (int) minutes;

		seconds = secondsinminute * remainder;

		System.out.println(totalseconds + " second(s) is equivalent to " + (int) hours + " hour(s), " + (int) minutes
				+ " minute(s), and " + (int) seconds + " second(s).");

	}

}