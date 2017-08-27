package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Factorial Trailing Zeroes
 */
public class Sol172 {
    // Idea: Find patterns on the number of trailing zeroes
    public int trailingZeroes(int n) {
        //transform & conquer
        int sum = 0;    int step = n;
        while(step >= 5){
            step = step - step % 5;
            step = step / 5;
            sum += step;
        }
        return sum;
    }
}
