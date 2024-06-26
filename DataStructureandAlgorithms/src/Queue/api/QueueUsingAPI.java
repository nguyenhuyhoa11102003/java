package Queue.api;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingAPI {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>() ;
		
		  queue.offer(1) ;
	        queue.offer(2) ;
	        queue.offer(3) ;

	        
	        System.out.println("Queue: " + queue) ;
	        System.out.println("size = " + queue.size()) ;
	        System.out.println("peek: " + queue.peek()) ;
	        System.out.println("poll: " + queue.poll()) ;
	        System.out.println("peek: " + queue.peek()) ;
	        System.out.println("isEmpty = " + queue.isEmpty()) ;  

		
		
	}

}
