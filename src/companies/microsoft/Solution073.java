//73. Set Matrix Zeroes
//289
//Similar to those 442 448 041
package companies.microsoft;

public class Solution073 {

	public Solution073() {
		// TODO Auto-generated constructor stub
	}
    public void setZeroes(int[][] matrix) {
    	
    	int row = matrix.length;
    	if(row == 0){ return;}
    	int col = matrix[0].length;
    	int row0=-1; int col0=-1;
    	
    	if(matrix[0][0] == 0){
    		row0 = 0;
    		col0 = 0;
    	}
    	
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){
    			if(i==0 && j==0){	continue;}
    			
    			if(matrix[i][j] == 0){
    				if(i == 0){
    					row0 = 0;
    				}else if(j == 0){
    					col0 = 0;
    				}else{
    					// i,j>0
    					matrix[i][0] = 0;
    					matrix[0][j] = 0;    					
    				}   				
    			}
    		}
    	}
    	
    	for(int i=1;i<row;i++){
    		if(matrix[i][0] == 0){
    			for(int j=1;j<col;j++){
    				matrix[i][j]=0;
    			}
    		}
    	}
    	for(int j=1;j<col;j++){
    		if(matrix[0][j] == 0){
    			for(int i=1;i<row;i++){
    				matrix[i][j]=0;
    			}
    		}
    	}
    	
    	if(row0 == 0){
			for(int j=1;j<col;j++){
				matrix[0][j]=0;
			}    		
    	}
    	if(col0 == 0){
			for(int i=1;i<row;i++){
				matrix[i][0]=0;
			}    		
    	}
    	
    	
    	
    }	

    //Time costs are equal.
    public void setZeroes1(int[][] matrix) {
    	int row = matrix.length;
    	if(row == 0){ return;}
    	int col = matrix[0].length;        
    	
    	int rows[] = new int[row];
    	int cols[] = new int[col];
    	
    	
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){
    			if(matrix[i][j] == 0){
    				rows[i] = 1;
    				cols[j] = 1;
    			}    			
    		}
    	}
    	
    	for(int i=0;i<row;i++){
    		if(rows[i] == 1){
    			for(int j=0;j<col;j++){
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	for(int j=0;j<col;j++){
    		if(cols[j] == 1){
    			for(int i=0;i<row;i++){
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	
    }	
	
	
	
	
	
	
	
	
	
	
	
}
