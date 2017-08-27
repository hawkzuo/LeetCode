package collectionEasyFirstHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/27.
 * Two Sum III - Data structure design
 */
public class Sol170TwoSum {
    // Idea: Since it's TwoSum, the map should only store either '1' or '2'. The max time of numbers is 2 times
    // Make elegant
    private Map<Integer, Integer> map = new HashMap<>()	;

    // Add the number to an internal data structure.
    public void add(int number) {
        //Key = number, Value = counts
        if(!map.containsKey(number)){
            map.put(number, 1);
        }else{
            map.put(number, 2);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for( Map.Entry<Integer, Integer> entry : map.entrySet() ){
            int k = entry.getKey();
            int v = entry.getValue();
            if (value - 2 * k == 0 && v == 2 || value - 2 * k != 0 && map.containsKey(value - k)) {
                return true;
            }
        }
        return false;
    }
}
