
//224. Basic Calculator
package scatter;

public class Solution224v {

	int cursor = 0;

    public int calculate(String s) {
        
    	StringBuilder resbd = cal(s);

    	return Integer.valueOf(resbd.toString());

    }
    
    private StringBuilder cal(String s){   	
    	StringBuilder sb = new StringBuilder();	
    	while(cursor<s.length()){
    		if(s.charAt(cursor) == ' '){
    			cursor++;
    			continue;
    		}else if(s.charAt(cursor) == ')'){
    			cursor++;
    			break;
    		}else if(s.charAt(cursor) == '('){
    			cursor++;
    			StringBuilder sub = cal(s);
    			//First Handle the sb.length == 0 case
    			if(sb.length() <2){
    				if(sub.charAt(0) == '-'){
    					sub.insert(0, 0);
    				}    				
    			}else{  			    			
	    			//Handle the negative number case
	    			if(sub.charAt(0) == '-'){
	    				if (sb.charAt(sb.length()-1) == '+'){
	    					sb.delete(sb.length()-1, sb.length());
	    				}else{
	    					sb.delete(sb.length()-1, sb.length());
	    					sub.delete(0, 1);
	    					sb.append("+");
	    				}
	    			} 
    			} 			
    			sb.append(sub);
    			
    		}else{
    			sb.append(s.charAt(cursor));
    			cursor++;
    		}
    	}
    	StringBuilder res = evaluate(sb.toString());    	
    	return res;   	
    }
    
    private StringBuilder evaluate(String str){
    	String[] dummy = str.split("(?<=[+-])");
    	char operator = '+';
    	int sum = 0;
    	for(int i=0;i<dummy.length;i++){
    		if(i == dummy.length-1){
    			int operrand = Integer.valueOf(dummy[i]);
    			sum = perform(sum,operrand,operator);
    		}else{
    			int operrand = Integer.valueOf(dummy[i].substring(0, dummy[i].length()-1));
    			sum = perform(sum,operrand,operator);
    			operator = dummy[i].charAt(dummy[i].length()-1);
    		}
    	}      	
    	String resstr = Integer.toString(sum);
    	return new StringBuilder(resstr); 	
    }
   
    private int perform(int l, int r, char op){
        if(op == '+'){
            return l+r;
        }else if(op == '-'){
            return l-r;
        }else{
            return Integer.MAX_VALUE;   
        }
    }   
  
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution224v s = new Solution224v();
		System.out.println(s.calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));
		
	}
}
