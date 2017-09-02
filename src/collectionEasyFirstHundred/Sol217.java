package collectionEasyFirstHundred;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/9/1.
 * Contains Duplicate
 */
public class Sol217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> table = new HashSet<>();
        for(int step: nums) {
            if(table.contains(step)) {
                return true;
            }
            table.add(step);
        }
        return false;
    }
}
