//367. Valid Perfect Square

package tags.math;

public class Solution367 {

    public boolean isPerfectSquare(int num) {
        if(num == 1){   return true;}
        double xn = num/2;

        while(Math.abs((xn+num/xn)/2 - xn) > 0.5){
            xn = (xn+num/xn)/2;
        }
        
        if((int)xn*(int)xn-num == 0){
            return true;
        }
        return false;
        
        
    }
    public static void main(String[] args) {
    	
    	Solution367 s = new Solution367();
    	int count=0;
    	for(int i = 1;i<10000*10000+1;i++){
    		if(s.isPerfectSquare(i)){
    			count++;
    		}
    		
    	}
    	System.out.println(count);
    	
    }
}
