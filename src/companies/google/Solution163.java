package companies.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/6/11.
 */
public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            StringBuilder dm = new StringBuilder();
            dm.append(lower);
            if(lower != upper){
                dm.append("->");
                dm.append(upper);
            }
            result.add(dm.toString());
            return result;
        }

        int curVal;
        if(lower != nums[0]){
            StringBuilder dm = new StringBuilder();
            dm.append(lower);
            if(lower + 1 != nums[0]){
                dm.append("->");
                dm.append(nums[0]-1);
            }
            result.add(dm.toString());
        }
        curVal = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] <= (long)curVal+1 ){   curVal = nums[i];  continue;}

            StringBuilder dm = new StringBuilder();
            dm.append(curVal+1);
            if(curVal!= nums[i]-2){
                dm.append("->");
                dm.append(nums[i]-1);
            }
            curVal = nums[i];
            result.add(dm.toString());
        }
        // Final take care
        if(curVal < upper){
            StringBuilder dm = new StringBuilder();
            dm.append(curVal+1);
            if(curVal + 1 != upper){
                dm.append("->");
                dm.append(upper);
            }
            result.add(dm.toString());
        }

        return result;
    }
}
