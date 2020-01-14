// *******************************************************************************
// Numbers.java			Author: Christina
//
// Numbers array
// *******************************************************************************

public class Numbers 
{
	
	// method accepts array of numbers and returns for each number in the array the next bigger one
	static void nextLargest(int arr[])
	{
		
		for (int i = 0; i < arr.length ; i++)
		{
			int next = Integer.MAX_VALUE;
			for (int j = i+1; j < arr.length; j++)
			{
				if (arr[i] < arr[j])
				{
					next = arr[j];
					break;
				}		
			}
			System.out.println(arr[i] + " : " + next);				
	}
			
}

	public static void main(String[] args) 
	{
		int arr[] = {78, 22, 56, 99, 12, 14, 17, 15, 1, 144, 37, 23, 47, 88, 3, 19}; 
		nextLargest(arr);
	}

}

