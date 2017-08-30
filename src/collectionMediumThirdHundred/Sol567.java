package collectionMediumThirdHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/30.
 * Permutation in String
 */
public class Sol567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null  || s1.length() > s2.length()) {    return false;    }
        if(s1.length() == 0) {  return true;}

        Map<Character, Integer> refer = breakDown(s1);

        int index = 0;  char[] str = s2.toCharArray();
        String corpus = s2.substring(index, index + s1.length());
        // Adding => value --
        // Removing => value ++
        int matchedCount = 0;

        for(char ch: corpus.toCharArray()) {
            if(refer.containsKey(ch)) {
                int times = refer.get(ch);
                if(times - 1 == 0) {
                    matchedCount ++;
                }
                refer.put(ch, times-1);
            }
        }
        if(matchedCount == refer.size()) {
            return true;
        }
        index ++;

        while(index + s1.length() -1 < str.length) {
            char toRemove = str[index-1];
            char toAdd = str[index + s1.length() -1];

            if(refer.containsKey(toRemove)) {
                int times = refer.get(toRemove);
                if(times  == 0) {
                    matchedCount --;
                }
                refer.put(toRemove, times+1);
            }
            if(refer.containsKey(toAdd)) {
                int times = refer.get(toAdd);
                if(times - 1 == 0) {
                    matchedCount ++;
                }
                refer.put(toAdd, times-1);
            }
            if(matchedCount == refer.size()) {
                return true;
            }
            index ++;
        }

        return false;

    }

    private Map<Character, Integer> breakDown(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: input.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }
}
