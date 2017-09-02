package collectionEasyFirstHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/9/2.
 * Contains Duplicate II
 */
public class Sol219 {
    // Idea: Greedy Map stores largest previous index of number in array and match each new step integer
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2){    return false;}

        Map<Integer,Integer> table = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(table.containsKey(nums[i])){
                int diff = i - table.get(nums[i]);
                if(diff <= k){  return true;}
                else{
                    table.put(nums[i],i);
                }
            }else{
                table.put(nums[i],i);
            }
        }
        return false;
    }
}
