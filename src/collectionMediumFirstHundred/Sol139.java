package collectionMediumFirstHundred;

import java.util.List;

/**
 * Created by Amos on 2017/8/10.
 * Word Break
 */
public class Sol139 {
    int [] flags;

    public boolean wordBreak(String s, List<String> wordDict) {
        flags = new int[s.length()+1];
        flags[s.length()] =1;

        return match(s, wordDict, 0) > 0;
    }

    private int match(String s, List<String> dict, int cur){
        // Base case is cur == s.length()
        if(flags[cur] != 0){
            return flags[cur];
        }
        int res = 0;
        // Try all the possible words in the dictionary to match the string beginning with index 'cur'
        for( String str : dict){
            int step;
            if ((s.length() - cur) >= str.length()) {
                if ( s.substring(cur,cur+str.length()).equals(str) ){
                    step = match(s,dict,cur+str.length());
                    res = Math.max(res,step);
                }
            }
        }

        if(res == 1){
            flags[cur] = 1;
        }else{
            flags[cur] = -1;
        }
        return res;
    }
}
