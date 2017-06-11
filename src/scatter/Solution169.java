//169. Majority Element

package scatter;

public class Solution169 {

    public int majorityElement(int[] nums) {
        
        int res = nums[0];
        int times = 1;
        
        
        //Worst-case for major is consumed floor(n/2) elements
        //Left at least 1 element for major
        //Other cases
        
        for(int i=1;i<nums.length;i++){
            if(times == 0){
                res = nums[i];
                times++;
                
            }else if(nums[i] == res){
                times++;
                
            }else{
                times--;
            }
        }
        return res;
    }

}
