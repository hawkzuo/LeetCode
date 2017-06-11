package unionfind;

import java.util.HashMap;
import java.util.Map;

public class Solution128 {

	public Solution128() {
		// TODO Auto-generated constructor stub
	}
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){   return 0;}
        else if(nums.length == 1){  return 1;}        
        int len = nums.length;        
        Map<Integer,Integer> refer = new HashMap<Integer,Integer>();       
        for(int i=0;i<len;i++){
            refer.put(nums[i],1);
        }
        
        int glMax = 0;        
        for(int i=0;i<len;i++){
            if(refer.get(nums[i]) == 1 ){
                //Begin
                int count = 1;
                refer.put(nums[i],0);
                
                int mid = nums[i];
                while(refer.containsKey(mid+1)){
                    count++;
                    refer.put(mid+1,0);
                    mid++;
                }
                mid = nums[i];
                while(refer.containsKey(mid-1)){
                    count++;
                    refer.put(mid-1,0);
                    mid--;
                }  
                glMax = Math.max(glMax,count);
                
            }else{
                continue;
            }
        }      
        return glMax;       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
