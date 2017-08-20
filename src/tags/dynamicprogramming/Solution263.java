//263. Ugly Number

package tags.dynamicprogramming;

public class Solution263 {

	public Solution263() {	
	}

    public boolean isUgly(int num) {
    	
    	
    	if(num <= 0){return false;}
    	while(num % 2 == 0){
    		num /= 2;
    	}
    	while(num % 3 == 0){
    		num /= 3;
    	}
    	while(num % 5 == 0){
    		num /= 5;
    	}
    	
        return num == 1;

        //Still 2ms
 /*           while(num>=2)
            {
                if(num%2==0)
                num = num/2;
                else if(num%3==0)
                num = num/3;
                else if(num%5==0)
                num = num/5;
                else return false;
            }
            if(num==1)  return true;
            else return false;
*/        
   	
    	
    	
    	
    }	
	

}
