public class MyBinaryHeapTester 
{
	public static void main(String[] args) 
	{
		/*MyBinaryHeap<String> heap = new MyBinaryHeap<>();
		heap.insert("A");
		heap.insert("H");
		heap.insert("E");
		heap.insert("D");
		heap.insert("B");
		heap.insert("F");
		heap.insert("C");
		heap.insert("G");
		System.out.println(heap);
		//heap.deleteMin();
		//System.out.println(heap);

		MyBinaryHeap<String> heap2 = new MyBinaryHeap<>(new String[]{"A", "H", "E", "D", "B", "F", "C", "G"});
		System.out.println(heap2);*/
		
		MyBinaryHeap<Integer> heap = new MyBinaryHeap<>();
		heap.insert(10);
		heap.insert(12);
		heap.insert(1);
		heap.insert(14);
		heap.insert(6);
		heap.insert(5);
		heap.insert(8);
		heap.insert(15);
		heap.insert(3);
		heap.insert(9);
		heap.insert(7);
		heap.insert(4);
		heap.insert(11);
		heap.insert(13);
		heap.insert(2);
		heap.deleteMin();
		heap.deleteMin();
		heap.deleteMin();
		System.out.println(heap);

		MyBinaryHeap<Integer> heap2 = new MyBinaryHeap<>(new Integer[]{10,12,1,14,6,5,8,15,3,9,7,4,11,13,2});
		heap2.deleteMin();
		heap2.deleteMin();
		heap2.deleteMin();
		System.out.println(heap2);
		
		MyBinaryHeap<Integer> heap3 = new MyBinaryHeap<>();
		
		Integer[] items = new Integer[]{2,6,8,4,45,8,9,1};
		
		System.out.println(heap3.findKthSmallest(4, items));

	}
}