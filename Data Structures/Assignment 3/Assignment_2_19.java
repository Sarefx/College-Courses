public class Assignment_2_19
{
	public static void main(String[] args)
	{
		int []a= {-1,2,-3,5,2,-4,-2}; // 5 starts at 3, and 2 start at 4, the length is 7, start 0, end 6
		System.out.println("The first algo result is "+maxSubSum2(a));
		System.out.println("The second algo result is "+maxSubSum4(a));
	}
	public static SubSeqObject maxSubSum2(int[] a)
	{
		int maxSum=0, startIndex=0, endIndex=0;
		for (int i=0;i<a.length;i++)
		{
			int thisSum=0;
			for (int j=i;j<a.length;j++)
			{
				thisSum+=a[j];
				if (thisSum>maxSum)
				{
					maxSum=thisSum;
					startIndex=i;
					endIndex=j;
				}
			}
		}
		SubSeqObject subSeq= new SubSeqObject(maxSum,startIndex,endIndex);
		return subSeq;
	}
	public static SubSeqObject maxSubSum4(int[]a)
	{
		int maxSum=0, thisSum=0, startIndex=0, endIndex=0;
		for(int j=0;j<a.length;j++)
		{
			thisSum+=a[j];	
			if(thisSum>maxSum)
			{
				maxSum=thisSum;
				endIndex=j;
			}
			else if(thisSum<0)
			{
				thisSum=0;
				startIndex=j+1;
			}
		}
		SubSeqObject subSeq= new SubSeqObject(maxSum,startIndex,endIndex);
		return subSeq;
	}
}