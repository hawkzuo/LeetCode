package threesums;

import java.util.HashMap;
import java.util.Map;

public class ValidWordAbbr {
//Ambiguous definition
	
	
	
	
	Map<String, Integer> map = new HashMap<String,Integer>()	;			
	public ValidWordAbbr(String[] dictionary) {
		// TODO Auto-generated constructor stub
		for(String str : dictionary){			
			if(str == null || str.length() == 0){
				continue;								
			}else if (str.length() <= 2){
				addStr(str);
				
			}else{				
				String s = str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
				addStr(s);				
			}						
			//String.valueOf(i)			
		}		
	}
	private void addStr(String s){
		if(!map.containsKey(s)){
			map.put(s, 1);			
		}else{
			map.put(s, map.get(s)+1);						
		}		
	}

	
    public boolean isUnique(String word) {
		if(word == null || word.length() == 0){
			return false;								
		}else if (word.length() <= 2){
			if(!map.containsKey(word)){
				return true;		
			}else{
				return false;			
			}			
		}else{				
			String s = word.charAt(0)+Integer.toString(word.length()-2)+word.charAt(word.length()-1);
			if(!map.containsKey(s)){
				return true;		
			}else{
				return false;			
			}			
		}	            	
    }
    
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
