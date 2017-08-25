package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Sqrt(x)
 */
public class Sol069 {
    // Idea: Newton Method for numeric calculating 'xielv'
    public int mySqrt(int x) {
        if(x == 1){   return 1;}
        double xn = x/2;

        while(Math.abs((xn+x/xn)/2 - xn) > 0.5){
            xn = (xn+x/xn)/2;
        }
        if((int)xn*(int)xn>x){    return  (int)xn-1;}
        return (int)xn;
    }
}
