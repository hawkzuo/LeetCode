package collectionEasyFirstHundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/9/6.
 * Palindrome Permutation
 */
public class Sol266 {
    // Idea: Sort first, and check how many odd times characters
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() <= 1){   return true;}
        char [] str = s.toCharArray();

        Arrays.sort(str);
        char prev = str[0];
        int counter = 1;
        int totalOddCount = 0;
        for(int i=1;i<str.length;i++) {
            char step = str[i];
            if(prev == step) {
                counter ++;
            } else {
                if(counter % 2 != 0) {
                    totalOddCount ++;
                }
                // Update prev
                prev = step;
                counter = 1;
                if(totalOddCount > 1) {
                    return false;
                }
            }
        }
        // Final take care
        if(counter % 2 != 0) {
            totalOddCount ++;
        }
        return totalOddCount <= 1;
    }

    // Old version: Use map to store how many times for every character and check 'odd' counts
    public boolean canPermutePalindromeOld(String s) {
        if(s == null || s.length() <= 1){   return true;}

        char [] str = s.toCharArray();
        Map<Character,Integer> table = new HashMap<>();

        for (char step : str) {
            if (table.containsKey(step)) {
                table.put(step, table.get(step) + 1);
            } else {
                table.put(step, 1);
            }
        }
        int oddCount = 0;
        for (Integer cur : table.values()) {
            if (cur % 2 != 0) {
                oddCount++;
            }
            if (oddCount >= 2) {
                return false;
            }
        }
        return true;
    }
}
