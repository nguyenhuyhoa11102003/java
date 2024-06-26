package LinkedList.Double;

public class DoubleNode {
	private double value;
	private DoubleNode pNext;
	
	public DoubleNode(double value) 
    {  
        this(value, null) ; 
    }
	
	public DoubleNode(double value, DoubleNode next) 
    { 
		this.value = value ; 
		this.pNext = next ;   
	}
	
	public DoubleNode getPNext() 
    { 
        return pNext; 
    }

	public double getValue() 
    { 
        return value; 
    }

	public void setPNext(DoubleNode pNext) 
    { 
        this.pNext = pNext ;
    }
	
    public void setValue(double value)
    {
        this.value = value ;
    }
	
}
