public class Assignemnt_2_7b 
{
	public static void main(String[] args)
	{
		int n=3000, sum, i, j, k;
		long startTime, endTime;
		System.out.println("The number is "+n);
		
		sum=0;
		startTime = System.nanoTime();
		for(i=0;i<n;i++)
			sum++;
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		
		sum=0;
		startTime = System.nanoTime();
		for(i=0;i<n;i++)
			for(j=0; j<n;j++)
				sum++;
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		
		sum=0;
		startTime = System.nanoTime();
		for(i=0;i<n;i++)
			for(j=0; j<n*n;j++)
				sum++;
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		
		sum=0;
		startTime = System.nanoTime();
		for(i=0;i<n;i++)
			for(j=0; j<i;j++)
				sum++;
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		
		sum=0;
		startTime = System.nanoTime();

		for(i=0;i<n;i++)
			for(j=0; j<i*i;j++)
				for(k=0; k<j;k++)
					sum++;
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		
		sum=0;
		startTime = System.nanoTime();
	
		for(i=0;i<n;i++)
			for(j=0; j<i*i;j++)
				if(j%i==0)
					for(k=0; k<j;k++)
						sum++;		
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
		
	
	}

}
