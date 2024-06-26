package LinkedList.Interger;

import java.util.NoSuchElementException;

public class LinkedList<E> implements LinkedListInterface<E> {

	private Node <E> head = null;
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
		for (Node <E> i = head ; i != null ; i = i.getPNext())  
			if (i.getValue().equals(value)) 
				return true;

		return false;

	}

	@Override
	public void addFirst(E value) {
		// TODO Auto-generated method stub
		head = new Node<E>(value, head);
		size++ ;  
		
	}

	@Override
	public void addBefore(Node<E> current, E value) {
		// TODO Auto-generated method stub
		
		Node<E> tmp;
		if(current == head) {
			addFirst(value);
			return;
		}
		
		for(Node<E> i = head ;i != null; i = i.getPNext()) {
			tmp = i.getPNext();
			
			if(tmp == current) {
				addAfter(current, value);
				return;
			}
		}		
		size++;
	
	}

	@Override
	public void addAfter(Node<E> current, E value) {
		// TODO Auto-generated method stub
		if ( current == null) {
			addFirst(value);
		}
		else { 	
			Node<E> newNode = new Node<E>(value , current.getPNext());
			current.setPNext(newNode);
		}
		size++;
	}

	@Override
	public void addLast(E value) {
		// TODO Auto-generated method stub
		if ( head == null) {
			addFirst(value);
			return;
		}
		Node<E> tmp =  head;
		while(tmp.getPNext() != null) {
			tmp =  tmp.getPNext();
		}
		Node<E> newNode = new Node<E>(value , null);
		tmp.setPNext(newNode);
		size++;
	}

	@Override
	public void addByIndex(E value, int index) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		return head.getValue();
	}

	@Override
	public Node<E> getHead() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		return head;
	}

	@Override
	public Node<E> getByIndex(int index) throws NoSuchElementException {
		// TODO Auto-generated method stub		
	
		int k =  0;
		for (Node<E> i = head ; i != null; i = i.getPNext(), k++) {
			if(k == index) {
				return i;
			}
		}
		throw new NoSuchElementException("Not found !") ;
	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
				
				Node<E> temp ;  
		
				temp = head ;    
				head = head.getPNext() ;  
		
				size--;
				return temp.getValue() ;
			}

	@Override
	public E removeAfter(Node<E> current) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
		if(current == null)
			throw new NoSuchElementException("Can't remove element from an empty list");
		
		
		else {
			Node<E> delNode = current.getPNext();
			if(delNode != null) {
				current.setPNext(delNode.getPNext());
				size--;
				return delNode.getValue();
			}
			else throw new NoSuchElementException("No next node to remove");	

		}		
	}

	@Override
	public E removeLast() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(head == null) throw new NoSuchElementException("Can't remove element from an empty list");
		else {
			
			Node<E> preNode = null;
			Node<E> delNode = head;
			
			while ( delNode.getPNext() != null) {
				preNode = delNode;
				delNode = delNode.getPNext();
			}
			preNode.setPNext(delNode.getPNext());
			delNode.setValue(null);
			size--;
			return delNode.getValue(); 
		}
	}

	@Override
	public E removeCurrent(Node<E> current) {
		// TODO Auto-generated method stub
		if(head == null) throw new NoSuchElementException("Can't remove element from an empty list");
		
		Node<E> tmp = head;
		if(size == 1 || current== head)
			return removeFirst();
		
		while(tmp.getPNext() != null && tmp.getPNext().getValue() != current.getValue()) {
			tmp = tmp.getPNext();
		}
		
		if(tmp.getPNext() != null) {
			removeAfter(tmp) ;  
			return tmp.getValue() ;
		}
		
		throw new NoSuchElementException("Remove fail !");
	}

	@Override
	public E removeByIndex(int index) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print(Node<E> head) {
		// TODO Auto-generated method stub
		if(head != null)
		{
			System.out.println(head.getValue()) ;  
			print(head.getPNext()) ;  // dua dong nay len tren thi in theo chieu nguoc lai (reverse)
		}
	}

	@Override
	public void sort() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");
		
		for(int i=0;i< size - 1 ; i++) {
			Node<E> n1 = head;
			Node<E> n2 = head.getPNext();
			
			for(int k= 0; i< k - 1 - i ; k++) {
				if((Integer)n1.getValue() > (Integer)n2.getValue()) {
					E tmp = n1.getValue();
					n1.setValue(n2.getValue());
					n2.setValue(tmp);
				}
				n1 =  n2;
				n2 = n2.getPNext();
			}
		}
	}
	
	@Override
	public void reverse() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		Node<E> prev = null ;
		Node<E> current = head ;
		Node<E> next = null;
		
		while( current != null) {
			next =  current.getPNext();
			current.setPNext(prev);
			prev = current;
			current = next;
		}
		
		head = prev;
		
	}

	@Override
	public int countEven() {
		// TODO Auto-generated method stub
		int count = 0;
		for(Node<E> i = head ;i != null ;i = i.getPNext()) {
			if((Integer)i.getValue() % 2 == 0) {
				count ++;
			}
		}
		return count;
	}

	@Override
	public int countPrime() {
		// TODO Auto-generated method stub
		
		int count = 0;
		for(Node<E> i = head ;i != null ;i = i.getPNext()) {
			if(isPrime((Integer)i.getValue())) {
				count ++;
			}
		}
		return count;
	}
	
	
	public boolean isPrime(Integer n)
	{
		if(n<2)	return false ;

		for(int i=2;i<=Math.sqrt(n);i++)
			if(n%i==0)
				return false ;
		
		return true ;
	}

	@Override
	public E findMax() {
		// TODO Auto-generated method stub
		E  max ;
		max = head.getValue() ;

		for (Node<E> i = head ; i!= null;i= i.getPNext()) {
			if((Integer)i.getValue() > (Integer) max)
				max = i.getValue() ;
		}
		return max;
	}

	@Override
	public boolean isSawTooth() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node<E> mergeSort(Node<E> head) {
		// TODO Auto-generated method stub
		return null;
	}

}
