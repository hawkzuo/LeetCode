package collectionMediumFirstHundred;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amos on 2017/7/13.
 * 4Sum
 */
public class Sol018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new LinkedList<>();
        if(nums.length < 4){	return res;}
        if(nums.length == 4){
            if( nums[0]+nums[1]+nums[2]+nums[3] == target){
                List<Integer> l= new LinkedList<>();
                l.add(nums[0]);l.add(nums[1]);l.add(nums[2]);l.add(nums[3]);
                res.add(l);
            }
            return res;
        }
        Arrays.sort(nums);
        //Begin with the greatest

        for(int outL=0;outL<nums.length-3;outL++){
            //This one must be added to eliminate duplicates on Rleft.
            if(outL !=0 && nums[outL] == nums[outL-1]){
                continue;
            }

            int outR=nums.length-1;
            while(outL+2 < outR){

                int innerTarget = target - nums[outL] - nums[outR];
                int i=outL+1;   int j=outR-1;
                while(i<j){
                    if(nums[i] + nums[j] > innerTarget){
                        while(i<j && nums[j-1] == nums[j]){ j--;    }
                        j--;
                    }else if(nums[i] + nums[j] == innerTarget){
                        List<Integer> l= new LinkedList<>();
                        l.add(nums[outL]);l.add(nums[i]);l.add(nums[j]);l.add(nums[outR]);
                        res.add(l);
                        while(i<j && nums[j-1] == nums[j]){ j--;    }
                        while(i<j && nums[i+1] == nums[i]){ i++;	}
                        j--;i++;
                    }else{
                        while(i<j && nums[i+1] == nums[i]){ i++;	}
                        i++;
                    }
                }
                //This one must be added too, to elimate duplicates on Rout.
                while(outL+2<outR && nums[outR-1] == nums[outR]){ outR--;}
                outR--;
            }
        }
        return (res);
    }
}
