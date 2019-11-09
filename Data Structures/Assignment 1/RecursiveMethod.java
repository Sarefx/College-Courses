// CSCI 3200 Assignment 1.5

import java.util.Scanner;

public class RecursiveMethod
{
	static int onesCount=0;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		//int userNum;
		int userNum=512;
		//System.out.println("Enter Integer");
		//userNum = scan.nextInt();
        System.out.println("The final number of ones " + recursiveMethod(userNum));
	}
	public static int recursiveMethod(int num)
	{
		int divider=1;
		return recursiveMethodHelper(num, divider);
	}
	public static int recursiveMethodHelper(int num, int divider)
	{
		System.out.println("system entered recursive method and num is "+num+" and divider is "+divider);
		if (num >0 && (num/divider) != 1 && num>divider)
		{
			divider *= 2;
			System.out.println("New divider is "+divider);
			recursiveMethodHelper(num, divider);
		}
		else if (num>0)
		{
			if (divider<=num)
			{
				onesCount++;
				System.out.println("New count of ones is "+onesCount);
				num = num % divider;
			}
			if (divider != 1)
			divider = divider / 2;
			recursiveMethodHelper(num, divider);
		}
		System.out.println("System shouldnt enter this stage");
		return onesCount;
	}
	
	
}
