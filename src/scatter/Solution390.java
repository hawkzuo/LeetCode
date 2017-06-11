package scatter;

public class Solution390 {

    public int lastRemaining(int n) {
        
        if(n<=0){   return 0;}
        else if(n==1){  return 1;}
 
        //Overflow
        
        long r = ((long)n*(long)(n+1))/2;
        boolean isLeft = true;
        int d =1;       
        while(n>1){
            if(n % 2 != 0){
                //left or right is the same when n is odd
            	//Note this writing form is wrong
                // r = (n-1)/2/n*r;
            	r = (r/n) * (n-1) / 2;
            }else{
                //require more work
                if(isLeft){
                    r = (2*r+n*d)/4;
                }else{
                	r = (2*r-n*d)/4;
                }                 
 
            }

            isLeft = !isLeft;
            n = n/2;
            d = d*2;
        }
        
        return (int) r;
        
        
    }
    public int lastRemainingr(int n) {
        return ((Integer.highestOneBit(n) - 1) & (n | 0x55555555)) + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution390 s = new Solution390();
		System.out.println(s.lastRemaining(100000));
	}

}
