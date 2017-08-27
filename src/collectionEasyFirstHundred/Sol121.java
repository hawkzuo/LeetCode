package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Best Time to Buy and Sell Stock
 */
public class Sol121 {
    // Idea: Simple DP, will be explored separately after collections
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices == null || prices.length == 0 || prices.length == 1){
            return max;
        }

        int len = prices.length;
        int min = prices[0];
        int i = 1;
        //Find min
        while(i<len){
            if(prices[i] < min){
                min = prices[i];
            }else{
                //Core DP
                max = Math.max(max, prices[i]-min);
            }
            i++;
        }
        return max;
    }
}
