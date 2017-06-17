package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/6/17.
 * Palindrome Permutation
 */
public class ESolution266 {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() <= 1){   return true;}

        char [] str = s.toCharArray();
        Map<Character,Integer> table = new HashMap<>();

        for(int i=0;i<str.length;i++){
            if(table.containsKey(str[i])){
                table.put(str[i],table.get(str[i])+1);
            }else{
                table.put(str[i],1);
            }
        }
        int oddCount = 0;

        for(Character ch: table.keySet()){
            if(table.get(ch) % 2 != 0){ oddCount ++;}
            if(oddCount >= 2){  return false;}
        }
        return true;
    }
}
