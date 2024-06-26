package SearchAlgorithms.Sequence;

public class Main {
	
	public static void main(String[] args) {
		   int[] a = new int[]{1,3,4,6,7,2,5,8,10,9} ; 
		   int key = 4 ; // tim so 4 trong mang
		   for(int i=0;i<a.length;i++)
	            if(a[i]==key)
	            {
	                System.out.println(i) ; 
	                break ; 
	            }
	}

}
