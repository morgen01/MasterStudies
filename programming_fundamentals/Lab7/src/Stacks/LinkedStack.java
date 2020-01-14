package Stacks;

// This class implements a stack as a linked list
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

// constructor
public LinkedStack() 
{
	top = null;
	n = 0;
}
// pushes elements into stack
public void push(int item) 
{
	Node newNode = new Node(item);
	newNode.next = top;
	top = newNode;
	n++;
}  
// returns length of linked stack
public int size() 
	{
	return n;
	}

// removes elements from stack
public int pop() 
{
	if(n == 0) 
	{
		return -999; // reference is returned when stack is empty
	}

	int data = top.data;
	top = top.next;
	n--;
	return data;
}
// shows top element in stack
public int peek()
{
	return top.data;
}


public void removeBottomHalf()
{
	Node cur = top;
	for (int i=0; i <size()/2-1; i++) {
		cur = cur.next;
	}
	// will remove bottom half
	cur.next = null;
}
}