//232. Implement Queue using Stacks
package companies.microsoft;

import java.util.Deque;
import java.util.LinkedList;

public class Solution232 {

	public Solution232() {
		// TODO Auto-generated constructor stub
	}

	Deque<Integer> stack = new LinkedList<Integer>();	
	
//push pop peek size
    // Push element x to the back of queue.
    public void push(int x) {
        
    	if(stack.isEmpty()){
    		stack.push(x);
    	}else{
    		
    		Deque<Integer> rep = new LinkedList<Integer>();
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
	
    
    public String toString(){
    	
    	String res = "";
		Deque<Integer> rep = new LinkedList<Integer>();
		while(!stack.isEmpty()){
			rep.push(stack.pop());
			res += "(" + rep.peek()+ ")";
		}
		while(!rep.isEmpty()){
			stack.push(rep.pop());
		}		
    	return res;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution232 q = new Solution232();
		
		q.push(1); q.push(2); q.push(3); q.push(4);
		System.out.println(q);
		q.pop(); q.pop();
		System.out.println(q);
		System.out.println(q.peek());
		
		
	}

}
