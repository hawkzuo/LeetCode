package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Valid Perfect Square
 */
public class Sol367 {
    // Idea: Use Newton's Method for approximation
    public boolean isPerfectSquare(int num) {
        if(num == 1){   return true;}
        double xn = num/2;

        while(Math.abs((xn+num/xn)/2 - xn) > 0.5){
            xn = (xn+num/xn)/2;
        }
        return (int) xn * (int) xn - num == 0;
    }
}
