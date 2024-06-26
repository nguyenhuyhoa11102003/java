package Stack.inheritanceLinkedList;

public class Node <E>
{
    // properties
	private E value;
	private Node <E> pNext;

    // constructors
	public Node(E value) 
    { 
        this(value, null) ; 
    }

	public Node(E value, Node <E> next) 
    { 
		this.value = value ; 
		this.pNext = next ;   
	}

    // getters
	public Node <E> getPNext() 
    { 
        return pNext; 
    }

	public E getValue() 
    { 
        return value; 
    }

    // setters
	public void setPNext(Node <E> pNext) 
    { 
        this.pNext = pNext ;
    }

    public void setValue(E value)
    {
        this.value = value ;
    }
}