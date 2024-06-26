package LinkedList.DoublyLinkedList;

import java.util.NoSuchElementException;

public interface LinkedListInterface<E> {
	
	public boolean isEmpty() ;
    public int getSize() ;
    public boolean contains(E value) ;
    public E getFirst() throws NoSuchElementException  ;
    public Node <E> getHead() throws NoSuchElementException  ;
    public Node <E> getTail() throws NoSuchElementException  ;
    public void addFirst(E value) ;
    public void addAfter(Node <E> current, E value) ;
    public E removeFirst() throws NoSuchElementException  ;
    public E removeAfter(Node <E> current) throws NoSuchElementException ; 
    public void sort() throws NoSuchElementException ;
    public void print() throws NoSuchElementException ;

}
