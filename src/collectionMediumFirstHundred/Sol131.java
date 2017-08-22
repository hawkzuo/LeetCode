package collectionMediumFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/7/31.
 * Palindrome Partitioning
 */
public class Sol131 {
    public List<List<String>> partition(String s) {
        // "abbdbb"
        //[["a","b","b","d","b","b"],["a","b","b","d","bb"],["a","b","bdb","b"],["a","bb","d","b","b"],["a","bb","d","bb"],["a","bbdbb"]]
        // Nonsplit + split
        // bbdbb = b{bdbb} bb{dbb}  bbdbb 6
        // bdbb = b{dbb} bdb{b} 3
        // dbb = d{bb} 2            str = 'dbb'
        // bb = b,b bb
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0) {  return result;}
        if(s.length() == 1){
            List<String> dummy = new ArrayList<>();
            dummy.add(s);
            result.add(dummy);
            return result;
        }else if(s.length() == 2) {
            List<String> dummy = new ArrayList<>();
            char[] str = s.toCharArray();
            if(str[0] == str[1]){
                dummy.add(s);
                result.add(dummy);
            }
            List<String> dummy2 = new ArrayList<>();
            dummy2.add(""+str[0]); dummy2.add(""+str[1]); result.add(dummy2);
            return result;
        }else{
            char[] str = s.toCharArray();
            for(int i=0;i<str.length;i++){
                String prefix = s.substring(0,i+1);
                if(!isPa(prefix)) { continue;}
                // This control flow must be added due to calling s.substring(i+1)
                if(i+1 == str.length) {
                    // prefix = allString
                    List<String> fullLength = new ArrayList<>();
                    fullLength.add(s);
                    result.add(fullLength);
                }else {
                    List<List<String>> partials = partition(s.substring(i + 1));
                    for(List<String> sub: partials) {
                        sub.add(0, prefix);
                        result.add(sub);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPa(String input) {
        StringBuilder sb = new StringBuilder(input);
        return input.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Sol131 s = new Sol131();
        System.out.println(s.partition("acabbdbb"));
    }
}
