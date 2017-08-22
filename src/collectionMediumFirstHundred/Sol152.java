package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/8/10.
 * Maximum Product Subarray
 */
public class Sol152 {
    public int maxProduct(int[] nums) {
        // 2 3 4 -2 [-3] 1 100 0
        // Idea: only two consequent negative values can result in final result, stores two values Min/Max
        //  If value >=1, will take anyway
        //  If value == 0, must restart process,    <=>  split into different parts

        int len = nums.length;
        if(len == 0){   return 0;}

        int dpMax = nums[0];
        int dpMin = nums[0];
        int result = nums[0];

        for(int i=1;i<len;i++){
            //These two lines cover all the cases here.
            int value = nums[i];
            int cmax = Math.max(Math.max(value, value*dpMax), value*dpMin);
            int cmin = Math.min(Math.min(value, value*dpMax), value*dpMin);
            result = Math.max(result, cmax);
            dpMax = cmax;
            dpMin = cmin;
        }
        return result;
    }
}
