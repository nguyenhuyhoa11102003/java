package Graph.GraUseAdijacentList;

import java.util.LinkedList;

public class AdjList {
	int n;
	LinkedList<Integer> list[]; 
	
	public AdjList(int n) {
		this.n =  n;
		 list = new LinkedList[n];

	        for (int i=0;i<n;i++) 
	            list[i] = new LinkedList<>(); 
	}
	
	
	 public void addEdge(int i, int j) 
	    {
	        list[i].addFirst(j);
	        list[j].addFirst(i);
	    }
	 
	 
	  public void print() 
	    {
	        for (int i = 0; i < n; i++) 
	            if(list[i].size() > 0) 
	            {
	                System.out.print(i + "->");

	                for(int j = 0; j < list[i].size(); j++) 
	                    if(j == list[i].size() - 1)
	                        System.out.print(list[i].get(j));
	                    else
	                        System.out.print(list[i].get(j) + "->");
	                
	                System.out.println();
	            }
	    }

	 
	 
	 
	
}
