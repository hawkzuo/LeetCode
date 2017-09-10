package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Power of Four
 */
public class Sol342 {
    // Idea: 4^x satisfies: must be 2^x and (4^x -1 ) must have a factor of three
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    // Bit Manipulation
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }
}
