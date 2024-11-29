package Stack.Api;

import java.util.Stack;

public class StackUsingAPI {
        public static void main(String[] args) {
                Stack<Integer> stack = new Stack<>();

                stack.push(1);
                stack.push(2);
                stack.push(3);

                System.out.println("Stack: " + stack);

                System.out.println("size = " + stack.size());
                System.out.println("peek = " + stack.peek());
                System.out.println("pop = " + stack.pop());
                System.out.println("peek = " + stack.peek());
                System.out.println("isEmpty = " + stack.empty()); // || isEmpty()
                System.out.println("index tinh tu tren cung xuong = " + stack.search(1));

        }
}
