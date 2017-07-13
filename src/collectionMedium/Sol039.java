package collectionMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 */
public class Sol039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){   return result;}
        Arrays.sort(candidates);
        for(int i=0;i<candidates.length;i++){
            List<Integer> path = new ArrayList<>();
            path.add(candidates[i]);
            generateSolution(result, path, candidates,i,target-candidates[i]);
        }
        return result;
    }

    private void generateSolution(List<List<Integer>> result,List<Integer> currentList, int[] candidates, int cursor, int remaining ) {

        // stop recursion if remaining <=0
        if(remaining <= 0 ){
            if(remaining == 0){
                addList(result,currentList);
            }
        }else {
            // Recursion
            // Solved
            for (int i = cursor; i < candidates.length; i++) {
                currentList.add(candidates[i]);
                generateSolution(result, currentList, candidates, i, remaining-candidates[i]);
                currentList.remove(currentList.size()-1);
                // This line improves efficiency a lot
                if(remaining-candidates[i] <= 0) {   break;}
            }
        }
    }

    private void addList(List<List<Integer>> result,List<Integer> currentList){
        List<Integer> dummy = new ArrayList<>(currentList);
        result.add(dummy);
    }

    public static void main(String[] args){
        Sol039 s = new Sol039();
        int[] arr = {2,3,5,7};
        List<List<Integer>> result = s.combinationSum(arr, 7);
        System.out.println(result);
    }

}
