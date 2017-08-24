package collectionEasyFirstHundred;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/8/24.
 * Valid Parentheses
 */
public class Sol020 {
    // Idea: Use a stack to store all "left-side" parentheses, then pop & check each "right-side" parenthesis

    public boolean isValid(String s) {

        char [] str = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char stepChar : str) {
            if (isLeft(stepChar)) {
                stack.push(stepChar);
            } else if (isRight(stepChar)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char l = stack.pop();
                    if (!checkTwoChar(l, stepChar)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
    private boolean checkTwoChar(char c1, char c2) {
        return c1 == '(' && c2 == ')' || c1 == '{' && c2 == '}' || c1 == '[' && c2 == ']';
    }

    private boolean isLeft(char ch){
        return ch == '(' || ch == '{' || ch == '[';
    }

    private boolean isRight(char ch){
        return ch == ')' || ch == '}' || ch == ']';
    }
}
