package facebook;

import java.util.HashMap;
import java.util.Map;

public class Solution525 {

	public Solution525() {
		// TODO Auto-generated constructor stub
	}
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length <=1){
            return 0;
        }        
        
        Map<Integer,Integer> table = new HashMap<Integer,Integer>( );             
        //Record # of zeros - # of ones
        int temp=0;
        int len =0;        
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] ==0){
                temp++;
            }else{
                temp--;
            }
            len++;
            table.put(temp,len);
        }         
        
        int res = 0;
        if(table.containsKey(0)){
            res = table.get(0);
        }
        int target = 0;
        int offset = 0; int cursor = nums.length-1;
        while(cursor>0){
            offset++;
            if(res+offset >= nums.length){
                break;
            }
            if(nums[cursor] == 0){
                target++;
            }else{
                target--;
            }
            if(table.containsKey(target)){
                res = Math.max(res,table.get(target)-offset);
            }
            cursor--;
        }       
        return res;                       
    }
}
