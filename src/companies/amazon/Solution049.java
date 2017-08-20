//49. Group Anagrams
//438 266 249
package companies.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution049 {

	public Solution049() {
		// TODO Auto-generated constructor stub
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
            	
    	Map<String,List<String>> m = new HashMap<String,List<String>>();
    	//loop takes O(n) time
    	for(String str : strs){
    		
    		//key takes O(mlogm) time
    		char [] temp = str.toCharArray();
    		Arrays.sort(temp);
    		String key = new String(temp);
    		
    		if(!m.containsKey(key)){
    			
    			List<String> nlist = new LinkedList<String>();
    			nlist.add(str);
    			m.put(key, nlist);
     			
    		}else{
    			
    			List<String> fetched = m.get(key);
    			fetched.add(str);
    			
    		}
    		
    		
    	}
    	
    	List<List<String>> res = new LinkedList<List<String>>(m.values());
    	
    	for(String k : m.keySet()){    		
    		res.add(m.get(k));    	  		
    	}  	    	
    	return res;
   }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
