import java.math.BigInteger;
import java.util.LinkedList;

public class LinearProbingHashTable<E> {
	private int size;
	private E[] table;
	private int count;
	private double load;
	public LinearProbingHashTable(int size, double load) {
		super();
		this.size = nextPrime(size);
		count = 0;
		if(load <= 1)//prevent infinite loop from being completely full
			this.load = load;
		else
			this.load = 1;
		this.makeEmpty();
	}
	public LinearProbingHashTable() {
		super();
		this.size = 5;
		count = 0;
		this.load = 0.5;
		this.makeEmpty();
	}
	public void insert(E data)
	{
		int tablePos = myHash(data);
		while(table[tablePos] != null)//if table full, infinite
		{
			tablePos++;
			if(tablePos == size)
				tablePos = 0;
		}
		table[tablePos] = data;
		count++;
		if(count >= load*size)//number of items is to large, rehash
		{
			rehash();
		}
	}
	private void rehash()
	{
		//System.out.println("Before Rehash");
		//this.printTable();
		E[] temp = table;//existing data
		size = nextPrime(size*2);
		makeEmpty();
		for(E data : temp)
		{
			insert(data);
		}
	}
	public boolean contains(E data)
	{
		int tablePos = myHash(data);
		while(table[tablePos] != null)//run until finding value or end of cluster
		{
			if(table[tablePos].equals(data))
			{
				return true;
			}
			tablePos++;
			if(tablePos == size)
				tablePos = 0;
		}//ends when we get to end of cluster
		return false;
	}
	public boolean delete(E data)
	{
		int tablePos = myHash(data);
		while(table[tablePos] != null)//run until finding value or end of cluster
		{
			if(table[tablePos].equals(data))
			{
				table[tablePos] = null;
				count--;
				move(tablePos);
				return true;
			}
			tablePos++;
			if(tablePos == size)
				tablePos = 0;
		}//ends when we get to end of cluster
		return false;
	}
	private void move(int pos)
	{
		int temp = pos + 1;
		while(table[temp] != null)
		{
			int tempPos = myHash(table[temp]);
			if(tempPos <= pos)
			{
				table[pos] = table[tempPos];
				table[tempPos] = null;
				move(tempPos);
				break;
			}
		}
	}
	public void makeEmpty()
	{
		table = (E[])new Object[size];
		count = 0;
	}
	public void printTable()
	{
		for(int i = 0; i < table.length; i++)
		{
			System.out.println(i+":"+table[i]);
		}
	}
	private int myHash(E obj)
	{
		return obj.hashCode() % size;
	}
	private int nextPrime(int s)
	{
		BigInteger bi = BigInteger.valueOf(s);
		return bi.nextProbablePrime().intValue();
	}
}
