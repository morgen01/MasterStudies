// *******************************************************************************
// DistCalc.java			Author: Christina
//
// Distance Calculator 
// *******************************************************************************

import java.util.Scanner;
import java.text.DecimalFormat;

public class DistCalc 
{
	
	//--------------------------------------------------------------------------
	// Reads the (x,y) coordinates of 2 points A and B and 
	// calculates the distance between the two.  
	//--------------------------------------------------------------------------
	
	public static void main(String[] args) 
	{
		
		int x1, y1, x2, y2;
		double dist;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print ("Enter a x-coordinate value for point A: ");
	    x1 = scan.nextInt();
	    
	    System.out.print ("Enter a y-coordinate value for point A: ");
	    y1 = scan.nextInt();
	    
	    System.out.print ("Enter a x-coordinate value for point B: ");
	    x2 = scan.nextInt();
	    
	    System.out.print ("Enter a y-coordinate value for point B: ");
	    y2 = scan.nextInt();
	    
	    dist = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow ((y2-y1), 2));
	    
	 // Round the output to three decimal places
	    DecimalFormat fmt = new DecimalFormat ("0.###");

	    System.out.print ("The distance between " + "(" + x1 + "," + y1 + ")" + "and (" + x2 + "," + y2 + ") is: " + fmt.format(dist));

	}

}
