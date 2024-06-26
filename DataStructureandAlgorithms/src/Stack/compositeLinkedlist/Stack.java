package Stack.compositeLinkedlist;

import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {
	
	private LinkedList<E> list ;
	
	public Stack() 
    {
		this.list = new LinkedList<E>() ;
	}
	
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return list.isEmpty(); 
	}

	@Override
	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (empty())   throw new EmptyStackException();
		
        return list.getFirst(); 	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		E temp = peek();
		list.removeFirst();
        
		return temp;
	}

	@Override
	public void push(E value) {
		// TODO Auto-generated method stub
		list.addFirst(value);
	}

	@Override
	public void print() throws EmptyStackException {
		// TODO Auto-generated method stub
		  if(empty()) throw new EmptyStackException() ;

	        list.print(); // print() nay la print() cua Basic Linked List chu ko phai cua Stack nha
	}

}
