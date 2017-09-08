package collectionEasyFirstHundred;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/9/10.
 * Intersection of Two Arrays
 */
public class Sol349 {
    // Idea: Use set to improve efficiency to O(n)
    // Otherwise use Sort
    public int[] intersect(int[] nums1, int[] nums2) {
//    	Arrays.sort(nums1);
//    	Arrays.sort(nums2);

        Set<Integer> m1 = new HashSet<>();
        Set<Integer> m2 = new HashSet<>();

        for (int step : nums1) {
            m1.add(step);
        }
        for (int step : nums2) {
            if (m1.contains(step)) {
                m2.add(step);
            }
        }

        int[] result = new int[m2.size()];
        int dummyIndex = 0;
        for(Integer num : m2){
            result[dummyIndex++] = num;
        }
        return result;
    }
}
