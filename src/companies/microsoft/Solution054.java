package companies.microsoft;
//fast as 2ms. Top
import java.util.ArrayList;
import java.util.List;

public class Solution054 {

	public Solution054() {
		// TODO Auto-generated constructor stub
	}
    public List<Integer> spiralOrder(int[][] matrix) {
        
    	if(matrix == null || matrix.length == 0){return new ArrayList<Integer>();}
    	List<Integer> l = new ArrayList<Integer>();
    	
    	int row=matrix.length;	int col=matrix[0].length;
    	
    	int rx=0;	int ry=0;
    	
    	int m=row;	int n=col;
    	if(m==0 || n==0){return l;}
    	
    	while(m > 0 && n > 0){
    		performSpiral(rx,ry,m,n,l,matrix);
    		rx++; ry++;
    		m=m-2;	n=n-2;   		    		
    	}
    	return l;    	
    }
    
    private void performSpiral(int x,int y,int m,int n, List<Integer> list, int[][] matrix){
    	
    	if(m==1 && n==1){
    		list.add(matrix[x][y]);
    		
    	}else if(m==1 && n>1){
    		for(int i=0;i<n;i++){
    			//Perform n times
    			list.add(matrix[x][y+i]);    			
    		}    		
    		
    	}else if(m>1 && n==1){
    		for(int j=0;j<m;j++){
    			list.add(matrix[x+j][y]);    			
    		}    		    		
    		
    	}else{
    		
    		for(int i=0;i<n-1;i++){
    			//Perform n-1 times
    			list.add(matrix[x][y+i]);    			
    		}
    		for(int j=0;j<m-1;j++){
    			list.add(matrix[x+j][y+n-1]);    			
    		}   		
    		for(int i=0;i<n-1;i++){
    			//Perform n-1 times
    			list.add(matrix[x+m-1][y+n-1-i]);    			
    		}  		
    		for(int j=0;j<m-1;j++){
    			list.add(matrix[x+m-1-j][y]);    			
    		}     		    		
    	}   	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution054 s=new Solution054();
		//5*2
		int[][] arr1={{1,2},{10,3},{9,4},{8,5},{7,6}};
		
		//5*1
		int[][] arr2={{1},{2},{3},{4},{5}};
		
		
		
		
		
		List<Integer> l1=s.spiralOrder(arr1);
		System.out.println(l1);
		
		List<Integer> l2=s.spiralOrder(arr2);
		System.out.println(l2);
		
	}

}
