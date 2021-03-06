package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/20.
 * Permutations II
 */
public class Sol047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Integer> sel = new HashMap<Integer,Integer>();
        Map<Integer,Integer> avl = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            avl.put(i, 1);
        }
        genPermutationUnique(list,new ArrayList<Integer>(),nums,sel,avl);
        return list;
    }
    private void genPermutationUnique(List<List<Integer>> list, List<Integer> path, int[] nums, Map<Integer,Integer> sel, Map<Integer,Integer> avl){
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
            genPermutationUnique(list,path,nums,sel,avl);
            //BT
            int lastIndex = path.get(path.size()-1);
            sel.remove(lastIndex);	avl.put(lastIndex, 1);	path.remove(path.size()-1);
            //Before move on to the next iteration, remove the duplicates first.
            while(i+1<nums.length && nums[i+1] == nums[lastIndex]){
                i++;
            }
        }

    }
}
