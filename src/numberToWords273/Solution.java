//5ms --38%
package numberToWords273;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

//Input max = 2,147,483,647
    public String numberToWords(int num) {
        int [] deg = {0,0,0,0,0,0,0,0,0,0,0};
        int i=1;
        deg[0]=num % 10;
        int value=num / 10;
        while(value > 0){
        	deg[i]=value % 10;
        	value = value /10;
        	i++;
        }
    	String [] units= {"Hundred","Thousand","Million","Billion"};
    	String [] tens= {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    	String [] special={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    	
    	
    	String [] words= {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};    	    	
    	String result="";
    	//d[9] ----------- d[0]
    	String p1="";String p2="";String p3="";String p4="";
    	if(deg[9]>0){
    		p1+=words[deg[9]];
    	}
    	
    	int d3=deg[8]; int d2=deg[7]; int d1=deg[6];
    	if(d3>0){
    		p2+=words[d3]+" "+units[0];
    		if(d2 > 1){
        		p2+=" "+tens[d2];
        		if(d1 == 0){
        			;
        		}else{
        			p2+=" "+words[d1];
        		}    		
        	}else if(d2 == 1){
        		p2+=" "+special[d1];
        	}else{
        		if(d1 == 0){
        			;
        		}else{
        			p2+=" "+words[d1];
        		}  
        	}
    	}else{
    		if(d2 > 1){
        		p2+=tens[d2];
        		if(d1 == 0){
        			;
        		}else{
        			p2+=" "+words[d1];
        		}    		
        	}else if(d2 == 1){
        		p2+=special[d1];
        	}else{
        		p2+=words[d1];
        	}
    	}

    	d3=deg[5];d2=deg[4];d1=deg[3];
    	if(d3>0){
    		p3+=words[d3]+" "+units[0];
    		if(d2 > 1){
        		p3+=" "+tens[d2];
        		if(d1 == 0){
        			;
        		}else{
        			p3+=" "+words[d1];
        		}    		
        	}else if(d2 == 1){
        		p3+=" "+special[d1];
        	}else{
        		if(d1 == 0){
        			;
        		}else{
        			p3+=" "+words[d1];
        		}  
        	}
    	}else{
    		if(d2 > 1){
        		p3+=tens[d2];
        		if(d1 == 0){
        			;
        		}else{
        			p3+=" "+words[d1];
        		}    		
        	}else if(d2 == 1){
        		p3+=special[d1];
        	}else{
        		p3+=words[d1];
        	}
    	}
    	
    	d3=deg[2];d2=deg[1];d1=deg[0];
    	if(d3>0){
    		p4+=words[d3]+" "+units[0];
    		if(d2 > 1){
        		p4+=" "+tens[d2];
        		if(d1 == 0){
        			;
        		}else{
        			p4+=" "+words[d1];
        		}    		
        	}else if(d2 == 1){
        		p4+=" "+special[d1];
        	}else{
        		if(d1 == 0){
        			;
        		}else{
        			p4+=" "+words[d1];
        		}  
        	}
    	}else{
    		if(d2 > 1){
        		p4+=tens[d2];
        		if(d1 == 0){
        			;
        		}else{
        			p4+=" "+words[d1];
        		}    		
        	}else if(d2 == 1){
        		p4+=special[d1];
        	}else{
        		p4+=words[d1];
        	}
    	}
    	
    	if(p1.length() != 0){
    		result+=p1+" "+units[3];
    	}
    	if(p2.length() != 0){
    		if(result != ""){
    			result+=" "+p2+" "+units[2];
    		}else{
    			result+=p2+" "+units[2];
    		}   		
    	}
    	if(p3.length() != 0){
    		if(result != ""){
    			result+=" "+p3+" "+units[1];
    		}else{
    			result+=p3+" "+units[1];
    		}
    	}
    	if(p4.length() != 0){
    		if(result != ""){
    			result+=" "+p4;
    		}else{
    			result+=p4;
    		}
    	}
    	if(result.length()==0){
    		result="Zero";
    	}
  	
    	return result;
    }	

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s=new Solution();
		String res=s.numberToWords(1123456789);
		res=s.numberToWords(112345);
		System.out.println(res);
		
	}

}
