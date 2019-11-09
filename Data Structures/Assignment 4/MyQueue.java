public class MyQueue<E> 
{
	private MyNode<E> first, last;
	private int size;
	
	public MyQueue()
	{
		first = null;
		last = null;
		size = 0;
	}
	public void enQueue(E v)
	{
		MyNode<E> temp = new MyNode<>(v);
		if (last == null)
		{
			first = temp;
			last = first;
		} 
		else 
		{
			temp.next = last;
			last.prev = temp;
			last = temp;
			
		}
		size++;
	}
	public E deQueue()
	{
		MyNode<E> current = first;
			first = first.prev;
			if (first != null)
				first.next = null;
			size--;			
			if (size == 0)
			{
				first = null;
				last = null;
			}
			return current.val;
	}
	public void printList()
	{
		MyNode<E> current = last;
		while(current != null)
		{
			System.out.print(current+",");
			current = current.next;
		}
		System.out.println();
	}
	private class MyNode<E>{
		public E val;
		public MyNode<E> next, prev;
		public MyNode(E v)
		{
			val = v;
			next = null;
			prev = null;
		}
		public String toString()
		{
			return val.toString();
		}
	}
}