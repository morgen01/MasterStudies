// This class implements a queue using a linked list
// It requires the LinkedNode class to be defined
package Queues;

public class LinkedQueue {

	LinkedNode front;
	LinkedNode rear;
	static int count, x;
	
	LinkedQueue() {
		front = rear = null;
		count = 0;
	}
	
	void enqueue(int x) {
		LinkedNode newNode = new LinkedNode(x);
		if (rear!=null)			
			rear.next = newNode;
		else 
			front = newNode;
		rear = newNode;
		count++;
	}
	
	int dequeue() {
		if (front==null) {
			return -1;
		}
		
		if (front!=rear) {
			int x = front.x;
			front = front.next;		
			count--;
			return x;
		} else {
			int x = front.x;
			front = null;
			rear = null;
			count --;
			return x;
		}
	}
	
	void removeMiddle() 
	{	
		LinkedNode temp = front;
		LinkedNode prev = null;
		
		// specify middle index
		int nodeDeleteIndex = size()/2;
		
		// traverse to element before the element to be deleted
		for(int i=0; i < nodeDeleteIndex-1; i++)
		{
			// change pointers to exclude middle node from the chain and adjust indexes
			prev = temp;
			temp = temp.next;
			count--;
		}
		prev.next = temp.next;
	}
	
	
	boolean isEmpty() {
		return count==0;
	}
	
	static int size() {
		return count;
	}
}
