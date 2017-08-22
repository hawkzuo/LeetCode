package collectionMediumFirstHundred;

import java.util.Arrays;

/**
 * Created by Amos on 2017/7/13.
 * 3Sum Closest
 */
public class Sol016 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){	return -1;}
        if(nums.length == 3){ return nums[0]+nums[1]+nums[2];}
        Arrays.sort(nums);

        int k;  int lowest=Integer.MIN_VALUE;   int highest=Integer.MAX_VALUE;

        // This extra if-statement is key to improve performance by constant factor
        if(nums[nums.length-1]-target < target - nums[0]){
            for(k=nums.length-1;k>=2;k--){
                int i=0; int j=k-1;

                while(i<j){
                    int cur = nums[i] + nums[j] + nums[k];
                    if( cur > target){
                        highest = Math.min(highest,cur);
                        j--;

                    }else if(cur < target){
                        lowest = Math.max(lowest, cur);
                        i++;
                    }else{
                        return target;
                    }
                }
            }
        }else{
            for(k=0;k<=nums.length-3;k++){
                int i=k+1; int j=nums.length-1;

                while(i<j){
                    int cur = nums[i] + nums[j] + nums[k];
                    if( cur > target){
                        highest = Math.min(highest,cur);
                        j--;

                    }else if(cur < target){
                        lowest = Math.max(lowest, cur);
                        i++;
                    }else{
                        return target;
                    }
                }
            }
        }
        return (highest + lowest - 2* target) > 0 ? lowest : highest;
    }

}
