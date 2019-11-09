// CSCI 3200 Assignment 1.15

public class ComparatorPerimeter
{
	public static int findMax(Rectangle[] arr)
	{
		int maxIndex = 0;
		for(int i=1; i< arr.length; i++)
			if(arr[i].getPerimeter()> arr[maxIndex].getPerimeter())
				maxIndex=i;
		return maxIndex;
	}
}