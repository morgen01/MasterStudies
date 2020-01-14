// ************************************************
// Driver.java			Author: Christina
//
// Implementation of ArrayQ and LinkedQueue
// ************************************************

package Queues;

public class Driver 
{
	
	public static void main(String[] args) 
	{

		// create instance of array queue
		ArrayQ aQueue = new ArrayQ();
		
		// adding elements to the array queue
		aQueue.enqueue(1);
		aQueue.enqueue(7);
		aQueue.enqueue(3);
		aQueue.enqueue(4);
		aQueue.enqueue(9);
		aQueue.enqueue(2);
		System.out.println("Number of elements pushed into the array queue: " + aQueue.size());

		// Remove and return elements from array queue
		System.out.println("Removed elements from array queue one-by-one: ");
		for (int i = aQueue.size(); i > 0; i--) 
		{
			System.out.println(aQueue.dequeue());
		}
		
		
		// create instance of linked list queue
		LinkedQueue lQueue = new LinkedQueue();
		
		// adding elements to the Linked Queue
		lQueue.enqueue(1);
		lQueue.enqueue(7);
		lQueue.enqueue(3);
		lQueue.enqueue(4);
		lQueue.enqueue(9);
		lQueue.enqueue(2);
		System.out.println("Number of elements pushed into the linked queue: " + lQueue.size());
		
		//Remove and return elements from linked queue
		//System.out.println("Removed elements from linked queue one-by-one: ");
		//	for (int i = lQueue.size(); i > 0; i--) 
		//	{
		//		System.out.println(lQueue.dequeue());
		//	}	
		
		// remove middle element of linked queue
		lQueue.removeMiddle();
		
	    System.out.println("Elements in the queue after removal: ");
	    for (int i = lQueue.size(); i > 0; i--) 
			{
			System.out.println(lQueue.dequeue());
			}	
	    
	   
	}

}
