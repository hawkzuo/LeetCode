//152. Maximum Product Subarray

package dynamicprogramming;

public class Solution152 {
    public int maxProduct(int[] nums) {
        
        int len = nums.length;
        if(len == 0){   return 0;}
        
        int dpmax = nums[0];
        int dpmin = nums[0];
        int result = nums[0];
        
        for(int i=1;i<len;i++){
            //These two lines cover all the cases here.
            
            int cmax = Math.max(Math.max(nums[i],nums[i]*dpmax),nums[i]*dpmin);
            int cmin = Math.min(Math.min(nums[i],nums[i]*dpmax),nums[i]*dpmin);
            result = Math.max(result,cmax);
            dpmax = cmax;
            dpmin = cmin;
        }
        return result;
        
    }	
    public int maxProductold(int[] nums) {
        int len = nums.length;
        if(len == 0){   return 0;}
        if(len == 1){   return nums[0];}
        
        int nsaver = 0;
        int max = nums[0];
        
        int product = 0;
        
        
        for(int i=0;i<len;i++){
            
            
            if(nums[i] > 0){
                
                if(product == 0){
                    product = nums[i];
                }else{
                    product *= nums[i];
                }
                
                
            }else if(nums[i] < 0){
                if(nsaver < 0){
                    if(product == 0){
                        product = nsaver * nums[i];
                    }else{
                        product *= nsaver * nums[i];
                    } 
                    nsaver = 0;
                }else{
                    if(product == 0){
                        nsaver = nums[i];
                    }else{
                        nsaver = nums[i] * product;
                    } 
                    
                    max = Math.max(max, product);
                    product = 0;
                }

            }else{
                    max = Math.max(max, product);
                    product = 0;                
                    nsaver = 0;
                
            }
            
            
            
            
        }
        max = Math.max(max, product);
        return max;




      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution152 s = new Solution152();
		int [] arr1 = {-1,-2,-3,4};    
		
		System.out.print(s.maxProduct(arr1));
		
	}
}
