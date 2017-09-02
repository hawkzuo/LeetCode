package collectionEasyFirstHundred;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Amos on 2017/9/2.
 * Implement Stack using Queues
 */
public class Sol225MyStack {
    // Idea: Brute-force

    private Deque<Integer> queue = new LinkedList<>();
    //Only add,remove,element,isEmpty
    public void push(int x) {
        if(queue.isEmpty()){
            queue.add(x);
        }else{
            Deque<Integer> rep = new LinkedList<>();

            while(!queue.isEmpty()){
                rep.add(queue.remove());
            }
            queue.add(x);
            while(!rep.isEmpty()){
                queue.add(rep.remove());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.element();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
