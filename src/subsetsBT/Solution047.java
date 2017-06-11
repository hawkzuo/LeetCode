package subsetsBT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution047 {

	public Solution047() {
		// TODO Auto-generated constructor stub
	}
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Integer> sel = new HashMap<Integer,Integer>();
        Map<Integer,Integer> avl = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	avl.put(i, 1);
        }
        genPermutUnique(list,new ArrayList<Integer>(),nums,sel,avl);       
        return list;        
    }
    private void genPermutUnique(List<List<Integer>> list, List<Integer> path, int[] nums, Map<Integer,Integer> sel,Map<Integer,Integer> avl){
    	if(avl.size() == 1){
    		//Base case
    		List<Integer> dummy = new ArrayList<Integer>();
    		for(int i=0;i<path.size();i++){
    			dummy.add(nums[path.get(i)]);
    		}
    		dummy.add(nums[avl.entrySet().iterator().next().getKey()]);
    		list.add(dummy);   		
    		//BT is not needed because this step doesn't add extras to path. 		    		
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		if(sel.containsKey(i)){
    			continue;
    		}    		
    		//Proceed to next step.
    		path.add(i);
    		sel.put(i, 1);	avl.remove(i);
    		genPermutUnique(list,path,nums,sel,avl);    
    		//BT
    		int lastIndex = path.get(path.size()-1);
    		sel.remove(lastIndex);	avl.put(lastIndex, 1);	path.remove(path.size()-1);
    		//Before move on to the next iteration, remove the duplicates first.
    		while(i+1<nums.length && nums[i+1] == nums[lastIndex]){
    			i++;
    		}    		
    	}
    	
    }    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution047 s = new Solution047();
		int[] nums = {1,1,1,1,2};
		System.out.println(s.permuteUnique(nums));
	}
}
