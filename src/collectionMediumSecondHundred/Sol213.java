package collectionMediumSecondHundred;

/**
 * Created by Amos on 2017/8/22.
 * House Robber II
 */
public class Sol213 {
    // Idea: compare max    dp will be analyzed separately
    public int rob(int[] nums) {
        int len = nums.length;
        if(len <=3){
            int sum=0;
            for(int x:nums){
                if(x>sum){
                    sum=x;
                }
            }
            return sum;
        }else{
            int[] nw = new int[len-3];
            System.arraycopy(nums, 2, nw, 0, len - 1 - 2);
            int sum = robFast(nw)+nums[0];

            System.arraycopy(nums, 3, nw, 0, len - 3);
            sum = Math.max(sum, robFast(nw)+nums[1]);

            System.arraycopy(nums, 1, nw, 0, len - 2 - 1);
            sum = Math.max(sum, robFast(nw)+nums[len-1]);
            return sum;
        }
    }

    private int robFast(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
