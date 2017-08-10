package collectionMedium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/8/10.
 * Evaluate Reverse Polish Notation
 */
public class Sol150 {
    public int evalRPN(String[] tokens) {
        // Idea: Use Stack to calculate expressions
        int a,b;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
