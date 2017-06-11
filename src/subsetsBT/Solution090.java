package subsetsBT;
import java.util.*;
public class Solution090 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        constructPwithDup(list,new ArrayList<Integer>(),nums,0);
        return list;   	
    }
    private void constructPwithDup(List<List<Integer>> res, List<Integer> path, int[] nums, int bIndex){
    	res.add(path);   	
    	for(int i=bIndex;i<nums.length;i++){
    		path.add(nums[i]);
    		//Move a bit right and recurse
    		constructPwithDup(res,new ArrayList<Integer>(path),nums,i+1);
    		//BT
    		path.remove(path.size()-1);
    		int ref = nums[i];
    		while(i+1<nums.length && nums[i+1] == ref){
    			i++;
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution090 s = new Solution090();
		int[] nums = {1,2,2,2};
		System.out.println(s.subsetsWithDup(nums));
	}

}
