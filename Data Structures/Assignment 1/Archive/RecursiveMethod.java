// CSCI 3200 Assignment 1.5

import java.util.Scanner;

public class RecursiveMethod
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int userNum, onesCount=0, result=0, result1=0, divider=1;
		
		System.out.println("Enter Integer");
		userNum = scan.nextInt();

        while (result !=1)
        {
        	divider = divider * 2;
        	result= userNum / divider;
        }
        //System.out.println("Divider is " + divider);
        	
        while (userNum>0)
        {
        	//System.out.print("Usernum " + userNum + " is divided by " + divider);
        	userNum %= divider;
        	//System.out.println(" and remainder " + userNum);
        
            while (result1 !=1 && divider>1)
            {
            	divider/= 2;
            	result1= userNum / divider;
            	//System.out.println("Usernum is "+userNum+" divided by "+divider+" and the result is "+result1);
            }
        	result1=0;
        	onesCount++;
        }
        System.out.println("The final number of ones " + onesCount);
	}
}
