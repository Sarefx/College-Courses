import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment_2_27
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int N=3, num = 5;
		System.out.println("Please enter integer for the size of matrix");
		N=scan.nextInt();
		System.out.println("Please enter integer to find");
		num=scan.nextInt();
		
		int[][] intArr = new int[N][N];
		
		int arrNum=1;
		for (int row=0; row<N; row++)
		{
			for (int col1=0; col1<N; col1++)
			{
				intArr[row][col1]=arrNum;
				System.out.print(intArr[row][col1]+" ");
				arrNum++;
			}
			System.out.println();
		}
		
		int row=0;
		while (row<N) //System.out.println("System is comparing "+num+" to "+intArr[row][N-1]);
		{
			if (num<=intArr[row][N-1]) //System.out.println(num+" is smaller than "+intArr[row][N-1]+" so the system is scanning the row");
			{
				int col=0;
				while(col < N)
				{
					if (num==intArr[row][col])
					{
						System.out.println("The number is in the matrix");
						break;
					}
					else //System.out.println("The number is NOT in the cell, so system is going to next cell");
					{
						col++;
					}
					if (col==N)
					{
						System.out.println("The number is NOT in the matrix");
						break;
					}
				}
				break;
			}
			else
				row++;
			if (row==N)
			{
				System.out.println("The number is NOT in the matrix");
				break;
			}
		}
	}
}