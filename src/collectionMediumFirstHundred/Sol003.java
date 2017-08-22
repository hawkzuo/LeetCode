package collectionMediumFirstHundred;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/7/12.
 * Longest Substring Without Repeating Characters
 */
public class Sol003 {
    public int lengthOfLongestSubstring(String s) {
        //O(n) scan only once
        if(s == null){  return 0;}
        if(s.length() <= 1){    return s.length();  }

        char[] input = s.toCharArray();
        Set<Character> window = new HashSet<>();

        int l=0, r = 0;
        int maxLength = 1;

        while(r < input.length) {
            maxLength = Math.max(maxLength, window.size());
            if (window.contains(input[r])) {
                while(window.contains(input[r])){
                    window.remove(input[l]);
                    l++;
                }
            }
            window.add(input[r]);
            r++;
        }
        maxLength = Math.max(maxLength, window.size());
        return maxLength;
    }
    public static void main(String[] args) {
        Sol003 s = new Sol003();
        System.out.print(s.lengthOfLongestSubstring("au"));
    }

}
