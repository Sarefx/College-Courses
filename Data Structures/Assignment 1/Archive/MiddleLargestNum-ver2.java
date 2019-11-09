// CSCI 3200 Assignment 1.1

import java.util.Arrays;
import java.util.Random;

public class MiddleLargestNum
{
	    public static void main(String[] args) 
	    {
	        int N=10, random=100, midNum=random/2, upperBound=0, lowerBound=0, equalBound=0, upperDifference=0, lowerDifference=0;
	        Random gen = new Random();
	        int[] numbers= new int[N];
	 
	        //System.out.println("The numbers in a random order:");
	         
	                for (int index = 0; index < N; index++)
	                  {
	                     numbers[index] = gen.nextInt(random)+1;
	                     //System.out.print(numbers[index] + " ");
	                  }
	                 
	                  //System.out.println();
	                  Arrays.sort(numbers);
	                  //System.out.println("The numbers in an increment order:");
	                  
	                  //for (int index : numbers)
	                     //System.out.print(index + " ");
	                  
	                  long startTime = System.nanoTime(); // Start Time
	                  
	                  for (int i=0; i<N;i++)
	                  {
	                	  if (numbers[i] <= midNum)
	                	  {
	                		  lowerBound=numbers[i];
	                		  lowerDifference=midNum-lowerBound;
	                	  }
	                	  else
	                		  break;
	                	  
	                  }
	                  for (int i=N-1; i>=0; i--)
	                  {
	                	  if (numbers[i] >= midNum)
	                	  {
	                		  upperBound=numbers[i];
	                		  upperDifference=upperBound-midNum;
	                	  }
	                	  else
	                		  break;
	                  }
	                  
	                  if (upperDifference<=lowerDifference)
	                	  midNum=upperBound;
	                  else if (upperDifference>lowerDifference)
	                	  midNum=lowerBound;
	                  else if (upperDifference==0 || lowerDifference==0)
	                	  midNum=random/2;
	         
	                  System.out.println();
	                  System.out.println("Middle largest number: " +(midNum));

	                  long endTime = System.nanoTime();
	                  
	                  
	                  System.out.println("Runtime:" + String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9)))); // End Time
	    }
}