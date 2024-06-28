package Graph.EgdeList.Triple;

public class Main {
	
	public static void main(String[] args) {
	       EdgeList graph = new EdgeList() ;

	       
	       System.out.println("Testing addEdge") ;
	        graph.addEdge(5, 1, 2) ;
	        graph.addEdge(6, 1, 3) ;
	        graph.addEdge(7, 2, 3) ;
	        graph.addEdge(8, 4, 3) ;
	        graph.addEdge(9, 1, 4) ;
	        graph.print() ;
	        
	        System.out.println("Testing removeEdge") ;
	        graph.removeEdge(5, 1, 2) ;

	        graph.print() ;

	}

}
