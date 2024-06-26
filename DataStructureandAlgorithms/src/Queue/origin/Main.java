package Queue.origin;

public class Main {
	
	public static void main(String[] args) {
		 Queue queue = new Queue() ;
		 
		 System.out.println("Testing offer()") ;
	        queue.offer(1);
	        queue.offer(2);
	        queue.offer(3);
	        queue.print();
	        

	        System.out.println("Testing peek()") ;
	        System.out.println("Front: "+queue.peek()) ;
	        queue.print();

	        
	        System.out.println("Testing poll()") ;
	        System.out.println("Top: "+queue.poll()) ;
	        queue.print();
	}

}
