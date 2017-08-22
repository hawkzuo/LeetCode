package collectionMediumSecondHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/22.
 * Combination Sum III
 */
public class Sol216 {

    // Idea: Pattern : BT
    // [3,7]  1,2,4 ;  1,3,4 -> stop    2,3,4 -> stop
    // [3,9]  1,2,6; 1,3,5; 1,4,5 -> stop   2,3,4; 2,4,5 -> stop

    // My original idea is to stop earlier (1 step before), tries to judge based on helper return values
    // Turned out to be much more complex than expected, so just remove it.

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(k < 1) { return result;}
        else if(k == 1) {
            if(n >= 1 && n <= 9){
                path.add(n);
                result.add(path);
            }
            return result;
        }
        generateAns(result, path, n, k);
        return result;
    }

    private void generateAns(List<List<Integer>> result, List<Integer> path, int leftover, int maxLen) {

        if(path.isEmpty()) {
            for(int i=1;i<=9;i++) {
                path.add(i);
                generateAns(result, path, leftover - i, maxLen);
                path.remove(path.size()-1);
            }
            return;
        }
        if(path.size() < maxLen) {
            if(leftover <= 0) { return;}
            int lastNumber = path.get(path.size()-1);
            for(int i=lastNumber + 1;i<=9;i++) {
                path.add(i);
                generateAns(result, path, leftover - i, maxLen);
                path.remove(path.size()-1);
            }
        }else {
            // Base case
            if(leftover == 0) {
                List<Integer> dm = new ArrayList<>(path);
                result.add(dm);
            }
        }

    }
    public static void main(String[] args) {
        Sol216 s = new Sol216();
        System.out.println(s.combinationSum3(4, 16));
    }

}
