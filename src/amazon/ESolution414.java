package amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/7/2.
 * Third Maximum Number
 */
public class ESolution414 {
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){   return -1;  }
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;
        Set<Integer> refer = new HashSet<Integer>();
        for (int num : nums) {
            if (refer.contains(num)) {
                continue;
            }
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            } else {;}
            refer.add(num);
        }
        if(refer.contains(m3) && refer.size() >= 3){ return m3;  }
        return m1;
    }
}
