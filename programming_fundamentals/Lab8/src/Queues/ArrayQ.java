package Queues;

// This class implements a queue using a circular array
public class ArrayQ {

	   private final int DEFAULT_CAPACITY = 10;
	   private int front, rear, count;
	   private int[] queue;

	   
	   public ArrayQ()
	   {
	      front = rear = count = 0;
	      queue = new int[DEFAULT_CAPACITY];
	   }

	   //  Adds the specified element to the rear of the queue.
	   public void enqueue (int element) {
	      if (count == queue.length)
	          expandCapacity();

	       queue[rear] = element;
	       rear = (rear+1) % queue.length;
	       count++;	   
	   }

	   //-----------------------------------------------------------------
	   //  Creates a new array to store the contents of this queue with
	   //  twice the capacity of the old one.
	   //-----------------------------------------------------------------
	   public void expandCapacity()
	   {
	      int[] larger = new int[queue.length*2];

	      for (int index=0; index < count; index++)
	         larger[index] = queue[(front+index) % queue.length];

	      front = 0;
	      rear = count;
	      queue = larger;
	   }
	   
	   
	   //  Removes and returns the element at the front of the queue.
	   public int dequeue() {
		   if (count==0) return -1;
		   int x = queue[front];
	       front = (front+1) % queue.length;
	       count--;
		   return x;
	   }

	   //  Returns a reference to the element at the front of the queue
	   //  without removing it.
	   public int first() {
		   return queue[front];
	   }

	   //  Returns true if the queue contains no elements and false
	   //  otherwise.
	   public boolean isEmpty() {
		   return count==0;
	   }

	   //  Returns the number of elements in the queue.
	   public int size() {
		   return count;
	   }

	   //  Returns a string representation of the queue.
	   public String toString() {
		   return "";
	   }

}
