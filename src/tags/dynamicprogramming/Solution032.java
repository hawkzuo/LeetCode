//32. Longest Valid Parentheses (via Stack)

package tags.dynamicprogramming;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution032 {

	public Solution032() {
		// TODO Auto-generated constructor stub
	}

    public int longestValidParentheses(String s) {
//THis one is hard.
    	if(s == null || s.length() == 0 || s.length() == 1){	return 0;}
    	int longest = 0;
    	char [] str = s.toCharArray();    	
    	Deque<Integer> stack = new ArrayDeque<Integer>();    	
    	
    	for(int i=0;i<str.length;i++){
    		
    		if(str[i] == '('){
    			
    			//Add a helper node inside the stack to cal longest
    			if(stack.isEmpty()){
    				stack.push(i-1);
    			}    			
    			
    			stack.push(i);

    		}else if(str[i] == ')'){
    			
    			if(stack.size() > 1){    				
    					stack.pop();
    					longest = Math.max(longest, i-stack.peek()); 				

    			}else{
    				//Stack is empty, move over
    				if(stack.size()==1){
    				    stack.clear();
    				}		
    			}
    			    			
    		}else{
    			return longest;
    		}
   		
    	}    	
    	return longest;
    	
    }	
		
	
	
	public static void main(String[] args) {
		Solution032 s = new Solution032();
		String str = "(()()(()))))())))))()()()()()()";
		System.out.print(s.longestValidParentheses(str));
		
	}	
	
	
	
	
	
	
	
	
	
}
