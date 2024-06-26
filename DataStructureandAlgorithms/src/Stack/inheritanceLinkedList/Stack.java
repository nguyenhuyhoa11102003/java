package Stack.inheritanceLinkedList;

import java.util.EmptyStackException;


//Su dung Inheritance
//Cac methods duoc goi thong qua cac methods cua lop cha (Linked List <E>)

public class Stack<E> extends LinkedList<E> implements StackInterface<E> {
		
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return super.isEmpty(); 
	}

	@Override
	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (empty())   throw new EmptyStackException();
		
        return super.getFirst(); 	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		E temp = peek();
		super.removeFirst();
        
		return temp;
	}

	@Override
	public void push(E value) {
		// TODO Auto-generated method stub
		super.addFirst(value);
	}

	@Override
	public void print() throws EmptyStackException {
		// TODO Auto-generated method stub
		  if(empty()) throw new EmptyStackException() ;
		  super.print(); // print() nay la print() cua Basic Linked List chu ko phai cua Stack nha
	}

}
