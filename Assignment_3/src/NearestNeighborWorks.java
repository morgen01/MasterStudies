import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NearestNeighborWorks {

	final static int NUM_EXAMPLES = 75;
	final static int NUM_ATTRS = 4;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		printHeading();
		
		// Get file names
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the training file: ");
		String trainFileName = scan.nextLine();
		System.out.print("Enter the name of the testing file: ");
		String testFileName = scan.nextLine();
		
		// Create arrays to store data and predictions
		double [][] trainAttrs = new double [NUM_EXAMPLES][NUM_ATTRS];
		double [][] testAttrs = new double[NUM_EXAMPLES][NUM_ATTRS];
		String[] trainLabels = new String[NUM_EXAMPLES];
		String[] testLabels = new String[NUM_EXAMPLES];
		String[] predLabels = new String[NUM_EXAMPLES];
		
		// Load training data
		loadData(trainFileName, trainAttrs, trainLabels);
		loadData(testFileName, testAttrs, testLabels);
		
		// check if data is loaded
		for (int i=0; i<trainAttrs.length; i++) 
		{
			for(int j=0; j<trainAttrs[i].length; j++)
				System.out.print(trainAttrs[i][j]+ " ");
			System.out.println();
		}
		
		//classify test examples and make predictions
		predict(trainAttrs, testAttrs, trainLabels, testLabels, predLabels);
		
		// compute accuracy
		System.out.println("EX#: TRUE LABEL, PREDICTED LABEL");
		int hits = 0;
		for (int i=0; i<testLabels.length; i++) 
		{
			System.out.println(i+1 + ":" + testLabels[i] + " " + predLabels[i]);
			if(testLabels[i].equals(predLabels[i])) // .equals because of strings
				hits++;
		}
		double accuracy = (double) hits/NUM_EXAMPLES;
		System.out.println("ACCURACY: " + accuracy);
	}
	
	// method to load data
	 public static void loadData(String fileName, double[][] attrs, String[] labels) throws FileNotFoundException
	 {
		Scanner fileScan = new Scanner (new File(fileName));
	 	
		int row = 0; // keep track of rows
		
		while(fileScan.hasNextLine()) 
		{
			String line = fileScan.nextLine();
			String [] tokens = line.split(","); // tokens as strings
			
			for(int i=0; i<NUM_ATTRS; i++)
				attrs[row][i] = Double.parseDouble(tokens[i]);
			
				labels[row] = tokens[NUM_ATTRS];
				row++;
		}
		
		fileScan.close();
	}
		
	// Classify test examples and make predictions
	public static void predict(double[][] trainAttrs, double[][] testAttrs, String[] trainLabels, String[] testLabels, String[] predLabels) 
	{
		for (int i=0; i<testAttrs.length; i++) 
		{
			int minIndex = 0;
			double min = getDist(testAttrs[i], trainAttrs[minIndex]);
				for (int j=1; j<trainAttrs.length; j++) 
				{
					double dist = getDist(testAttrs[i], trainAttrs[j]);
					if(dist < min)
					{
						min = dist;
						minIndex = j;
					}
				}
		predLabels[i] = trainLabels[minIndex];
		}
		
	}
	
	public static double getDist(double[] x, double[] y) 
	{
		double sum = 0.0;
		for (int i=0; i<x.length; i++) 
		{
			sum += Math.pow(x[i] - y[i], 2);
		}
		return Math.sqrt(sum); 
	}
	
	
	public static void printHeading() 
	{
	System.out.println("Programming Fundamentals \nNAME: Christina Morgenstern"
			+ "\nPROGRAMMING ASSIGNMENT 3 \n");
	}
}
