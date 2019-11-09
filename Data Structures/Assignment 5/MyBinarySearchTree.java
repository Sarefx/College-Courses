import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree<E extends Comparable<? super E>> 
{
	public static void main(String[] args) 
	{
		MyBinarySearchTree<Integer> t = new MyBinarySearchTree<>();
		MyBinarySearchTree<Integer> b = new MyBinarySearchTree<>();
		t.insert(8);
		t.insert(4);
		t.insert(13);
		t.insert(1);
		t.insert(15);
		
		b.insert(8);
		b.insert(4);
		b.insert(12);
		b.insert(1);
		b.insert(15);
		b.insert(20);
		//t.inOrderPrint();
		//b.inOrderPrint();
		
		System.out.println("2 trees are same: "+b.compareTrees(t));
		t.printEachLevel();
		b.printEachLevel();
		
	/*	t.lazyDeleted(8);
		System.out.println("Max value in the tree is " + t.findMax());
		System.out.println(t.contains(8));
		t.lazyDeleted(1);
		System.out.println("Min value in the tree is " + t.findMin());
		t.inOrderPrint();*/
	}

	private MyTreeNode<E> root;
	private int size; // Its never used
	boolean similar;

	public MyBinarySearchTree()
	{
		root = null;
		size = 0;

	}
	////////////////////// My Methods Start///////////////////////////
	public boolean compareTrees(MyBinarySearchTree<E> tree)
	{
		similar = true;
		return compareTrees(tree.root, root);
	}
	private boolean compareTrees(MyTreeNode<E> curr, MyTreeNode<E> thisCurr) 
	{
		System.out.println("curr is ***"+curr.val+"*** and thisCurr is ***"+thisCurr.val+"***");
		//System.out.println("curr.left is "+curr.left.val+" and thisCurr.left is "+thisCurr.left.val);
		//System.out.println("curr.right is "+curr.right.val+" and thisCurr.right is "+thisCurr.right.val);
		
			
			if (curr.left == null && thisCurr.left != null)
			{
				System.out.println("curr.left is null and thisCurr.left is not null");
				return false;
			}
			if (curr.left != null && thisCurr.left == null)
			{
				System.out.println("curr.left is not null and thisCurr.left is null");
				return false;
			}
			
			if (curr.left == null && thisCurr.left == null)
			{
				System.out.println("curr.left is null and thisCurr.left is null");
				similar =  true;
			}
			if (curr.left != null && thisCurr.left != null)
			{
				System.out.println("System is comparing values on the left");
				similar = compareTrees(curr.left, thisCurr.left);
				System.out.println("Finished comparing values on the left and similar is "+similar);
				if (similar == false)
				{
					System.out.println("Since similar is false system should return false");
					return false;
				}
				else
				{
					
				}
			}
			
			if (curr.right == null && thisCurr.right != null)
			{
				System.out.println("curr.right is null and thisCurr.right is not null");
				return false;
			}
			if (curr.right != null && thisCurr.right == null)
			{
				System.out.println("curr.right is not null and thisCurr.right is null");
				return false;
			}
			
			if (curr.right == null && thisCurr.right == null)
			{
				System.out.println("curr.right is null and thisCurr.right is null");
				similar =  true;
			}
			if (curr.right != null && thisCurr.right != null)
			{
				System.out.println("System is comparing values on the right");
				similar = compareTrees(curr.right, thisCurr.right);
				System.out.println("Finished comparing values on the right and similar is "+similar);
				if (similar == false)
				{
					System.out.println("Since similar is false system should return false");
					return false;
				}
				else
				{
					
				}
			}
			
		System.out.println("The value of similar before return is "+similar);
		return similar;
	}
	public void printEachLevel()
	{
		Queue<MyTreeNode<E>> myQ = new LinkedList<>();
		myQ.add(root);
		System.out.println();
		while (!myQ.isEmpty())
		{
			MyTreeNode<E> tempNode = myQ.remove();
			if (tempNode.left != null)
				myQ.add(tempNode.left);
			if (tempNode.right != null)
				myQ.add(tempNode.right);
			if (tempNode.deleted != true)
				System.out.print(tempNode.val+", ");
		}
	}
	/*public void printEachLevel()
	{
		if (root != null && !root.deleted)
		{
			size(root);
			printLevelOrder(root);
		}
	}
	private void size(MyTreeNode<E> curr)
	{
		size++;
		if (curr.left != null && curr.right != null)
		{
			size(curr.left);
			size(curr.right);
		}
		if (curr.left != null && curr.right == null)
		{
			size(curr.left);
		}
		if (curr.right != null && curr.left == null)
		{
			size(curr.right);
		}
	}
	private void printLevelOrder(MyTreeNode<E> root)
	{
		int h = size;
	    int i;
	    for (i=1; i<=h; i++)
	    {
	        printGivenLevel(root, i);
	        System.out.println();
	    }
	}*/
/*	private void printGivenLevel(MyTreeNode<E> root, int level)
	{
	    if (root == null)
	        return;
	    if (level == 1)
	        System.out.print(root.val+", ");
	    else if (level > 1)
	    {
	        printGivenLevel(root.left, level-1);
	        printGivenLevel(root.right, level-1);
	    }
	}*/
	public void lazyDeleted(E val) 
	{
		lazyDeleted(val, root);
	}
	private void lazyDeleted(E val, MyTreeNode<E> curr)
	{
		if (curr != null)
		{
			// System.out.println("System is comparing current value of "+curr.val+" to the
			// value we are looking for "+val);
			int compare = curr.val.compareTo(val);

			if (compare < 0)
			{
				// System.out.println("System is looking for "+val);
				lazyDeleted(val, curr.right);
			} else if (compare > 0)
			{
				// System.out.println("System is looking for "+val);
				lazyDeleted(val, curr.left);
			} 
			else
			{
				curr.deleted = true;
				// System.out.println("System set "+val+" to "+curr.deleted);
			}
		}
	}
	//////////////////////My Methods End///////////////////////////
	public E contains(E val) 
	{
		return contains(val, root);
	}
	private E contains(E val, MyTreeNode<E> curr) 
	{
		if (curr != null) {
			int compare = curr.val.compareTo(val);
			if (compare < 0) {
				return contains(val, curr.right);
			} else if (compare > 0) {
				return contains(val, curr.left);
			} else if (!curr.deleted) {
				return curr.val;
			}
		}
		System.out.println("System didnt find " + val + " in the tree");
		return null;
	}
	//Modified Method to implement lazy deletion
	public E findMax() 
	{ 
		if (root == null)
			return null;
		return findMax(root).val;
	}
	//Modified Method to implement lazy deletion
	private MyTreeNode<E> findMax(MyTreeNode<E> curr)
	{ 
		if (curr.right != null) {
			// System.out.println(curr.val+" value to the right is "+curr.right.val+" and
			// its Deleted "+curr.right.deleted);
			if (curr.right.deleted) {
				// System.out.println("System is looking for a value to the right and its
				// Deleted");
				if (curr.right.right != null) {
					return findMax(curr.right);
				} else if (curr.right.right == null) {
					return curr;
				}
			} else
				return findMax(curr.right);
		} else {
			// System.out.println("The value is NOT deleted");
			return curr;
		}
		return null;
	}
	//Modified Method to implement lazy deletion
	public E findMin() 
	{ 
		if (root == null)
			return null;
		return findMin(root).val;
	}
	//Modified Method to implement lazy deletion
	private MyTreeNode<E> findMin(MyTreeNode<E> curr) 
	{ 
		if (curr.left != null) {
			// System.out.println(curr.val+" value to the left is "+curr.left.val+" and its
			// Deleted "+curr.left.deleted);
			if (curr.left.deleted) {
				// System.out.println("System is looking for a value to the left and its
				// Deleted");
				if (curr.left.left != null) {
					return findMin(curr.left);
				} else if (curr.left.left == null) {
					return curr;
				}
			} else
				return findMin(curr.left);
		} else {
			// System.out.println("The value is NOT deleted");
			return curr;
		}
		return null;
	}
	public void insert(E val)
	{
		root = insert(val, root);
	}
	private MyTreeNode<E> insert(E val, MyTreeNode<E> curr)
	{
		if (curr == null)
			return new MyTreeNode<E>(val);
		int compare = val.compareTo(curr.val);
		if (compare < 0) {
			curr.left = insert(val, curr.left);
		} else if (compare > 0) {
			curr.right = insert(val, curr.right);
		} else// == 0//update this item
		{
			curr.val = val;
		}
		return curr;
	}
	public void remove(E val) 
	{
		root = remove(val, root);
	}
	private MyTreeNode<E> remove(E val, MyTreeNode<E> curr)
	{
		if (curr == null)// not found
			return curr;

		int comparison = val.compareTo(curr.val);

		if (comparison < 0)// item is smaller than current
		{
			curr.left = remove(val, curr.left);
		} else if (comparison > 0) {
			curr.right = remove(val, curr.right);
		} else if (curr.left != null && curr.right != null)// two children
		{
			curr.val = findMin(curr.right).val;
			curr.right = remove(curr.val, curr.right);
		} else {
			curr = (curr.left != null) ? curr.left : curr.right;
		}
		return curr;
	}
	//Modified Method to implement lazy deletion
	public void inOrderPrint() 
	{ 
		inOrderPrintHelper(root);
		System.out.println();
	}
	//Modified Method to implement lazy deletion
	private void inOrderPrintHelper(MyTreeNode<E> curr) 
	{ 
		if (curr.left != null)
			inOrderPrintHelper(curr.left);
		if (!curr.deleted)
			System.out.print(curr.val + ",");
		if (curr.right != null)
			inOrderPrintHelper(curr.right);
	}
	private class MyTreeNode<E> 
	{
		E val;
		MyTreeNode<E> left, right;
		public boolean deleted;

		public MyTreeNode(E v) {
			val = v;
			left = null;
			right = null;
			deleted = false;
		}
	}
}