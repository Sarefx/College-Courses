import java.math.BigInteger;
import java.util.LinkedList;

public class SeparateChainingHashTable2<E> {
	private int size;
	private LinkedList<E>[] table;
	private int count;
	private double load;
	public SeparateChainingHashTable2(int size, double load) {
		super();
		this.size = nextPrime(size);
		count = 0;
		this.load = load;
		this.makeEmpty();
	}
	public SeparateChainingHashTable2(int size) {
		super();
		this.size = nextPrime(size);
		count = 0;
		load = 0.5;
		this.makeEmpty();
	}
	public SeparateChainingHashTable2() {
		super();
		count = 0;
		load = 0.5;
		this.size = 5;
		this.makeEmpty();
	}
	public void makeEmpty()
	{
		table = new LinkedList[size];
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new LinkedList<E>();
		}
		count = 0;
	}
	public void insert(E obj)
	{
		int tablePos = myHash(obj);
		if(!table[tablePos].contains(obj))
		{
			table[tablePos].add(obj);
			count++;
		}
		if(count >= load*size)//number of items is to large, rehash
		{
			rehash();
		}
	}
	private void rehash()
	{
		//System.out.println("Before Rehash");
		//this.printTable();
		LinkedList<E>[] temp = table;//existing data
		size = nextPrime(size*2);
		//table = new LinkedList[size];//done inside of makeEmpty();
		makeEmpty();
		for(LinkedList<E> arrayElement : temp)
		{
			for(E data : arrayElement)
			{
				insert(data);
			}
		}
	}
	public boolean delete(E obj)
	{
		int tablePos = myHash(obj);
		if(table[tablePos].contains(obj))
		{
			table[tablePos].remove(obj);
			count--;
			return true;
		}
		return false;
	}
	public E search(E obj)
	{
		int tablePos = myHash(obj);
		if(table[tablePos].contains(obj))
		{
			return table[tablePos].get(table[tablePos].indexOf(obj));
		}
		return null;
	}
	public boolean contains(E obj)
	{
		int tablePos = myHash(obj);
		if(table[tablePos].contains(obj))
		{
			return true;
		}
		return false;
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
