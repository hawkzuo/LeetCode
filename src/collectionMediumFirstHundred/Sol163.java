package collectionMediumFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/10.
 * Missing Ranges
 */
public class Sol163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // Idea: Brute-force Appending
        // Pitfall: Annoying taking care of situation like (2) or (2->3)
        // In general: Final take care is very important
        List<String> result = new ArrayList<>();
        // Corner case
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

        // Take care of nums[0] > lower
        if(lower != nums[0]){
            StringBuilder dm = new StringBuilder();
            dm.append(lower);
            if(lower + 1 != nums[0]){
                dm.append("->");
                dm.append(nums[0]-1);
            }
            result.add(dm.toString());
        }

        int curVal = nums[0];
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
