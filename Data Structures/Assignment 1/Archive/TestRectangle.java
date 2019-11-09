// CSCI 3200 Assignment 1.15

import java.util.Random;

public class TestRectangle 
{
	public static void main(String[] args)
	{
	Random gen=new Random();
	final int rectNum=100, limitLength=100000;
	Rectangle[] rectList=new Rectangle[rectNum];
	
	for(int i =0; i<rectNum; i++)
			rectList[i]= new Rectangle(gen.nextInt(limitLength)+1, gen.nextInt(limitLength)+1);		
	
	System.out.println("Rectangle at the position "+ComparatorArea.findMax(rectList)+" has the largest Area with an area of "+rectList[ComparatorArea.findMax(rectList)].getArea());
	System.out.println("Rectangle at the position "+ComparatorPerimeter.findMax(rectList)+" has the largest Perimeter with a pertimeter of "+rectList[ComparatorPerimeter.findMax(rectList)].getPerimeter());
	}
}
