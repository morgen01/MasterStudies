

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// -------------------------------------------------------------------------------
// reads entered files and prints file contents - WORKS!
// -------------------------------------------------------------------------------

public class FileInput 
{
	// reads file input
		public void readFile (String name)
		{
			File inFile = new File (name);
		}
		
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
	// Printing Header
	System.out.println("Programming Fundamentals \nNAME: Christina Morgenstern"
					+ "\nPROGRAMMING ASSIGNMENT 3 \n");
	
	String trainingFile, testFile;
	
	// Scanner for user input
	Scanner keyboard = new Scanner (System.in);
	
	// Read training file data
	System.out.print("Enter the name of the training file: ");
	trainingFile = keyboard.nextLine();
	File input = new File(trainingFile);
	Scanner fileScan = new Scanner(input);
	
	while (fileScan.hasNext())
	{
		System.out.println(fileScan.nextLine());
	}
	fileScan.close();
	
	// Read testing file data
	System.out.print("Enter the name of the testing file: ");
	testFile = keyboard.nextLine();
	File input2 = new File(testFile);
	Scanner fileScan2 = new Scanner(input2);
	
	while (fileScan2.hasNext())
	{
		System.out.println(fileScan2.nextLine());
	}
	
	fileScan2.close();
					
	}
}
