package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Best Time to Buy and Sell Stock II
 */
public class Sol122 {
    // Idea: Just Greedy choices
    public int maxProfit(int[] prices) {

        //Greedy
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }

        int sum = 0;
        int len = prices.length;
        int prev = prices[0];
        int min = prev;
        int max = 0;

        for(int i=1;i<len;i++){
            if(prices[i] < prev){
                //down ward
                if(max > min){
                    sum += max -min;
                    max = 0;
                }

                min = prices[i];
                prev = min;
            }else if(prices[i] > prev){
                //Up ward
                max = prices[i];
                prev = max;
            }else{
                //Equal move onto the next
                ;
            }
        }

        if(max > min){
            sum += max -min;
        }
        return sum;
    }
}
