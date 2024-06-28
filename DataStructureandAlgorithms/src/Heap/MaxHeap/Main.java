package Heap.MaxHeap;

public class Main {
	
	public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(5) ;
        
        
        mh.insert(15) ;
        mh.insert(10) ;
        mh.insert(5) ;
        mh.insert(2) ;
        mh.insert(8) ;
        mh.print() ;
        
        
        System.out.println(mh.extractMax()) ;

        mh.print() ;

        

	}

}
