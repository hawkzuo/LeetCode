package collectionEasyFirstHundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Amos on 2017/9/1.
 * Isomorphic Strings
 */
public class Sol205 {
    // No two characters may map to the same character but a character may map to itself.
    // Idea:    Use Map to store the mapping for different characters, then use an extra Set to check uniqueness
    // Example: 'paperp' 'titlte' => True
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {    return true; }
        if(s.length() != t.length()) {  return false;   }

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> selected = new HashSet<>();

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        for(int i=0; i<str1.length; i++) {
            char ch = str1[i];
            char mapped;

            if(mapping.containsKey(ch)) {
                mapped = mapping.get(ch);
                if(mapped != str2[i]) {
                    return false;
                }
            } else {
                // new mapping will be added
                mapped = str2[i];
                // Check 1-on-1 mapping
                if(selected.contains(mapped)) {
                    return false;
                }
                mapping.put(ch, mapped);
                selected.add(mapped);
            }
        }
        return true;
    }
}
