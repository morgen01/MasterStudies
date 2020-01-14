// *******************************************************************************
// MaxValues.java			Author: Christina
//
// Maximum values 
// *****************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Reads the file input.csv and outputs to the screen the largest number in each row
public class MaxValues 
{
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		int row = 0;
		System.out.println("Maximum values:"); 
		
		// set up new File and Scanner object to read input.csv
		String fileName = "input.csv";
		File f = new File(fileName);
		Scanner fileScan = new Scanner(f);
		
		// read and process each line of the file
		while (fileScan.hasNext())
		{
			String line = fileScan.nextLine();
			row = row + 1;
			
			// parsing the string to extract largest value
			int maxval = Integer.parseInt(line.substring(12,13));
		
			System.out.println("ROW " + row + ": " + maxval);
		}

		fileScan.close();
		
	}

}
