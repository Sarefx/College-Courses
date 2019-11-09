import java.util.Arrays;

public class MyArrayList<E> {
	private E[] arr;
	private int size;

	public String toString()
	{
		return Arrays.toString(arr);
	}
	public MyArrayList()
	{
		size = 0;
		arr = (E[])new Object[10];
	}
	public MyArrayList(int s)
	{
		if(s < 1)
			s = 10;
		size = 0;
		arr = (E[])new Object[s];
	}

	public void printList()//O(N)
	{
		for(int i = 0; i < size; i++)
		{
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
	public void insert(E v, int index)//O(N-index) - move everything after the index we want to use
	{
		if(size == arr.length)
			growArray();
		for(int i = size-1; i >= index; i--)
		{
			arr[i+1] = arr[i];
		}
		arr[index] = v;
		size++;
	}
	public void add(E v)//O(1) OR O(N) if full - O(1) on average
	{
		if(size == arr.length)
			growArray();
		arr[size] = v;
		size++;
	}
	public E remove(E v)//O(N)
	{
		for(int i = 0; i < size; i++)//move to value
		{
			if(arr[i].equals(v))
			{
				E temp = arr[i];
				for(int j = i; j < size-1; j++)//move through rest of array
				{
					arr[j] = arr[j+1];
				}
				size--;
				return temp;
			}
		}
		return null;
	}
	public E delete(int i)//O(N-index)
	{
		if(size > i)//position exists
		{
			for(; i < size; i++)
			{
				arr[i] = arr[i+1];
			}
			size--;
		}
		return null;
	}
	public E find(E v)//O(N)
	{
		for(int i = 0; i < size; i++)
		{
			if(arr[i].equals(v))
				return arr[i];
		}
		return null;
	}
	public E get(int i)//O(1)
	{
		if(size > i)//position exists
			return arr[i];
		else
			return null;
	}
	private void growArray(int newSize)//O(N)
	{
		if(newSize <= size)
			newSize = size*2;
		E[] newArr = (E[])new Object[newSize];
		for(int i = 0; i < arr.length; i++)
			newArr[i] = arr[i];
		arr = newArr;
	}
	private void growArray()
	{
		growArray(arr.length * 2);//O(N)
	}
}
