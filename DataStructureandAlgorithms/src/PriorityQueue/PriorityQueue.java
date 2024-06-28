package PriorityQueue;

public class PriorityQueue {
	
	 private int[] a ;
	    private int size ;

	    
	    public PriorityQueue()
	    {
	        a = new int[100] ;
	        size = -1 ;
	    }

	    // return index of parent of node i
	    public int parent(int i) 
	    {
	        return (i - 1) / 2;
	    }

	    // return index of left child of node i
	    public int leftChild(int i) 
	    {
	        return 2 * i + 1;
	    }

	    // return index of right child of node i
	    public int rightChild(int i) 
	    {
	        return 2 * i + 2;
	    }

	    public void shiftUp(int i) 
	    {
	        while(i > 0 && a[parent(i)] < a[i]) 
	        {
	            swap(parent(i), i);

	            i = parent(i);
	        }
	    }

	    public void shiftDown(int i) 
	    {
	        int maxIndex = i;

	        int left = leftChild(i);

	        if(left <= size && a[left] > a[maxIndex]) 
	            maxIndex = left;

	        int right = rightChild(i);

	        if(right <= size && a[right] > a[maxIndex]) 
	            maxIndex = right;

	        if(i != maxIndex) 
	        {
	            swap(i, maxIndex);
	            shiftDown(maxIndex);
	        }
	    }
	    
	    
	    public int peek() 
	    {
	        return a[0];  // Binary Max Heap -> a[0] (root) is the largest element
	    }
	    
	    public int poll() 
	    {
	        int result = a[0];

	        a[0] = a[size];
	        size-- ;

	        shiftDown(0);

	        return result;
	    }
	    
	    public void offer(int value) 
	    {
	        size++;
	        a[size] = value;

	        shiftUp(size);
	    }

	    
	    public void changePriority(int i, int p) 
	    {
	        int oldPriority = a[i];
	        a[i] = p;

	        if(p > oldPriority)    shiftUp(i);     
	        else                   shiftDown(i);  
	    }
	    
	    public void remove(int i) 
	    {
	        a[i] = peek() + 1;
	        shiftUp(i);
	        poll();
	    }
	    
	    public void swap(int i, int j) 
	    {
	        int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }

	    public void print()
	    {
	        for(int i=0;i<=size;i++)   // NOTE: <= size
	            System.out.print(a[i]+" ") ;
	        System.out.println() ;
	    }
	    
	

}
