package unclassified;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/9/10.
 */
public class Sol565SOFL {
    // Overflow => Set is not needed
    public int arrayNesting(int[] nums) {
        Set<Integer> oneSet = new HashSet<>();

        boolean[] flags = new boolean[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(!flags[i]) {
                Set<Integer> compete = recursivelyConstructSet(i, flags, nums, new HashSet<>());
                if(compete.size() > oneSet.size()) {
                    oneSet = compete;
                }
            }
        }

        return oneSet.size();
    }

    private Set<Integer> recursivelyConstructSet(int index, boolean[] flags, int[] nums, Set<Integer> res) {
        int newIndex = nums[index];
        if(res.contains(newIndex)) {
            return res;
        } else {
            res.add(newIndex);
            flags[index] = true;
            return recursivelyConstructSet(newIndex, flags, nums, res);
        }
    }
}
