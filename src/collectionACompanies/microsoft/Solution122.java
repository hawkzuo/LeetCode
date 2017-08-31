package collectionACompanies.microsoft;

public class Solution122 {

	public Solution122() {
		// TODO Auto-generated constructor stub
	}
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
    			
    			//One down-up finished
    			if(max > min){
    				sum += max -min;
    				max = 0;
    			}
    			//down ward --- update min
    			min = prices[i];
    			prev = min;
    		}else if(prices[i] > prev){
    			//Up ward --- update max
    			max = prices[i];
    			prev = max;    			
    		}else{
    			//Equal move onto the next
    			;    			
    		}    		
    	}
    	
		if(max > min){
			sum += max -min;
			max = 0;
		}    	    	    
    	return sum;    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution122 s = new Solution122();
		int [] arr1 = {7,9,7,2,1,11,12,19,19,19,18,16,12,0,0,0,1,2,3,14};
		
		int res = s.maxProfit(arr1);
		System.out.print(res);
		

	}    
}
