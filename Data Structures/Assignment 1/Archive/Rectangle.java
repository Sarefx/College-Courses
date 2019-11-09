// CSCI 3200 Assignment 1.15

public class Rectangle
{
	private int width=0, length=0, area, perimeter;

	public Rectangle(int wid, int leng) 
	{
		width=wid;
		length=leng;
		area=wid*leng;
		perimeter=(wid+leng)*2;
	}
	public int getLength()	{
		return width;	}
	public int getWidth()	{
		return length;	}
	public int getArea()	{
		return area;	}
	public int getPerimeter()	{
		return perimeter;	}
	public String toString()	{
		String result=("width "+width+"; length "+length+"; area "+area+"; perimeter "+perimeter);
		return result;	}
}