
/*
 * This program shows examples of recursive methods
 */
public class RecursionExamples {

	public static void main(String[] args) {
		System.out.println("The 10th Fibonnaci number is "+fib(10));
		
		System.out.println("The sum of numbers from 1 to 100 is "+sum(100));

		System.out.println("5! is "+factorial(5));
		
		System.out.println("Is \"racecar\" a palindrome? Answer: "+isPalindrome("racecar"));
		System.out.println("Is \"computer\" a palindrome? Answer: "+isPalindrome("computer"));

	}
	
	// Returns the nth Fibonacci number
	public static int fib(int n) {
		if (n<0) {
			System.out.println("Wrong input, number must be >=0");
		}
		if (n==0) return 0;
		else if (n==1) return 1;
		else return fib(n-1)+fib(n-2);
	}
	
	// Returns the sum of all numbers from 1 to n
	public static int sum(int n) {
		if (n<1) {
			System.out.println("Wrong input, number must be >=1");
		}
		if (n==1) return 1;
		else return n + sum(n-1);		
	}
	
	// Returns the factorial of n
	public static int factorial(int n) {
		if (n<1) {
			System.out.println("Wrong input, number must be >=1");
		}
		if (n==1) return 1;
		else return n * factorial(n-1);		
	}
	
	// A palindrome is a word spelled the same forwards and backwards
	// Returns true if s is a palindrome and false otherwise
	public static boolean isPalindrome(String s) {
		// 3 base cases and a recursive case
		if (s==null || s.length()==1) {
			// Base case 1 (s is null) and 2 (length of string is 1)
			return true;		
		} else if (s.length()==2) {
			// Base case 3 (length of string is 2)
			// If the two characters are the same, then it is a palindrome
			if (s.charAt(0)==s.charAt(s.length()-1)) return true;
			else return false;
		} else {
			// Recursive case
			if (s.charAt(0)==s.charAt(s.length()-1) &&
				    isPalindrome(s.substring(1,s.length()-1))) {
				return true;
			} else {
				return false;
			}
		}			
		
	}

}
