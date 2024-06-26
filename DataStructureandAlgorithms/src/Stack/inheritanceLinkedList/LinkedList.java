package Stack.inheritanceLinkedList;

import java.util.NoSuchElementException;
 
public class LinkedList<E> implements LinkedListInterface<E>
{
	private Node <E> head = null;
	private int size = 0;
	
	public boolean isEmpty() 
    { 
        return (size == 0) ;  
    }

	public int getSize() 
    { 
        return size; 
    }

	public boolean contains(E value) 
    {
		for (Node <E> i = head ; i != null ; i = i.getPNext())  
			if (i.getValue().equals(value)) 
				return true;

		return false;
	}

	public void addFirst(E value)  
    {
		head = new Node<E>(value, head);

		size++ ;  
	}

	// Lay first node -> lay value cua no
	public E getFirst() throws NoSuchElementException 
    {
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");

        return head.getValue() ;
	}

	// xoa first node -> xoa value cua no -> nho return lai value xoa dc
	public E removeFirst() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		
		Node<E> temp ;  

		temp = head ;    
		head = head.getPNext() ;  

		size--;
		return temp.getValue() ;
	}

	// Xuat cac node (value cua node) co trong Linked List
    public void print() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		Node <E> temp = head ;

		System.out.print("List includes: " + temp.getValue()) ;  // print first node

		for (int i = 1 ; i < size ;i++)   // i = 1 tai print cai first node roi
        {
			temp = temp.getPNext();
			System.out.print("  " + temp.getValue());
		}

		System.out.println() ;
	}
}