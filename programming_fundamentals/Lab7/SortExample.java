import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

// This example shows implementations of sorting algorithms
// It also tests the algorithms in terms of running time
class SortExample {

	public static void main(String args[]) {
		// Generate an array of random integers
		Random gen = new Random(1);
		int[] randNums = new int[100000];
		for (int i=0; i<randNums.length; i++) {
			randNums[i] = gen.nextInt();
		}

		// Save the current time
		System.out.println("START");
		long startTime = System.currentTimeMillis();

		// Do the sort (uncomment the method call you want to test)
		for (int i=0; i<1; i++) {
			Arrays.sort(randNums);
			//selectionSort(randNums);
			//insertionSort(randNums);
			//mergeSort(randNums, 0, randNums.length-1);
		}
		// Save the current time and display the difference
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("END");
		System.out.println("TIME="+elapsedTime+"ms");		

	}

	// Sorts array a using the selection sort
	public static void selectionSort(int[] a) {
		int min;

		for (int i = 0; i<a.length-1; i++)
		{
			min = i;
			for (int j=i+1; j<a.length; j++)
				if (a[j] < a[min])
					min = j;

			swap (a, min, i);
		}

	}

	//-----------------------------------------------------------------
	//  Sorts the specified array of objects using an insertion
	//  sort algorithm.
	//-----------------------------------------------------------------
	public static void insertionSort (int[] a)
	{
		for (int i=1; i<a.length; i++)
		{
			int key = a[i];
			int j = i;

			// Shift larger values to the right
			while (j>0 && a[j-1]>key)
			{
				a[j] = a[j-1];
				j--;
			}

			a[j] = key;
		}
	}


	//  Swaps two elements in the specified array.
	public static void swap (int[] data, int index1, int index2)
	{
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	//-----------------------------------------------------------------
	//  Sorts the specified array of objects using the merge sort
	//  algorithm.
	//-----------------------------------------------------------------
	public static void mergeSort (int[] data, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort (data, min, mid);
			mergeSort (data, mid+1, max);
			merge (data, min, mid, max);
		}
	}

	//-----------------------------------------------------------------
	//  Sorts the specified array of objects using the merge sort algorithm.
	//-----------------------------------------------------------------
	public static void merge (int[] data, int first, int mid, int last)
	{
		int[] temp = new int[data.length];

		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array

		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1] < data[first2])
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}

		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}

		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
	}

	
}