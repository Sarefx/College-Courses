public class MySingleLinkedList<E> {
	private MyNode<E> start;
	private int size;

	public MySingleLinkedList() {
		start = null;
		size = 0;
	}

	public MySingleLinkedList(E v) {
		start = null;
		size = 0;
		this.add(v);
	}

	//////////// My Methods Start ////////////
	public void swap(E a, E b) {
		MyNode<E> currentA = start;
		MyNode<E> previousA = null;
		MyNode<E> currentB = start;
		MyNode<E> previousB = null;
		MyNode<E> temp = null;

		while (currentA != null && !currentA.val.equals(a)) {
			previousA = currentA;
			currentA = currentA.next;
		}
		while (currentB != null && !currentB.val.equals(b)) {
			previousB = currentB;
			currentB = currentB.next;
		}
		// System.out.println("First: current value is "+currentA+" and previous is
		// "+previousA+". Second: current value is "+currentB+" and previous is
		// "+previousB);
		if (currentA != null || currentB != null) {
			if (previousA != null)
				previousA.next = currentB;
			else
				start = currentB;
			if (previousB != null)
				previousB.next = currentA;
			else
				start = currentA;

			temp = currentA.next;
			currentA.next = currentB.next;
			currentB.next = temp;
		}
	}

	public void firstToEnd() {
		insert(this.get(0), this.size);
		this.delete(0);
	}

	public int getSize() {
		return size;
	}

	//////////// My Methods End ////////////
	public void printList() {
		MyNode<E> current = start;
		while (current != null) {
			System.out.print(current + ",");
			current = current.next;
		}
		System.out.println();
	}

	public void add(E v) {
		MyNode<E> temp = new MyNode<>(v);
		if (start == null) {
			start = temp;
		} else {
			MyNode<E> current = start;
			// run until finding the end of the list
			while (current.next != null) {
				current = current.next;
			}
			// current is now the end of the list
			current.next = temp;
		}
		size++;
	}

	public void insert(E v, int i) {
		if (i < 0)
			i = 0;
		if (i >= size)
			add(v);
		else {
			MyNode<E> temp = new MyNode<>(v);
			if (i == 0) {
				temp.next = start;
				start = temp;
			} else {
				MyNode<E> current = start;
				// run until finding the end of the list
				for (; i > 1; i--) {
					current = current.next;
				}
				// current is now the item before we want to insert
				temp.next = current.next;
				current.next = temp;
			}
		}
	}

	public E find(E v) {
		MyNode<E> current = start;
		while (current != null && !current.val.equals(v)) {
			current = current.next;
		}

		if (current != null)
			return current.val;
		else
			return null;
	}

	public E get(int i) {
		if (i < 0)
			i = 0;
		if (i > size - 1)
			i = size - 1;
		MyNode<E> current = start;
		for (; i > 0; i--) {
			current = current.next;
		}
		if (current != null)
			return current.val;
		else
			return null;
	}

	public E remove(E v) {
		MyNode<E> current = start;
		if (start != null && start.val.equals(v)) {
			start = start.next;
			size--;
			return current.val;
		}
		while (current.next != null && !current.next.val.equals(v)) {
			current = current.next;
		}
		if (current.next != null) {
			current.next = current.next.next;
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
			size--;
			return current.val;
		}
		for (; i > 1; i--) {
			current = current.next;
		}
		if (current != null) {
			current.next = current.next.next;
			size--;
			return current.val;
		} else
			return null;
	}

	private class MyNode<E> {
		public E val;
		public MyNode<E> next;

		public MyNode(E v) {
			val = v;
			next = null;
		}

		public String toString() {
			return val.toString();
		}
	}
}
