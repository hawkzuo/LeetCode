package dungeongame174;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
    public int calculateMinimumHP(int[][] grid) {
  	
    	int row=grid.length;  int col=grid[0].length;
    	int [][]now = new int[row][col];   	
    	int [][]blood = new int[row][col];
    	
    	//The origin
    	if(grid[0][0]<0){
    		now[0][0]=1;
    		blood[0][0]=1-grid[0][0];
    	}else{
    		now[0][0]=1+grid[0][0];
    		blood[0][0]=1;
    	}
    	//Horizontal line
    	for(int i=1;i<col;i++){
    		if(now[0][i-1]+grid[0][i] > 0){
    			
    			now[0][i]=now[0][i-1]+grid[0][i];
    			blood[0][i]=blood[0][i-1];
    		}else{
    			
    			now[0][i]=1;
    			blood[0][i]=blood[0][i-1]-(now[0][i-1]+grid[0][i])+1;   			
    		}   		
    	}
    	//Vertical line
    	for(int j=1;j<row;j++){
    		if(now[j-1][0]+grid[j][0] > 0){
    			
    			now[j][0]=now[j-1][0]+grid[j][0];
    			blood[j][0]=blood[j-1][0];    			
    		}else{
    			
    			now[j][0]=1;
    			blood[j][0]=blood[j-1][0]-(now[j-1][0]+grid[j][0])+1;
    		}
    	}
    	//Step 1 finished
    	
    	//Step 4: special treatment
    	if(row == 1){
    		return blood[0][col-1];
    	}
    	if(col == 1){
    		return blood[row-1][0];
    	}
    	
    	boolean row_greater=false;
    	int commonstep=0;
    	if(row > col){
    		row_greater=true;
    		commonstep=col-2;
    	}else{
    		row_greater=false;
    		commonstep=row-2;
    	}  	       	
    	int n1=0;int n2=0;int b1=0;int b2=0;
    	
    	
    	for(int k=1;k<=commonstep;k++){
    		//Vertical half
    		for(int j=k;j<row;j++){
    			//First calculate upward incoming
        		if(now[j-1][k]+grid[j][k] > 0){
        			
        			n1=now[j-1][k]+grid[j][k];
        			b1=blood[j-1][k];    			
        		}else{
        			
        			n1=1;
        			b1=blood[j-1][k]-(now[j-1][k]+grid[j][k])+1;
        		}    			
    			//Then calculate left incoming
        		if(now[j][k-1]+grid[j][k] > 0){
        			
        			n2=now[j][k-1]+grid[j][k];
        			b2=blood[j][k-1];
        		}else{
        			
        			n2=1;
        			b2=blood[j][k-1]-(now[j][k-1]+grid[j][k])+1;   			
        		}   		
    			//Then compare which b is smaller
    			if(b1 <= b2){
    				now[j][k]=n1;
    				blood[j][k]=b1;
    			}else{
    				now[j][k]=n2;
    				blood[j][k]=b2;
    			}   			    			
    		}
    		//Horizontal
        	for(int i=k+1;i<col;i++){
        		//Left
        		if(now[k][i-1]+grid[k][i] > 0){
        			
        			n1=now[k][i-1]+grid[k][i];
        			b1=blood[k][i-1];
        		}else{
        			
        			n1=1;
        			b1=blood[k][i-1]-(now[k][i-1]+grid[k][i])+1;   			
        		}
        		//Upward
        		if(now[k-1][i]+grid[k][i] > 0){
        			
        			n2=now[k-1][i]+grid[k][i];
        			b2=blood[k-1][i];    			
        		}else{
        			
        			n2=1;
        			b2=blood[k-1][i]-(now[k-1][i]+grid[k][i])+1;
        		}
    			//Then compare which b is smaller
    			if(b1 <= b2){
    				now[k][i]=n1;
    				blood[k][i]=b1;
    			}else{
    				now[k][i]=n2;
    				blood[k][i]=b2;
    			}   			    		
        	}
    		
    		
    		
    	}
    	//Step 2: Common path finished
    	if(row_greater){
    		//An extra Vertical needed
    		for(int j=col-1;j<row;j++){
    			//First calculate upward incoming
        		if(now[j-1][col-1]+grid[j][col-1] > 0){
        			
        			n1=now[j-1][col-1]+grid[j][col-1];
        			b1=blood[j-1][col-1];    			
        		}else{
        			
        			n1=1;
        			b1=blood[j-1][col-1]-(now[j-1][col-1]+grid[j][col-1])+1;
        		}    			
    			//Then calculate left incoming
        		if(now[j][col-1-1]+grid[j][col-1] > 0){
        			
        			n2=now[j][col-1-1]+grid[j][col-1];
        			b2=blood[j][col-1-1];
        		}else{
        			
        			n2=1;
        			b2=blood[j][col-1-1]-(now[j][col-1-1]+grid[j][col-1])+1;   			
        		}   		
    			//Then compare which b is smaller
    			if(b1 <= b2){
    				now[j][col-1]=n1;
    				blood[j][col-1]=b1;
    			}else{
    				now[j][col-1]=n2;
    				blood[j][col-1]=b2;
    			}   			    			
    		}	
   		
    	}else{
    		//An extra Horizontal needed
        	for(int i=row-1;i<col;i++){
        		//Left
        		if(now[row-1][i-1]+grid[row-1][i] > 0){
        			
        			n1=now[row-1][i-1]+grid[row-1][i];
        			b1=blood[row-1][i-1];
        		}else{
        			
        			n1=1;
        			b1=blood[row-1][i-1]-(now[row-1][i-1]+grid[row-1][i])+1;   			
        		}
        		//Upward
        		if(now[row-1-1][i]+grid[row-1][i] > 0){
        			
        			n2=now[row-1-1][i]+grid[row-1][i];
        			b2=blood[row-1-1][i];    			
        		}else{
        			
        			n2=1;
        			b2=blood[row-1-1][i]-(now[row-1-1][i]+grid[row-1][i])+1;
        		}
    			//Then compare which b is smaller
    			if(b1 <= b2){
    				now[row-1][i]=n1;
    				blood[row-1][i]=b1;
    			}else{
    				now[row-1][i]=n2;
    				blood[row-1][i]=b2;
    			}   			    		
        	}   		    		
    	}    	
    	//Step 3: Special path finished.
    	
    	return blood[row-1][col-1];    	
    	
   	
 
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int [][] ref={{1,-3,3},{0,-2,0},{-3,-3,-3}};

		System.out.println(s.calculateMinimumHP(ref));
	}

}
