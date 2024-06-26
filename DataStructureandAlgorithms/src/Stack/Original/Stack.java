package Stack.Original;

import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {

	private E[] stack;
	private int top;
	private int size;
	private final int MAXSIZE = 1000;

	public Stack() {
		this.stack = (E[]) new Object[MAXSIZE]; 
		this.top = -1;  
		this.size = MAXSIZE;
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return (top < 0); 
	}

	@Override
	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (empty())   throw new EmptyStackException();
		return stack[top];
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		E temp =  peek();
		top--;
		return temp;
	}

	@Override
	public void push(E value) {
		// TODO Auto-generated method stub
		
		if (top >= size -1 ) 
			enlargeStack();
		
		top++;
		stack[top] = value;
	}
	
	private void enlargeStack() {
		int newSize = 2 * size; 
		E[] newStack = (E[]) new Object[newSize];
		
		for (int i=0 ; i < size ; i++) 
			newStack[i] = stack[i];
		
		size = newSize;
		stack = newStack;
	}

	@Override
	public void print() throws EmptyStackException {
		// TODO Auto-generated method stub
        if(empty()) throw new EmptyStackException() ;
        int temp = top ;  // temp de giu cai top lai, ko thoi no se -- ben duoi
        
        while(top >= 0)
        {
            System.out.println(peek()) ;
            top-- ;
        }
        
        top = temp ;
	}

}
