
public class MyBinaryHeap<E extends Comparable<? super E>> 
{
	private static final int DEFAULT_CAPACITY = 4;
	private int currentSize;
	private E[] heap;
	private int operationCount = 0;//example done for constructor that adds all, need to add to all other methods
	public int opCount()
	{
		return operationCount;
	}
	public String toString()
	{
		String output = "Current Size:"+currentSize+"\n";
		for(int i = 1; i <= currentSize; i++)//heap.length
		{
			output += i+":"+((heap[i]!=null)?heap[i]:"")+"\n";
			/*
			 * same as above
			output += i+":";
			if(heap[i]!=null)
				output += heap[i];
			output += "\n";

			 */

		}
		return output;
	}
	public MyBinaryHeap()
	{
		this(DEFAULT_CAPACITY);
	}
	public MyBinaryHeap(int size)
	{
		currentSize = 0;
		operationCount++; // currentSize assignment
		heap = (E[]) new Comparable[ nextSize(size) ];
		operationCount++; // heap assignment 
	}
	public MyBinaryHeap(E[] items)
	{
		currentSize = items.length;
		operationCount++;
		//create heap with enough space
		heap = (E[]) new Comparable[ nextSize(items.length) ];
		operationCount++;
		//put all items into structure out of order
		operationCount++;//assign i value
		operationCount++;//first comparison
		for(int i = 0; i < items.length; i++)
		{
			heap[i+1] = items[i];
			operationCount += 2;//addition for array index and assignment

			operationCount++;//comparison
			operationCount++;//increment i
		}
		//fix heap structure
		buildHeap();
	}
	public void addAll(E[] items)
	{
		//make room for new items
		if(currentSize+items.length >= heap.length)
		{
			growArray(nextSize(currentSize+items.length));
			operationCount++; // addition
			operationCount++; // comparison
			operationCount++; // addition
		}
		//put all items into structure out of order
		operationCount++; // i assignment
		for(int i = 0; i < items.length; i++)
		{
			heap[currentSize+i+1] = items[i];
			operationCount++; // comparison
			operationCount++; // increment
			operationCount++; // heap assignment
			operationCount++; // addition
		}
		currentSize += items.length;
		operationCount++; // addition
		operationCount++; // currentSize assignment
		//fix heap structure
		buildHeap();
	}
	public void buildHeap()
	{
		//start with lowest parent
		operationCount++; // i assignment
		for(int i = currentSize / 2; i > 0; i--)
		{
			percolateDown(i);
			operationCount += 3; // comparison, decrement, deleteMin
		}
	}
	public boolean isEmpty()
	{
		return (currentSize == 0);
	}
	public void makeEmpty()
	{
		currentSize = 0;
		operationCount++; // currentSize assignment
	}
	private void growArray(int newSize)
	{
		E[] old = heap;
		operationCount++; // old assignment 
		heap = (E []) new Comparable[ newSize ];
		operationCount++; // heap assignment
		operationCount++; // i assignment
        for( int i = 1; i <= currentSize; i++ )
        {
        	operationCount++; // comparison
        	operationCount++; // increment
        	heap[ i ] = old[ i ];
        	operationCount++; // heap assignment
        }
	}
	private void growArray()
	{
		//multiply current length by 2 to allow full level to be added
		this.growArray(heap.length<<1);
		operationCount++; // binary shift
	}
	private int nextSize(int size)
	{
		//finds next size that allows full level to be added
		operationCount++; // binary shift
		operationCount++; // toBinaryString method
		return 1 << Integer.toBinaryString(size).length();
	}
	public void insert(E item)
	{
		//array is currently full, add next depth
		operationCount++; // comparison
		operationCount++; // subtraction
		if( currentSize == heap.length - 1 )
		{
			growArray(heap.length * 2);
			operationCount++; // multiplication
		}

		currentSize++;
		operationCount++; // currentSize increment
		int hole = currentSize;
		operationCount++; // hole assignment
		heap[0] = item;//store item in temporary location
		operationCount++; //heap assignment
		percolateUp(hole);

	}
	private void percolateUp(int pos)
	{
		E item = heap[0];
		operationCount++; // item assignment
		//check if item is smaller than parent
		//pos/2 = parent, 11 and 10 divided by 2 = 5
		for(; item.compareTo(heap[pos/2]) < 0; pos = pos/2)
		{
			operationCount++; // compareTo method
			operationCount++; // division in index of heap
			operationCount++; // comparison
			operationCount++; // pos assignment
			operationCount++; // pos division
			heap[pos] = heap[pos/2];
			operationCount++; // heap assigment
			operationCount++; // pos division
		}
		//put item in final position
		heap[pos] = item;
		operationCount++; // heap assignment
	}
	public E deleteMin()
	{
		operationCount++; // comparison
		if(currentSize == 0)
			return null;
		//smallest item
		E temp = heap[1];
		operationCount++; // temp assignment

		//move last item to the root
		heap[1] = heap[currentSize];
		operationCount++; // heap assignment
		currentSize--;
		operationCount++; // currentSize decrement

		//shift last item down to where it belongs
		percolateDown(1);

		//return smallest item
		return temp;
	}
	private void percolateDown(int pos)
	{
		int child;
		E temp = heap[pos];
		operationCount++; // temp assignment
		//check if there are children
		for(; pos*2 <= currentSize; pos = child)
		{
			child = pos*2;
			operationCount++; // comparison
			operationCount++; // pos assignment
			operationCount++; // pos multiplication
			
			//is there 2 children
			//if there are check if second child is smaller
			if(child != currentSize &&
					heap[child+1].compareTo(heap[child]) < 0)
			{
				operationCount++; // comparison 1
				operationCount++; // comparison 2
				operationCount++; // addition for heap index
				operationCount++; // compareTo method
				child++;
				operationCount++; // child increment
			}
			//smaller child compare to parent
			operationCount++; // comparison
			if(heap[child].compareTo(temp) < 0)
			{
				heap[pos] = heap[child];
				operationCount++; // heap assignment
			}
			else
				break;
		}
		heap[pos] = temp;
		operationCount++; // heap assignment
	}
	public E findMin()
	{
		operationCount++; // comparison
		if(currentSize == 0)
			return null;
		return heap[1];
	}
	public E findKthSmallest(int kth, E[] items)
	{
		currentSize=0;
		operationCount++; // currentSize assignment
		heap = (E[]) new Comparable[ nextSize(items.length) ];
		addAll(items);
		E element=null;
		operationCount++; // E assignment
		operationCount++; // i assignment
		for (int i=0; i<kth; i++)
		{
			element = deleteMin();
			operationCount++; // comparison
			operationCount++; // increment
			operationCount++; // element assignment
		}
		return element;
	}
	public void insertInBulk(E[] items)
	{
		this.addAll(items);
	}
	public void insertOneByOne(E[] items)
	{
		operationCount++; // i assignment
		for (int i=0; i < items.length; i++)
		{
			this.insert(items[i]);
			operationCount++; // comparison
			operationCount++; // increment
		}
	}
}
