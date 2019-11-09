import java.util.Scanner;

public class JosephusProblem
{
	public static void main(String[] args) 
	{
		MySingleLinkedList<String> players = new MySingleLinkedList<>();
		int N, M;
		Scanner scan=new Scanner (System.in);
		
		System.out.println("Please enter the value for N(number of players)");
		N = scan.nextInt();
		System.out.println("Please enter the value for M(number of turns)");
		M = scan.nextInt();
		
		for (int b=0; b<N; b++)
			players.add("Player"+(b+1));
		
		//players.printList();
		while (players.getSize()>1) // getSize method was added to MySingleLinkedlist
		{
			System.out.println(players.get(M)+" is getting eliminated");
			players.delete(M);
			for (int i=0;i<M;i++)
				players.firstToEnd(); // firstToEnd method was added to MySingleLinkedlist
		}
		System.out.println(players.get(M)+" is a winner");
	}
}
