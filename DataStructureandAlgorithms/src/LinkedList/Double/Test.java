package LinkedList.Double;

public class Test {
	
	public static void main(String[] args) {
		MyDoubleLinkedList list = new MyDoubleLinkedList() ;
		System.out.println("Testing addFirst()") ;
        list.addFirst(1.1);
        list.addFirst(2.6);
		list.addFirst(4.8);
		list.addFirst(3.7);
		list.addFirst(5.4);
		list.print(); 
		
		
		  System.out.println("Testing getFirst()") ;
		System.out.println(list.getFirst()) ;
		
		   System.out.println("Testing getSize()") ;
			System.out.println(list.getSize()) ;

			System.out.println("Testing removeFirst()") ;
			list.removeFirst();
			list.print();
			
			System.out.println("Testing find()") ;
			System.out.println(list.find(4.8)) ;    
	}

}
