package LinkedList.Interger;

import java.util.NoSuchElementException;

public interface LinkedListInterface<E> {
		public boolean isEmpty() ;
	    public int getSize() ;
	    public boolean contains(E value) ;
	    public void addFirst(E value) ;
	    public void addBefore(Node<E> current, E value) ;
	    public void addAfter(Node <E> current, E value) ;
	    public void addLast(E value) ;
	    public void addByIndex(E value, int index) throws NoSuchElementException ; // index starts at 0
	    public E getFirst() throws NoSuchElementException  ;
	    public Node <E> getHead() throws NoSuchElementException  ;
	    public Node<E> getByIndex(int index) throws NoSuchElementException ;  // index starts at 0
	    public E removeFirst() throws NoSuchElementException  ;
	    public E removeAfter(Node <E> current) throws NoSuchElementException ; 
	    public E removeLast() throws NoSuchElementException  ;
	    public E removeCurrent(Node<E> current) ;
	    public E removeByIndex(int index) throws NoSuchElementException  ;  // index starts at 0
	    public void print(Node<E> head) ;
	    public void sort() throws NoSuchElementException ;
	    public void reverse() throws NoSuchElementException ;
	    public int countEven() ;
	    public int countPrime() ;
	    public E findMax() ;
	    public boolean isSawTooth() throws NoSuchElementException ;  // kiem tra tinh rang cua cua mot list
	    public Node <E> mergeSort(Node<E> head) ;
}
