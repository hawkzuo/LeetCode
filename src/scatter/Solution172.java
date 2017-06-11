//172. Factorial Trailing Zeroes

package scatter;

public class Solution172 {

    public int trailingZeroes(int n) {       
        //transform & conquer
        int sum = 0;
        while(n >= 5){
            n = n - n%5;
            n = n/5;
            sum += n;
        }

        return sum;
    }

}
