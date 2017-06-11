//393. UTF-8 Validation

//397,318,78
package bitmanipulate;

public class Solution393 {

	public Solution393() {
		// TODO Auto-generated constructor stub
	}

	
	
    public boolean validUtf8(int[] data) {
        
    	int i=0;
    	while(i<data.length){    		
    		int bit = data[i] & 255;
    		if(((bit >>> 3)-30)==0){
    			//4 bits
    			if(!checkSeq(i+1,data,3)){
    				return false;
    			}
    			
    			i+=4;
    		}else if(((bit >>> 4)-14)==0){
    			if(!checkSeq(i+1,data,2)){
    				return false;
    			}    
    			i+=3;
    		}else if(((bit >>> 5)-6)==0){
    			if(!checkSeq(i+1,data,1)){
    				return false;
    			}    
    			i+=2;
    		}else{
    			if((bit & 128)==0){
    				i++;
    			}else{
    				return false;
    			}
    		}    		
    	}
    	return true;
    	
    	
    }
    
    private boolean checkSeq(int sindex,int[] a,int times){
    	if((sindex+times-1)>=a.length){
    		return false;
    	}
    	for(int j=0;j<times;j++){
    		int bit = a[sindex+j] & 255;
    		if(((bit >>> 6)-2)==0){
    			continue;
    		}else{
    			return false;
    		}
    		
    	}
    	return true;
    }
    public static void main(String[] args) {
    	
    	Solution393 s = new Solution393();
    	int [] a = {255};

    	System.out.print(s.validUtf8(a));

    } 
    
    
    
    
}
