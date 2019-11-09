import java.util.Collection;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String  name = "";
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		while (!name.equals("stop"))
		{
			System.out.println("Please enter the word to store it in TreeMap, if you want to stop enter 'stop'");
			int vowelsNum = 0;
			name = scan.nextLine();
			if (name.equals("stop")){
				break;	
			}
			for (int i=0; i<name.length();i++){
				char nameChar = name.charAt(i);
				if (nameChar == 'a' ||  nameChar == 'e' || nameChar == 'i' || nameChar == 'o' || nameChar == 'u'){
					vowelsNum++;
				}
			}
			//System.out.println("The number of vowels in "+name+" is "+vowelsNum);
			treeMap.put(name, vowelsNum);
		}
		for ( Entry<String, Integer> set : treeMap.entrySet())
		{
			System.out.println("The key is "+set.getKey()+" and the value is "+set.getValue());
		}
	}
}
