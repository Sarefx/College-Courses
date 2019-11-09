import java.util.TreeMap;
import java.util.TreeSet;

public class SetsMaps {

	public static void main(String[] args) {
		TreeSet<String> treeString = new TreeSet<>();
		treeString.add("JET");
		treeString.add("Bob");
		treeString.add("Billy");
		System.out.println(treeString.size());
		treeString.add("JET");
		System.out.println(treeString.size());//does not allow duplicate
		for(String s : treeString)
		{
			System.out.println(s);
		}

		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("JET", 3);
		treeMap.put("Bob", 3);
		treeMap.put("Billy", 5);
		System.out.println(treeMap.size());
		System.out.println(treeMap);
		treeMap.put("JET", 5);
		System.out.println(treeMap.size());
		System.out.println(treeMap);
		for(String k : treeMap.keySet())
		{
			System.out.println(k+":"+treeMap.get(k));
		}
	}

}










