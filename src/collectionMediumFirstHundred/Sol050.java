package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/20.
 * Pow(x, n)
 */
public class Sol050 {
    public double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        // Multiply bit by bit  a^(0b111) = a^(0b100)*a^(0b10)*a^(0b1)
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
    public static void main(String[] args) {
        Sol050 s = new Sol050();
        System.out.println(s.myPow(2,7));
    }
}
