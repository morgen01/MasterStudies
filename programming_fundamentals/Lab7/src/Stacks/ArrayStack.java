package Stacks;
// This example shows an implementation of a stack
// using an array
// NOTE: this stack can only contain int data types
public class ArrayStack {

	int[] stack;   // Array containing the data in the stack
	int top;       // Index representing the top of the stack
	
	// Constructor
	// Preallocates an array of size 10 to be used as a stack
	// Initializes the top of the stack
	ArrayStack() {
		stack = new int[6]; // change to 6
		top = 0;
	}
	
	// Increases the capacity of the stack by making
	// a new array that is double the size of the previous one
	void makeNewArray() {
		int[] newStack = new int[stack.length*2];
		for (int i=0; i<stack.length; i++)
			newStack[i] = stack[i];
		
		stack = newStack;
	}
	
	// Implements the push operation
	void push(int e) {
		if (top==stack.length) {
			makeNewArray();
		}
		stack[top] = e;
		top++;
	}
	
	// Implements the pop operation
	int pop() {
		top--;
		return stack[top];
	}
	
	// Implements the peek operation
	int peek() {
		return stack[top-1];
	}
	
	// Implements the isEmpty operation
	boolean isEmpty() {
		return top==0;
	}
	
	// Implements the size operation
	int size() {
		return top; 
	}
	
	
}
