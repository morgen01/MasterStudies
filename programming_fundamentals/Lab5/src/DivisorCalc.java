// *******************************************************************************
// DivisorCalc.java			Author: Christina
//
// Greatest common divisor
// *****************************************************************************

// Finds the greatest common divisor of two positive integers
public class DivisorCalc 
{	
	private static int gcd(int num1, int num2)
	{
		if (num2 <= num1 && num1%num2 == 0)
			return num2;
		
		// recursive cases
		else if (num1 < num2)
			return gcd(num2, num1);
	
		else return gcd(num2, num1%num2);
	}

	public static void main(String[] args) 
	{
		System.out.println("The greatest common divisor of 3780 and 3528 is: "+gcd(3780,3528));
	}
}
