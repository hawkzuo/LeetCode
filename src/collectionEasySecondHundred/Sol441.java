package collectionEasySecondHundred;

/**
 * Created by Amos on 2017/8/29.
 * Arranging Coins
 */
public class Sol441 {
    public int arrangeCoins(int n) {
        // Solve the equation
        double sol = (Math.sqrt(8 * (double) n + 1) - 1 ) * 0.5;
        return (int)sol;
    }
}
