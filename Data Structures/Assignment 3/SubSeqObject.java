
public class SubSeqObject
{
	private int sum, startIndex, endIndex;
	public SubSeqObject(int sum1, int startIndex1, int endIndex1)
	{
		sum=sum1;
		startIndex=startIndex1;
		endIndex=endIndex1;
	}
	public String toString()
	{
		String str="The sum is "+sum+", start index is "+startIndex+" and the end index is "+endIndex;
		return str;
	}

}
