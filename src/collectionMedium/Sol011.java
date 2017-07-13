package collectionMedium;

/**
 * Created by Amos on 2017/7/13.
 * Container With Most Water
 */
public class Sol011 {
    public int maxArea(int[] height) {
        // 1 5 2 3 1 5                   5 1 100 4 100 2 5      5 1 6 4 6 1 5    5 1 100 1 5
        // Start with [1,5] only goes to greater values
        // Only shift if encounter greater value
        int len = height.length;
        int l = 0;  int r = len -1;

        int globalMax = (r - l) * Math.min(height[l], height[r]);

        while(l < r){
            globalMax = Math.max(globalMax, (r - l) * Math.min(height[l], height[r]));
            if(height[l] > height[r]) {
                r--;
            }else if (height[l] < height[r]) {
                l++;
            }else {
                l++;    r--;
            }
        }
        return globalMax;
    }
}
