package LinkedList.Double;

import java.util.NoSuchElementException;

public interface DoubleLinkedListInterface {
	   public boolean isEmpty() ;
	    public int getSize() ;
	    public void addFirst(double value) ;
	    public double getFirst() throws NoSuchElementException  ;
	    public double removeFirst() throws NoSuchElementException  ;
	    public String find(double value) ;
	    public void print() throws NoSuchElementException ;


}
