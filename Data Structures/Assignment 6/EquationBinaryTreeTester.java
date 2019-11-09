import java.util.Scanner;

public class EquationBinaryTreeTester {

	public static void main(String[] args) {
/*		EquationBinaryTree tree = new EquationBinaryTree();
		tree.populateFromInfix("((a+(b*c))+(((d*e)+f)*g))");
		System.out.println(tree.toInfix());
		System.out.println(tree.toPostfix());
		System.out.println(tree.toPrefix());
		
		EquationBinaryTree tree1 = new EquationBinaryTree();
		tree1.populateFromPrefix("++a*bc*+*defg");
		System.out.println(tree1.toInfix());
		System.out.println(tree1.toPostfix());
		System.out.println(tree1.toPrefix());
		
		EquationBinaryTree tree2 = new EquationBinaryTree();
		tree2.populateFromPostfix("abc*+de*f+g*+");
		System.out.println(tree2.toInfix());
		System.out.println(tree2.toPostfix());
		System.out.println(tree2.toPrefix());*/
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the equation you want to convert");
		String equation = scan.nextLine();
		System.out.println("Please enter integer for the conversation type: 1 for FromInfix, 2 for FromPostfix, 3 for FromPrefix");
		int conversationType = scan.nextInt();
		EquationBinaryTree tree3 = new EquationBinaryTree();
		switch(conversationType)
		{
		case 1:
			tree3.populateFromInfix(equation);
			break;
		case 2:
			tree3.populateFromPostfix(equation);
			break;
		case 3:
			tree3.populateFromPrefix(equation);
			break;
		}
		System.out.println(tree3.toInfix());
		System.out.println(tree3.toPostfix());
		System.out.println(tree3.toPrefix());
	}

}
