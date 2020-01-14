// *******************************************************************************
// NearestNeighbor.java					Author: Christina Morgenstern
//										Programming Fundamentals 
//										Fall 2018
//										
// Programming Assignment 3
// *******************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// -------------------------------------------------------------------------------
// Program implements Nearest Neighbor algorithm for classification of iris plants 
// based on flower morphology.
// -------------------------------------------------------------------------------


public class NearestNeighbor 
{
	private static String[] predictedLabel = new String [75];
	private static double accuracy;
	private static double [] closest = new double [75];
	
	
	// Classifying testing examples using nearest neighbor algorithm and selecting closest training example
	public static double [] nearestNeighbor (double[][] train, double[][] test) 
	{
		double distance = 0;
		double closest []= train[0]; // index of current closest sample
		double smallestDistance = 0;
        
        // iterating over testing examples and computing the Euclidian distance
       for (int i = 0; i < test.length; i++)
       {
        	for(int j = 0; j < test[i].length; j++)
        	{
        		distance = Math.sqrt(Math.pow(Math.abs(train[i][j] - test[i][j]), 2));
             }
        }
        		
       
        // retrieving indexes with smallest distance to training examples
        for (int m = 0; m < train.length; m++)
        {
            	for(int n = 0; n < train[n].length; n++)
            	{	
        	if (distance <= smallestDistance)
        		{
        			smallestDistance = distance;
        			closest = train[m];
        		}
            	}
        }
        return closest;
	}
	  
	
     // copy class labels corresponding to retrieved indexes into new String array
    public static String [] getClassLabel (String [] irisType, int [] closest) 
    {
	for (int index = 0; index < closest.length; index++)
		
		for (int index2 = 0; index2 < irisType.length; index2++)
			
			if (index == index2)
				
				predictedLabel = irisType[index];			
	
	return predictedLabel;
	}
           

	// Calculates accuracy of prediction
	public static double performance (String[] predictedLabel, String[] trueLabel)
	{
		int count = 0;
		double total = trueLabel.length;
		
		for (int i = 0; i < trueLabel.length; i++)
        {
        	for(int j = 0; j < predictedLabel.length; j++)
        	{
        		if (trueLabel[i] == predictedLabel[j])
        		{
        			count =+ 1;
        		}
        		else
        		{
        			count =+ 0;
        		}
        	}
        }	
	accuracy = count/total;
	return accuracy;
	}
	
			
	// Main method to read and parse input files, to perform nearest neighbor algorithm and print output
	public static void main(String[] args) throws FileNotFoundException
	{
	// Printing Header
	System.out.println("Programming Fundamentals \nNAME: Christina Morgenstern"
					+ "\nPROGRAMMING ASSIGNMENT 3 \n");
	
	// Variables to read and parse input files
	String trainingFile, testFile;
	String inputLine1 = " ";
	String inputLine2 = " ";
	int row = 0;
	int row2 = 0;
	
	// Array set up for storing morphological characteristics and species names of training data
	double [][] trainingData = new double [75][4];
	String [] trainingType = new String [75];
	
	// Scanner for user input
	Scanner keyboard = new Scanner (System.in);
	
	// Prompt user for training file and read file using scanner
	System.out.print("Enter the name of the training file: ");
	trainingFile = keyboard.nextLine();
	
	// create new file object
	File file = new File(trainingFile);
	
	// Scanner object to read lines from training file
	Scanner fileScan = new Scanner(file);
	
	// store attributes of training data in 2D array and species labels in 1D array
	while (fileScan.hasNext())
	{
		inputLine1 = fileScan.nextLine();
		String [] inArray = inputLine1.split(",");
		
		for (int y = 0; y < inArray.length; y++)
		{
			trainingType [row] = inArray[4];
		}
		
		for (int x = 0; x < inArray.length-1; x++)
		{
			trainingData [row] [x] = Double.parseDouble(inArray[x]);
		}
		row++;
	}
	fileScan.close();
	
	// Array set up for storing morphological characteristics and species names of test data 
	double [][] testData = new double [75][4];
	String [] testType = new String [75];
	
	// Prompt user for test file and read file using scanner
	System.out.print("Enter the name of the testing file: ");
	testFile = keyboard.nextLine();
		
	// create new file object
	File file2 = new File(testFile);
		
	// Scanner object to read lines from training file
	Scanner fileScan2 = new Scanner(file2);
		
	// store attributes in 2D array and species labels in 1D array
	while (fileScan2.hasNext())
	{
		inputLine2 = fileScan2.nextLine();
		String [] inArray2 = inputLine2.split(",");
			
		for (int y = 0; y < inArray2.length; y++)
		{
			testType [row2] = inArray2[4];
		}
			
		for (int x = 0; x < inArray2.length-1; x++)
		{
			testData [row2] [x] = Double.parseDouble(inArray2[x]);
		}
		row++;
		}
	fileScan2.close();
		
	keyboard.close();
	
	// applying nearest neighbor algorithm
	nearestNeighbor(trainingData, testData);
	
	// matching closest values to corresponding plant species in training data set
	getClassLabel (testType, closest);
	
	// print output data
	System.out.println("EX#:  \t TRUE LABEL, \t PREDICTED LABEL");
	
	for (int i = 1; i < 75; i++)
	
	for (int j = 1; j < testType.length; j++)
		
	for (int k = 1; k < predictedLabel.length; k++)
		
	System.out.println(i + ":" + "\t"  + testType + "\t" + predictedLabel);
			
	
	System.out.print("ACCURACY: " +  performance (predictedLabel, testType));
	System.out.print("____________________________________________________________________________");
	}
}
					


