package LinkedList.Interger;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>() ;

		System.out.println("Testing addFirst()") ;
        list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		list.print(list.getHead());
	
//		System.out.print(String.format("LinkedList after reverser :"));
//		list.reverse();
//		list.print(list.getHead());
		
		
	}
}
