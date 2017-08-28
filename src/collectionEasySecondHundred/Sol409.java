package collectionEasySecondHundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Amos on 2017/8/28.
 * Longest Palindrome
 */
public class Sol409 {
    // Idea: How to build a palindrome? Double characters & allow 1 single element in the middle

    // O(1n) method:
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){   return 0;}
        if(s.length() == 1){    return 1;}

        char [] str = s.toCharArray();
        Set<Character> availableChars = new HashSet<>();
        int result = 0;

        for(Character step: str) {
            if(availableChars.contains(step)) {
                result += 2;
                availableChars.remove(step);
            } else {
                availableChars.add(step);
            }
        }
        if(!availableChars.isEmpty()) {
            result += 1;
        }
        return result;
    }


    // Use Map version: O(2n)
    public int longestPalindromeViaMap(String s) {
        if(s == null || s.length() == 0){   return 0;}
        if(s.length() == 1){    return 1;}

        char [] str = s.toCharArray();
        Map<Character,Integer> table = new HashMap<>();

        for (char stepChar : str) {
            if (table.containsKey(stepChar)) {
                table.put(stepChar, table.get(stepChar) + 1);
            } else {
                table.put(stepChar, 1);
            }
        }

        int count = 0;      boolean addOffset = false;
        for(Character ch: table.keySet()){
            if(table.get(ch) % 2 == 0){
                count += table.get(ch);
            }else{
                addOffset = true;
                count += table.get(ch)-1;
            }
        }
        if(addOffset){  count ++;}
        return count;
    }


}
