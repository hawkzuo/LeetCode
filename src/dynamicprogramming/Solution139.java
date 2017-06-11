package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class Solution139 {

	public Solution139() {
		// TODO Auto-generated constructor stub
	}
	   
    int [] flags;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        flags = new int[s.length()+1];
        flags[s.length()] =1;
        
        if(match(s,wordDict,0) > 0){
            return true;
        }else{
            return false;
        }
    }
    private int match(String s, List<String> dict, int cur){
        if(flags[cur] != 0){
            return flags[cur];
        }
        int res = 0;
        for( String str : dict){
            int step = 0;
            if( (s.length() - cur) < str.length() ){
                continue;
            }else if ( s.substring(cur,cur+str.length()).equals(str) ){
                step = match(s,dict,cur+str.length());
                res = Math.max(res,step);
            }

        }
        /* Must use memoization	*/
        if(res == 1){
            flags[cur] = 1;
        }else{
            flags[cur] = -1;
        }        
        return res;        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution139 s = new Solution139();
		List<String> wordDict = Arrays.asList("leet","code");
		System.out.println(s.wordBreak("leetleet", wordDict));
		
	}

}
