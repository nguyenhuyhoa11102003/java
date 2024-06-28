package Graph.EgdeList.LinkedList;

public class Main {
	
	public static void main(String[] args) {
		  EdgeList edgeList = new EdgeList(5);
	        edgeList.addEdge(1,2,2) ;
	        edgeList.addEdge(0,1,4) ;
	        edgeList.addEdge(0,2,4) ;
	        edgeList.addEdge(0,3,6) ;
	        edgeList.addEdge(0,4,6) ;
	        edgeList.print() ;
	}

}
