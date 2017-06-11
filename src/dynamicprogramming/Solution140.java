package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution140 {

	public Solution140() {
		// TODO Auto-generated constructor stub
	}
    int [] flags;
    List<String> [] parents;
    List<String> resultString;
    // Change to bottom-up Solution 
    
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        flags = new int[s.length()+1];
        flags[0] =1;
        resultString = new ArrayList<String>();
        parents = new ArrayList[s.length()+1];
        for(int i=0;i<parents.length;i++){
        	parents[i] = new ArrayList<String>();
        }
        //Second trial: Use hashmap
        Map<Integer,List<String>> table = new HashMap<Integer,List<String>>();
        for(String str: wordDict){
        	if(!table.containsKey(str.length())){
        		List<String> dm = new ArrayList<String>();
        		dm.add(str);
        		table.put(str.length(), dm);
        	}else{
        		table.get(str.length()).add(str);
        	}
        }       
       
        for(int i=1;i<=s.length();i++){
        	for(int j=i-1;j>=0;j--){
        		if(flags[j] != 1){
        			continue;
        		}
        		//Try all possible situations
        		if(!table.containsKey(i-j)){
        		    continue;
        		}
        		for(String str: table.get(i-j)){
                	//change here
        			if(str.length() > (i-j)){
                		continue;
                	}         			
                	if (s.substring(j,i).equals(str)){             		
                		parents[i].add(str);
                		flags[i] = 1;
                	}
                }        		
        	}        	
        }
      //Third trial: separate construct back from marking
        if(s.length() == 0){
        	return new ArrayList<String>();
        }else{
        	resultString = cPath(s.length());
        	return resultString;
        }

    }
 
    
    public List<String> cPath(int left){
    	List<String> res = new ArrayList<String>();
    	
    	for(String cur:parents[left]){   		
    		if(cur.length() == left){
    			res.add(cur);
    		}else{
    			List<String> prev = cPath(left-cur.length());
    			for(String pre:prev){
    				res.add(pre+" "+cur);
    			}
    		}
    	}
    	return res;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution140 s = new Solution140();
		List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaacaaaaaaaaaaa", wordDict).size());
		System.out.println();
	}

}
