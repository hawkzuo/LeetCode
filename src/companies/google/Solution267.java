package companies.google;

import java.util.*;

/**
 * Created by Amos on 2017/6/17.
 * Palindrome Permutation II
 * FirstAttempt: Map concurrent modification
 * SecondAttempt: Copy to a new Set
 */
public class Solution267 {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0 ){  return result;}
        if(s.length() == 1){    result.add(s);  return result;   }

        Map<Character,Integer> table = new HashMap<>();
        char[] str = s.toCharArray();

        for(int i=0;i<str.length;i++){
            if(table.containsKey(str[i])){
                table.put(str[i],table.get(str[i])+1);
            }else{
                table.put(str[i],1);
            }
        }
        int oddCount = 0;   char specialChar='a';

        for(Character ch: table.keySet()){
            if(table.get(ch) % 2 != 0){ oddCount ++;    specialChar = ch;   }
            if(oddCount >= 2){  return result;}
        }
        boolean extraChar = oddCount > 0;
        if(extraChar && table.get(specialChar) == 1){ table.remove(specialChar);}
        for(Character ch: table.keySet()){
            table.put(ch,table.get(ch) /2 );
        }
        StringBuilder sb = new StringBuilder();
        construct(result,table,extraChar,specialChar,sb);
        return result;
    }

    private void construct(List<String> res, Map<Character,Integer> canSelect, boolean extraChar, char spChar, StringBuilder sb){
        if(canSelect.size() == 1){
            char toApp = canSelect.keySet().iterator().next();
            int times = canSelect.get(toApp);
            int oriLength = sb.length();
            for(int i=0;i<times;i++){
                sb.append(toApp);
            }
            if(extraChar){
                res.add(sb.toString()+spChar+sb.reverse().toString());
            }else{
                res.add(sb.toString()+sb.reverse().toString());
            }
            //BackTrack
            sb.reverse();   sb.setLength(oriLength);
        }else{
            Set<Character> choices =new HashSet<>();
            Collections.addAll(choices,canSelect.keySet().toArray(new Character[canSelect.size()]));
        //OR:   for(Character ch: canSelect.keySet()) { choices.add(ch);    }
            for(Character toAdd: choices){
                int avCount = canSelect.get(toAdd);
                sb.append(toAdd);
                if(avCount == 1){   canSelect.remove(toAdd);}
                else{   canSelect.put(toAdd,avCount-1);}

                construct(res,canSelect,extraChar,spChar,sb);
                //BackTrack
                sb.deleteCharAt(sb.length()-1);
                if(avCount == 1){   canSelect.put(toAdd,1);}
                else{   canSelect.put(toAdd,avCount);}
            }
        }
    }
    public static void  main(String[] args){
        Solution267 s = new Solution267();
        System.out.print(s.generatePalindromes("12321aaaabb"));
    }
}
