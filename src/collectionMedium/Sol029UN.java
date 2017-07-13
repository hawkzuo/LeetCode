package collectionMedium;

/**
 *
 */
public class Sol029UN {
    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) {
            if(divisor == 0){
                return Integer.MAX_VALUE;
            }else{
                return 0;
            }
        }

        boolean isPositive = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            isPositive = true;
        }
        long newDividend = Math.abs((long)dividend);
        long newDivisor = Math.abs((long)divisor);
        long  result = 0;
        while(newDividend >= newDivisor){
            result ++;
            newDividend -= newDivisor;
        }

        if(isPositive) {
            if(result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }else {
                return (int)result;
            }
        }else {
            result = -result;
            return (int) result;
        }
    }

    public static void main(String[] args) {
        Sol029UN s = new Sol029UN();
        System.out.println(s.divide(Integer.MIN_VALUE,-1));
    }


}
