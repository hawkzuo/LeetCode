package trie;
import java.util.*;
public class Solution472 {

	public Solution472() {
		// TODO Auto-generated constructor stub
	}
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
  	
    	List<String> res = new ArrayList<String>();
    	if(words == null || words.length <=1){	return res;}
    	Trie tr = new Trie();
    	for(String dummy: words){
    		if(dummy == null || dummy.length() == 0){	continue;}
    		tr.insert(dummy);
    	}
    	
    	for(String word: words){
    		if(word == null || word.length() <=1){	continue;}
    		dpSolve(word,tr,res);
    		
    	}
    	
    	
    	return res;
    	
    }
	private void dpSolve(String word, Trie tr, List<String> res) {
		// TODO Auto-generated method stub
		int len = word.length();
		if(dpTop(word,tr,1,len)){
			res.add(word);
		}
/*		int[] table = new int[len+1];
		if(tr.search(word.substring(len-1, len))){
			table[len]=1;
		}else{
			table[len] = 0;
		}
		
		for(int i=len-1;i>0;i--){			
			int candidate = 0;
			for(int cursor = i;cursor<len;cursor++){
				if(tr.search(word.substring(i-1,cursor)) && table[cursor+1]>0){
					candidate = Math.max(candidate, 1+table[cursor+1]);
				}
			}
			if(tr.search(word.substring(i-1,len))){
				candidate = Math.max(candidate, 1);
			}
			table[i] = candidate;
		}
		
		if(table[1] >=2){
			res.add(word);
		}
*/ 		
	}
   
	//Use top-down dp && optimization
	private boolean dpTop(String word, Trie tr, int i, int max){
		boolean ans = false;
		if(i == max){
		    if(tr.search(word.substring(i-1,max))){
		        return true;
		    }else{
		        return false;
		    }
		}
		for(int cursor = i; cursor<max; cursor++){
			if(tr.search(word.substring(i-1,cursor)) && tr.search(word.substring(cursor,max))){
				return true;
			}else if(tr.search(word.substring(i-1,cursor)) ){
				ans= dpTop(word,tr,cursor+1,max);
				if(ans){	return ans;}
			}else{
				
			}
		}
		return ans;		
	}
	
	
	
	
	
	public static void main(String[] args) {
		Solution472 s = new Solution472();
		String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa"};
		
		System.out.println(s.findAllConcatenatedWordsInADict(words));
		
	}
    
    
    
    
    
    
}
