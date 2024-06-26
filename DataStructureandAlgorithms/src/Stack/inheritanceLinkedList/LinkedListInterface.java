package Stack.inheritanceLinkedList;

import java.util.NoSuchElementException;

public interface LinkedListInterface<E>
{
    public boolean isEmpty() ;
    public int getSize() ;
    public boolean contains(E value) ;
    public void addFirst(E value) ;
    public E getFirst() throws NoSuchElementException  ;
    public E removeFirst() throws NoSuchElementException  ;
    public void print() throws NoSuchElementException ;
}