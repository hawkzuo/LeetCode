package collectionEasyFirstHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/27.
 * House Robber
 */
public class Sol198 {
    // Idea: Easy DP
    // TODO: Add bottom-up version when working on tags
    // Top-down Solution
    public int rob(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        return getSum(nums,0, hash);
    }

    private int getSum(int[] a, int begin, Map<Integer,Integer> m){
        int end = a.length;
        if(end - begin <=0){
            return 0;
        }
        if(end - begin == 1){
            m.put(begin,a[begin]);
            return a[begin];
        }
        if(end - begin == 2){
            int cur = Math.max(a[begin],a[begin+1]);
            m.put(begin,cur);
            return cur;
        }
        // Recursively calculating next level elements
        int s1 = m.containsKey(begin + 2) ? m.get(begin + 2) : getSum(a, begin + 2, m);
        int s2 = m.containsKey(begin + 3) ? m.get(begin + 3) : getSum(a, begin + 3, m);

        int cur = Math.max(a[begin]+s1, a[begin+1] + s2);
        m.put(begin,cur);
        return cur;
    }
}
