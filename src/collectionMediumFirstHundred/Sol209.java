package collectionMediumFirstHundred;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Amos on 2017/8/21.
 * Minimum Size Subarray Sum
 */
public class Sol209 {

    // Idea: O(n) solution takes me some time to figure it out.
    public int minSubArrayLenWindow(int s, int[] nums) {
        // O(n): Sliding window
        int left = 0;
        int right = 0;

        int path = 0;   int globalMin = Integer.MAX_VALUE;
        // When checking A[right] is not added, cannot add extra 'if' to while loop
        while(right < nums.length) {
                path += nums[right];
                right ++;
                // Once added new right element, must run the inner loop to take effective of this change
                while(path >= s) {
                    // Move left pointer righter
                    globalMin = Math.min(globalMin, right - left);
                    path -= nums[left];
                    left ++;
                }
        }
        if(globalMin == Integer.MAX_VALUE){ return 0;}
        else{   return globalMin;}
    }

    public int minSubArrayLen(int s, int[] nums) {
        // O(nlgn): Change target instead of pointers when dealing with "subarray" problems
        TreeMap<Integer, Integer> sumToIndex = new TreeMap<>();
        int path = 0;
        int globalMin = -1;
        int desiredSum = s;
        for(int i=0;i<nums.length;i++) {
            path += nums[i];
            if(globalMin == -1 && path >= desiredSum){
                globalMin = i+1;
            }
            sumToIndex.put(path, i+1);
        }
        if(globalMin == -1){    return 0;}

        // Now loop over the array via changing the target value
        for(int i=0;i<nums.length;i++) {
            desiredSum += nums[i];
            Map.Entry<Integer, Integer> stepEntry = sumToIndex.ceilingEntry(desiredSum);
            if(stepEntry == null) { break;}
            globalMin = Math.min(globalMin, stepEntry.getValue()-i-1);
        }
        return globalMin;
    }

    public static void main(String[] args) {
        Sol209 s = new Sol209();
        int[] t = {2,3,1,2,4,10,10,10,3};
        System.out.println(s.minSubArrayLenWindow(30, t));
    }
}
