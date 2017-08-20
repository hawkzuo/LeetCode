//242. Valid Anagram
//049
package companies.amazon;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution242 {

	public Solution242() {
		// TODO Auto-generated constructor stub
	}

	
    public boolean isAnagram(String s, String t) {
        
    	if(s == null && t == null){	
    		return true;
    	}else if(s == null || t == null){
    		return false;
    	}
    	
    	if(s.length() != t.length()){ return false;}
    	
    	
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        
        for(int i=0;i<sc.length;i++){        	
        	if(!m.containsKey(sc[i])){
        		m.put(sc[i], 1);       		
        	}else{
        		m.put(sc[i], m.get(sc[i])+1);
        	}       	        	
        }
        
        for(int i=0;i<tc.length;i++){
        	if(!m.containsKey(tc[i])){
        		return false;
        	}else{
        		if(m.get(tc[i]) <= 0){
        			return false;
        		}else{
        			m.put(tc[i], m.get(tc[i])-1);
        		}        		
        	}        	        	        	
        }
        
        return true;
        
    }	
    public boolean isAnagram2(String s, String t) {
        
    	if(s == null && t == null){	
    		return true;
    	}else if(s == null || t == null){
    		return false;
    	}
    	
    	if(s.length() != t.length()){ return false;}
        
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        //Quicksort trick swap 2 nums
        Arrays.sort(sc);
        Arrays.sort(tc);
        
        
        
        for(int i=0;i<sc.length;i++){        	
      	   if(sc[i] != tc[i]){
      		   return false;
      	   }
        }
        return true;

        
    }	
	
	
	
	
	
	
	
}
