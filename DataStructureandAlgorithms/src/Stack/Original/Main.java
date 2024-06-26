package Stack.Original;

public class Main {
	public static void main(String[] args) {
        Stack stack = new Stack() ;
		   System.out.println("Testing push()") ;
	        stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.print();
	        
	        System.out.println("Testing peek()") ;
	        System.out.println("Top: "+stack.peek()) ;
	        
	        stack.print();
	        
	        System.out.println("Testing pop()") ;
	        System.out.println("Top: "+stack.pop()) ;
	        stack.print();
	}
}
