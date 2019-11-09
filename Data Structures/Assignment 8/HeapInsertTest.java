import java.util.Random;

public class HeapInsertTest
{
	public static void main(String[] args) 
	{
		int number;
		//number = 10;
		//number = 25;
		//number = 50;
		number = 100;
		Integer[] numbers = new Integer[number];
		Random gen = new Random();
		
		for (int n=0; n<numbers.length; n++)
		{
			numbers[n]= gen.nextInt(300);
			//System.out.println(numbers[n]);
		}
		MyBinaryHeap<Integer> insert1 = new MyBinaryHeap<>(numbers.length*2);
		insert1.insertOneByOne(numbers);
		int operationCount1 = insert1.opCount();
		
		MyBinaryHeap<Integer> insert2 = new MyBinaryHeap<>(numbers.length*2);
		insert2.insertInBulk(numbers);
		int operationCount2 = insert2.opCount();

		System.out.println("Operation count by 1by1 is "+operationCount1+" and by bulk is "+operationCount2);
		

	}
}
