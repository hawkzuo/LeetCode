//

package dynamicprogramming;

import java.util.Arrays;

public class Solution473 {

    public boolean makesquare(int[] nums) {
        
        int len = nums.length;
        if(len <=3){    return false;}
        
        long sum = 0;
        long max = 0;
        
        for(int i=0;i<len;i++){
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        
        if(sum % 4 != 0){   return false;}
        
        sum = sum / 4;
        
        if(max > sum){  return false;}
        
        Arrays.sort(nums);
        

        
        int times =0;
        
        for(int z=0;z<=3;z++){
            long csum = gG(nums);
            while(csum == sum){
            	times++;
            	z++;
            	csum = gG(nums);
            }
            outer:
            while(csum < sum){
                for(int i=0;i<len;i++){
                    
                    
                    if(csum + nums[i] == sum){
                        times ++;
                        nums[i] = 0;
                        break outer;
                    }
                }  
                if(pG(nums) + csum < sum){
                	csum = csum + gG(nums);
                }else{
                	csum = csum + gL(nums);
                }
            }
            if(csum > sum){
                return false;
            }
        }
        
        if(times == 4){ return true;}
        else{   return false;}
        
        
    }
    
    private int gL(int[] nums){
        for(int j=0;j<nums.length;j++){
            if(nums[j] != 0){
                int res = nums[j];
                nums[j] =0;
                return res;
            } 
        }
        return -1;
    }
    
    private int gG(int[] nums){
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j] != 0){
                int res = nums[j];
                nums[j] = 0;
                return res;
            }
        }
        return -1;
    }
    
    private int pG(int[] nums){
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j] != 0){
                int res = nums[j];
                return res;
            }
        }
        return -1;
    }    
    
    
    
    
	public static void main(String[] args) {
		Solution473 s = new Solution473();
		int[] tes = {1,1,2,2,2,2,2,2,2,3,4,5};
		int[] tes2 = {5,5,5,5,4,4,4,4,3,3,3,3};
		System.out.println(s.makesquare(tes2));
		
	}
}
