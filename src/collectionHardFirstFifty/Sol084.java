package collectionHardFirstFifty;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/8/28.
 * Largest Rectangle in Histogram
 */
public class Sol084 {
    // Idea: Reference Link: https://aaronice.gitbooks.io/lintcode/content/data_structure/largest_rectangle_in_histogram.html
    // Key idea is every step rectangle width can be calculated via i-s.peek()-1, even though they are not directly connected
    // Also, once pop out from the stack, the values will never be used again.
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {    return 0;}
        int globalMax = 0;
        // Stack stores the index of non-decreasing elements
        Deque<Integer> stack = new ArrayDeque<>();

        int cursor = 0;
        while(cursor <= heights.length) {
            if(stack.isEmpty() || (cursor < heights.length && heights[stack.peek()] <= heights[cursor] ) )  {
                stack.push(cursor);
                // Only way to increase the cursor value
                cursor++;
            } else {
                // Pour out all the elements in the stack that are greater than the A[cursor] value
                // Rectangle is formed only concerning i&s.peek(s.pop())
                // The interval is [s.peek()+1, i-1] or [0, i-1] if stack is empty
                // Should I separate the cursor == height.length case or not? Is the smallest value must be in stack when ends?
                int instanceHeight = heights[stack.pop()];
                int instanceWidth;
                if(stack.isEmpty()) {
                    instanceWidth = cursor;
                } else {
                    instanceWidth = cursor-stack.peek()-1;
                }
                // Update global
                globalMax = Math.max(globalMax, instanceHeight * instanceWidth);
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        Sol084 s = new Sol084();
        int[] A = {6,6,3,7,4};
        int[] B = {};
        StringBuilder sb = new StringBuilder();
        System.out.println(s.largestRectangleArea(A));
    }
}
