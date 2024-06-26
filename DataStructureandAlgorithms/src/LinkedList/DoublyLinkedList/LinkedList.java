package LinkedList.DoublyLinkedList;

import java.util.NoSuchElementException;

public class LinkedList<E> implements LinkedListInterface<E> {
	
	private Node <E> head = null;
	private Node <E> tail = null;
	private int size = 0;
	
	
	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean contains(E value) {
		// TODO Auto-generated method stub
		for (Node<E> i = head ; i != null ; i = i.getPNext())  
			if (i.getValue().equals(value)) 
				return true;

		return false;
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
	    return head.getValue() ;	
	 }

	@Override
	public Node<E> getHead() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return head;
	}

	@Override
	public Node<E> getTail() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return tail;
	}

	@Override
	public void addFirst(E value) {
		// TODO Auto-generated method stub
		
		if(size == 0) {
			head = new Node<E>(value , null , null);
			tail = head;
		}
		else {
			Node<E> tmp = new Node<E>(value , null , head);
			head.setPBack(tmp);
			head =tmp;
		}
		size++;
	}

	@Override
	public void addAfter(Node<E> current, E value) {
		// TODO Auto-generated method stub
		if (current == null) {
			addFirst(value);
			return;
		}
		
		else if(current == tail) {
			Node<E> newNode = new Node<E>(value , current  , current.getPNext());
			current.setPNext(newNode);
			tail=  newNode;
		}
		else {
			Node<E> newNode = new Node<E>(value , current , current.getPNext());
			current.setPNext(newNode);
			newNode.getPNext().setPBack(newNode);
		}
		
		size++;
		
	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		
		if (head == tail) {
			E tmp =head.getValue();
			head = null;
			tail = null;
			size--;
			return tmp;
		}
		
		Node<E> temp = head ;    
		head = new Node<E>(head.getPNext().getValue() , head , head.getPNext().getPNext());
		size--;
		
		return temp.getValue();
	}

	@Override
	public E removeAfter(Node<E> current) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
		if(current.getPNext() == null || current == tail || size == 0)	
			throw new NoSuchElementException("No next node to remove");

		if(current.getPBack() == null)	return removeFirst() ;

		Node<E> temp = current.getPNext() ;
		current.setPNext(current.getPNext().getPNext());
		current.getPBack().setPBack(current);
		
		size--;
	
		return temp.getValue();
	}

	@Override
	public void sort() throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (head == null || size == 0 || isEmpty())	
			throw new NoSuchElementException("Empty Linked List");
		Node <E> temp = head ;
		System.out.print("List includes: " + temp.getValue()) ;  
		for (int i = 1 ; i < size ;i++)   
        {
			temp = temp.getPNext();
			System.out.print("  " + temp.getValue());
		}
		System.out.println() ;
	}

}
