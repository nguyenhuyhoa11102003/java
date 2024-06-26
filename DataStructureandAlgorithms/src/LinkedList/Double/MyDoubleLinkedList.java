package LinkedList.Double;

import java.util.NoSuchElementException;

public class MyDoubleLinkedList implements DoubleLinkedListInterface{
	
	private DoubleNode head ;
	private int size;
	
	public MyDoubleLinkedList() {
		this.head = null ;
		this.size = 0 ;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return  size == 0;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public void addFirst(double value) {
		// TODO Auto-generated method stub
		head =  new DoubleNode(value , head);
		size++;
	}

	public double getFirst() throws NoSuchElementException {
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		// TODO Auto-generated method stub
		return head.getValue();
	}

	public double removeFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");

		DoubleNode temp ;  
		temp = head;
		head = head.getPNext();
		size--;
		return head.getValue();
	}

	public String find(double value) {
		// TODO Auto-generated method stub
		for(DoubleNode i= head ; i != null ; i = i.getPNext()) {
			if (i.getValue() == value) {
				return "Find success !"; 
			}
		}
		
		return "Find unsucess";
		
	}

	public void print() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");
		
		
		DoubleNode temp = head ;
		
		System.out.print("List includes: " + temp.getValue()) ; 
		
		for (int i = 1 ; i < size ;i++)  
        {
			temp = temp.getPNext();
			System.out.print("  " + temp.getValue());
		}
		
		System.out.println() ;

		
	}

}
