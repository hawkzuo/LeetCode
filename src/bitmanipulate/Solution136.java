//136. Single Number

package bitmanipulate;

import java.util.HashMap;
import java.util.Map;

public class Solution136 {

	public Solution136() {
		// TODO Auto-generated constructor stub
	}
//Bit Manipulation --Xor
	public int singleNumber(int[] A) {

        int result=A[0];
        for(int i=1;i<A.length;i++)
        {
            result= result^A[i];  /* Get the xor of all elements */
        }
        return result;
}	

	
	
	
	
	
	
//Hash Table O(n) time O(n) Space	
    public int singleNumberHash(int[] nums) {

    	Map<Integer,Integer> m = new HashMap<Integer,Integer>();
    	
    	for(int i=0;i<nums.length;i++){
    		if(!m.containsKey(nums[i])){
    			m.put(nums[i], 1);
    		}else{
    			m.put(nums[i], m.get(nums[i])+1);
    		}
   		
    	}
		for( Map.Entry<Integer, Integer> entry : m.entrySet() ){
			int v = entry.getValue();
			if(v != 2){
				return entry.getKey();
			}
		}
		return -1;
    }

    
	public static void main(String[] args) {
		
		int x=1; int y=2; int z=4;
		System.out.print(3^5);
		
	}
    
    
    
}
