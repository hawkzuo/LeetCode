package collectionMediumSecondHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/9.
 * Summary Ranges
 */
public class Sol228 {
    public List<String> summaryRanges(int[] nums) {
//        [-1,0,1,2,3,7,8,10,11,12]
//        ["-1->3","7->8","10->12"]
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {  return result;}
        if(nums.length == 1) {  result.add(""+nums[0]); return result;}
        StringBuilder sb = new StringBuilder();

        Integer prev = null;    int count = 0;
        for (int val : nums) {
            if (prev == null) {
                sb.append(val);
                prev = val;
                count = 1;
            } else {
                if (val == prev + 1) {
                    prev = val;
                    count++;
                } else {
                    // Build part
                    if (count != 1) {
                        sb.append("->");
                        sb.append(prev);
                    }
                    result.add(sb.toString());
                    //Clean up
                    sb = new StringBuilder();
                    sb.append(val); prev = val; count = 1;
                }
            }
        }
        // Take care of last part
        if (count != 1) {
            sb.append("->");
            sb.append(prev);
        }
        result.add(sb.toString());
        return result;
    }

    public static void main(String[] args) {
        Sol228 s = new Sol228();
        int[] t = {-1,0,1,2,3,7,8,10,11,12,13};
        System.out.println(s.summaryRanges(t));
    }
}
