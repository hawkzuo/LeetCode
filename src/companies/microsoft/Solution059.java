package companies.microsoft;
//fast as 2ms. Top
public class Solution059 {

	public Solution059() {
		// TODO Auto-generated constructor stub
	}
    public int[][] generateMatrix(int n) {
        
    	//....... 
    	if(n<=0){return new int[0][0];}
    	
    	int[][] m=new int[n][n];
    	int rxy=0;
    	int value=1;
    	
    	while(n>0){
    		value=performAdd(rxy,n,m,value);
    		rxy++;
    		n=n-2;  		
    	}
    	
    	return m;
    }
    private int performAdd(int x,int n, int[][] matrix,int value){
    	if(n==1){
    		matrix[x][x]=value;
    		value++;
    	}else if(n>1){
    		for(int i=0;i<n-1;i++){
    			//Perform n-1 times
    			matrix[x][x+i]=value;
    			value++;
    		}
    		for(int j=0;j<n-1;j++){
    			
				matrix[x+j][x+n-1]=value;
    			value++;
    			
    		}   		
    		for(int i=0;i<n-1;i++){
    			//Perform n-1 times
    			matrix[x+n-1][x+n-1-i]=value;
    			value++;
    		}  		
    		for(int j=0;j<n-1;j++){
    			matrix[x+n-1-j][x]=value;
    			value++;
    		} 
    	}
    	
    	
    	return value;
    }
    
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
