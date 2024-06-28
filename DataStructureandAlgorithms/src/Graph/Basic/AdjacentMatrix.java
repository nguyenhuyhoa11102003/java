package Graph.Basic;

public class AdjacentMatrix {
	
	private int[][] matrix;
	private int n;
	
	public AdjacentMatrix(int vertices) {
		n = vertices;
		matrix = new int[n][n];
	}
	
    public int getNumberOfVertices()
    {
        return n ;
    }

    public void setNumberOfVertices(int n)
    {
        this.n = n  ;
    }

    public int[][] getMatrix()
    {
        return matrix ;
    }
    
    public void addEdge(int i, int j, int weight) 
    {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }
        
    public int getEgde(int i, int j) 
    {
        return matrix[i][j];
    }

    
    
    public void print() 
    {
        for (int i=0;i<n;i++) 
        {
            for (int j=0;j<n;j++) 
                System.out.print(matrix[i][j] + " ");
            
            System.out.println();
        }
    }
    
    
	
	
	
	

}
