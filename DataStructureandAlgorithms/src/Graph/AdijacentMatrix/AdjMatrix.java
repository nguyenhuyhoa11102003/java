package Graph.AdijacentMatrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjMatrix {

	int n; // number of vertexs
	int matrix[][];

	public AdjMatrix(int n) {
		this.n = n;
		matrix = new int[n][n];
	}

	public void addEdge(int i, int j) {
		matrix[i][j] = 1; // neu la weighted graph thi gan cai weigh (khong gan 1)
		matrix[j][i] = 1; // doi xung -> do thi vo huong (2 chieu)
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + " ");

			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			System.out.print("Vertex " + i + " is connected to: ");

			for (int j = 0; j < n; j++)
				if (matrix[i][j] == 1)
					System.out.print(j + " ");

			System.out.println();
		}
	}

	public void BFS(int start) {

		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[start] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			System.out.print(temp + "");

			for (int i = 0; i < n; i++) {
				if (matrix[temp][i] != 0 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}
	
	
	public void DFS(int start  , boolean[] visited) {
        visited[start] = true;

        
        System.out.print(start + " ");
        
        for(int i = 0;i< n ;i++) {
        	if(matrix[start][i] != 0 && !visited[i]) // kiem tra gia tri va flag = falsse
                DFS(i, visited);
        }
	}
	
	  public void DFS(int start)
	    {
	        boolean[] visited = new boolean[n];
	        DFS(start, visited);
	    }
	
	
	
	
	
	public void dfs_stack(int start) {
		
		 boolean visited[] = new boolean[n]; 
	        Stack<Integer> stack = new Stack<>(); 
	        
	        
	        stack.push(start);             
	        int temp = 0;
            

	        
	        while(!stack.empty()) {
	        	 start = stack.peek();                      
	             stack.pop();                    
	             
	             
	             if(!visited[start]) 
	             { 
	                 System.out.print(start + " "); 
	                 visited[start] = true; 
	             } 
	             
	             for(int i=0;i<matrix[start].length;i++)  
	             {
	                 temp = i;

	                 if (!visited[temp])                   
	                     stack.push(temp);                         
	             }          
	        }
	        
	        
		
	}
	
}
