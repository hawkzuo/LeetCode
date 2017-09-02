package collectionEasySecondHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/29.
 * Number of Boomerangs
 */
public class Sol447 {
    // Idea: Store the distance between selected Mid-point and any other point and count same distance numbers
    // Use n(n-1) to calculate possible permutations
    public int numberOfBoomerangs(int[][] points) {
        // (i,j,k)  dist(i,j)  == dis(i,k)
        // SB corner case
        if(points == null || points.length < 3) {   return 0;}

        int sum = 0;
        for(int[] midPoint : points) {
            sum += getBooms(midPoint, points);
        }
        return sum;
    }

    private int getBooms(int[] midPoint, int[][] points) {
        int res = 0;
        Map<Double, Integer> distances = new HashMap<>();

        for(int[] pt: points) {
            double dx = midPoint[0] - pt[0];
            double dy = midPoint[1] - pt[1];
            double dist = dx * dx + dy * dy;
            if(distances.containsKey(dist)) {
                distances.put(dist, distances.get(dist) + 1);
            } else {
                distances.put(dist, 1);
            }
        }
        for(Map.Entry<Double,Integer> pair: distances.entrySet()) {
            int times = pair.getValue();
            res += times * (times-1);
        }
        return res;
    }
}
