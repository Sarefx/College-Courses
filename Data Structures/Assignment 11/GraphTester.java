
public class GraphTester {

	public static void main(String[] args) {
		Graph courses = new Graph();
		//required CS courses
		courses.addEdge("CSCI 1301", "CSCI 1302");
		courses.addEdge("CSCI 1301", "CSCI 2150");
		courses.addEdge("CSCI 1302", "CSCI 3100");
		courses.addEdge("CSCI 1302", "CSCI 3200");
		courses.addEdge("CSCI 1302", "CSCI 3300");
		courses.addEdge("CSCI 1302", "CSCI 3410");
		courses.addEdge("CSCI 1302", "CSCI 3450");
		courses.addEdge("CSCI 1302", "CSCI 3510");
		courses.addEdge("CSCI 1302", "CSCI 4200");
		courses.addEdge("CSCI 3100", "CSCI 4100");
		courses.addEdge("CSCI 3300", "CSCI 4400");
		courses.addEdge("CSCI 3300", "CSCI 4950");
		courses.addEdge("MATH 1113", "MATH 1450");
		courses.addEdge("MATH 1113", "MATH 2400");
		courses.addEdge("MATH 1113", "MATH 2510");
		courses.addEdge("MATH 1450", "MATH 2460");
		courses.addEdge("MATH 2510", "CSCI 3200");
		courses.addEdge("MATH 2510", "CSCI 3450");
		courses.addEdge("MATH 2510", "CSCI 4200");
		/**/
		//System.out.println(courses);
		//run topological sort that shows these printing in order
		/**/

		/** /
		Graph g1 = new Graph();
		g1.addEdge("V1", "V2", 1);
		g1.addEdge("V2", "V1", 2);
		g1.addEdge("V3", "V4", 3);
		g1.addEdge("V4", "V5", 1);
		g1.addEdge("V5", "V3", 2);
		/** /
		System.out.println(g1);
		g1.printPath("V1", "V5", "unweighted");
		System.out.println(g1);
		g1.printPath("V3", "V5", "unweighted");
		System.out.println(g1);
		g1.printPath("V3", "V5", "weighted");
		System.out.println(g1);
		/** /
		Graph g2 = new Graph();
		g2.addEdge("V1", "V2", 2);
		g2.addEdge("V1", "V4", 1);
		g2.addEdge("V2", "V4", 3);
		g2.addEdge("V2", "V5", 10);
		g2.addEdge("V3", "V1", 4);
		g2.addEdge("V3", "V6", 5);
		g2.addEdge("V4", "V3", 2);
		g2.addEdge("V4", "V5", 2);
		g2.addEdge("V4", "V6", 8);
		g2.addEdge("V4", "V7", 4);
		g2.addEdge("V5", "V7", 6);
		g2.addEdge("V7", "V6", 1);
		/*
		   v1 - v2
		  /  \ /  \
		v3 - v4 - v5
          \  / \  /
           v6 - v7
		*/
		/** /
		System.out.println(g2);
		g2.printPath("V1", "V7", "unweighted");
		System.out.println(g2);
		g2.printPath("V3", "V5", "unweighted");
		System.out.println(g2);
		g2.printPath("V3", "V5", "weighted");
		System.out.println(g2);
		/**/
		Graph g3 = new Graph();
		g3.addEdge("V1", "V2", 2);
		g3.addEdge("V1", "V4", -3);
		g3.addEdge("V2", "V4", 3);
		g3.addEdge("V2", "V5", 10);
		g3.addEdge("V3", "V1", 4);
		g3.addEdge("V3", "V6", 5);
		g3.addEdge("V4", "V5", 2);
		g3.addEdge("V4", "V6", 8);
		g3.addEdge("V4", "V7", 4);
		g3.addEdge("V5", "V7", 6);
		g3.addEdge("V7", "V6", 1);
		/**/
		//g3.printPath("V3", "V7", "negative");
		//System.out.println(g3);
		/**/
		
		Graph g4 = new Graph();
		g4.addEdge("A", "B");
		g4.addEdge("A", "C");
		g4.addEdge("B", "D");
		g4.addEdge("B", "E");
		g4.addEdge("C", "D");
		g4.addEdge("D", "F");
		g4.addEdge("E", "F");
		System.out.println(g4);
		g4.topologicalSort();


	}

}
