import java.util.TreeMap;

public class Vertex implements Comparable<Vertex>
{
	public String vertex;
	public TreeMap<String, Integer> adjacent;//vertex connected name and weight to that vertex
	public Integer dist;
	public Vertex path;
	public boolean known;
	public Vertex(String name) 
	{
		this.vertex = name;
		adjacent = new TreeMap<>();
	}
	public void addEdge(String v, Integer weight)
	{
		adjacent.put(v, weight);
	}
	public void addEdge(String v)
	{
		adjacent.put(v, 1);
	}
	public String toString()
	{
		String temp = "Vertex:" + vertex + " | Distance:" + dist;
		if(adjacent.size() > 0)
			temp += " | Adjacent List:" + adjacent;
		return temp;
	}
	public int compareTo(Vertex v)
	{
		return dist.compareTo(v.dist);
	}
}
