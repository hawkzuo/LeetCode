//225. Implement Stack using Queues
package collectionACompanies.microsoft;

import java.util.Deque;
import java.util.LinkedList;

public class Solution225 {

	public Solution225() {
		// TODO Auto-generated constructor stub
	}
	
	Deque<Integer> queue = new LinkedList<Integer>();
	//Only add,remove,element,isEmpty
    public void push(int x) {
        
    	if(queue.isEmpty()){
    		queue.add(x);  		
    	}else{
    		Deque<Integer> rep = new LinkedList<Integer>();
    		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
