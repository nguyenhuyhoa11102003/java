package Queue.origin;

public interface QueueInterface<E> {
	public boolean isEmpty();
    public E peek();               // lay tren cung
	public E poll();               // <=> dequeue: lay tren cung va xoa 
	public void offer(E value);  // <=> enqueue: them mot phan tu vao sau cung
    public void print() ;
}
