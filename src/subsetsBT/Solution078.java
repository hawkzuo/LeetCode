package subsetsBT;
import java.util.*;
public class Solution078 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);

        constructP(list,new ArrayList<Integer>(),nums,0);
        return list;
    }
    private void constructP(List<List<Integer>> res, List<Integer> path, int[] nums, int bIndex){
    	res.add(path);   	
    	for(int i=bIndex;i<nums.length;i++){
    		path.add(nums[i]);
    		//Move a bit right and recurse
    		constructP(res,path,nums,i+1);
    		//BT
    		path.remove(path.size()-1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution078 s = new Solution078();
		int[] nums = {1,2,3,4,5,6,7,8,10,0,22,23};
		System.out.println(s.subsets(nums).size());
		
	}

}
