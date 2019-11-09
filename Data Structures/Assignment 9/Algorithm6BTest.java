import java.util.*;

public class Algorithm6BTest
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Random gen = new Random();
		System.out.println("please enter List");
		int listSize = scan.nextInt();
		System.out.println("please enter k");
		int k = scan.nextInt();
		Integer[] items = new Integer[listSize];
		for (int i=0;i<items.length;i++)
		{
			items[i]= gen.nextInt(1000); // Adds a random value between 0 and 1000 in the list
			//System.out.println(items[i]);
		}
		MyBinaryHeap<Integer> heap = new MyBinaryHeap<>();
		System.out.println("The "+k+"th largest value in the array is "+heap.findKthLargest(k, items));
	}
}