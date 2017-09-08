package collectionEasyFirstHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/9/1.
 * Word Pattern
 */
public class Sol290 {
    // Idea: bijecture meaning 1-on-1 matching
    //  Establish pattern -> word connection
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || pattern.length() == 0) {  return false;   }
        String[] words = str.split("\\s");

        char[] pt = pattern.toCharArray();
        if(pt.length != words.length) { return false; }

        Map<Character, String> mapping = new HashMap<>();
        Map<String, Character> reversedMap = new HashMap<>();

        for(int i=0;i<pt.length;i++) {
            char step = pt[i];
            if(mapping.containsKey(step)) {
                String mapped = mapping.get(step);
                if(!mapped.equals(words[i])) {
                    return false;
                }
            } else {
                if(reversedMap.containsKey(words[i])) {
                    return false;
                }
                reversedMap.put(words[i], step);
                mapping.put(step, words[i]);
            }
        }
        return true;
    }
}
