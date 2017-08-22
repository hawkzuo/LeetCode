package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/19.
 * Combination Sum II
 */
public class Sol040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){   return result;}
        Arrays.sort(candidates);

        Map<Integer,Integer> refer = new HashMap<>();
        for(int i:candidates) {
            if(refer.containsKey(i)){
                refer.put(i, refer.get(i)+1);
            }else{
                refer.put(i, 1);
            }
        }
        List<Integer> path = new ArrayList<>();
        generateSolution(result,path, candidates, 0, target, refer);
        return result;
    }
    // cursor is the first available element index
    private void generateSolution(List<List<Integer>> result,List<Integer> currentList, int[] candidates, int cursor, int remaining, Map<Integer,Integer> refer ) {

        // stop recursion if remaining <=0
        if(remaining <= 0 ){
            if(remaining == 0){
                addList(result,currentList);
            }
        }else {
            // Recursion   112567 10
            int index = cursor;
            while(index < candidates.length) {
                int stepValue = candidates[index];
                int times = refer.get(stepValue);
                // 'countToChoose' must be set to VALUE '1', otherwise will fail
                for(int countToChoose = 1; countToChoose <= times; countToChoose++){
                    // Try to take countToChoose elements from the array
                    int newRemaining = remaining;
                    for(int dummy=0;dummy<countToChoose;dummy++){
                        currentList.add(stepValue);
                        newRemaining -= stepValue;
                    }
                    generateSolution(result, currentList, candidates, index+times, newRemaining, refer);
                    // BT
                    for(int dummy=0;dummy<countToChoose;dummy++){
                        currentList.remove(currentList.size()-1);
                    }
                    if(newRemaining <= 0) { break;}
                }
                index += times;
            }
        }
    }

    private void addList(List<List<Integer>> result,List<Integer> currentList){
        List<Integer> dummy = new ArrayList<>(currentList);
        result.add(dummy);
    }
    public static void main(String[] args){
        Sol040 s = new Sol040();
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> result = s.combinationSum2(arr, 8);
        System.out.println(result);
    }
}
