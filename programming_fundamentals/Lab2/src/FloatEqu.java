// *******************************************************************************
// FloatEqu.java			Author: Christina
//
// Equal or not equal  
// *******************************************************************************

public class FloatEqu 
{
	//--------------------------------------------------------------------------
	// Declaration and instantiation of two floating point variables 
	// and implementation of if-else to check if the variables are equal.
	//--------------------------------------------------------------------------
	
	public static void main(String[] args) 
	{
		double varA = (1.0/10) * (1.0/10);
		double varB = (1.0/100);
		
		if (varA == varB)
			System.out.print("EQUAL");
		else
			System.out.print("NOT EQUAL");

	}

}
