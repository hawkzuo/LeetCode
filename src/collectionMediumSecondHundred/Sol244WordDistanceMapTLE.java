package collectionMediumSecondHundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amos on 2017/9/4.
 *
 */
public class Sol244WordDistanceMapTLE {
    // Use Map to improve efficientcy
    // Calculate all the distances when initialization

    // 'a' 'b' 'c' 'd' 'a' 'd' 'e'
    private int[][] minDist;
    private Map<String, Integer> refer;

    public Sol244WordDistanceMapTLE(String[] words) {
        // Initialize as hash
        Map<String, List<Integer>> hash = new HashMap<>();
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
        // Stored as Array
        minDist = new int[hash.size()][hash.size()];
        refer = new HashMap<>();
        int index = 0;
        for(String uniqueStr: hash.keySet()) {
            refer.put(uniqueStr, index);
            index ++;
        }
        for(int i=0;i<minDist.length;i++) {
            for(int j=0;j<minDist[0].length;j++) {
                minDist[i][j] = Integer.MAX_VALUE;
            }
        }

        // O(n^2) Storing
        for(int i=0;i<words.length;i++) {
            Integer left = refer.get(words[i]);
            for(int j=i+1;j<words.length;j++) {
                Integer right = refer.get(words[j]);
                minDist[left][right] = Math.min(minDist[left][right], j-i);
                minDist[right][left] = minDist[left][right];
            }
        }
    }

    public int shortest(String word1, String word2) {
        return minDist[refer.get(word1)][refer.get(word2)];
    }
}
