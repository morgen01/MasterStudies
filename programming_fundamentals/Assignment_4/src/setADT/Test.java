// *******************************************************************************
// Test.java							Author: Christina Morgenstern
//										Programming Fundamentals 
//										Fall 2018
//										
// Programming Assignment 4
// *******************************************************************************

package setADT;

import java.util.Scanner;

//driver class for programming assignment 4
public class Test 
{
	
	public static void main(String[] args) 
	{
		// printing header
		System.out.println("Programming Fundamentals \nNAME: Christina Morgenstern"
						+ "\nPROGRAMMING ASSIGNMENT 4 - SET\n");
		
		// declare local variables
		String input, command = " ";
		
		// instantiate new set object
		Set set = new Set();
		
		Scanner scan = new Scanner(System.in);
		
		// infinite do-while loop
		do
		{
			
			System.out.print("Enter command: ");
			input = scan.nextLine(); 
			
			String [] commands = input.split(" ");
			command = commands[0];
			int x = Integer.parseInt(commands[1]);	
			
				switch(command)
				{
				case "add":
					set.add(x);
					System.out.println(set.toString());
					break;
				case "del":
					set.del(x);
					System.out.println(set.toString());
					break;
				case "exists":
					System.out.println(set.exists(x));
					break;
				default:
					break;
				}	
			
				
			// check if input is of correct format
			while (!command.equals("add " + x) || (!command.equals("del " + x) || (!command.equals("exists " + x) || (command.equals(" "))))) 
			{	
				
				System.out.print("Enter command: ");
				input = scan.nextLine(); 
					
				commands = input.split(" ");
				command = commands[0];
				x = Integer.parseInt(commands[1]);	
				
					switch(command)
					{
					case "add":
						set.add(x);
						System.out.println(set.toString());
						break;
					case "del":
						set.del(x);
						System.out.println(set.toString());
						break;
					case "exists":
						System.out.println(set.exists(x));
						break;
					default:
						break;
					}
				}
			}
		
			while (command.equals("add") || command.equals("del") || command.equals("exists"));
		
			scan.close();
	}
}




