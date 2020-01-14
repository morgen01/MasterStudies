
import java.util.Iterator;

public class Driver2 
{
	
	// This class implements a Stack ADT as a linked list
	public class LinkedStack 
	{
		LinkedNode front;  // Reference to the first LinkedNode in the list
		int count;         // Number of nodes in the list
		
		// Constructor - initializes the front and count variables
		LinkedStack() 
		{
			front = null;
			count = 0;
		}
		
		// Implements the push operation
		void push(int x) 
		{
			LinkedNode newNode = new LinkedNode(x);
	    	newNode.next = front;
	    	front = newNode;
	    	count++;
		}
		
		// Implements the pop operation
		int pop() 
		{
			int x = front.x;
			front = front.next;
			count--;
			return x;
		}
	}
	
	public static void main(String[] args) 
	{
		push(1);
		System.out.println()

	}

}
