package collectionEasyFirstHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/23.
 * Two Sum
 */
public class Sol001 {
    // Idea: Either use HashMap or use Two Pointers
    // Map-based
    public int[] twoSum(int[] nums, int target) {
        int[] res =new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }
            else{
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }

    // Two-Pointers
    public int[] twoSum2(int[] nums, int target) {

        //Sort O(nlogn) solution --not applicable
        // O(n^2) solution: 2 loops
        int [] res = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        res[0] = 0;   res[1] = 0;
        return res;
    }


    // 1018 version
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<>();
        int[] result = new int[2];

        for(int i=0; i<nums.length; i++) {

            if(container.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = container.get(target - nums[i]);
                return result;
            } else {
                container.put(nums[i], i);
            }
        }

        return result;
    }





}
