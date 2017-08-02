package collectionMedium;

/**
 * Created by Amos on 2017/8/1.
 * Gas Station
 */
public class Sol134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // [-1 1 0] [-1 10 -7 11 -12] [-1 11 -12 10 -7]
        // [-1 0 0] [-1 9 2 13 1] [-1 10 -2 8 1]
        // [0 3 0 0 0]

        //[-1 10 -6 -6 4 -5 4]
        //[-1 9 3 -3 1 -4 0]

        // [1,2,3,4,5]
        // [3,4,5,2,1]

        // Find the first index with all positive left is wrong
        // Find the first index with rest remaining is all positive
        int startIndex = -1;
        int remaining = 0;
        int total = 0;
        for (int i = 0; i < cost.length; i++) {
            // remaining is calculated just like choose this index as start point, 'Mimic' behaviour
            remaining += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(remaining < 0) {
                // meaning this stored 'startIndex' cannot be chosen
                remaining = 0;
                startIndex = i;
            }
        }
        return (total < 0) ? -1 : startIndex + 1;
    }
}
