//69. Sqrt(x)

package tags.math;

public class Solution069 {

    public int mySqrt(int x) {
        if(x == 1){   return 1;}
        double xn = x/2;

        while(Math.abs((xn+x/xn)/2 - xn) > 0.5){
            xn = (xn+x/xn)/2;
        }
        if((int)xn*(int)xn>x){    return  (int)xn-1;}
        return (int)xn;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Solution069 s = new Solution069();
    	int count=0;
    	for(int i = 0;i<100*100;i++){
    		System.out.println(i+" "+s.mySqrt(i));
    	}
    	System.out.println(s.mySqrt(2147395599));
    	System.out.println(s.mySqrt(Integer.MAX_VALUE));;
	}

}
