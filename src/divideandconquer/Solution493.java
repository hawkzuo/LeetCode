package divideandconquer;

import java.util.Arrays;

public class Solution493 {
	//Brute-Force will be O(n^2)
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        return dcPairs(nums,0,nums.length);
    }
    
    public int dcPairs(int[] nums, int l, int r){
        //Base case
        if(r-l == 2 ){
            int sum = 0;
            if((long)nums[l] > 2* (long)nums[r-1]){
                sum++;
            }
            Arrays.sort(nums,l,r);
            return sum;
        }else if ( r-l == 3){
            int sum = 0;
            if((long)nums[l] > 2*(long)nums[l+1]){
                sum++;
            }
            if((long)nums[l] > 2*(long)nums[l+2]){
                sum++;
            }
            if((long)nums[l+1] > 2*(long)nums[l+2]){
                sum++;
            } 
            Arrays.sort(nums,l,r);
            return sum;
        }else{
            // Divide & Conquer
            int mid = l+(r-l)/2;
            int tsum = 0;
            int lsum = dcPairs(nums,l,mid);
            int rsum = dcPairs(nums,mid,r);
            tsum = tsum + lsum + rsum;
            //Conbine   O(n^2)  TLE:
/*
            for(int i=l;i<mid;i++){
                for(int j=mid;j<r;j++){
                   if((long)nums[i] > 2*(long)nums[j]){
                       tsum++;
                   }else{
                       break;
                   }
                }
            }    
*/            
            //Try New Version:
            // Observation: when doing the combine step, the order within the self group is 
            // not a big concern. Meaning we can change whatever we want, since we only combine left half and 
            // right half, with assurance the i is anyway smaller than j    
            // Utilize two-pointers' idea
            // T(n) = 2T(n/2)+O(nlgn)   => T(n) = O(nlg n)
            int count = 0;
            for (int lef = l, ri = mid; lef < mid;) {
                if (ri > (r-1) || (long)nums[lef] <= 2*(long)nums[ri]) {
                	//These two lines, order doesn't matter.
                    lef++;
                    tsum += count;
                } else {
                    ri++;
                    count++;
                }
            }
            Arrays.sort(nums,l,r);
            return tsum;
        }
    }
}