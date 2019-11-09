import java.math.BigInteger;
import java.util.LinkedList;

public class SeparateChainingHashTable<E> {
	private int size;
	private LinkedList<E>[] table;
	public SeparateChainingHashTable(int size) {
		super();
		this.size = nextPrime(size);
		this.makeEmpty();
	}
	public SeparateChainingHashTable() {
		super();
		this.size = 11;
		this.makeEmpty();
	}
	public void makeEmpty()
	{
		table = new LinkedList[size];
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new LinkedList<E>();
		}
	}
	public void insert(E obj)
	{
		int tablePos = myHash(obj);
		if(!table[tablePos].contains(obj))
			table[tablePos].add(obj);
	}
	public boolean delete(E obj)
	{
		int tablePos = myHash(obj);
		if(table[tablePos].contains(obj))
		{
			table[tablePos].remove(obj);
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
