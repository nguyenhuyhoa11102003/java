package SortAlgorithms;

public class SelectionSort {
	
	public static void main(String[] args) {
        int[] a = new int[]{1,3,4,6,7,2,5,8,10,9} ; 

        int min_index   , tmp;
        
        for(int i=0;i< a.length - 1; i++) {
        	
        	min_index =  i;
        	
        	
        	// index nho nhat cua mang chua sort 
        	for(int k = i+1 ; k <  a.length; k++) {
        		if(a[k] < a[min_index]) {
        			min_index = k;
        		}
        	}
        	
        	// swap 
        	tmp =  a[i];
        	a[i] =  a[min_index];
        	a[min_index]  = tmp;
        	
        }
        
        for (int i : a){
        	   System.out.println(i) ; 
        }
        
        
	}

}
