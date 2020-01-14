// *******************************************************************************
// Box.java			Author: Christina
//
// Own class and method overload
// *******************************************************************************

// Box class containing instance data size
public class Box
{
	private int size = 0;
	
	// Own method printBox with no parameters and void return type
	public void printBox()
	{
		int row, column;
		
		// setting up loop to create a box figure made of *
		for(row = 1; row <= size; row++)
		{
			for(column = 1; column <= size; column++)
			{
				System.out.print("*"); 
			}
			System.out.print("\n"); 	
		}
	}
	
	// Demonstration of method overload
	public void printBox(char c)
	{
		int row, column;
		
		// setting up loop to create a box figure made of c
		for(row = 1; row <= size; row++)
		{
			for(column = 1; column <= size; column++)
			{
				System.out.print('c'); 
			}
			System.out.print("\n"); 		
		}
	}
	
	// Execution of printBox methods
	public static void main(String[] args) 
	{
		Box figure = new Box();
		figure.size = 5;
		figure.printBox();
		figure.printBox('c');
		
	}
}