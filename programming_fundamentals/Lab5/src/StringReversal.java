// *******************************************************************************
// StringReversal.java			Author: Christina
//
// String in reverse order
// *****************************************************************************

import java.util.Scanner;

// Accepts user string and outputs it in reverse order
public class StringReversal 
{
	private static String s;
	private static String s_rev;
	
	public static String reverseString(String s) 
	{
		// 2 base cases 
		if (s.isEmpty() || s.length()==1) 
			return s;		
		// Recursive case
		else 
			return reverseString(s.substring(1)) + s.charAt(0);	
	}		
	
	public static void main(String[] args) 
	{
		System.out.println("Enter a string to print in reverse order: ");
		
		java.util.Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		s_rev = reverseString(s);
		
		System.out.println("Reversed string is: \n" + s_rev);
	}
}
