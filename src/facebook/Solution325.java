package facebook;

import java.util.HashMap;
import java.util.Map;

public class Solution325 {

	public Solution325() {
		// TODO Auto-generated constructor stub
	}
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0){   return 0;}
        if(nums.length == 1){
            if(nums[0] == k)    return 1;
            else    return 0;
        }
        
        Map<Integer,Integer> table = new HashMap<Integer,Integer>( );       
        int temp=0;
        int len =0;
        for(int i=nums.length-1;i>=0;i--){
            temp+=nums[i];
            len++;
            if(!table.containsKey(temp)){
                table.put(temp,len);
            }else{
                table.put(temp,Math.max(table.get(temp),len));
            }
        }        
        int res = 0;
        if(table.containsKey(k)){
            res = Math.max(res,table.get(k));
        }       
        int offset = 0; int cursor = nums.length-1;
        
        while(cursor>0){
            k+=nums[cursor];
            offset++;
            if(table.containsKey(k)){
                res = Math.max(res,table.get(k)-offset);
            }
            cursor--;
        }       
        return res;       
    }
}
