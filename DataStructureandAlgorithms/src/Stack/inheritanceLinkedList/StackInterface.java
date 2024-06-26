package Stack.inheritanceLinkedList;

import java.util.EmptyStackException;

public interface StackInterface <E> 
{
	public boolean empty(); 
	public E peek() throws EmptyStackException;  // lay phan tu tren cung
	public E pop() throws EmptyStackException;   // lay phan tu tren cung va xoa
	public void push(E value);                   // them mot phan tu vao tren cung
    public void print() throws EmptyStackException ;
}