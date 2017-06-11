package subsetsBT;
import java.util.*;
public class Solution046 {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Integer> sel = new HashMap<Integer,Integer>();
        Map<Integer,Integer> avl = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	avl.put(i, 1);
        }
        genPermut(list,new ArrayList<Integer>(),nums,sel,avl);
        
        return list;          
    }

    private void genPermut(List<List<Integer>> list, List<Integer> path, int[] nums, Map<Integer,Integer> sel,Map<Integer,Integer> avl){
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
    		genPermut(list,path,nums,sel,avl);    
    		//BT
    		int lastIndex = path.get(path.size()-1);
    		sel.remove(lastIndex);	avl.put(lastIndex, 1);	path.remove(path.size()-1);
    	}
    	
    }
    
    public List<List<Integer>> permuteV2(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Integer> sel = new HashMap<Integer,Integer>();
        Map<Integer,Integer> avl = new HashMap<Integer,Integer>();
        Map<Integer,Integer> ref = new HashMap<Integer,Integer>();
        //Use an extra map to support O(1) access for only disjoint situations
        for(int i=0;i<nums.length;i++){
        	avl.put(i, 1);
        	ref.put(nums[i], i);
        }
        genPermutV2(list,new ArrayList<Integer>(),nums,sel,avl,ref);
        
        return list;          
    }

    private void genPermutV2(List<List<Integer>> list, List<Integer> path, int[] nums,
    		Map<Integer,Integer> sel, Map<Integer,Integer> avl, Map<Integer,Integer> ref){
    	if(avl.size() == 1){
    		List<Integer> dummy = new ArrayList<Integer>(path);
    		dummy.add(nums[avl.entrySet().iterator().next().getKey()]);
    		list.add(dummy);   		
    		//BT is not needed because this step doesn't add extras to path. 		    		
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		if(sel.containsKey(i)){
    			continue;
    		}    		
    		//Proceed to next step.	If no duplicates can add directly the values
    		path.add(nums[i]);
    		sel.put(i, 1);	avl.remove(i);
    		genPermutV2(list,path,nums,sel,avl,ref);    
    		//BT
    		int lastIndex = ref.get(path.get(path.size()-1));
    		sel.remove(lastIndex);	avl.put(lastIndex, 1);	path.remove(path.size()-1);
    	}
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution046 s = new Solution046();
		int[] nums = {1,2,3,4};
		System.out.println(s.permute(nums));
	}

}
