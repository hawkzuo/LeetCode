package collectionMediumFirstHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/20.
 * Fraction to Recurring Decimal
 */
public class Sol166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        // Use definition of Recurring Decimal
        // What is a RD? remaining repeated
        if(numerator == 0) {    return "0"; }
        boolean isPositive=false;
        if( (numerator > 0 && denominator >0) || (numerator < 0 && denominator <0)) {   isPositive = true;}
        if(!isPositive){    sb.append("-"); }

        Long up =  Math.abs((long)numerator);
        Long down =  Math.abs((long)denominator);
        Long quotient = up / down;
        sb.append(quotient);

        Long remaining = up % down;
        if(remaining == 0){ return sb.toString();}
        sb.append(".");

        Map<Long, Integer> refer = new HashMap<>();

        while(remaining != 0) {
            if(refer.containsKey(remaining)) {
                // Recurring inspected, output result
                int startIndex = refer.get(remaining);
                String nonRepeat = sb.substring(0, startIndex);
                String repeating = sb.substring(startIndex);
                return nonRepeat + "(" + repeating + ")";
            }
            refer.put(remaining, sb.length());
            Long step = remaining * 10;
            Long q = step / down;
            sb.append(q);
            remaining = step % down;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Sol166 s = new Sol166();
        int[] t = {};
        System.out.println(s.fractionToDecimal(Integer.MIN_VALUE,1));
    }
}
