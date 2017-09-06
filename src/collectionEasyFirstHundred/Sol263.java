package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/6.
 * Ugly Number
 */
public class Sol263 {
    // Idea: Brute-force checking for factors 2,3,5
    public boolean isUgly(int num) {
        int value = num;
        while(value>=2)
        {
            if(value%2==0) {
                value = value / 2;
            } else if(value%3==0) {
                value = value / 3;
            } else if(value%5==0) {
                value = value / 5;
            } else return false;
        }
        return value == 1;
    }
}
