package Heap.HeapSort;

public class Main {

	 static void ascending(int[] a)
	    {
	        MinHeap heap = new MinHeap(a.length) ;

	        for(int i:a)
	            heap.insert(i) ;
	        
	        for(int i=0;i<a.length;i++)
	            a[i] = heap.extractMin() ;
	    }

	    static void descending(int a[])
	    {
	        MaxHeap heap = new MaxHeap(a.length) ;

	        for(int i:a)
	            heap.insert(i) ;
	        
	        for(int i=0;i<a.length;i++)
	            a[i] = heap.extractMax() ;
	    }

	    static void print(int[] a)
	    {
	        for(int i:a)
	            System.out.print(i + " ") ;
	    }
	
	
	    
	    // nlogn
	public static void main(String[] args) {
	
        int[] a = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};	
        
        System.out.println("Ascending order: ") ;
        ascending(a);
        print(a) ;

        System.out.println("\nDescending order: ") ;
        descending(a);
        print(a);
	}
}
