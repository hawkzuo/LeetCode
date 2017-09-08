package collectionEasyFirstHundred;

import java.util.Random;

/**
 * Created by Amos on 2017/9/10.
 * Guess Number Higher or Lower
 */
public class Sol374 {
    // Idea: Use Binary Search To Guess the numbers until you get the answer.
    public int guessNumber(int n) {
        return myGuess(1, n);
    }

    // Returns the value guessed
    public int myGuess(int smallest, int largest) {
        int left = smallest;
        int right = largest;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int guessResult = guess(mid);
            if(guessResult == 0) {
                return mid;
            } else if (guessResult > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(guess(left) == 0) {
            return left;
        } else if (guess(right) == 0) {
            return right;
        } else {
            return -1;
        }

    }

   /*
    *    @param num, your guess
    *    @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
    */
    private int guess(int mid) {
        Random r = new Random(47);
        int val = r.nextInt(10) + 1;
        if(val < 5) {
            return -1;
        } else if(val > 6) {
            return 1;
        } else {
            return 0;
        }
    }
}
