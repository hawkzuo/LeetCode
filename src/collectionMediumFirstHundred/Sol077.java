package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/26.
 * Combinations
 */
public class Sol077 {
//    C 5 3
//      123 124 125 134 135 145 15-
//      234 235 245
//      345
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if(k > n || k <= 0) {   return result;}

        List<Integer> path = new ArrayList<>();
        generateCombinations(path, k, n, result);

        return result;
    }

    private void generateCombinations(List<Integer> currentPath, int desiredLength,
                                      int totalLength, List<List<Integer>> result) {
        if(currentPath.size() == desiredLength) {
            List<Integer> dummy = new ArrayList<>(currentPath);
            result.add(dummy);
            return;
        }

        if(currentPath.isEmpty()) {
            for(int i=1;i<=totalLength;i++) {
                currentPath.add(i);
                generateCombinations(currentPath, desiredLength, totalLength, result);
                currentPath.remove(currentPath.size()-1);
            }
        }else {
            int lastNumber = currentPath.get(currentPath.size()-1);
            for(int i=lastNumber+1;i<=totalLength;i++) {
                currentPath.add(i);
                generateCombinations(currentPath, desiredLength, totalLength, result);
                currentPath.remove(currentPath.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Sol077 s = new Sol077();
        List<List<Integer>> combine = s.combine(5, 0);
        System.out.println();
    }

}
