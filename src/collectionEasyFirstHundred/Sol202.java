package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Happy Number
 */
public class Sol202 {
    // Idea: Just find the pattern of happy numbers
    public boolean isHappy(int n) {
        // 1, 7, 10 will be the happy number finally.
        if (n == 1 || n == 7 || n == 10) return true;
        if (n < 10) return false;
        int newN = power(n % 10);
        while (n >= 10) {
            n /= 10;
            newN += power(n % 10);
        }
        return isHappy(newN);
    }

    private int power(int n){
        return n * n;
    }
}
