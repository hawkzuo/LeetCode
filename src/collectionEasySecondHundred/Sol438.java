package collectionEasySecondHundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amos on 2017/8/29.
 * Find All Anagrams in a String
 */
public class Sol438 {
    // Idea: First try Brute-force but TLE
    // Then use sliding window
    // Instead of using a map, an array can also be used since the letters count is only 26

    // Remove from window => key += 1
    // Add to window => key -= 1
    // Stores diff with target
    // ZerosCount = 0
    // a(1) b(1) c(1)       0
    // a(1) b(1) c(-2)      0
    // a(1) b(0) c(-1)      1
    // a(0) b(0) c(0)       3
    // a(0) b(0) c(1)       2

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) {   return result;  }
        Map<Character, Integer> refer = breakDown(p);
        int matchedCount = 0;
        char[] str = s.toCharArray();

        int index = 0;
        String window = s.substring(index, index + p.length());
        // Initialize the window
        for(char ch: window.toCharArray()) {
            if(refer.containsKey(ch)) {
                int times = refer.get(ch);
                if(times -1 == 0) {
                    matchedCount ++;
                }
                refer.put(ch, times-1);
            }
        }
        if(matchedCount == refer.size()) {
            result.add(index);
        }
        index ++;

        // Then loop over all the possible substrings 'str' can have
        while(index + p.length() - 1 < s.length()) {
            char toRemove = str[index-1];
            char toAdd = str[index + p.length() - 1];
            if(refer.containsKey(toRemove)) {
                int times = refer.get(toRemove);
                if(times == 0) {
                    matchedCount --;
                }
                refer.put(toRemove, times+1);
            }
            if(refer.containsKey(toAdd)) {
                int times = refer.get(toAdd);
                if(times -1 == 0) {
                    matchedCount ++;
                }
                refer.put(toAdd, times-1);
            }
            // Use refer.size() not p.length()
            if(matchedCount == refer.size()) {
                result.add(index);
            }
            index ++;
        }

        return result;
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
