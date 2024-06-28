package Graph.GraUseAdijacentList;

public class Main {
	 public static void main(String[] args) 
	    {
	        AdjList adjList = new AdjList(5) ;
	        adjList.addEdge(0, 1);
	        adjList.addEdge(1, 2);
	        adjList.addEdge(2, 3);
	        adjList.addEdge(1, 4);
	        adjList.addEdge(3, 4);
	        adjList.print();
	    }
}
