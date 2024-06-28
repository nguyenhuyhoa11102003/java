package Graph.EgdeList.HashSet;

public class Edge {
	
	 private int weight;
	    private Vertex endVertex;
	    
	    
	    public Edge(Vertex endVertex, int weight) 
	    {
	        this.endVertex = endVertex;
	        this.weight = weight;
	    }
	    
	    
	    
	    public Edge(Vertex endVertex) 
	    {
	        this.endVertex = endVertex;
	        this.weight = 1;
	    }

	    public int getWeight() 
	    {
	        return weight;
	    }

	    public Vertex getEndVertex() 
	    {
	        return endVertex;
	    }
	    
	    
	    

}
