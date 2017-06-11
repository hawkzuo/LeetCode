package scatter;
import java.util.*;

public class Solution030Wrong {
    public List<Integer> findSubstring(String s, String[] words) {
        
        //Duplicates are allowed in words.
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || words == null || words[0].length() == 0 || s.length()< words[0].length()*words.length ){ return res;}
        
        //Pre processing words:
        int step = words[0].length();   int totalCount = words.length;
        Map<String,Integer> ndup = new HashMap<String,Integer>();
        for(String word : words){
            if(ndup.containsKey(word)){
                ndup.put(word,ndup.get(word)+1);
            }else{
                ndup.put(word,1);
            }
        }
        
        //Find first window     Use another map to record the operations on the data
        Map<String,Integer> useRef = new HashMap<String,Integer>();
        StringBuilder str = new StringBuilder(s);   int bIndex = 0;     int curCount = 0;   int beginWindow = -1;
        
        while(bIndex + (totalCount-curCount) *step <= str.length() ){
            if(curCount == 0){
                String toCheck = str.substring(bIndex,bIndex+step);
                if(ndup.containsKey(toCheck)){
                    int avalCount = ndup.get(toCheck);
                    if(avalCount >= 1){
                        //Good
                        if(!useRef.containsKey(toCheck)){
                            useRef.put(toCheck,1);
                        }else{
                            useRef.put(toCheck,1+useRef.get(toCheck));
                        }
                        ndup.put(toCheck,avalCount-1);
                        
                        curCount ++;
                        beginWindow = bIndex;
                        bIndex +=step;
                        
                    }else{
                        //Stop and reset    actually this shouldn't happen
                        resetMap(ndup,useRef);
                    }
                }else{
                    bIndex ++;
                }
                
                
            }else if(curCount < totalCount){
                String toCheck = str.substring(bIndex,bIndex+step);
                if(ndup.containsKey(toCheck)){
                    int avalCount = ndup.get(toCheck);
                    if(avalCount >= 1){
                        //Good
                        if(!useRef.containsKey(toCheck)){
                            useRef.put(toCheck,1);
                        }else{
                            useRef.put(toCheck,1+useRef.get(toCheck));
                        }
                        ndup.put(toCheck,avalCount-1);
                        
                        curCount ++;
                        bIndex +=step;
                        
                    }else{
                        //Stop and reset and don't increase the bIndex	--Bug
                    	//Must use some small tricks
                    	
                        resetMap(ndup,useRef);
                        //Mimic the process
                        int nCount = 0;	
                        //Pre "add" this dummy node
                        ndup.put(toCheck,ndup.get(toCheck)-1);
                        useRef.put(toCheck, 1+useRef.get(toCheck));
                        //Find the intersection point
                        for(int i=0;i<curCount;i++){
                        	String dm = str.substring(bIndex-step*(1+i), bIndex-step*(i));
                        	int avldm = ndup.get(dm);
                        	if(avldm >=1){
                        		//Keep going left
                        		useRef.put(dm,1+useRef.get(dm));
                        		ndup.put(dm,avldm-1);
                        		nCount++;
                        	}else{
                        		//Max possible subWindow found
                        		break;
                        	}
                        }
                        //Remove the dummy node
                        ndup.put(toCheck,ndup.get(toCheck)+1);
                        useRef.put(toCheck, useRef.get(toCheck)-1);  
                        
                        curCount = nCount;
                        if(nCount == 0){	beginWindow = -1;}
                        else{	beginWindow =bIndex-step*nCount;}
                        
                    }
                }else{
                    //Stop and reset and increase the bIndex
                    resetMap(ndup,useRef);
                    curCount = 0;
                    beginWindow = -1;
                    bIndex +=step;
                }                
                
            }else{
                //Now that curCount == totalCount
                if(beginWindow != -1){  res.add(beginWindow);}
                if(bIndex + step > str.length()){
                    //Add these lines to check for strange cases.
                    for(int cursor = beginWindow+1;cursor<beginWindow+1+str.length()-bIndex;cursor++){
                    	if(checkValid(str,cursor,step,useRef,totalCount)){
                    		res.add(cursor);
                    	}
                    }                	
                	                	
                	beginWindow = -1;
                    break;
                }
                
                //Add these lines to check for strange cases.
                for(int cursor = beginWindow+1;cursor<beginWindow+step;cursor++){
                	if(checkValid(str,cursor,step,useRef,totalCount)){
                		res.add(cursor);
                	}
                }
                
                
                if(str.substring(bIndex,bIndex+step).equals(str.substring(beginWindow,beginWindow+step)) ){
                    //window successful shifted
                    beginWindow +=step;
                    bIndex +=step;
                }else{
                    //Restart process and don't increase the bIndex
                        resetMap(ndup,useRef);
                        curCount = 0;
                        beginWindow = -1;                    
                }
            }
        }
        if(curCount == totalCount && beginWindow != -1){	res.add(beginWindow);}
        
        
        return res;
    }
    
    private boolean checkValid(StringBuilder str, int cursor, int step, Map<String, Integer> ndup,int tCount) {
		// TODO Auto-generated method stub
    	StringBuilder toCheck = new StringBuilder(str.substring(cursor,cursor+step*tCount));
    	Map<String,Integer> useRef = new HashMap<String,Integer>();
    	for(int i=0;i<tCount;i++){
    		String tC = toCheck.substring(i*step,i*step+step);
    		if(ndup.containsKey(tC)){
    			int avltm = ndup.get(tC);
    			if(avltm >= 1){
    				ndup.put(tC, avltm-1);
    				if(useRef.containsKey(tC)){
    					useRef.put(tC, 1+useRef.get(tC));
    				}else{
    					useRef.put(tC, 1);
    				}
    			}else{
    				//Return false;
    				for(String key:useRef.keySet()){
    					ndup.put(key, ndup.get(key)+useRef.get(key));
    				}
    				return false;
    			}
    		}else{
				for(String key:useRef.keySet()){
					ndup.put(key, ndup.get(key)+useRef.get(key));
				}
				return false;    			
    		}
    	}    	
		for(String key:useRef.keySet()){
			ndup.put(key, ndup.get(key)+useRef.get(key));
		}  	
		return true;
	}

	private void resetMap(Map<String,Integer> ndup, Map<String,Integer> useRef){
        for(String key: useRef.keySet()){
            int cgs = useRef.get(key);
            ndup.put(key,ndup.get(key)+cgs);
            useRef.put(key,0);
        }
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "goodwordgoodgoodbestword";
		String[] words = {"word","good","good","best"};
		Solution030Wrong s = new Solution030Wrong();
		System.out.println(s.findSubstring(input, words));
	}    
}
