package collectionEasyFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/9/10.
 * Intersection of Two Arrays II
 */
public class Sol350 {
    // Idea: Duplicates remained, use map then
    //      Still sorting + 2 pointers can solve this problem
    // Map version
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        for(int num: nums1) {
            if(m1.containsKey(num)) {
                m1.put(num, m1.get(num) +1);
            } else {
                m1.put(num, 1);
            }
        }

        int totalCounter = 0;
        Map<Integer, Integer> intersected = new HashMap<>();
        for(int num: nums2) {
            if(m1.containsKey(num)) {
                if(!intersected.containsKey(num)) {
                    intersected.put(num, 1);
                    totalCounter++;
                } else if(intersected.get(num) +1 <= m1.get(num)) {
                    intersected.put(num, 1+intersected.get(num));
                    totalCounter++;
                }
            }
        }

        int[] result = new int[totalCounter];
        int dummyIndex = 0;
        for(Integer num : intersected.keySet()){
            int times = intersected.get(num);
            for(int i=0;i<times;i++) {
                result[dummyIndex++] = num;
            }
        }
        return result;
    }

    // Sort version
    public int[] intersectSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new LinkedList<>();
        int i=0;	int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                j++;i++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }

        int[] result = new int[res.size()];
        int dummyIndex = 0;
        for(Integer num : res){
            result[dummyIndex++] = num;
        }
        return result;
    }
}
