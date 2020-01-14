// *******************************************************************************
// FloatEqu_2.java			Author: Christina
//
// Equal or not equal  
// *******************************************************************************

public class FloatEqu_2 
{
	//--------------------------------------------------------------------------
	// Declaration and instantiation of two floating point variables 
	// and comparing the variables using absolute values and tolerance value.
	//--------------------------------------------------------------------------
	
	public static void main(String[] args) 
	{
		double varA = (1.0/10) * (1.0/10);
		double varB = (1.0/100);
		
		final double TOLERANCE = 0.000001;
		
		if (Math.abs(varA-varB) < TOLERANCE)
			System.out.print("EQUAL");
		else
			System.out.print("NOT EQUAL");

	}

}
