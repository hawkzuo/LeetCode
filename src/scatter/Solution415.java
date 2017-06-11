package scatter;

public class Solution415 {

    public String addStrings(String num1, String num2) {
        if(num1==null||num1.length()==0) return num2;
        if(num2==null||num2.length()==0) return num1;
        
    	char[]	c1 = num1.toCharArray();
    	char[] c2 = num2.toCharArray();   	
    	StringBuilder res = new StringBuilder();   	
    	int cLen = Math.min(c1.length, c2.length);	int carry = 0;   	
    	for(int i=0;i<cLen;i++){
    		int val = (c1[c1.length-1-i]-'0') + (c2[c2.length-1-i]-'0') + carry;
    		carry = val / 10;
    		res.insert(0, val % 10);
    	}
    	
    	if(c1.length == c2.length){
    		;
    	}else if(c1.length > c2.length){
    		for(int i=c1.length-c2.length-1;i>=0;i--){
    			int val = (c1[i]-'0')+carry;
        		carry = val / 10;
        		res.insert(0, val % 10);    			
    		}
    	}else{
    		for(int i=c2.length-c1.length-1;i>=0;i--){
    			int val = (c2[i]-'0')+carry;
    			carry = val / 10;
    			res.insert(0, val % 10);
    		}
    	}
    	
    	if(carry == 1){	res.insert(0, 1);}
    	return res.toString();
    }

}
