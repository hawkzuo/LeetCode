package collectionHardFirstFifty;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/8/29.
 * Trapping Rain Water
 */
public class Sol042 {
    public int trap(int[] height) {
        // Idea is very similar to Sol084/085
        if(height == null || height.length <= 1) {  return 0;}

        Deque<Integer> stack = new ArrayDeque<>();
        int cursor = 0;
        int total = 0;

        while(cursor < height.length) {
            if(stack.isEmpty() || cursor < height.length && height[cursor] <= height[stack.peek()] ) {
                // Add to stack
                stack.push(cursor);
                // Only way to add cursor
                cursor++;
            } else {
                int lowBarIndex = stack.pop();  int lowBarHeight = height[lowBarIndex];
                int width;  int internalWaterHeight=0;
                if(stack.isEmpty()) {
                    // Meaning the left-side has no bar to stop the water
                    width = 0;
                } else {
                    width = cursor-1- stack.peek();
                    internalWaterHeight = Math.min(height[stack.peek()], height[cursor]) - lowBarHeight;
                }
                total += internalWaterHeight*width;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Sol042 s = new Sol042();
        int[] A = {1,0,0, 5,2,1,4,1,3,2,4};
        int[] B = {5,2,1,2,1,5};
        StringBuilder sb = new StringBuilder();

        System.out.println(s.trap(A));
    }
}
