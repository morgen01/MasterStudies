// *******************************************************************************
// Cards.java			Author: Christina
//
// Dealing cards
// *******************************************************************************

import java.util.Random;

public class Card 
{
	private static int face;

	private static int suit;
	
	private int club, diamond, heart, spade;
	private int jack, queen, king, ace;

	// generates random face (5-8) and suit (1-4) values
	public void Deal()
	{
		Random generator = new Random();
		face = generator.nextInt(4)+5;
		suit = generator.nextInt(4)+1;
		
	}
	
	// toString() method - but not used by program 
	public String toString()
	{
		 return face + " of " + suit;
	}
	
	
	public static void main(String[] args) 
	{
		final int CARD_DEALS = 5;
		
		// new deck object constructor
		Card deck = new Card();
		
		
		for (int count = 0; count < CARD_DEALS; count++)
		{
			deck.Deal();
			
			switch (face)
		    {
		    case 5:
		    	System.out.print("jack of ");
		    	break;  
		    case 6:
		    	System.out.print("queen of ");
		    	break;   
		    case 7:
		    	System.out.print("king of ");
		    	break;     
		    case 8:
		    	System.out.print("ace of ");
		    	break;     
		    }
		    	
		    	switch (suit)
		    {
		    case 1:
		    	System.out.println("club ");
		    	break;
		    case 2:
		    	System.out.println("diamond ");
		    	break;
		    case 3:
		    	System.out.println("heart ");
		    	break;
		    case 4:
		    	System.out.println("spade ");
		    	break;
		    }
	    
		    	
		    }		
			
		}			

}


