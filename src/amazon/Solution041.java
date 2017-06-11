//41. First Missing Positive
//287 268
package amazon;

public class Solution041 {

	public Solution041() {
		// TODO Auto-generated constructor stub
	}
	
    public int firstMissingPositive(int[] nums) {
        
    	int i = 0;    	
    	while(i<nums.length){
    		if(nums[i]<=0 || nums[i]>nums.length || nums[i] == i+1) {	i++;	}
    		else{
    			if(nums[i] != nums[nums[i]-1]){
    				swap(nums,i,nums[i]-1);
    			}else{	i++; }
    		}    		
    	}
    	for(i=0;i<nums.length;i++){
    		if(nums[i] != i+1){
    			return i+1;
    		}
    	}
    	return i+1;
   	
    }	
	private void swap(int[] n, int l, int r){
		int t = n[l];
		n[l] = n[r];
		n[r] = t;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] t = {4,3,5,-1,1,1,1};
		Solution041 s = new Solution041();
		int res =s.firstMissingPositive(t);
		System.out.print(res);
	}
}
