import java.util.Random;
public class Assignment_2_8_2 
{
	public static void main(String[] args) 
	{
		int n, ran;
		n=15;
		long startTime, endTime;
		int[] a=new int[n];
		boolean[] used=new boolean[n+1];
		
		Random gen=new Random();
		ran=gen.nextInt(n)+1;
		//System.out.println("Num generated "+ran);
		a[0]=ran;
		used[ran]=true;
		
		boolean found=false;
	
		startTime = System.nanoTime();
		for (int i=1; i<n; i++)
		{
			found=false;
			while (found==false)
			{	
			ran=gen.nextInt(n)+1;
			//System.out.println("Num generated "+ran);
			
			if (used[ran])
				found=false;
			else
			{
				a[i]=ran;
          	    used[ran]=true;
          	    found=true;
			}
			}
		}
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
	
		for (int value : a)
		System.out.print(value+" ");	
		
			
	}	
}

