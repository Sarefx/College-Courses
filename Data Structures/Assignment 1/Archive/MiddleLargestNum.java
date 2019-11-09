// CSCI 3200 Assignment 1.1

import java.util.Arrays;
import java.util.Random;

public class MiddleLargestNum
{
	    public static void main(String[] args) 
	    {
	        int N=10, random=100;
	        Random gen = new Random();
	        int[] numbers= new int[N];
	 
	        System.out.println("The numbers in a random order:");
	         
	                for (int index = 0; index < N; index++)
	                  {
	                     numbers[index] = gen.nextInt(random)+1;
	                     System.out.print(numbers[index] + " ");
	                  }
	                 
	                  System.out.println();
	                   
	                  long startTime = System.nanoTime(); // Start Time
	                  
	                  Arrays.sort(numbers);
	                  System.out.println("The numbers in an increment order:");
	                  for (int index = 0; index < N; index++)
	                     System.out.print(numbers[index] + " ");

	                  long endTime = System.nanoTime();
	                  
	                  System.out.println();
	                  System.out.println("Middle largest number: " +numbers[N/2]);
	                  System.out.println("Runtime:" +
	                            String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9)))); // End Time
	    }
}