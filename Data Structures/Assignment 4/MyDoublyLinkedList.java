public class MyDoublyLinkedList<E> // Assignment 3.2
{
	private MyNode<E> start, end;
	private int size;
	private int numOfDeleted;

	public MyDoublyLinkedList() {
		start = null;
		end = null;
		size = 0;
		numOfDeleted = 0;
	}

	public MyDoublyLinkedList(E v) {
		start = null;
		end = null;
		size = 0;
		numOfDeleted = 0;
		this.add(v);
	}

	/////////////// My Methods Start ///////////////
	public void swap(E a, E b) {
		MyNode<E> curA = start;
		while (curA != null && !curA.val.equals(a)) {
			curA = curA.next;
		}
		MyNode<E> curB = start;
		while (curB != null && !curB.val.equals(b)) {
			curB = curB.next;
		}
		/*
		 * start: 1 <-> A <-> 2 <-> 3 <-> B <-> 4 end: 1 <-> B <-> 2 <-> 3 <-> A <-> 4
		 * Changing pointers A: 1: 3 <- A 2: A -> 4 3: 3 -> A 4: A <- 4 B: 1: 1 <- B 2:
		 * B -> 2 3: 1 -> B 4: B <- 2
		 * start: A <-> 1 <-> 2 <-> B end: B <-> 1 <-> 2 <-> A
		 * Changing pointers A: 1: 2 <- A 2: A -> null 3: 2 -> A B: 1: null <- B 2: B ->
		 * 1 3: B <- 1
		 */
		MyNode<E> tempAprev = curA.prev;
		MyNode<E> tempAnext = curA.next;
		MyNode<E> tempBprev = curB.prev;
		MyNode<E> tempBnext = curB.next;
		/// System.out.println(curA+": previous is "+curA.prev+", next is "+curA.next+".
		/// "+curB+": previous is "+curB.prev+" next is "+curB.next);
		// System.out.println("tempAprev = "+tempAprev+"; tempAnext = "+tempAnext+";
		/// tempBprev = "+tempBprev+"; tempBnext = "+tempBnext);
		if (tempBprev == null) {
			curA.prev = tempBprev; // 2 <- A
			curA.next = tempBnext; // A -> null
			tempBnext.prev = curA;
		} else if (tempBnext == null) {
			curA.prev = tempBprev; // 2 <- A
			curA.next = tempBnext; // A -> null
			tempBprev.next = curA; // 2 -> A
		} else {
			curA.prev = tempBprev; // 3 <- A
			curA.next = tempBnext; // A -> 4
			tempBnext.prev = curA; // A <- 4
			tempBprev.next = curA; // 3 -> A
		}
		// System.out.println("curA.prev is "+curA.prev+" curB.prev.next is
		// "+curB.prev.next+", curA.next is "+curA.next+", curB.next.prev is
		// "+curB.next.prev);
		if (tempAprev == null) {
			curB.prev = tempAprev;
			curB.next = tempAnext; // B -> 1
			tempAnext.prev = curB; // B <- 1
		} else if (tempAnext == null) {
			curB.prev = tempAprev; // 2 <- A
			curB.next = tempAnext; // A -> null
			tempAprev.next = curB; // 2 -> A
		} else {
			curB.prev = tempAprev; // 1 <- B
			curB.next = tempAnext; // B -> 2
			tempAnext.prev = curB; // B <- 2
			tempAprev.next = curB; // 1 -> B
		}
		if (curB.prev == null)
			start = curB;
		else if (curA.prev == null)
			start = curA;

		if (curB.next == null)
			end = curB;
		else if (curA.next == null)
			end = curA;
	}
	public boolean markDeleted(E itemToBeDeleted) {
		MyNode<E> lazyDeletedNode = start;
		while (lazyDeletedNode != null && !lazyDeletedNode.val.equals(itemToBeDeleted)) {
			lazyDeletedNode = lazyDeletedNode.next;
		}
		lazyDeletedNode.deleted = true;
		numOfDeleted++; // working correctly
		lazyDeletion();
		return lazyDeletedNode.deleted;
		/*MyNode<E> temp = new MyNode<>(this.get(i));
		System.out.println("System is attempting to delete item at " + temp);
		temp.deleted = true;
		System.out.println("System set deleted value to " + temp.deleted);
		MyNode<E> temp2 = new MyNode<>(this.get(i));
		System.out.println("CHECK AGAIN: System set deleted value to " + temp2.deleted);
		numOfDeleted++;
		lazyDeletion();*/
	}
	public boolean checkDeleted(E itemToBeDeleted) {
		MyNode<E> lazyDeletedNode = start;
		while (lazyDeletedNode != null && !lazyDeletedNode.val.equals(itemToBeDeleted)) {
			lazyDeletedNode = lazyDeletedNode.next;
		}
		return lazyDeletedNode.deleted;
	}

	private void lazyDeletion() 
	{
		if (numOfDeleted > (size / 2)) // working correctly
		{
			MyNode<E> tempNode = start;
			while (tempNode != null)
			{
				if (!tempNode.deleted)
				{
					//System.out.println("System is looking at "+tempNode+" and its deleted value is "+tempNode.deleted+" so the system wont delete it");
				}
				else if (tempNode.deleted)
				{
					//System.out.println("System is looking at "+tempNode+" and its deleted value is "+tempNode.deleted);
					this.remove(tempNode.val);
				}
				tempNode = tempNode.next;
			}
		}
	}

	/////////////// My Methods End ///////////////
	public void printList()   // Lazy deletion implemented
	{
		MyNode<E> current = start;
		while (current != null) 
		{
			if (!current.deleted)    // Lazy deletion implemented
			{
			System.out.print(current + ",");
			}
			current = current.next;
			
		}
		System.out.println();
	}

	public void printListRev() {
		MyNode<E> current = end;
		while (current != null) {
			System.out.print(current + ",");
			current = current.prev;
		}
		System.out.println();
	}

	public void add(E v) {
		MyNode<E> temp = new MyNode<>(v);
		if (start == null) {
			start = temp;
			end = start;
		} else {
			end.next = temp;
			temp.prev = end;
			end = end.next;
		}
		size++;
	}

	public void insert(E v, int i) {
		if (i < 0)
			i = 0;
		if (i >= size)
			add(v);// O(1)
		else {
			MyNode<E> temp = new MyNode<>(v);
			if (i == 0) {
				temp.next = start;
				start.prev = temp;
				start = temp;
			} 
			else
			{
				/* possibly place to start near end might be faster */
				MyNode<E> current = start;
				// run until finding the end of the list
				for (; i > 1; i--) {
					current = current.next;
				}
				// current is now the item before we want to insert
				temp.next = current.next;
				temp.prev = current;
				current.next.prev = temp;
				current.next = temp;
			}
		}
	}

	public E find(E v) {
		MyNode<E> current = start;
		while (current != null && !current.val.equals(v) && !current.deleted) // Lazy deletion implemented
		{
			current = current.next;
		}
		if (current != null && !current.deleted )  // Lazy deletion implemented
			return current.val;
		else
			return null;
	}

	public E get(int i) {
		if (i < 0)
			i = 0;
		if (i > size - 1)
			i = size - 1;
		/* possibly place to start near end might be faster */
		MyNode<E> current = start;
		for (; i > 0; i--) {
			current = current.next;
		}
		if (current != null && !current.deleted) // Lazy deletion implemented
			return current.val;
		else
			return null;
	}

	public E remove(E v) {
		MyNode<E> current = start;
		if (start != null && start.val.equals(v)) {
			start = start.next;
			if (start != null)
				start.prev = null;
			size--;
			return current.val;
		}
		if (end != null && end.val.equals(v)) {
			current = end;
			end = end.prev;
			if (end != null)
				end.next = null;
			size--;
			return current.val;
		}
		while (current != null && !current.val.equals(v)) {
			current = current.next;
		}
		if (current != null) {
			current.prev.next = current.next;
			current.next.prev = current.prev;
			size--;
			return current.val;
		} else
			return null;
	}

	public E delete(int i) {
		if (i < 0)
			i = 0;
		if (i > size - 1)
			i = size - 1;
		MyNode<E> current = start;
		if (start != null && i == 0) {
			start = start.next;
			if (start != null)
				start.prev = null;
			size--;
			return current.val;
		}
		if (end != null && i == size - 1) {
			current = end;
			end = end.prev;
			if (end != null)
				end.next = null;
			size--;
			return current.val;
		}
		/* possibly place to start near end might be faster */
		for (; i > 1; i--) {
			current = current.next;
		}
		if (current != null) {
			current.next = current.next.next;
			current.next.prev = current;
			size--;
			return current.val;
		}
		else
			return null;
	}

	private class MyNode<E> {
		public boolean deleted;
		public E val;
		public MyNode<E> next, prev;

		public MyNode(E v) {
			val = v;
			next = null;
			prev = null;
			deleted = false;
		}

		public String toString() {
			return val.toString();
		}
	}
}
