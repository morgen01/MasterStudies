
// *****************************************************************************
// Driver.java			Author: Christina
//
// Implementation of stacks using Arrays and Linked Lists
// *****************************************************************************

package Stacks;

public class Driver
{	
	public static void main(String[] args) 
	{
		int top=0; // variable to declare top of stack
		
		// implementation of stack as array
		ArrayStack stack = new ArrayStack();
		stack.push(1);
		stack.push(7);
		stack.push(3);
		stack.push(4);
		stack.push(9);
		stack.push(2);
		System.out.println("Number of pushed elements into Array stack: " + stack.size());	
		
		// Pop off elements from array stack and display each int
		System.out.println("Removed elements from Array stack one-by-one: ");
		for (int i=stack.size(); i>top ; i--)
			{
			System.out.println(stack.peek());
			stack.pop();
			}
	
		// Prof. solution 
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
		
		
		
		// implementation of stack as linked list
		LinkedStack stack1 = new LinkedStack();
		stack1.push(1);
		stack1.push(7);
		stack1.push(3);
		stack1.push(4);
		stack1.push(9);
		stack1.push(2);
		System.out.println("Number of pushed elements into Linked stack: " + stack1.size());
		
		
		// Prof. solution 
		//System.out.println(stack1.pop());
		//System.out.println(stack1.pop());
		//System.out.println(stack1.pop());
		//System.out.println(stack1.pop());
		//System.out.println(stack1.pop());
		//System.out.println(stack1.pop());
		
		
		// Pop off elements from linked stack and displaying each int
		//System.out.println("Removed elements from Linked stack one-by-one: ");
		//for (int i=stack1.size(); i>0; i--)
		//	{
		//	System.out.println(stack1.peek());
		//	stack1.pop();
		//	}
		
		// remove bottom half of elements in linked stack
		//for (int i=stack1.size()/2; i>0; i--)
		//{
		//	System.out.println(stack1.pop());
		//}
		
		stack1.removeBottomHalf();
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
	
				
}
}

