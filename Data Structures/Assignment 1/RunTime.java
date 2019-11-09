// CSCI 3200 Assignment 1.1

import java.util.Random;

public class RunTime
{
	public static void main(String[] args) 
	{
		Random r = new Random();
		
		long startTime = System.nanoTime();
		
		long endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		 

		startTime = System.nanoTime();
		for(int i = 0; i < 1000000; i++)
		{
			//do a bunch of work		
			r.nextInt(5000);
		}
		 endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
	}
}