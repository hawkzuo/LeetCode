package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/24.
 * Reverse Integer
 */
public class Sol007 {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        boolean isPositive = true;
        if(sb.charAt(0) == '-') {
            isPositive = false;
            sb.deleteCharAt(0);
        }
        sb.reverse();
        long reversed = Long.valueOf(sb.toString());
        if(!isPositive) {   reversed = -reversed; }

        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }else {
            return (int) reversed;
        }
    }
}
