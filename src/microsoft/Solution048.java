//48. Rotate Image
//4 parts 
//229 73 39
package microsoft;

public class Solution048 {

	public Solution048() {
		// TODO Auto-generated constructor stub
	}
	
	
    public void rotate(int[][] matrix) {
        
    	if(matrix.length == 1){
    		return;
    	}else if(matrix.length != matrix[0].length){
    		return;
    	}
    	
    	int n = matrix.length;
    	//Rotate matrix circle by circle
		for(int i=0;i<n/2;i++){			
			RotateCircle(matrix,i,n-2*i);			
		}    	    	    	   	    	
    }
    private void RotateCircle(int[][] a, int o, int size){
    	for(int i=0;i<size-1;i++){
   		
    		int next = a[o+i][o+size-1];
    		a[o+i][o+size-1] = a[o][o+i];
    		int temp = next;
    		next = a[o+size-1][o+size-1-i];
    		a[o+size-1][o+size-1-i] = temp;
    		
    		a[o][o+i] = a[o+size-1-i][o];
    		a[o+size-1-i][o] = next;    		   		
    	}    	    	
    }
/*    
    private void eRotateCircle(int[][] a, int o, int size){
    	//0,4
    	//1,2
    	for(int i=0;i<size-1;i++){
    		
    		int next = a[o+i][o+size-1];
    		a[o+i][o+size-1] = a[o][o+i];
    		int temp = next;
    		next = a[o+size-1][o+size-1-i];
    		a[o+size-1][o+size-1-i] = temp;
    		
    		a[o][o+i] = a[o+size-1-i][o];
    		a[o+size-1-i][o] = next;    		
    		
    	}
   	
    	
    	
    	
    	
    }
*/     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution048 s = new Solution048();
		int[][] t4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] t3 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] t2 = {{1,2},{3,4}};
		int[][] t1 = {{1}};
		s.rotate(t1);
		s.rotate(t2);
		s.rotate(t3);
		s.rotate(t4);
		System.out.print(s);
	}     
}
