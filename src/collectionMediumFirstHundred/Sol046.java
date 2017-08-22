package collectionMediumFirstHundred;

import java.util.*;
/**
 * Created by Amos on 2017/7/20.
 *
 */
public class Sol046 {
    public List<List<Integer>> permute(int[] nums) {
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
        genPermutation(list,new ArrayList<Integer>(),nums,sel,avl,ref);

        return list;
    }

    private void genPermutation(List<List<Integer>> list, List<Integer> path, int[] nums,
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
            genPermutation(list,path,nums,sel,avl,ref);
            //BT
            int lastIndex = ref.get(path.get(path.size()-1));
            sel.remove(lastIndex);	avl.put(lastIndex, 1);	path.remove(path.size()-1);
        }

    }
}
