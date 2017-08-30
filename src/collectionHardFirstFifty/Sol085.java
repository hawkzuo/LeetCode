package collectionHardFirstFifty;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/8/28.
 * Maximal Rectangle
 */
public class Sol085 {
    // Idea: Run N-times Sol084 method
    public int maximalRectangle(char[][] matrix) {
        // Annoying control flow of 2D matrix
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {   return 0; }

        int rows = matrix.length;   int cols = matrix[0].length;
        int[] heights = new int[rows];
        int globalMax = 0;
        // Loop over all the columns
        for(int cursor=0; cursor<cols; cursor++) {
            // Refresh heights
            for(int i=0; i<rows; i++) {
                if(heights[i] == 0) {
                    searchRow(matrix, heights, i, cursor, cols);
                } else {
                    heights[i] -= 1;
                }
            }
            globalMax = Math.max(globalMax, largestRectangleArea(heights));
        }
        return globalMax;
    }

    private void searchRow(char[][] matrix, int[] heights, int rowNumber, int colCursor, int cols) {
        int value = 0;
        while(colCursor < cols) {
            if(matrix[rowNumber][colCursor] == '1') {
                value ++;
                colCursor ++;
            } else {
                break;
            }
        }
        heights[rowNumber] = value;
    }

    private int largestRectangleArea(int[] heights) {
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
        Sol085 s = new Sol085();
        int[] A = {6,6,3,7,4};
        int[] B = {};
        StringBuilder sb = new StringBuilder();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix2 = {};
        System.out.println(s.maximalRectangle(matrix2));
    }


}
