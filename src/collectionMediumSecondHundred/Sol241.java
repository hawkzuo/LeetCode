package collectionMediumSecondHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/10/18.
 * Different Ways to Add Parentheses
 */
public class Sol241 {
    // Idea: Full DC example. Memorize once calculated
    private List<Integer>[][] table;
    public List<Integer> diffWaysToCompute(String input) {

        if(input == null || input.length() == 0){
            return new ArrayList<>();
        }
        String[] dummy = input.split("(?<=[-+*])");

        int[] numbers = new int[dummy.length];
        char[] operators = new char[dummy.length - 1];
        for(int i=0; i< dummy.length; i++) {
            if(i == dummy.length -1) {
                numbers[i] = Integer.valueOf(dummy[i]);
            } else {
                numbers[i] = Integer.valueOf(dummy[i].substring(0, dummy[i].length() - 1));
                operators[i] = dummy[i].charAt(dummy[i].length()-1);
            }
        }
        table = new ArrayList[numbers.length][numbers.length];
        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                table[i][j] = new ArrayList<>();
            }
        }
        return construct(numbers, operators, 0, numbers.length -1);
    }

    private List<Integer> construct(int[] numbers, char[] operators, int left, int right) {
        if(table[left][right].size() > 0) {
            return table[left][right];
        }

        if(left == right) {
            table[left][right].add(numbers[left]);
        } else if (left + 1 == right) {
            table[left][right].add(calculate(numbers[left], numbers[right], operators[left]));
        } else {
            // Try all combinations
            List<Integer> step = new ArrayList<>();
            for(int cursor=left; cursor < right; cursor++) {
                List<Integer> leftHalf = construct(numbers, operators, left, cursor);
                List<Integer> rightHalf = construct(numbers, operators, cursor+1, right);
                // 12 [] 3
                for(Integer leftOp: leftHalf) {
                    for(Integer rightOp: rightHalf) {
                        step.add(calculate(leftOp, rightOp, operators[cursor]));
                    }
                }
            }
            table[left][right] = step;
        }
        return  table[left][right];
    }

    private int calculate(int leftOp, int rightOp, char operator) {
        switch (operator) {
            case '+': return leftOp + rightOp;
            case '-': return leftOp - rightOp;
            case '*': return leftOp * rightOp;
            default: return Integer.MAX_VALUE;
        }
    }

}
