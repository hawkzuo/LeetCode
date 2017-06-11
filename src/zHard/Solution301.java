package zHard;
import java.util.*;
public class Solution301 {

	    public List<String> removeInvalidParentheses(String s) {
	        
	        
	        
	        List<String> resList = new ArrayList<String>();
	        if(s == null || s.length() == 0){   resList.add("");    return resList;}
	        Set<String> res = new HashSet<String>();
	        if(checkValid(s)){
	            resList.add(s);     return resList;
	        }
	             
	        Deque<String> queue = new ArrayDeque<String>(); 
	        queue.add(s);
	        while(! queue.isEmpty() ){
	            
	            Set<String> nextiters = new HashSet<String>();
	            //Bug2: Queue size is dynamic-based
	            int totalNum = queue.size();
	            for(int i=0; i<totalNum; i++){
	                //Perform BFS
	                String toSplit = queue.remove();
	                //Base Case
	                if( toSplit.length()<=1  ){
	                    resList.add("");    return resList;
	                }
	                //Now check
	                
	                char[] toCheck = toSplit.toCharArray();
	                for(int k=0;k<toCheck.length;k++){
	                    //Bug1: Forget to check valid removal character.
	                    if(toCheck[k] != ')' && toCheck[k] != '('){
	                        continue;
	                    }	                	
	                    String cV = formString(toCheck,k);
	                    if(checkValid(cV)){
	                        res.add(cV);
	                    }else{
	                        nextiters.add(cV);
	                    }
	                }
	              
	            }
	            
	            if(! res.isEmpty()){
	                //Stop the iteration
	                resList = new ArrayList<String>(res);   return resList;
	            }else{
	                for(String stt: nextiters){
	                    queue.offer(stt);
	                }
	            }
	            
	        }
	        
	        resList.add("");    return resList;
	        

	        
	    }
	    private String formString(char[] input, int rIndex){
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<input.length;i++){
	            if(i == rIndex){
	                continue;
	            }else{
	                sb.append(input[i]);
	            }
	        }
	        return sb.toString();
	    }

	    private boolean checkValid(String s){
	        char[] str = s.toCharArray();
	        int numLeft = 0;
	        for(int i=0;i<str.length;i++){
	            if(str[i] == '('){
	                numLeft++;
	            }else if(str[i] == ')'){
	                numLeft--;
	            }else{
	                continue;
	            }
	            if(numLeft < 0){
	                return false;
	            }
	        }
	        if(numLeft != 0){
	            return false;
	        }else{
	            return true;
	        }
	        
	    }

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String input = "(r(()()(";
			Solution301 s = new Solution301();
			System.out.println(s.removeInvalidParentheses(input));
		}

}
