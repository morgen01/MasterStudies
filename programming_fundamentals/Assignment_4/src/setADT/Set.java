// *******************************************************************************
// Set.java								Author: Christina Morgenstern
//										Programming Fundamentals 
//										Fall 2018
//										
// Programming Assignment 4
// *******************************************************************************

package setADT;

// methods of the Set class
public class Set 
{
	
	private LinkedNode head; // head node
	private int n; 			// list count
	
	class LinkedNode 
	{
		int data;
		LinkedNode next;
		LinkedNode(int item) 
	{
		data = item;
	}
	}
	

	// constructor of set implemented using a singly linked list
	public Set()
	{
		head = null;
		n = 0;
	}
	
	
	// adds element to set if not already present
	public void add(int item) 
	{	
		if (exists(item) == true)
		{
			return;
		}

        else 
        {   	
        	LinkedNode newNode = new LinkedNode(item);
        	newNode.next = head;
    		head = newNode;
    		n++;	
        }
	}  
	
	
	// deletes selected element from set
	public void del(int item) 
	{
		
		// degenerate case - empty linked list
		if (head == null)
			return;
		
		LinkedNode cur = new LinkedNode(item);
		cur = head;
		LinkedNode prev = new LinkedNode(item);
		prev = null;
			
		// special case - removing the first node
		if (head.data == item)
		{
			head = head.next;
			return;
		}
			
		//general case - removing any but first node
		while (cur != null && cur.data != item)
		{
			prev = cur;
			cur = cur.next;
		}
			
		// if item is not present in set
		if (cur == null) return;
			
		// unlink node to be deleted from linked list
		prev.next = cur.next;
	
	}

	
	// returns true if element is present and false otherwise
	public boolean exists(int item)
	{
		LinkedNode cur = new LinkedNode(item);
        cur = head;
        
        while (cur != null) 
        {
        	if (cur.data == item)
        	{
        		return true; 
        	}
        	else
        	{
        		cur = cur.next;
        	}
        }
        return false;
	}
	
	
	// returns space separated list of set elements
	public String toString()
    {
		LinkedNode cur = new LinkedNode(n);
        cur = head;
        String str = "";
        
        while (cur != null) 
        {
              str += cur.data + " ";
              cur = cur.next;
        }
        return str;
    }
	
}
