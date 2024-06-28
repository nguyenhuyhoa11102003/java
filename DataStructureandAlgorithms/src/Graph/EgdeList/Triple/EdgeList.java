package Graph.EgdeList.Triple;


import java.util.*;

public class EdgeList {
	
    private ArrayList<Triple> edges;

    
    public EdgeList()
    {
        edges = new ArrayList<>();
    }
    
    
    public ArrayList<Triple> getEdges()
    {
        return edges ;
    }

    public void setEdges(ArrayList<Triple> edges)
    {
        this.edges = edges ;
    }
    
    public void addEdge(Integer weight, Integer source, Integer dest)
    {
        // do thi vo huong
        edges.add(new Triple(weight, source, dest)) ;
        edges.add(new Triple(weight, dest, source)) ;  
    }
    
    public void removeEdge(Integer weight, Integer source, Integer dest)
    {
        // do thi vo huong
        for(int i=0;i<edges.size();i++)
            if(edges.get(i).getWeight() == weight && edges.get(i).getSource() == source && edges.get(i).getDest() == dest)
            {
                edges.remove(i) ;
                edges.remove(i) ;  // do thi vo huong
            }     
    }
    
    
    

    public void print()
    {
        for(Triple i:edges)
            System.out.println(i) ;
    }
    
    
    
    
    

    
    

}
