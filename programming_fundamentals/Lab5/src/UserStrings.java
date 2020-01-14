// *******************************************************************************
// UserStrings.java			Author: Christina
//
// Reading & Writing Strings 
// *****************************************************************************

import java.io.*;
import java.util.Scanner;

// Program reads strings from the user and writes them to an output file userStrings.txt
public class UserStrings 
{

	public static void main(String[] args) throws IOException 
	{
		String inputStr;
		
		// creating writer objects to write text file
		FileWriter fw = new FileWriter("userStrings.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter outFile = new PrintWriter(bw);
		
		Scanner scan = new Scanner (System.in);
		System.out.print ("Enter a string of your choice (Write DONE to terminate): ");
		inputStr = scan.nextLine();
		
		while(!inputStr.equals("DONE"))
		{
			outFile.println(inputStr); 
			System.out.print ("Enter a string of your choice (Write DONE to terminate): ");
			inputStr = scan.nextLine();
				
	     }
		outFile.close(); 
	    scan.close();
	}
}
