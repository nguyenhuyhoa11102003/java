package Graph.EgdeList.HashSet;

public class Main {

	
	public static void main(String[] args) {
		
		EdgeList edgeList = new EdgeList();
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        
        edgeList.addVertex(v0);
        edgeList.addVertex(v1);
        edgeList.addVertex(v2);
        edgeList.addVertex(v3);
        
        edgeList.addEdge(v0, v1, 2);
        edgeList.addEdge(v1, v2, 3);
        edgeList.addEdge(v2, v0, 1);
        edgeList.addEdge(v2, v3, 1);

        edgeList.print();
        
	}
	
}
