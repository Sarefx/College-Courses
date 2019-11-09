public class ADTTester 
{
	public static void main(String[] args) 
	{
		
		MyDoublyLinkedList<String> list4 = new MyDoublyLinkedList<>();
		list4.add("1");
		list4.add("A");
		list4.add("2");
		list4.add("3");
		list4.add("B");
		list4.add("4");
		list4.printList();
		System.out.println(list4.markDeleted("4"));
		System.out.println(list4.markDeleted("A"));
		System.out.println(list4.markDeleted("3"));

		list4.printList();
		
		//System.out.println(list4.checkDeleted("A"));

		//list4.swap("A", "B");
		//list4.markDeleted(0);
		//list4.markDeleted(1);
		//list4.markDeleted(2);
		//list4.printList();
		
		MyQueue<String> list5=new MyQueue<>();
		list5.enQueue("Test1");
		list5.enQueue("Test2");
		list5.enQueue("Test3");
		list5.printList();
		list5.deQueue();
		list5.deQueue();
		list5.printList();
		list5.enQueue("Test4");
		list5.enQueue("Test5");
		list5.enQueue("Test6");
		list5.enQueue("Test7");
		list5.printList();
		list5.deQueue();
		list5.deQueue();
		list5.printList();
		list5.deQueue();
		list5.deQueue();
		list5.printList();
		list5.deQueue();
		list5.printList();
		
		
		//list4.printList();
		//list4.printListRev();
		//list4.remove("Test4");
		//list4.printList();
		//list4.printListRev();
		//list4.delete(4);
		//list4.printList();
		//list4.printListRev();
		//System.out.println(list4.findPosition("Test1"));
		 
		/*
		MySingleLinkedList<String> list3 = new MySingleLinkedList<>();
		list3.add("Test1");
		list3.add("Test2");
		list3.add("Test3");
		list3.insert("Test4", 3);
		list3.printList();
		list3.swap("Test4", "Test1");
		list3.printList();
		//list3.remove("Test4");
		//list3.printList();
		//list3.delete(0);
		//list3.printList();
		
		
		MyStack<String> list2 = new MyStack<>();
		list2.push("Test1");
		list2.push("Test2");
		list2.push("Test3");
		list2.push("Test4");
		System.out.println(list2.pop());
		System.out.println(list2.top());
		System.out.println(list2.top());
		/*
		MyArrayList<Integer> list1 = new MyArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.insert(4, 1);
		list1.add(5);
		list1.add(6);
		list1.add(7);
		list1.add(8);
		list1.add(9);
		list1.add(10);
		System.out.println(list1);
		list1.add(11);//array is full, have to grow before add
		System.out.println(list1);
		list1.remove(4);
		System.out.println(list1);
		list1.delete(4);
		System.out.println(list1);
		list1.printList();
		*/
	}
}