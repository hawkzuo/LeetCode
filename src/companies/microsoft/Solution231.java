package companies.microsoft;

public class Solution231 {

	public Solution231() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Bit Operation O(1)
    public boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);       
    }
    //Iteration O(logn)
    public boolean isPowerOfTwo2(int n) {
    	if(n==0) return false;
    	while(n%2==0) n/=2;
    	return (n==1);        
    }    
    //Recursive	O(logn)
    public boolean isPowerOfTwo3(int n) {
    	return n>0 && (n==1 || (n%2==0 && isPowerOfTwo(n/2)));        
    }   
    //Math O(1)
    public boolean isPowerOfTwo4(int n) {
    	return n>0 && (1073741824 % n == 0);        
    }    
    


}
