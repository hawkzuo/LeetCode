package collectionMediumFirstHundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amos on 2017/7/26.
 * Subsets II
 */
public class Sol090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        constructPathWithDuplicate(list, new ArrayList<>(),nums,0);
        return list;
    }
    private void constructPathWithDuplicate(List<List<Integer>> res, List<Integer> path, int[] nums, int bIndex){
        res.add(path);
        for(int i=bIndex;i<nums.length;i++){
            path.add(nums[i]);
            //Move a bit right and recurse
            constructPathWithDuplicate(res, new ArrayList<>(path),nums,i+1);
            //BT
            path.remove(path.size()-1);
            int ref = nums[i];
            while(i+1<nums.length && nums[i+1] == ref){
                i++;
            }
        }
    }
}
