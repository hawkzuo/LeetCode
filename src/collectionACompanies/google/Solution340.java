package collectionACompanies.google;

import java.util.HashMap;
import java.util.Map;

/**
 *  "Sliding window" Strategy
 * Created by Amos on 2017/6/10.
 */
public class Solution340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s == null || s.length() == 0){ return 0;}
        char[] input = s.toCharArray();
        Map<Character,Integer> window = new HashMap<>();

        int globalMax = 0;
        int curLength = 0;
        for(int i=0;i<input.length;i++){

            if(window.keySet().size() < k){
                curLength ++;
                if(window.containsKey(input[i])){
                    window.put(input[i],window.get(input[i])+1);
                }else{
                    window.put(input[i],1);
                }
            }else{
                if(window.containsKey(input[i])){
                    curLength ++;
                    window.put(input[i],window.get(input[i])+1);
                }else{
                    globalMax = Math.max(globalMax,curLength);
                    // Remove the chars to fit in the new character
                    for(int j=i-curLength;j<i;j++){

                        char toRemove = input[j];
                        int count = window.get(input[j]);
                        curLength --;
                        if(count == 1){
                            window.remove(toRemove);
                            break;
                        }else{
                            window.put(input[j],count-1);
                        }
                    }
                    curLength ++;
                    window.put(input[i],1);
                }
            }

        }
        globalMax = Math.max(globalMax,curLength);
        return globalMax;
    }

}
