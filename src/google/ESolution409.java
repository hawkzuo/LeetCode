package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/6/17.
 * Longest Palindrome
 */
public class ESolution409 {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){   return 0;}
        if(s.length() == 1){    return 1;}

        char [] str = s.toCharArray();
        Map<Character,Integer> table = new HashMap<>();

        for(int i=0;i<str.length;i++){
            if(table.containsKey(str[i])){
                table.put(str[i],table.get(str[i])+1);
            }else{
                table.put(str[i],1);
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
