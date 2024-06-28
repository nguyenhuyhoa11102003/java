package PriorityQueue;

public class Main {
	
	public static void main(String[] args) {
		
        PriorityQueue pq = new PriorityQueue() ;

        
        System.out.print("Priority Queue: ") ;
        pq.offer(45);
        pq.offer(20);
        pq.offer(14);
        pq.offer(12);
        pq.offer(31);
        pq.print();
        
        System.out.println("Node with maximum priority: " + pq.peek());

        System.out.print("Priority queue after priority change: ") ;
        pq.changePriority(2, 49);
        pq.print();

        System.out.print("Priority queue after removing the element: ") ;
        pq.remove(3);
        pq.print();
        
	}

}
