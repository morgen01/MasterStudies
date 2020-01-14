import java.util.Arrays;
import java.util.Random;

// This example shows implementations of linear
// and binary search algorithms (recursive and iterative versions)
class Search {
	
	public static void main(String args[]) {
		int[] nums = {45, 23, 86, 31, 50, 38, 28, 67, 12, 17};
		int target = 38;
		System.out.println(target+" is at index "+linearSearch(nums,target));

		Arrays.sort(nums);  // Need to sort before using binary search
		System.out.println(target+" is at index "+binarySearch(nums,target));
		System.out.println(target+" is at index "+binarySearchR(nums,target,0,nums.length-1));
		
	}
	
	// Linear search
	public static int linearSearch(int[] a, int t) {
		for (int i=0; i<a.length; i++) {
			if (a[i]==t) {
				return i;
			}
		}		
		return -1;
	}
	
	// Iterative implementation of binary search
	public static int binarySearch(int[] a, int t) {
		int l = 0;
		int r = a.length-1;
		int m;
		
		while (l<=r) {
			m = (l+r)/2;
			if (t==a[m]) return m;
			else if (t<a[m]) r = m - 1;
			else l = m + 1;					
		}
		
		return -1;
	}
	
	// Recursive implementation of binary search
	public static int binarySearchR(int[] a, int t, int l, int r) {
		// Test for base case
		if (l>r) return -1;
		
		int m = (l+r)/2;
		if (t==a[m]) return m;
		
		// Recursive cases
		else if (t<a[m]) return binarySearchR(a, t, l, m - 1);
		else return binarySearchR(a, t, m + 1, r);							
	}
	
}