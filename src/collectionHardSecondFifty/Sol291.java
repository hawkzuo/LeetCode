package collectionHardSecondFifty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/9/1.
 * Word Pattern II
 */
public class Sol291 {
    // Idea: Brute-force matching any possible combinations scope by scope
    // Use backtracking when two Maps have been modified

    public boolean wordPatternMatch(String pattern, String str) {
        // Annoying corner cases
        if(pattern.length() == 0 || str.length() ==0) {
            return pattern.length() == 0 && str.length() == 0;
        }

        char[] pt = pattern.toCharArray();

        Map<Character, String> mapping = new HashMap<>();
        Map<String, Character> reversedMap = new HashMap<>();

        return tryThemAll(0, 0, mapping, reversedMap, pt, str, pt.length, str.length());
    }

    private boolean tryThemAll(int pIndex, int strIndex,
                               Map<Character, String> mapping, Map<String, Character> reversedMap,
                               char[] pt, String str,
                               int patternLen, int strLen) {
        // Base case:
        if(pIndex + 1 == patternLen) {
            // This checking leads to bug for 'b' 'g', really my fault
            if(strIndex == strLen) {    return false;   }
            char stepPattern = pt[pIndex];
            String mappedString = str.substring(strIndex);
            // Two cases:
            if(mapping.containsKey(stepPattern)) {
                // The pattern has already been mapped  =>  Check same or not
                String reference = mapping.get(stepPattern);
                return reference.equals(mappedString);
            } else {
                // No mapping existing, check bijection
                return !reversedMap.containsKey(mappedString);
            }
        }

        // Try them all:
        char stepPattern = pt[pIndex];
        boolean answer = false;
        for(int possibleEnd = strIndex+1; possibleEnd < strLen; possibleEnd ++) {
            String mappedString = str.substring(strIndex, possibleEnd);
            // Two cases:
            if(mapping.containsKey(stepPattern)) {
                // The pattern has already been mapped
                String reference = mapping.get(stepPattern);
                if(!reference.equals(mappedString)) {
                    // Matching failed, goto next loop
                    continue;
                }
                // Proceed to next step
                answer = tryThemAll(pIndex+1, possibleEnd, mapping, reversedMap, pt, str, patternLen, strLen);
                // BT is not needed because nothing changes on Maps
            } else {
                // No mapping, create one and checking
                if(reversedMap.containsKey(mappedString)) {
                    // Already mapped by other patterns, goto next loop
                    continue;
                }
                // Add to maps
                reversedMap.put(mappedString, stepPattern);
                mapping.put(stepPattern, mappedString);
                // Proceed to next
                answer = tryThemAll(pIndex+1, possibleEnd, mapping, reversedMap, pt, str, patternLen, strLen);
                // BT is needed
                reversedMap.remove(mappedString);
                mapping.remove(stepPattern);
            }
            if(answer) {    return true;}
        }
        return false;
    }
}
