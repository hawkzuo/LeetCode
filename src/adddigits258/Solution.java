//2ms Beats 23.74  HOWEVER 74.64 in 2ms



package adddigits258;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
    public int addDigits(int num) {
        if(num < 10){return num;}
/*
        int res=0;
    	
    	while(num!=0){
    		res += num % 10;
    		num = num / 10;
    		if(res >= 10){
    			res = res % 10 + res / 10;
    		}    		
    	}
    	return res;
*/   
/*        
    	int res=0;
    	while(num!= 0){
    		res += num % 10;
    		num = num / 10;
    	}
        return addDigits(res);
*/        
        return 1 + (num-1)%9; 
    }
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		System.out.println(s.addDigits(9999));
	}

}
