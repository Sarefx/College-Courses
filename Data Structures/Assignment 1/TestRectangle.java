// CSCI 3200 Assignment 1.15
import java.util.Comparator;
import java.util.Random;

public class TestRectangle 
{
	public static void main(String[] args)
	{
		Random gen=new Random();
		final int rectNum=100, limitLength=10000000;
		Rectangle[] rectList=new Rectangle[rectNum];
		for(int i =0; i<rectNum; i++)
			rectList[i]= new Rectangle(gen.nextInt(limitLength)+1, gen.nextInt(limitLength)+1);	
		System.out.println("This rectangle has the largest Area: "+findMax(rectList, new AreaCompare()));
		System.out.println("This rectangle has the largest Pertimeter "+findMax(rectList, new PerimeterCompare()));
	}
	public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp)
	{
		int maxIndex=0;
		for(int i =1; i<arr.length; i++)
			if(cmp.compare(arr[i], arr[maxIndex])>0)
				maxIndex=i;
		return arr[maxIndex];
	}
	static class AreaCompare implements Comparator<Rectangle>
	{
		public int compare(Rectangle lhs, Rectangle rhs)
		{
			if (lhs.getArea() > rhs.getArea())
				return 1;
			else
				return 0;
		}
	}
	static class PerimeterCompare implements Comparator<Rectangle>
	{
		public int compare(Rectangle lhs, Rectangle rhs)
		{
			if (lhs.getPerimeter() > rhs.getPerimeter())
				return 1;
			else
				return 0;
		}
	}
}