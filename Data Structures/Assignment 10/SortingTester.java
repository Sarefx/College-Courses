import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTester {

	public static void main(String[] args) {
		Integer[] a1 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		Integer[] a2 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		Integer[] a3 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		Integer[] a4 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		Integer[] a5 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		Integer[] a6 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		System.out.println("Unsorted:         " + Arrays.toString(a1) + "\n\n");
		insertSort(a1);//O(I+N), I is 0 to N^2
		System.out.println("Insertion Sorted: " + Arrays.toString(a1) + "\n\n");
		shellSort(a2);//O(N^3/2)
		System.out.println("Shell Sorted:     " + Arrays.toString(a2) + "\n\n");
		MyBinaryHeap<Integer> heap = new MyBinaryHeap<>(a3);
		int c = 0;
		while(!heap.isEmpty())//O(N*logN)
		{
			a3[c] = heap.deleteMin();//O(logN)
			c++;
		}
		System.out.println("Binary Heap Sorted:     " + Arrays.toString(a3) + "\n\n");
		mergeSort(a4);//O(N logN)
		System.out.println("Merge Sorted:     " + Arrays.toString(a4) + "\n\n");
		quickSort(a5);//O(N logN)
		System.out.println("Quick Sorted:     " + Arrays.toString(a5) + "\n\n");
		bucketSort(a6, 0, 100);//O(N+M)
		System.out.println("Bucket Sorted:    " + Arrays.toString(a6) + "\n\n");

		String[] words = new String[]{"jgrh", "ahdffhdhfdhdbe","dddb", "ddda", "fasfag"};
		//radixSortStrings(words, 3);
		radixSortStrings(words);
		System.out.println("Final:"+Arrays.toString(words));
	}
	public static void insertSort(Integer[] arr)
	{
		int hole = 0;
		int moveCount = 0;
		for(int position = 1; position < arr.length; position++)
		{
			Integer temp = arr[position];
			for(hole = position; hole > 0 && temp.compareTo(arr[hole-1]) < 0;hole--)
			{
				arr[hole] = arr[hole-1];//move number one space over
				moveCount++;
			}
			arr[hole] = temp;
		}
		System.out.println("Move Count:" + moveCount);
	}
	public static void shellSort(Integer[] arr)
	{
		//sort a shell at a time
		int hole;
		int moveCount = 0;
		//N/2 shells
		for(int sequence = arr.length/2; sequence > 0; sequence /= 2)
		{
			System.out.println("Shell:" + sequence);
			for(int i = sequence; i < arr.length; i++)//loop for each sub-list
			{
				Integer temp = arr[i];
				for(hole = i; hole >= sequence &&
						temp.compareTo(arr[hole-sequence]) < 0; hole -= sequence)
				{
					arr[hole] = arr[hole-sequence];
					moveCount++;
				}
				arr[hole] = temp;
			}
		}
		System.out.println("Shellsort Move Count:" + moveCount);
	}
	public static void mergeSort(Integer[] arr)
	{
		//call mergeSort(arr, temp[], 0, length-1)
		mergeSort(arr, new Integer[arr.length], 0, arr.length-1);
	}
	public static void mergeSort(Integer[] arr, Integer[] temp, int left, int right)
	{
		//if left < right
		if(left < right)
		{
			//find center
			int center = (left+right)/2;
			//call mergeSort on left half (left,center)
			mergeSort(arr, temp, left, center);
			//call mergeSort on right half (center+1,right)
			mergeSort(arr, temp, center+1, right);
			//call merge over left/right halves
			merge(arr, temp, left, center+1, right);
			//System.out.println(Arrays.toString(arr));
		}
	}
	public static void merge(Integer[] arr, Integer[] temp, int leftStart, int rightStart, int rightEnd)
	{
		//determine leftEnd
		int leftEnd = rightStart-1;
		//set temp array position (same as left start)
		int tempPos = leftStart;
		//determine number of elements (end - start + 1)
		int count = rightEnd - leftStart + 1;
		//while items left in both lists
		while(leftStart <= leftEnd && rightStart <= rightEnd)
		{
			//put smaller into temp array, move pointers forward
			if(arr[leftStart] < arr[rightStart])
			{
				temp[tempPos] = arr[leftStart];
				leftStart++;
				tempPos++;
			}
			else
			{
				temp[tempPos] = arr[rightStart];
				rightStart++;
				tempPos++;
			}
		}
		//while items left in either list
		while(leftStart <= leftEnd)
		{
			//add left over items to end of temp array
			temp[tempPos] = arr[leftStart];
			leftStart++;
			tempPos++;
		}
		while(rightStart <= rightEnd)
		{
			//add left over items to end of temp array
			temp[tempPos] = arr[rightStart];
			rightStart++;
			tempPos++;
		}
		//merge temp data to original using number of items and rightEnd
		for(int i = 0; i < count; i++)
		{
			arr[rightEnd] = temp[rightEnd];
			rightEnd--;
		}
	}
	public static void quickSort(Integer[] arr)
	{
		//convert array to list for processing
		List<Integer> temp = Arrays.asList(arr);
		quickSort(temp);
	}
	public static void quickSort(List<Integer> list)
	{
		//if list has more than 1 item
		if(list.size() > 1)
		{
			//create 3 lists (smaller, same, larger)
			List<Integer> smaller = new ArrayList<>();
			List<Integer> same = new ArrayList<>();
			List<Integer> larger = new ArrayList<>();

			//pick item for middle
			Integer middle = list.get(0);

			//loop through list putting items into correct containers
			for(int i = 0; i < list.size(); i++)
			{
				if(list.get(i) > middle)
				{
					larger.add(list.get(i));
				}
				else if(list.get(i) < middle)
				{
					smaller.add(list.get(i));
				}
				else
					same.add(list.get(i));
			}

			//recursively sort smaller/larger
			quickSort(larger);
			quickSort(smaller);

			//put all items into original list [.clear(), .addAll()]
			int pos = 0;
			for(int i = 0; i < smaller.size(); i++)
			{
				list.set(pos, smaller.get(i));
				pos++;
			}
			for(int i = 0; i < same.size(); i++)
			{
				list.set(pos, same.get(i));
				pos++;
			}
			for(int i = 0; i < larger.size(); i++)
			{
				list.set(pos, larger.get(i));
				pos++;
			}

			/*
			list.clear();
			list.addAll(smaller);
			list.addAll(same);
			list.addAll(larger);
			*/
		}
	}
	public static void bucketSort(Integer[] arr, int min, int max)
	{
		//determine number of buckets from min/max
		int maxBuckets = max - min+1;
		//create buckets for entire range
		int[] buckets = new int[maxBuckets];

		//process items into specific buckets (shift if needed)
		for(Integer a : arr)//N
		{
			buckets[a-min]++;
		}

		//put items back into original list in order
		int index = 0;
		for(int b = 0; b < buckets.length; b++)//M
		{
			for(int i = 0; i < buckets[b]; i++)
			{
				arr[index] = b+min;//shift back to correct value
				index++;
			}
		}
	}
	public static void radixSortStrings(String[] arr)
	{
		//number of buckets = 256 (characters in the character set)
		int buckets = 256;
		//if you were doing a case insensitive sort, and you knew everything was single words, you could use 26 as your size

		//Buckets need to be lists instead of counters
		ArrayList<String>[] bucket = new ArrayList[buckets];
		//create array of lists and initialize each object
		for(int i = 0; i < buckets; i++)
		{
			bucket[i] = new ArrayList<>();
		}
		//pointer for position in original list
		int index = 0;
		int maxLength=0;
		
		for (int k=0; k < arr.length ; k++)
		{
			if (arr[k].length()>maxLength)
			{
				maxLength = arr[k].length();
			}
		}
		System.out.println("Max length string was "+maxLength);
		//loop from end of string to beginning
		for(int i = maxLength-1; i >= 0; i--)
		{
			System.out.println("\nString Postion:"+i);
			//loop through each string
			System.out.println("System enters first loop");
			for(int j = 0; j < arr.length; j++)
			{
				//add to appropriate bucket
				if (arr[j].length() > i)
				{
					int something = (int)arr[j].charAt(i);
					bucket[something].add(arr[j]);
				}
				else
				{
					bucket[0].add(arr[j]);
				}
			}
			//loop through buckets
			System.out.println("System enters second loop");
			for(int j = 0; j < bucket.length; j++)
			{
				if(bucket[j].size() > 0)
					System.out.println(j+":"+bucket[j].toString());
				//add each string back to original array in new order
				for(String s : bucket[j])
				{
					arr[index] = s;
					index++;
				}
				//clear the bucket
				bucket[j].clear();
			}
			index = 0;
		}
	}



}
