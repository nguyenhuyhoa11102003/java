package Stack.BranchMatch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao mot bieu thuc toan hoc (co cac ngoac '()', '[]', '{}') ma ban muon kiem tra: ");
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));

            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.empty()) {
                    System.out.println("Too many closing brackets !");
                    return;
                }
            } else {
                char c = stack.pop();
                if ((c == '(' && s.charAt(i) != ')')
                        || (c == '[' && s.charAt(i) != ']')
                        || (c == '{' && s.charAt(i) != '}')) {
                    System.out.println("Bracket mismatch !");
                    return;
                }

            }
        }

        if (stack.empty())
            System.out.println("brackets are matched");
        else
            System.out.println("Too many opening brackets !");

    }
}
