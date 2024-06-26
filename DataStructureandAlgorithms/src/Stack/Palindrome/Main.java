package Stack.Palindrome;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>(); 
		Queue<Character> queue = new Queue<Character>();
		
        boolean check = true;
		System.out.print("Enter text you want to check palindrome: "); 
		 Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		
		for(int i=0 ; i < s.length() ; i++) 
        {
			stack.push(s.charAt(i));
			queue.offer(s.charAt(i));
		}
		
		
		while (!stack.empty()) 
			if(!(stack.pop().equals(queue.poll())))
				check = false;
			
		if (check) System.out.println(s+" is a palindrome");	
		else       System.out.println(s+" isn't a palindrome");
		
		
	}
}
