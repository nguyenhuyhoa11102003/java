package Graph.EgdeList.HashSet;

import java.util.HashSet;

public class EdgeList {
	
    private HashSet<Vertex> vertices;

    public EdgeList() 
    {
        vertices = new HashSet<>();
    }
    
    public boolean addEdge(Vertex v1, Vertex v2, int weight) 
    {
        return v1.getEdges().add(new Edge(v2, weight)) && v2.getEdges().add(new Edge(v1, weight));
    }

    public boolean addVertex(Vertex v) 
    {
        return vertices.add(v);
    }
    
    public void print() 
    {
        for (Vertex v:vertices) 
        {
            System.out.println("vertex " + v.getName() + " is connected to vertex: ");

            for (Edge e:v.getEdges()) 
                System.out.println(e.getEndVertex().getName() + " with weight = " + e.getWeight());
            
            System.out.println();
        }
    }

    
    
    
    
    
    
    
    
    
	
	
	

}
