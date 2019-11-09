import java.util.Arrays;

import javax.swing.plaf.basic.BasicBorders.RolloverButtonBorder;

public class EquationBinaryTree {
	private EquationBinaryTreeNode root;
	private MyStack<Character> tempStack = new MyStack<>();

	public EquationBinaryTree() {
		root = null;
	}

	/*
	 * Populate from infix ((a+(b*c))+(((d*e)+f)*g))
	 */
	public void populateFromInfix(String inf) {
		root = populateFromInfixHelper(inf);
	}

	private EquationBinaryTreeNode populateFromInfixHelper(String inf) {
		if (inf.length() == 1)
			return new EquationBinaryTreeNode(inf.charAt(0));

		String[] pieces = infixBreakdownHelper(inf);
		EquationBinaryTreeNode temp = new EquationBinaryTreeNode(pieces[1].charAt(0));
		temp.left = populateFromInfixHelper(pieces[0]);
		temp.right = populateFromInfixHelper(pieces[2]);
		return temp;
	}

	private String[] infixBreakdownHelper(String inf) {
		inf = inf.substring(1, inf.length() - 1);// remove outer layer of parens
		int open = 0;
		int pos = 0;
		for (; pos < inf.length(); pos++) {
			if (inf.charAt(pos) == '(')
				open++;
			else if (inf.charAt(pos) == ')')
				open--;
			if (open == 0)
				break;
		}
		pos++;
		return new String[] { inf.substring(0, pos), "" + inf.charAt(pos), inf.substring(pos + 1) };
	}

	/*
	 * Populate from postfix abc*+de*f+g*+
	 */
	public void populateFromPostfix(String post) 
	{
		for (int i = 0; i < post.length(); i++) { // working correctly
			tempStack.push(post.charAt(i));
			// System.out.println(tempStack.peek()+" was pushed to the stack");
		}
		root = new EquationBinaryTreeNode();
		populateFromPostfixHelper(root);
	}

	private EquationBinaryTreeNode populateFromPostfixHelper(EquationBinaryTreeNode tempNode)
	{
		if (tempStack.peek() != null) {
			tempNode.data = tempStack.pop(); // Working correctly
			if (tempNode.data == '+' || tempNode.data == '-' || tempNode.data == '*' || tempNode.data == '/') {
				// System.out.println("System moved down right of "+tempNode);
				tempNode.right = new EquationBinaryTreeNode();
				populateFromPostfixHelper(tempNode.right);
				// System.out.println("System moved down left of "+tempNode);
				tempNode.left = new EquationBinaryTreeNode();
				populateFromPostfixHelper(tempNode.left);
				return tempNode;
			} else if (tempNode.data >= 'a' && tempNode.data <= 'z') {
				// System.out.println("child is "+tempNode);
				return null;
			}
			return null;
		} else
			return null;
	}

	/*
	 * Populate from prefix ++a*bc*+*defg
	 */
	public void populateFromPrefix(String pre)
	{
		for (int i = pre.length(); i > 0; i--) { // working correctly
			tempStack.push(pre.charAt(i - 1));
		}
		root = new EquationBinaryTreeNode();
		populateFromPrefixHelper(root);
	}

	private EquationBinaryTreeNode populateFromPrefixHelper(EquationBinaryTreeNode tempNode)
	{
		// System.out.println("tempStack.peek() is "+tempStack.peek());
		if (tempStack.peek() != null) {
			tempNode.data = tempStack.pop(); // Working correctly
			if (tempNode.data == '+' || tempNode.data == '-' || tempNode.data == '*' || tempNode.data == '/') {
				// System.out.println("System moved down left of "+tempNode);
				tempNode.left = new EquationBinaryTreeNode();
				populateFromPrefixHelper(tempNode.left);
				// System.out.println("System moved down right of "+tempNode);
				tempNode.right = new EquationBinaryTreeNode();
				populateFromPrefixHelper(tempNode.right);
				return tempNode;
			} else if (tempNode.data >= 'a' && tempNode.data <= 'z') {
				// System.out.println("child is "+tempNode);
				return null;
			}
			return null;
		} else
			return null;
	}

	/*
	 * Print Infix ((a+(b*c))+(((d*e)+f)*g))
	 */
	public String toInfix() {
		return toInfixHelper(root);
	}

	private String toInfixHelper(EquationBinaryTreeNode node) {
		String output = "";
		if (node.left != null) {
			output += "(";
			output += toInfixHelper(node.left);
			output += node;
			output += toInfixHelper(node.right);
			output += ")";
		} else
			output += node;
		return output;
	}

	/*
	 * Print Postfix abc*+de*f+g*+
	 */
	public String toPostfix() {
		return toPostfixHelper(root);
	}

	private String toPostfixHelper(EquationBinaryTreeNode node) {
		String output = "";
		if (node.left != null) {
			output += toPostfixHelper(node.left);
			output += toPostfixHelper(node.right);
			output += node;
		} else
			output += node;
		return output;
	}

	/*
	 * Print Prefix ++a*bc*+*defg
	 */
	public String toPrefix() {
		return toPrefixHelper(root);
	}

	private String toPrefixHelper(EquationBinaryTreeNode node) {
		String output = "";
		if (node.left != null) {
			output += node;
			output += toPrefixHelper(node.left);
			output += toPrefixHelper(node.right);
		} else
			output += node;
		return output;
	}

	private class EquationBinaryTreeNode {
		Character data;
		EquationBinaryTreeNode left;
		EquationBinaryTreeNode right;

		public EquationBinaryTreeNode(char d) {
			data = d;
			left = null;
			right = null;
		}
		public EquationBinaryTreeNode() {
			data = null;
			left = null;
			right = null;
		}
		public String toString() {
			return "" + data;
		}
	}
}