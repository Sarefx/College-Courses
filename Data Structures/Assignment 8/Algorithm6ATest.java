import java.util.*;

public class Algorithm6ATest
{
	public static void main(String[] args) 
	{
		MyBinaryHeap<Integer> heap = new MyBinaryHeap<>();
		Scanner scan = new Scanner(System.in);
		Random gen = new Random();
		
		System.out.println("Please enter the size of an array");
		int size = scan.nextInt();
		System.out.println("Please enter the Kth smallest you want to find from the array");
		int kth = scan.nextInt();
		Integer[] items = new Integer[size];
		for (int i=0; i<size; i++)
		{
			items[i] = gen.nextInt(1000);
		}
		System.out.println("The "+kth+"th smallest in the array is "+heap.findKthSmallest(kth, items));
	}
}
