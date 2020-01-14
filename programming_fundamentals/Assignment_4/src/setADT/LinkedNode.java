// *******************************************************************************
// LinkedNode.java						Author: Christina Morgenstern
//										Programming Fundamentals 
//										Fall 2018
//										
// Programming Assignment 4
// *******************************************************************************

package setADT;

// This class encapsulates an int value as a linked node
public class LinkedNode {
	
	int x;            // the data value
	LinkedNode next; // reference to the next LinkedNode 
	
	// default constructor
	LinkedNode() 
	{
		next = null;
	}
	
	// constructor that initializes the data value
	LinkedNode(int x) 
	{
		this.x = x;
	}
}
