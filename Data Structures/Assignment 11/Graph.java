import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Graph
{
	public TreeMap<String, Vertex> graph;
	public Graph()
	{
		graph = new TreeMap<>();
	}
	/////////////////////////////////// MY METHOD /////////////////////////////////////////
	public void topologicalSort()
	{
		Queue<String> sortedGraph = new LinkedList<>();
		while(!graph.isEmpty())
		{
			for (Vertex thisVertex : graph.values())
			{
				System.out.println("*Checking incoming edges to "+thisVertex.vertex);
				boolean zeroIncomingEdges = true;
				for (Vertex nextVertex : graph.values())
				{
					System.out.println("**Checking if "+nextVertex.vertex+" has edges going to "+thisVertex.vertex);
					for (String nameAdjacentVertex : nextVertex.adjacent.navigableKeySet())
					{
						System.out.println("***The name of adjacent vertex is "+nameAdjacentVertex);
						System.out.println("***Checking if "+nameAdjacentVertex+" equals to "+thisVertex.vertex);
						if (nameAdjacentVertex.equals(thisVertex.vertex))
						{
							zeroIncomingEdges = false;
							//System.out.println("***Temp of # Incoming Edges increased to "+tempNumberIncomingEdges);	
							break;
						}
					}
				}
				if (zeroIncomingEdges)
				{
					System.out.println("***"+thisVertex.vertex+" was assigned to have 0 incoming edges");
					sortedGraph.add(thisVertex.vertex);
					graph.remove(thisVertex.vertex);
					break;
				}
			}
		}
		System.out.println(sortedGraph);
			
	}
	public void addEdge(String v1, String v2, int weight)
	{
		//make sure both vertex exist in graph
		addVertex(v1);
		addVertex(v2);

		graph.get(v1).addEdge(v2, weight);
	}
	public void addEdge(String v1, String v2)
	{
		addEdge(v1, v2, 0);
	}
	public void addBidirectionalEdges(String v1, String v2, int weight)
	{
		//make sure both vertex exist in graph
		addVertex(v1);
		addVertex(v2);

		graph.get(v1).addEdge(v2, weight);
		graph.get(v2).addEdge(v1, weight);
	}
	public void addBidirectionalEdges(String v1, String v2)
	{
		addBidirectionalEdges(v1, v2, 0);
	}
	private void addVertex(String v)
	{
		if(!graph.containsKey(v))
		{
			graph.put(v, new Vertex(v));
		}
	}
	public void printMaxDistance()
	{
		int maxDist = 0;
		String vert = "";
		for(Map.Entry<String, Vertex> vertex : graph.entrySet())
			if(vertex.getValue().dist != Integer.MAX_VALUE && vertex.getValue().dist > maxDist)
			{
				maxDist = vertex.getValue().dist;
				vert = vertex.getKey();
			}
		System.out.println("MAX:"+vert+":"+maxDist);
	}
	public String toString()
	{
		if(graph.size() > 0)
		{
			String temp = "";
			for(Map.Entry<String, Vertex> vertex : graph.entrySet())
				temp += vertex.getValue() + "\n";
			return temp;
		}
		return "No Verticies";
	}
	public void printPath(String vs, String ve, String type)
	{
		if(graph.containsKey(vs) && graph.containsKey(ve))
		{
			System.out.println(type.toUpperCase());
			Vertex s = graph.get(vs);
			if(type.toLowerCase().equals("unweighted"))
			{
				unweighted(s);
			}
			else if(type.toLowerCase().equals("weighted"))
			{
				weighted(s);
			}
			else if(type.toLowerCase().equals("negative"))
			{
				negative(s);
			}
			Vertex e = graph.get(ve);
			/*
			 * Pseudocode
			if(e.dist != INFINITY){
				String path = "";
				Vertex curr = e;
				while(curr.path != null){
					path += curr;
					curr = curr.path;
				}
				path = s + path;
				print(path)
				print(dist)
			}else{
				print("can not reach end");
			}
			 */
			if(e.dist != Integer.MAX_VALUE)
			{
				Vertex curr = e;
				String path = curr.vertex;
				curr = curr.path;
				while(curr.path != null)
				{
					path = curr.vertex + "->" + path ;
					curr = curr.path;
				}
				path = vs  + "->" + path;
				System.out.println(path);
				System.out.println("Distance:" + e.dist);
			}
			else
			{
				System.out.println("can not reach end");
			}
		}
	}
	public void unweighted(Vertex s)
	{
		/*
		 * Pseudocode from textbook PG 372
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist == INFINITY){
					w.dist = v.dist + 1;
					w.path = v;
					q.enqueue(w);
				}
			}
		}
		 */
		LinkedList<Vertex> q = new LinkedList<>();
		for(Map.Entry<String, Vertex> vertex : graph.entrySet())
		{
			vertex.getValue().dist = Integer.MAX_VALUE;//v.dist = INFINITY;
			vertex.getValue().path = null;
		}
		s.dist = 0;
		q.addLast(s);
		while(!q.isEmpty())
		{
			Vertex v = q.removeFirst();
			for(Map.Entry<String, Integer> vertex : v.adjacent.entrySet())
			{
				Vertex w = graph.get(vertex.getKey());
				if(w.dist == Integer.MAX_VALUE){
					w.dist = v.dist + 1;
					w.path = v;
					q.addLast(w);
				}
			}
		}
	}
	public void weighted(Vertex s)
	{
		/*
		 * Pseudocode
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		//implement Comparable<Vertex> based on distance for PriorityQueue
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
			v.known = false;
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();//smallest distance in queue
			v.known = true;
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
				}
				if(!w.known){
					q.enqueue(w);
				}
			}
		}
		 */
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		for(Map.Entry<String, Vertex> vertex : graph.entrySet())
		{
			vertex.getValue().dist = Integer.MAX_VALUE;//v.dist = INFINITY;
			vertex.getValue().path = null;
			vertex.getValue().known = false;
		}
		s.dist = 0;
		q.add(s);
		while(!q.isEmpty())
		{
			Vertex v = q.remove();//smallest distance in queue
			v.known = true;
			for(Map.Entry<String, Integer> vertex : v.adjacent.entrySet())
			{
				Vertex w = graph.get(vertex.getKey());
				int weight = vertex.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					w.path = v;
				}
				if(!w.known){
					q.add(w);
				}
			}
		}
	}
	public void negative(Vertex s)
	{
		/*
		 * Pseudocode
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
					if(!q.contains(w)){
						q.enqueue(w);
					}
				}
			}
		}
		 */
		LinkedList<Vertex> q = new LinkedList<>();
		for(Map.Entry<String, Vertex> vertex : graph.entrySet())
		{
			vertex.getValue().dist = Integer.MAX_VALUE;//v.dist = INFINITY;
			vertex.getValue().path = null;
		}
		s.dist = 0;
		q.addLast(s);
		while(!q.isEmpty())
		{
			Vertex v = q.removeFirst();
			for(Map.Entry<String, Integer> vertex : v.adjacent.entrySet())
			{
				Vertex w = graph.get(vertex.getKey());
				int weight = vertex.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					w.path = v;
					if(!q.contains(w)){
						q.addLast(w);
					}
				}
			}
		}
	}
}
