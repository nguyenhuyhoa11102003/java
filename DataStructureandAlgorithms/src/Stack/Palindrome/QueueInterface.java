package Stack.Palindrome;

public interface QueueInterface<E> {
	public boolean isEmpty();
    public E peek();               
	public E poll();               
	public void offer(E value);  
    public void print() ;
}
