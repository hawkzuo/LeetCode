package scatter;
import java.util.*;
public class Solution282Slow {

    int maxDepth;
    Map<String,Integer> store;
    public List<String> addOperators(String num, int target) {
        

        List<String> result = new ArrayList<String>();
        if(num == null || num.length() == 0){   return result;}
        char[] str = num.toCharArray();        
        maxDepth = str.length-1;
        store = new HashMap<String,Integer>();
        
        
        String[] refTable = new String[4];
        refTable[0] = "";   refTable[1] = "+"; refTable[2] = "-";  refTable[3] = "*";
        
        StringBuilder sb = new StringBuilder();
        dfsConstruct(sb,str,target,0,result,refTable,store);
        
        return result;
    }
    
    private void dfsConstruct(StringBuilder sb, char[] cstr, int target, int curDep, List<String> res, String[] refTable,
    		Map<String,Integer> store){
        
        if(curDep == maxDepth){
            
            sb.append(cstr[curDep]);
            String candidate = sb.toString();
            if(evaluate(candidate,target,store)){
                res.add(candidate);
            }
            sb.deleteCharAt(sb.length()-1);
            
        }else{
            sb.append(cstr[curDep]);
            for(int i=0;i<=3;i++){
                sb.append(refTable[i]);
                dfsConstruct(sb,cstr,target,curDep+1,res,refTable,store);
                if(i!=0){
                	sb.deleteCharAt(sb.length()-1);
            
                }
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }


    private boolean evaluate(String input, int target,Map<String,Integer> store){
        
        //General idea, parse only left values, once come across *, calculate first
    	//Whenever update lValue, save it.

        
        StringBuilder sb = new StringBuilder();

        
        int lValue = 0;     char lOper = '+';       
        int regValue = 0;   boolean regMul = false;

 //2 situations:
        StringBuilder refer = new StringBuilder(input);
        int bigLen = refer.length();	int refIndex = -1;	char last = '+';
        for(int i=bigLen-1;i>0;i--){
        	if(store.containsKey(refer.toString() ) && last !='*'){
        		refIndex = i;	break;
        	}else{
        		last = refer.charAt(refer.length()-1);
        		refer.deleteCharAt(refer.length()-1);
        	}
        }
        if(refIndex != -1){
        	String leftover = "0"+input.substring(refIndex+1);
        	String[] actions = leftover.split("(?<=[*+-])"); 
        	int Len = actions.length;
        	actions[actions.length-1] = actions[actions.length-1]+"+";
        	lValue = store.get(refer.toString());
        	
        	sb.append(refer);
	        for(int i=0;i<Len;i++){
		           if(actions[i].charAt(0) == '0' && actions[i].length() > 2){
		        	   return false;
		           }
		           if(i == 0){
		        	   sb.append(actions[i].substring(1));
		           }else{
		        	   sb.append(actions[i]);
		           }
		           
		           
		           int curVal = Integer.valueOf(actions[i].substring(0,actions[i].length()-1));
		           char curOp = actions[i].charAt(actions[i].length()-1);
		           
		           if(regMul){
		               if(curOp == '*'){
		                   regValue = regValue*curVal;
		                   
		               }else{
		                   regValue = regValue*curVal;
		                   if(lOper == '+'){
		                       lValue = lValue + regValue;
		                   }else{
		                       lValue = lValue - regValue;
		                   }
		                   
		                   regValue = 0;    regMul = false;
		                   lOper = curOp;
		                   
		                   store.put(sb.substring(0,sb.length()-1), lValue);
		                   
		               }
		           }else{
		               if(curOp == '*'){
		                   regValue = curVal;   
		                   regMul = true;
		                   //Special treatment
		                   if(i == 0){
		                	   regValue = lValue;
		                	   lValue = 0;
		                   }
		               }else{
		                   if(lOper == '+'){
		                       lValue = lValue + curVal;
		                   }else{
		                       lValue = lValue - curVal;
		                   }  
		                   lOper = curOp;
		                   
		                   store.put(sb.substring(0,sb.length()-1), lValue);
		               }               
		           }   
		        }        	
        	
        	
        	
        	
        	
        }else{
        
            String[] actions = input.split("(?<=[*+-])"); 
            int Len = actions.length;                         
            if(Len == 1){
            	return false;
            }
            actions[Len-1] = actions[Len-1]+"+";
            
	        for(int i=0;i<Len;i++){
	           if(actions[i].charAt(0) == '0' && actions[i].length() > 2){
	        	   return false;
	           }
	           
	           sb.append(actions[i]);
	           int curVal = Integer.valueOf(actions[i].substring(0,actions[i].length()-1));
	           char curOp = actions[i].charAt(actions[i].length()-1);
	           
	           if(regMul){
	               if(curOp == '*'){
	                   regValue = regValue*curVal;
	                   
	               }else{
	                   regValue = regValue*curVal;
	                   if(lOper == '+'){
	                       lValue = lValue + regValue;
	                   }else{
	                       lValue = lValue - regValue;
	                   }
	                   
	                   regValue = 0;    regMul = false;
	                   lOper = curOp;
	                   
	                   store.put(sb.substring(0,sb.length()-1), lValue);
	                   
	               }
	           }else{
	               if(curOp == '*'){
	                   regValue = curVal;   regMul = true;
	                   
	               }else{
	                   if(lOper == '+'){
	                       lValue = lValue + curVal;
	                   }else{
	                       lValue = lValue - curVal;
	                   }  
	                   lOper = curOp;
	                   
	                   store.put(sb.substring(0,sb.length()-1), lValue);
	               }               
	           }   
	        }
        }
	        
        return lValue == target;
        
    }

	public static void main(String[] args) {
		
		
	}
}
