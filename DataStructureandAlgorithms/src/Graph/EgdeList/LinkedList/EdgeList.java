package Graph.EgdeList.LinkedList;

import java.util.LinkedList;

public class EdgeList {
	
	  int n;  // number of vertexs
	    LinkedList<Integer> edges[];
	    int edge ;
	    
	    public EdgeList(int n) 
	    {
	        this.n = n;
	        edge = 0 ;
	        edges = new LinkedList[n];

	        for (int i=0;i<n;i++) 
	            edges[i] = new LinkedList<>();
	    }
	    
	    
	    public void addEdge(int v1, int v2, int weight) {
	    	   edges[edge].addFirst(v2) ;
	           edges[edge].addFirst(v1) ;
	           edges[edge].addFirst(weight) ;
	           edge++ ;
	    }
	    
	    public void print() 
	    {
	        System.out.println("Edge Weight   v1     v2") ;
	        for (int i = 0; i < n; i++)
	        {
	            System.out.print(i) ;
	            if (edges[i].size() > 0) 
	            {
	                for (int j = 0; j < edges[i].size(); j++) 
	                    System.out.print("      "+edges[i].get(j));
	                
	                System.out.println();
	            }
	        }
	    }
	    

}
