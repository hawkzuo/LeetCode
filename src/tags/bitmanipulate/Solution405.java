//405. Convert a Number to Hexadecimal

package tags.bitmanipulate;

public class Solution405 {

	public Solution405() {
		// TODO Auto-generated constructor stub
	}
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
    	char[] str = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    	
    	for(int j=1;j<=8;j++){    		
    		int bit = (num >> (32-j*4)) & 15;
    		if(sb.length() == 0){
    			if(bit == 0){
    				continue;
    			}else{
    				sb.append(str[bit]);
    			}
    		}else{
    			sb.append(str[bit]);
    		}    		
    	}
    	if(sb.length() == 0){
    		sb.append('0');
    	}
    	
    	return sb.toString();   	
    	
    	
    }
    
    public static void main(String[] args) {
    	
    	Solution405 s = new Solution405();


    	System.out.print(s.toHex(0));

    } 
}
