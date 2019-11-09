import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("What is your name:");
		String name = s.nextLine();
		System.out.println("Hello, " + name);
		System.out.println(recursion(5));
	}
	public static int recursion(int x)
	{
		if(x == 0)
			return 0;
		else
		{
			return 2 * recursion(x-1) + (x*x);
		}
	}
}
