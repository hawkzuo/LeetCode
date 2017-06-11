package zHard;
import java.util.*;
public class Solution420 {
    public int strongPasswordChecker(String s) {
    	if(s == null){	return 6;}
    	if(s.length() <=2){	return 6-s.length();}
    	
    	/*Part I:	Transform to List Representation	*/
    	
    	//Best case required replacing times
    	Map<Integer,Integer> bestRep = new HashMap<Integer,Integer>();
    	for(int i=1;i<=7;i++){
    		bestRep.put(i*3-1, i-1);
    	}
    	   	
    	char[] input = s.toCharArray();
    	List<Integer> repeated = getRepeated(input);
    	int hasDigit = repeated.remove(repeated.size()-1);
    	int hasUpper = repeated.remove(repeated.size()-1);
    	int hasLower = repeated.remove(repeated.size()-1);
    	//Get the minimum unsatisfied conditions number
    	int minRep = (3-hasDigit-hasUpper-hasLower);
    	
    	if(s.length() < 6){
    		//Only 2 situations:	Either 1 repeated sequence	or none   		 
    		if(repeated.size() == 1){
    			int repCount = repeated.get(0);
    			int requiredCut = 1;
    			if(repCount == 5){    				
    				requiredCut = 2;
    				if(minRep == 3){
    					//Handle '*****' case
    					return minRep;
    				}else{
    					//Handle 'aaaaa' case
    					return requiredCut;
    				}
    			}else{
    				//At most 'aaaa'
        			if(minRep + s.length() <=6){
        				return 6-s.length();
        			}else{
        				return minRep;
        			}    				
    			}   			
    		}else{
    			//Handle minRep
    			if(minRep + s.length() <=6){
    				return 6-s.length();
    			}else{
    				return minRep;
    			}
    		}
    	}else if(s.length() <= 20){
    		//Apply replacement
    		int rCounter = 0;
    		for(int i=0;i<repeated.size();i++){
    			int curDup = repeated.get(i);
    			int stepsReq = -1;
    			if(bestRep.containsKey(curDup)){
    				stepsReq = bestRep.get(curDup);
    			}else if(bestRep.containsKey(curDup+1)){
    				stepsReq = bestRep.get(curDup+1);
    			}else{
    				stepsReq = bestRep.get(curDup+2);
    			}
    			rCounter+=stepsReq;
    		}
    		//2 cases:
    		return Math.max(minRep, rCounter);

    	}else{
    		//This case is annoying
    		int mustRemove = s.length()-20;
    		//Check two possibles
    		int[] bests = new int[repeated.size()];
    		int s1Rem = 0;
    		
    		for(int i=0;i<repeated.size();i++){
    			int curDup = repeated.get(i);
    			int stepsReq = 0;
    			if(bestRep.containsKey(curDup)){
    				stepsReq = 0;
    			}else if(bestRep.containsKey(curDup-1)){
    				stepsReq = 1;
    			}else{
    				stepsReq = 2;
    			}  
    			bests[i] = stepsReq;
    			s1Rem += stepsReq;
    		}
    		
    		if(s1Rem < mustRemove){
    			//Good Process next steps
    			ListIterator<Integer> it = repeated.listIterator();
    			int iIndex=0;
    			while(it.hasNext()){
    				int curval = it.next();
    				if(curval - bests[iIndex] == 2){
    					it.remove();
    				}else{
    					it.set(curval - bests[iIndex]);
    				}
    				iIndex++;
    			}
    			//Move to iterations
    			mustRemove = mustRemove - s1Rem;
    			int lSize = repeated.size();
    			while(mustRemove-3*lSize >= 0){
    				//Repeat
    				if(lSize == 0){
    					break;
    				}
    				mustRemove -=3*lSize;
    				it = repeated.listIterator();
    				while(it.hasNext()){
        				int curval = it.next();
        				if(curval  == 5){
        					it.remove();
        				}else{
        					it.set(curval - 3);
        				}    					
    				}  
        			lSize = repeated.size();
    			}
    			/*Bug1: The "lSize" must be checked 	*/
    			if(mustRemove == 0 || lSize == 0){
    				//Add up
    				/*Bug2: The "minRep" must be checked 	*/
    				int total = s.length()-20;
    				int sum=0;
        			for(int i=0;i<repeated.size();i++){
        				sum+=bestRep.get(repeated.get(i));
        			}
        			return total+Math.max(sum, minRep);    				
    			}else{
    				//Last iteration
    				it = repeated.listIterator();
    				lSize = repeated.size();
    				while(it.hasNext() && mustRemove >= 3 ){
        				int curval = it.next();
        				if(curval  == 5){
        					it.remove();
        				}else{
        					it.set(curval - 3);
        				}   
        				mustRemove -= 3;
    				}
    				//Add up
    				int total = s.length()-20;
    				int sum=0;
        			for(int i=0;i<repeated.size();i++){
        				sum+=bestRep.get(repeated.get(i));
        			}
        			return total+Math.max(sum, minRep);     				
    			}
    			
    		}else if(s1Rem == mustRemove){
    			//It's done
    			for(int i=0;i<repeated.size();i++){
    				repeated.set(i, repeated.get(i)-bests[i]);
    			}
				int total = s.length()-20;
				int sum=0;
    			for(int i=0;i<repeated.size();i++){
    				sum+=bestRep.get(repeated.get(i));
    			}
    			return total+Math.max(sum, minRep); 
    		}else{
    			//It's done
    			int Ones = 0;
    			for(int i=0;i<bests.length;i++){
    				if(bests[i] == 1){
    					Ones++;
    				}
    			}
    			int rones = 0;	int rtwos = 0;
    			if(Ones >= mustRemove){
    				rones = mustRemove;
    			}else{
    				rones = Ones;
    				rtwos = (mustRemove-Ones)/2;    				
    			}
    			//Perform Removal
    			for(int i=0;i<bests.length;i++){
    				if(bests[i] == 1 && rones >0){
    					repeated.set(i, repeated.get(i)-bests[i]);
    					rones--;
    				}else if(bests[i] == 2 && rtwos >0){
    					repeated.set(i, repeated.get(i)-bests[i]);
    					rtwos--;
    				}
    			}
    			//Finally combine answer:   			
    			int total = mustRemove;
    			int sum=0;
    			for(int i=0;i<repeated.size();i++){
    				int curDup = repeated.get(i);
        			if(bestRep.containsKey(curDup)){
        				sum+= bestRep.get(curDup);
        			}else if(bestRep.containsKey(curDup+1)){
        				sum+= bestRep.get(curDup+1);
        			}else{
        				sum+= bestRep.get(curDup+2);
        			}     				    				
    			}
    			return total+Math.max(sum, minRep);   			
    		}
    	}
    }
    private List<Integer> getRepeated(char[] input){
    	//Use the last three bits to represent no lowercase, no uppercase, no digit
    	List<Integer> result = new ArrayList<Integer>();
    	char repeat = input[0];	int cV1 = repeat - '0';
    	
    	int i=1;	int counter = 1;
    	int hasLower = 0,hasUpper = 0,hasDigit = 0;
		if(cV1 >= 0 && cV1 <= 9){
			hasDigit = 1;
		}else if(cV1 >= 17 && cV1 <= 42){
			hasUpper = 1;
		}else if(cV1 >= 49 && cV1 <= 74){
			hasLower = 1;
		}    	
    	
    	
    	while(i<input.length){   		
    		char cur = input[i];
    		int cValue = cur-'0';
    		if(cValue >= 0 && cValue <= 9){
    			hasDigit = 1;
    		}else if(cValue >= 17 && cValue <= 42){
    			hasUpper = 1;
    		}else if(cValue >= 49 && cValue <= 74){
    			hasLower = 1;
    		}
    		
    		if(cur == repeat){
    			counter++;
    		}else{
    			if(counter >=3){
    				result.add(counter);
    				repeat = cur;
    				counter = 1;    				
    			}else{
    				repeat = cur;
    				counter = 1;
    			}
    		}
    		i++;
    	}
    	if(counter >=3){
    		result.add(counter);
    	}
    	result.add(hasLower);
    	result.add(hasUpper);
    	result.add(hasDigit);
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution420 s = new Solution420();
    	System.out.println(s.strongPasswordChecker("1Abababcaaaabababababa"));
    	System.out.println("1Abababcaaaabababababa".length());
    }
    
}
