//20. Valid Parentheses
package companies.microsoft;

import java.util.Deque;
import java.util.LinkedList;

public class Solution020 {

	public Solution020() {
		// TODO Auto-generated constructor stub
	}
	
	
    public boolean isValid(String s) {
        
    	char [] str = s.toCharArray();
//    	Deque<Character> stack = new ArrayDeque<Character>();    	
    	Deque<Character> stack = new LinkedList<Character>();
    	
    	for(int i=0; i<str.length; i++){
    		if(isLeft(str[i])){    			
    			stack.push(str[i]);
    		}else if(isRight(str[i])){
    			
    			if(stack.isEmpty()){
    				return false;
    			}else{
    				char l = stack.pop();
    				if(!checkTwoChar(l,str[i])){
    					return false;
    				}    				    				
    			}   			    			
    			
    		}else{
    			return false;
    		}   		    		    		
    	}

    	if(stack.isEmpty()){
    		return true;
    	}else{
    		return false;
    	}   	
    	
    }	
	private boolean checkTwoChar(char c1, char c2){
		if(c1 == '(' && c2 == ')'){
			return true;
		}
		if(c1 == '{' && c2 == '}'){
			return true;
		}		
		if(c1 == '[' && c2 == ']'){
			return true;
		}	
		return false;
	}
    
    
    
    
    private boolean isLeft(char ch){
    	if(ch == '(' || ch == '{' || ch == '['){
    		return true;
    	}else{
    		return false;
    	}    	    	
    }
    
    private boolean isRight(char ch){
    	if(ch == ')' || ch == '}' || ch == ']'){
    		return true;
    	}else{
    		return false;
    	}    	    	
    }    
    
    
    
	
	public static void main(String[] args) {
		Solution020 s = new Solution020();
		String str = "((()(){[()()]}()))()";
		System.out.print(s.isValid(str));
		
	}
}
