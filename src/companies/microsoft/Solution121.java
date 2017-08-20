package companies.microsoft;

public class Solution121 {

	public Solution121() {
		// TODO Auto-generated constructor stub
	}

    public int maxProfit(int[] prices) {
//Require DP        
    	
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
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution121 s = new Solution121();
		int [] arr1 = {7,1,19,0,14};
		
		int res = s.maxProfit(arr1);
		System.out.print(res);
		

	}

}
