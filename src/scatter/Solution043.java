



package scatter;

public class Solution043 {

    public String multiplyIncomplete(String num1, String num2) {

    	
    	StringBuilder res = mul(new StringBuilder(num1),new StringBuilder(num2));
    	return res.toString();
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
    
    
    
    private StringBuilder mul(StringBuilder sb1, StringBuilder sb2){
    	StringBuilder res = new StringBuilder();
    	int d1= sb1.length();
    	int d2= sb2.length();
    	if(sb1.charAt(0) == '0' || sb2.charAt(0) == '0'){
    		res.append('0');
    		return res;
    	}
    	
    	
    	if(d1 <=4 && d2<=4){
    		res = bruteMul(sb1,d1,sb2,d2);
    	}else if (d1<=4){
    		StringBuilder yh = new StringBuilder(sb2.substring(0, (d2+1)/2));
    		StringBuilder yl = new StringBuilder(sb2.substring((d2+1)/2,d2));
    		removeZeros(yl);
    		StringBuilder t1 = mul(sb1,yh);
    		add(res,t1,d2/2);
    		t1 = mul(sb1,yl);
    		add(res,t1,0);    		
    		
    	}else if(d2<=4){
    		StringBuilder xh = new StringBuilder(sb1.substring(0, (d1+1)/2));    		
    		StringBuilder xl = new StringBuilder(sb1.substring((d1+1)/2,d1));
    		removeZeros(xl);
    		StringBuilder t1 = mul(xh,sb2);
    		add(res,t1,d1/2);
    		t1 = mul(xl,sb2);
    		add(res,t1,0);
    		
    	}else{
    		StringBuilder xh = new StringBuilder(sb1.substring(0, (d1+1)/2));    		
    		StringBuilder xl = new StringBuilder(sb1.substring((d1+1)/2,d1));    		
    		StringBuilder yh = new StringBuilder(sb2.substring(0, (d2+1)/2));
    		StringBuilder yl = new StringBuilder(sb2.substring((d2+1)/2,d2));
    		removeZeros(xl);	removeZeros(yl);
    		
    		StringBuilder t1 = mul(xh,yh);
    		add(res,t1,(d1+d2)/2);
    		t1 = mul(xh,yl);
    		add(res,t1,d1/2);
    		t1 = mul(xl,yh);
    		add(res,t1,d2/2);
    		t1 = mul(xl,yl);
    		add(res,t1,0);
    		
    	}
    	
    	return res;
    		
    }
    private StringBuilder add(StringBuilder res, StringBuilder term, int offset){
		for(int i=1;i<=offset;i++){
			term.append('0');
		}		
    	if(res.length() == 0){
    		for(int i=0;i<term.length();i++){
    			res.append(term.charAt(i));
    		}
    		return res;
    	}else{
    		
    		if(res.length() < term.length()){
    			for(int i=0;i<term.length() - res.length();i++){
    				res.insert(0, '0');
    			}
    		}   		
    		int p =0;
    		for(int i=0;i<term.length();i++){
    			
    			int cur = p+Character.getNumericValue(term.charAt(term.length()-1-i))+Character.getNumericValue(res.charAt(res.length()-1-i));
    			p = cur / 10;
    			res.setCharAt(res.length()-1-i, (char)((cur % 10)+'0') );
    		}    		
    		if(p > 0){
    			if(res.length() == term.length()){
    				res.insert(0, (char)(p+'0'));
    			}else{
    				//Res.len > Term.len
    				for(int i=0;i<res.length() - term.length();i++){
    					int cur = p+Character.getNumericValue(res.charAt(res.length()- term.length()-1-i));
    					p = cur/10;
    					res.setCharAt(res.length()- term.length()-1-i, (char)((cur % 10)+'0') );
    					if(p==0){
    						break;
    					}
    				}
    				if(p>0){
    					res.insert(0, (char)(p+'0'));
    				}
    			}
    		}
    	}
    	
    	return res;
    	
    	
    }
    private StringBuilder bruteMul(StringBuilder sb1, int d1, StringBuilder sb2, int d2){    	
    	int l = Integer.valueOf(sb1.toString());
    	int r = Integer.valueOf(sb2.toString());
    	StringBuilder res = new StringBuilder(Integer.toString(l*r));
    	return res;
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution043 s = new Solution043();
		System.out.println(s.multiplyIncomplete("37296631467", "779131722517345395622848491058058983367518474023588972833940045054380263000522873890275"));
		System.out.println(s.multiplyIncomplete("1111111111","200010230"));
		
		System.out.println((char) (9+'0'));
		
	}

}
