import java.util.Random;
public class Assignment_2_8_1
{
	public static void main(String[] args) 
	{
		int n, ran;
		n=25;
		long startTime, endTime;
		int[] a=new int[n];

		
		Random gen=new Random();
		a[0]=gen.nextInt(5)+1;
		
		
		boolean found=false;
			
		startTime = System.nanoTime();
		for (int i=1; i<n; i++)
		{
			found=false;
			while (found==false)
			{	
			ran=gen.nextInt(n)+1;
			//System.out.println("Num generated "+ran);
			
		     for (int b=0; b<i; b++)
		       {
		              if (a[b]==ran)
		              {
		            	      found=false;
		                      break;    
		              }
		              else if (a[b]!=ran)
		              {
		            	  a[i]=ran;
		           
		            	  found=true;
		              }
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
