package companies.google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/6/17.
 * Min Stack
 */
public class ESolution155MinStack {
    int min = Integer.MAX_VALUE;
    Deque<Integer> stack = new ArrayDeque<>();

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
