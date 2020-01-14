import Stacks.ArrayStack;
import Stacks.LinkedStack;

// *****************************************************************************
// Driver.java			Author: Christina
//
// Implementation of stacks using Arrays and Linked Lists
// *****************************************************************************

public class Driver4 
{
	public static void main(String[] args) 
	{
		ArrayStack stack = new ArrayStack(10);
		stack.push(1);
		stack.push(7);
		stack.push(3);
		stack.push(4);
		stack.push(9);
		stack.push(2);

		LinkedStack stack1 = new LinkedStack();
		stack1.push(1);
		stack1.push(7);
		stack1.push(3);
		stack1.push(4);
		stack1.push(9);
		stack1.push(2);
	}
}

public class ArrayStack<T> implements StackADT<> 
{
	private int[] arr;
	private int n;
	private int capacity;
	
// Creates an empty stack using the default capacity.
public ArrayStack(int cap) 
{
	capacity = cap;
	n = 0;
	arr = new int[cap];
}

public int size() 
{
	return n;
}

  
public void push(int item) 
{
	if(n == capacity)
	System.out.println("Stack is full");
else 
{
	arr[n] = item;
	n++;
}

}
  

public int pop() 
{
	int data = -999;
	if(n == 0)
	System.out.println("Stack is full");
else 
{
	data = arr[n-1];
	n--;
}
return data;
}
}

public class LinkedStack 
{
	class Node 
	{
	int data;
	Node next;
	Node(int item) 
	{
		data = item;
	}

}

private Node top;
private int n;

public LinkedStack() 
{
	top = null;
	n = 0;
}

public void push(int item) 
{
	Node newNode = new Node(item);
	newNode.next = top;
	top = newNode;
	n++;
}  

public int size() 
{
return n;
}

public int pop() 
{
if(n == 0) 
{
return -999;
}

int data = top.data;
top = top.next;
n--;

return data;

}

}