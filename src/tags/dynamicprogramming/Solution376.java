package tags.dynamicprogramming;

public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){   return 0;}        
        int n = nums.length;
        
        int len =1;
        int min = nums[0];
        int max = Integer.MIN_VALUE;
        boolean expectHigh = true;
        // One direction      
        for(int i=1;i<n;i++){
            int cur = nums[i];
            if(max == Integer.MIN_VALUE){
                if(cur <= min){
                    min = cur;
                    expectHigh = true;
                }else{
                    max = cur;
                    len ++;
                    expectHigh = false;
                }
            }else{
                if(expectHigh){
                    if(cur <= min){
                        min = cur;
                        expectHigh = true;
                    }else{
                        max = cur;
                        len ++;
                        expectHigh = false;                        
                    }
                }else{
                    if(cur >= max){
                        max = cur;
                        expectHigh = false;
                    }else{
                        min = cur;
                        len ++;
                        expectHigh = true;
                    }
                }
            }
        }
        // Record global
        int globallen = len;
        
        // Run on the other direction
        len = 1;
        max = nums[0];
        min = Integer.MIN_VALUE;
        expectHigh = false;
        for(int i=1;i<n;i++){
            int cur = nums[i];
            if(min == Integer.MIN_VALUE){
                if(cur < max){
                    min = cur;
                    len ++;
                    expectHigh = true;
                }else{
                    max = cur;
                    expectHigh = false;
                }
            }else{
                if(expectHigh){
                    if(cur <= min){
                        min = cur;
                        expectHigh = true;
                    }else{
                        max = cur;
                        len ++;
                        expectHigh = false;                        
                    }
                }else{
                    if(cur >= max){
                        max = cur;
                        expectHigh = false;
                    }else{
                        min = cur;
                        len ++;
                        expectHigh = true;
                    }
                }
            }
        }
        globallen = Math.max(globallen,len);
        
        return globallen;
      
    }
}