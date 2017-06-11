//

package scatter;

public class Solution043Brute {

		// Dlist has a sentinel node will help a lot . dummy node
	
	   public String multiply(String num1, String num2) {
	        
	        //Can optimize to constant space
	        
	        int m = num1.length();
	        int n = num2.length();
	        
	        StringBuilder sb = new StringBuilder();
	        
	        int leftover = 0;
	        int i=0;
	        while(i<(m+n)){
	        	int p1 = 0; int p2 = i-p1;
	        	int bit =0;
	        	while(p1 <= Math.min(i, m)){
	        		if(p1 >=0 && p1 <= (m-1) && p2>=0 && p2<= (n-1)){
	        			bit +=Character.getNumericValue(num1.charAt(m-1-p1))*Character.getNumericValue(num2.charAt(n-1-p2));
	        		}else{
	        			;
	        		}
	        		p1++;	p2--;
	        	}	
	        	int cur = bit + leftover;
	        	leftover = cur / 10;
	        	sb.insert(0,(char)('0'+(cur % 10)));
	        	i++;
	        }
	        removeZeros(sb);
	        
	        return sb.toString();
	                   
	   }
	   public static boolean checkString(String str1,String str2){
		   if(str1.length() != str2.length()){
			   return false;
		   }else{
			   for(int i=0;i<str1.length();i++){
				   if(str1.charAt(i) != str2.charAt(i)){
					   return false;
				   }
			   }
		   }
		   return true;
	   }
	   
	   
	   public String multiplyOld(String num1, String num2) {
	        
	        //Can optimize to constant space
	        
	        int m = num1.length();
	        int n = num2.length();
	        //if(m<=0 || n<=0 ){  return "";}
	        
	        int[] dp = new int[m+n+1];
	        
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                dp[i+j] += Character.getNumericValue(num1.charAt(m-1-i))*Character.getNumericValue(num2.charAt(n-1-j));
	            }
	            
	        }
	        StringBuilder sb = new StringBuilder();
	        
	        int leftover = 0;
	        
	        int i = 0;
	        while(i<(m+n)){
	            int cur = leftover + dp[i];
	            
	            leftover = cur / 10;
	            
	            sb.insert(0,(char)('0'+(cur % 10)));
	            i++;
	        }
	        removeZeros(sb);
	        
	        return sb.toString();
	        
	        
	        
	        
	                
	    }
	 
	    private StringBuilder removeZeros(StringBuilder src){
	    	while(src.length() > 0){
	    		if(src.charAt(0) == '0'){
	    			src.deleteCharAt(0);
	    			
	    		}else{
	    			return src;
	    		}
	    	}
	    	src.append('0');
	    	return src;
	    }    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution043Brute s = new Solution043Brute();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		String str1 = "312367";
		String str2 = "72870275";
		
		
		//ref = 22762269190925
		
		System.out.print(s.multiply(str1, str2));
		
	}

}
