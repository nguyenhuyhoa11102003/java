package Graph.Basic;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static AdjacentMatrix getGraph() {

		try {

			File file = new File("AM.txt");

			Scanner sc = new Scanner(file);
			int row = 0;

			int vertex = Integer.parseInt(sc.nextLine());

			AdjacentMatrix graph = new AdjacentMatrix(vertex);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] items = line.split(" ");

				int colum = 0;

				for (String i : items) {
					System.out.print(i + " ");

					if (!i.equals("0"))
						graph.addEdge(row, colum, Integer.parseInt(i));

					colum++;
				}

				row++;
				System.out.println();
			}

			sc.close();
			return graph;
		} catch (Exception e) {
			// TODO: handle exception

			System.err.print(e.getMessage());
			return null;
		}

	}

	static void getDegreeOfVertices(AdjacentMatrix graph) {
		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
			int degree = 0;

			for (int j = 0; j < graph.getNumberOfVertices(); j++)
				if (graph.getMatrix()[i][j] != 0)
					degree++;

			System.out.println("Degree of vertex " + (i + 1) + " is: " + degree);
		}
	}

	static int getTotalOfEdges(AdjacentMatrix graph) {
		int sum = 0;

		for (int i = 0; i < graph.getNumberOfVertices(); i++)
			for (int j = i + 1; j < graph.getNumberOfVertices(); j++) // duyet duong cheo tren
				if (graph.getMatrix()[i][j] != 0)
					sum++;

		if (isDirectedGraph(graph))
			return sum;
		return sum * 2; // vo huong canh x2

	}

	static boolean isDirectedGraph(AdjacentMatrix graph) {
		for (int i = 0; i < graph.getNumberOfVertices(); i++)
			for (int j = i + 1; j < graph.getNumberOfVertices(); j++) // duyet duong cheo tren
				if (graph.getMatrix()[i][j] != graph.getMatrix()[j][i])
					return true;
		return false;
	}

	static LinkedList<Integer>[] transferToAdjacentList(AdjacentMatrix graph) {
		LinkedList<Integer>[] AdjacentList = new LinkedList[graph.getNumberOfVertices()];

		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
			AdjacentList[i] = new LinkedList<>();

			for (int j = 0; j < graph.getNumberOfVertices(); j++)
				if (graph.getMatrix()[i][j] != 0)
					AdjacentList[i].add(j);
		}

		for (int i = 0; i < graph.getNumberOfVertices(); i++)
			if (AdjacentList[i].size() > 0) {
				for (int j = 0; j < AdjacentList[i].size(); j++)
					if (j == AdjacentList[i].size() - 1)
						System.out.print(AdjacentList[i].get(j));
					else
						System.out.print(AdjacentList[i].get(j) + "->");

				System.out.println();
			}

		return AdjacentList;

	}
	
    static EdgeList transferToEdgeList(AdjacentMatrix graph) {
    	
        EdgeList edgeList = new EdgeList() ;
        for(int i=0;i<graph.getNumberOfVertices();i++)
            for(int j=0;j<graph.getNumberOfVertices();j++)  
                if(graph.getMatrix()[i][j] != 0)
                    edgeList.getEdges().add(new IntegerTriple(graph.getMatrix()[i][j], i, j)) ;
        
        
        for(int i=0;i<edgeList.getEdges().size();i++)
            System.out.println(i + " " + edgeList.getEdges().get(i)) ;
        
        return edgeList ;
    	
    	
    }
	
	
	
	

	public static void main(String[] args) {

		System.out.println("ADJACENT MATRIX");
		AdjacentMatrix graph = getGraph();

		getDegreeOfVertices(graph);

		System.out.println("Total of edges: " + getTotalOfEdges(graph));

		System.out.println("ADJACENT LIST");
		LinkedList<Integer>[] AdjacentList = transferToAdjacentList(graph);

		
	    System.out.println("EDGE LIST") ;
        EdgeList edgeList = transferToEdgeList(graph) ;
	}

}
