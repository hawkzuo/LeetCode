package facebook;
import java.util.*;
public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){   return 0;}
        else if(nums.length == 1){  return 1;}
        else if(nums.length == 2){
            return nums[0] < nums[1] ? 2 : 1;
        }
        
        int[] minPref = new int[nums.length+1];
        Arrays.fill(minPref,Integer.MAX_VALUE); minPref[0] = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= minPref[1]){
                minPref[1] = nums[i];
            }else{
                int starJ = binarySearch(minPref,nums[i]);
                if(minPref[starJ] == nums[i]){	continue;	}
                else{	minPref[starJ +1] = Math.min(minPref[starJ +1], nums[i]);	}
            }
        }       
        for(int i=2;i<minPref.length;i++){
        	if(minPref[i] == Integer.MAX_VALUE){	return i-1;	}
        }
        return nums.length;        
    }

	private int binarySearch(int[] minPref, int tar) {
		// TODO Auto-generated method stub
		// Find the largest j*, such that minPref[j*] <= nums[i]
		int l = 0;	int r = minPref.length-1;
		while(r-l > 1){
			int mid = l+(r-l)/2;
			int curVal = minPref[mid];
			if(tar > curVal){
				l = mid;
			}else if(tar < curVal){
				r = mid;
			}else{
				l = mid;
			}
		}
		if(minPref[r] <= tar){
			return r;
		}else{
			return l;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution300 s = new Solution300();
		int[] input = {2,1};
		System.out.println(s.lengthOfLIS(input));
		
	}

}
