public class MyStack<E> {
	private MyNode<E> top;
	private int size;
	public MyStack()
	{
		top = null;
		size = 0;
	}
	public E top()
	{
		if(top != null)
			return top.val;
		return null;
	}
	public E peek()
	{
		return this.top();
	}
	public void push(E v)
	{
		MyNode<E> temp = new MyNode<>(v);
		temp.next = top;
		top = temp;
		size++;
	}
	public E pop()
	{
		if(top != null)
		{
			MyNode<E> temp = top;
			top = top.next;
			return temp.val;
		}
		return null;
	}

	private class MyNode<E>{
		public E val;
		public MyNode<E> next;
		public MyNode(E v)
		{
			val = v;
			next = null;
		}
		public String toString()
		{
			return val.toString();
		}
	}

}
