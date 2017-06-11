//213. House Robber II

package dynamicprogramming;

public class Solution213 {

    public int rob(int[] nums) {
        
        int len = nums.length;
        if(len <=3){
            int sum=0;
            for(int x:nums){
            	if(x>sum){
            		sum=x;
            	}
            }
            return sum;
        }else{
            int[] nw = new int[len-3];
            for(int i=2;i<len-1;i++){
                nw[i-2]=nums[i];
            }
            int sum = robfast(nw)+nums[0];
            
            for(int i=3;i<len;i++){
                nw[i-3]=nums[i];
            }
            sum = Math.max(sum,robfast(nw)+nums[1]);
            
            for(int i=1;i<len-2;i++){
                nw[i-1]=nums[i];
            }
            sum = Math.max(sum,robfast(nw)+nums[len-1]);
            return sum;
        }       
    }
    
    
    public int robfast(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution213 s = new Solution213();    
		int[] room = {3,2,1,4,105,6,7,8};
		int[] rooms = {1,2,3,4};
		System.out.println(s.rob(room));
    
    }
}
