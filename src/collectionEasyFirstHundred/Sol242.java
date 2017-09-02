package collectionEasyFirstHundred;

import java.util.Arrays;

/**
 * Created by Amos on 2017/9/4.
 * Valid Anagram
 */
public class Sol242 {
    // Idea: Sort => O(nlogn) with O(1) memory
    //       Map  => O(n) time O(n) memory
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return s == null && t == null;
        }
        if(s.length() != t.length()){ return false;}

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);

        for(int i=0;i<sc.length;i++){
            if(sc[i] != tc[i]){
                return false;
            }
        }
        return true;
    }
}
