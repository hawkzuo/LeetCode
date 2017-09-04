package collectionMediumSecondHundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amos on 2017/9/4.
 * Shortest Word Distance II
 */
public class Sol244WordDistance {
    // Idea: Either use O(n^2) initialize and O(1) query, or
    //      Use O(n) initialize into a hash and matching on two lists with O(<n) query
    // Why O(n^2) TLE?
    private Map<String, List<Integer>> hash = new HashMap<>();

    public Sol244WordDistance(String[] words) {
        for(int i = 0; i<words.length; i++) {
            String step = words[i];
            if(hash.containsKey(step)) {
                hash.get(step).add(i);
            } else {
                List<Integer> dummy = new ArrayList<>();
                dummy.add(i);
                hash.put(step, dummy);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> freq1 = hash.get(word1);
        List<Integer> freq2 = hash.get(word2);
        return getMin(freq1, freq2);
    }

    // Same matching technique as Sol244WordDistance I
    private int getMin(List<Integer> freq1, List<Integer> freq2) {

        int ret = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < freq1.size() && j < freq2.size(); ) {
            int index1 = freq1.get(i), index2 = freq2.get(j);
            if(index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            } else {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }

    // I forgot to add  the while loop. Ops
    private int getMinMy(List<Integer> freq1, List<Integer> freq2) {
        // 0 3 5 6
        // 4 8 10
        int lc = 0; int rc = 0;
        int lIndex = freq1.get(0);
        int rIndex = freq2.get(0);
        int result = Math.abs(lIndex-rIndex);
        if(lIndex < rIndex ) {
            if(lc+1 < freq1.size()) {
                lc++;
                lIndex = freq1.get(lc);
                result = Math.min(result, Math.abs(lIndex - rIndex));
            }
        } else if(rc+1 < freq2.size()) {
            rc++;
            rIndex = freq2.get(rc);
            result = Math.min(result, Math.abs(lIndex-rIndex));
        }
        result = Math.min(result, Math.abs(lIndex-rIndex));
        return result;
    }
}
