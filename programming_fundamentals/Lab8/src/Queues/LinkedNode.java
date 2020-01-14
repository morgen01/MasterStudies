// This class encapsulates an int value as a linked node

package Queues;

public class LinkedNode {
	int x;            // The data value
	LinkedNode next;  // Reference to the next LinkedNode
	
	// Default constructor
	LinkedNode() {
		next = null;
	}
	
	// Constructor that initializes the data value
	LinkedNode(int x) {
		this.x = x;
	}
	
}
