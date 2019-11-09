// CSCI 3200 Assignment 1.15

public class ComparatorArea
{
	public static int findMax(Rectangle[] arr)
	{
		int maxIndex = 0;
		for(int i=1; i< arr.length; i++)
			if(arr[i].getArea()> arr[maxIndex].getArea())
				maxIndex=i;
		return maxIndex;
	}
}


/*
public static int findMax(Rectangle []arr, cmp)
{
	int maxIndex = 0;
	for(int i=1; i<arr.size(); i++)
		if(cmp.compare(arr[i].getArea(), arr[maxIndex].getArea())>0)
			maxIndex=i;
	return arr[maxIndex].getArea();
	
}



class CaseInsensitiveCompare implements ComparatorArea
{
	public int compare(String lhs, String rhs)
	{
		return lhs.compareToIgnoreCase(rhs);
		
	}
}
*/

