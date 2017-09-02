package collectionEasyFirstHundred;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Amos on 2017/9/2.
 * Implement Queue using Stacks
 */
public class Sol232MyQueue {
    // Idea: Pour out and then push
    private Deque<Integer> stack = new LinkedList<>();

    //push pop peek size
    // Push element x to the back of queue.
    public void push(int x) {

        if(stack.isEmpty()){
            stack.push(x);
        }else{

            Deque<Integer> rep = new LinkedList<>();
            while(!stack.isEmpty()){
                rep.push(stack.pop());
            }
            stack.push(x);
            while(!rep.isEmpty()){
                stack.push(rep.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
