package companies.facebook;

public class Solution209 {

	public Solution209() {
		// TODO Auto-generated constructor stub
	}
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            if(nums[0] >= s)    return 1;
            else    return 0;
        }
        
        int [] table = new int[nums.length+1];
        int temp=0; int index = 1;
        for(int i=nums.length-1;i>=0;i--){
            temp+=nums[i];
            table[index++]=temp;
        } 
        
        int best = 0;   int cur = 1;        
        while(cur <= nums.length){
            if(table[cur] >= s){
                break;
            }else{
                cur++;
            }
        }
        if(cur > nums.length)	 return best;
        best = cur;
        
        //Now loop
        int cursor = nums.length-1; int offset=0;
        while(cursor > 0){
            s += nums[cursor];
            offset++;
            
            while(cur <= nums.length){
                if(table[cur] >= s){
                    break;
                }else{
                    cur++;
                }
            }
            if(cur > nums.length){
                return best;
            }  
            
            best = Math.min(best,cur-offset);
            cursor--;           
        }
        return best;        
    }
}
