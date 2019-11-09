import java.util.*;
public class Assignment_2_8_3 


{
	public static void main(String[] args) 
	{
		/*
		int n, ran, holdvalue;
		long startTime, endTime;
		n=15;
		int[] a=new int[n];

		Random r=new Random();
		
		
		startTime = System.nanoTime();
		for (int i=0; i<n ;i++)
		{
			a[i]=i+1;
		}
		
		for (int i=1; i<n; i++)
		{
			holdvalue=a[i];
			ran=r.nextInt(i);
			a[i]=a[ran];
			a[ran]=holdvalue;
		}
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));

		
		for (int value : a)
		System.out.print(value+" ");
		*/
		double answer;
		double limit=1.00002800000;
		long startTime, endTime;
		
		startTime = System.nanoTime();

		//for (int i=1; i<limit; i++) {

			answer = limit * (Math.log(limit) / Math.log(2));
		//}
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		System.out.println(answer);

		
		
	}
	
}
