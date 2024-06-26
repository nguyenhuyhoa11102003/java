package Stack.Palindrome;

public class Queue<E> implements QueueInterface<E> {

	
	private E[] queue;
	private int front; 
    private int back;
    private int size;
	private final int MAXSIZE = 1000;
	
	public Queue() {
		this.queue = (E[]) new Object[MAXSIZE]; 
		this.front = 0;
		this.back = 0;
		this.size = MAXSIZE;
	}	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (front == back);
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if (isEmpty())  return null;   
        
		return queue[front];
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void offer(E value) {
		// TODO Auto-generated method stub
		
		if (((back + 1) % size) == front)  
			enlargeQueue();
		
		queue[back] = value;
		back = (back + 1) % size;   
	}
	
    private void enlargeQueue() {
    	int newSize = size * 2;
    	E[] newQueue = (E[]) new Object[newSize];

		for (int i=0 ; i < size ; i++) 
			newQueue[i] = queue[(front + i) % size]; 
		
		
		front = 0 ; 
		back = size - 1 ;
		queue = newQueue;
		size = newSize;
    	
    }

	@Override
	public void print() {
		// TODO Auto-generated method stub
		 if(isEmpty())
	        {
	            System.out.println("Queue is empty !") ;  // dung ngoai le cung dc
	            return ;
	        }
		 
		 
		   int temp = front ; 
		   while(front != back)
	        {
	            System.out.println(peek()) ;
	            front++ ;
	        }
		   
		   
		   front = temp;
		   		 
	}

}
