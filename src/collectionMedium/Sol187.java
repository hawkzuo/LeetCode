package collectionMedium;

import java.util.*;

/**
 * Created by Amos on 2017/8/20.
 * Repeated DNA Sequences
 */
public class Sol187 {
    // Either use Map or use two sets to remove duplicates

    public List<String> findRepeatedDnaSequences(String s) {
        // Brute-force matching for 10-char-long substrings
        List<String> result = new ArrayList<>();
        if(s == null || s.length() <= 10) { return result;}

        Map<String, Integer> refer = new HashMap<>();
        StringBuilder window = new StringBuilder(s.substring(0, 10));
        refer.put(window.toString(), 1);

        char[] str = s.toCharArray();
        int cur = 10;
        while(cur < str.length) {
            window.deleteCharAt(0);
            window.append(str[cur]);
            String step = window.toString();
            if(refer.containsKey(step)) {
                int frequency = refer.get(step);
                if(frequency == 1) {
                    result.add(step);
                }
                refer.put(step, frequency+1);
            } else {
                refer.put(step, 1);
            }
            cur++;
        }
        return result;
    }

    public List<String> findRepeatedDnaSequencesViaTwoSets(String s) {
        Set<String> app = new HashSet<>();
        Set<String> repeat = new HashSet<>();
        for(int i=0;i+9<s.length();i++){
            String ten = s.substring(i,i+10);
            if(!app.add(ten)){
                repeat.add(ten);
            }
        }
        return new ArrayList<>(repeat);
    }



}
