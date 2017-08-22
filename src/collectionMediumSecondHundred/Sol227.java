package collectionMediumSecondHundred;

/**
 * Created by Amos on 2017/8/22.
 * Basic Calculator II
 */
public class Sol227 {
    // Not BigInteger   will overflow
    public int calculate(String s) {
        // Remove whitespaces & split the strings
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch != ' ') {
                sb.append(ch);
            }
        }
        String str = sb.toString();
        int overallSum = 0;    char prevOperator = '+'; char sumOperator = '+';
        Integer registerValue = null;
        String[] parts = str.split("(?<=[-*/+])");

        // A more easy-to-understand way would be to use a stack
        // I would like to have a try with annotations and control flows
        // Another natural way would be to use recursive calls.
        for(int i=0;i<parts.length;i++) {
            if(i == parts.length -1) {
                // Kind of like 'final take care'
                int stepValue = Integer.parseInt(parts[i]);
                if(registerValue == null) {
                    overallSum = cal(overallSum, sumOperator, stepValue);
                } else {
                    overallSum = cal(overallSum, sumOperator, cal(registerValue, prevOperator, stepValue));
                }
            }else {
                int stepValue = Integer.parseInt(parts[i].substring(0, parts[i].length()-1));
                char nextOperator = parts[i].charAt(parts[i].length()-1);
                if(nextOperator == '+' || nextOperator == '-') {
                    // Clear register and update overallSum
                    if(registerValue == null) {
                        overallSum = cal(overallSum, sumOperator, stepValue);
                    }else {
                        overallSum = cal(overallSum, sumOperator, cal(registerValue, prevOperator, stepValue));
                    }
                    registerValue = null;
                    prevOperator = nextOperator;
                    sumOperator = nextOperator;
                } else {
                    // Write to register
                    if(registerValue == null) {
                        registerValue = stepValue;
                    } else {
                        registerValue = cal(registerValue, prevOperator, stepValue);
                    }
                    prevOperator = nextOperator;
                }
            }
        }
        return overallSum;
    }

    private int cal(Integer reg, char op, int second) {
        if(op == '*') {
            return reg * second;
        } else if(op == '/') {
            return reg / second;
        } else if(op == '+') {
            return reg + second;
        } else if(op == '-') {
            return reg - second;
        } else{
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Sol227 s = new Sol227();
        System.out.println(s.calculate("3-5/2*  4 / 2 *1"));
    }
}
