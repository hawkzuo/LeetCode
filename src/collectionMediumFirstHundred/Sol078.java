package collectionMediumFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/7/26.
 * Subsets
 */
public class Sol078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] numbers, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < numbers.length; i++){
            tempList.add(numbers[i]);
            backtrack(list, tempList, numbers, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
